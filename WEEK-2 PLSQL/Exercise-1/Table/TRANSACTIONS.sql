create table transactions (
	transactionid   number primary key,
	accountid       number,
	transactiondate date,
	amount          number,
	transactiontype varchar2(10),
	foreign key ( accountid )
		references accounts ( accountid )
);

insert all into transactions (
	transactionid,
	accountid,
	transactiondate,
	amount,
	transactiontype
) values ( 1,
           1,
           sysdate,
           200,
           'Deposit' ) into transactions (
	transactionid,
	accountid,
	transactiondate,
	amount,
	transactiontype
) values ( 2,
           2,
           sysdate,
           300,
           'Withdrawal' ) 
select *
                 from dual;

SELECT * FROM TRANSACTIONS;                 