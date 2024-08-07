declare
	cursor customers_cur is
	select c.customerid,
	       l.interestrate,
	       trunc(months_between(
		       sysdate,
		       c.dob
	       ) / 12) as age
	  from customers c,
	       loans l
	 where c.customerid = l.customerid;

	v_custid customers.customerid%type;
	v_rate   loans.interestrate%type;
	v_age    number;
begin
	open customers_cur;
	loop
		fetch customers_cur into
			v_custid,
			v_rate,
			v_age;
		exit when customers_cur%notfound;
		if v_age < 60 then
            DBMS_OUTPUT.PUT_LINE('current rate : ' || v_rate);
			v_rate := v_rate * 0.99;
			update loans
			   set
				interestrate = v_rate
			 where customerid = v_custid;
            DBMS_OUTPUT.PUT_LINE('updated rate : ' || v_rate);

		end if;
	end loop;

    COMMIT;

	close customers_cur;
	dbms_output.put_line('Discount applied to eligible customers.');
end;
/