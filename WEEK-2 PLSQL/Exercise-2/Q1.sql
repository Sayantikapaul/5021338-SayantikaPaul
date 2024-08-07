create or replace procedure safetransferfunds (
	p_sourceaccountid in number,
	p_targetaccountid in number,
	p_amount          in number
) is
	v_sourcebalance    number;
	v_targetbalance    number;
	v_sourcecustomerid number;
	v_targetcustomerid number;
	v_errormessage     varchar2(1000);

    -- Create insufficient funds exception
	insufficient_funds exception;
begin
    -- Fetch the balance and customer ID of the source account
	select balance,
	       customerid
	  into
		v_sourcebalance,
		v_sourcecustomerid
	  from accounts
	 where accountid = p_sourceaccountid
	for update;  -- Lock the row for update to prevent concurrent changes

    -- Check if the source account has sufficient funds
	if v_sourcebalance < p_amount then
		raise insufficient_funds;  -- Throw the exception
	end if;

    -- Fetch the balance and customer ID of the target account
	select balance,
	       customerid
	  into
		v_targetbalance,
		v_targetcustomerid
	  from accounts
	 where accountid = p_targetaccountid
	for update;  -- Lock the row for update to prevent concurrent changes

    -- Deduct the amount from the source account
	update accounts
	   set balance = balance - p_amount,
	       lastmodified = sysdate
	 where accountid = p_sourceaccountid;

    -- Add the amount to the target account
	update accounts
	   set balance = balance + p_amount,
	       lastmodified = sysdate
	 where accountid = p_targetaccountid;

    -- Update the customer's balance (assuming a simple update for illustration)
	update customers
	   set
		balance = (
			select sum(balance)
			  from accounts
			 where customerid = v_sourcecustomerid
		)
	 where customerid = v_sourcecustomerid;

	update customers
	   set
		balance = (
			select sum(balance)
			  from accounts
			 where customerid = v_targetcustomerid
		)
	 where customerid = v_targetcustomerid;

    -- Commit the transaction
	commit;
	dbms_output.put_line('Funds transferred successfully.');
exception
	when insufficient_funds then
		v_errormessage := 'Insufficient funds in source account ID: ' || p_sourceaccountid;
		dbms_output.put_line(v_errormessage);
		rollback;
	when others then
		v_errormessage := 'Error during fund transfer: ' || sqlerrm;
		dbms_output.put_line(v_errormessage);
		rollback;
end safetransferfunds;
/
