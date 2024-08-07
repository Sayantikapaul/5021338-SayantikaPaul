create table loans (
	loanid       number primary key,
	customerid   number,
	loanamount   number,
	interestrate number,
	startdate    date,
	enddate      date,
	foreign key ( customerid )
		references customers ( customerid )
);

insert all 
into loans (
	loanid,
	customerid,
	loanamount,
	interestrate,
	startdate,
	enddate
) values ( 1,
           1,
           5000,
           5,
           sysdate,
           add_months(
	           sysdate,
	           60
           ) ) into loans (
	loanid,
	customerid,
	loanamount,
	interestrate,
	startdate,
	enddate
) 
into loans values ( 2,
           2,
           1000,
           5,
           sysdate,
           add_months(
	           sysdate,
	           60
           ) ) select *
      from dual;

SELECT * FROM LOANS;
