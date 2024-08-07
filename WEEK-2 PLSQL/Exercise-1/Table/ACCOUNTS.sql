create table accounts (
	accountid    number primary key,
	customerid   number,
	accounttype  varchar2(20),
	balance      number,
	lastmodified date,
	foreign key ( customerid )
		references customers ( customerid )
);

insert all into accounts (
	accountid,
	customerid,
	accounttype,
	balance,
	lastmodified
) values ( 1,
           1,
           'Savings',
           1000,
           sysdate ) into accounts (
	accountid,
	customerid,
	accounttype,
	balance,
	lastmodified
) values ( 2,
           2,
           'Checking',
           1500,
           sysdate ) select *
            from dual;


SELECT * FROM ACCOUNTS;