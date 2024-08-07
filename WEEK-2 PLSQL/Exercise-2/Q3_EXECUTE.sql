-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Execute the AddNewCustomer procedure to add a new customer
BEGIN
    AddNewCustomer(4, 'Alice Johnson', TO_DATE('1995-08-25', 'YYYY-MM-DD'), 1500);
END;
/

-- Try to add a customer with an existing ID to test the duplicate ID handling
BEGIN
    AddNewCustomer(4, 'Bob Brown', TO_DATE('1992-11-30', 'YYYY-MM-DD'), 2000);
END;
/

