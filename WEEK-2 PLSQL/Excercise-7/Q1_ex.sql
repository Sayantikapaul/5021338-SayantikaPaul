BEGIN
    CustomerManagement.AddNewCustomer(5, 'John Doe', TO_DATE('1980-01-01', 'YYYY-MM-DD'), 5000);
END;
/


BEGIN
    CustomerManagement.UpdateCustomerDetails(1, 'John A. Doe', TO_DATE('1980-01-01', 'YYYY-MM-DD'), 5500);
END;
/



DECLARE
    v_Balance NUMBER;
BEGIN
    v_Balance := CustomerManagement.GetCustomerBalance(1);
    DBMS_OUTPUT.PUT_LINE('Customer Balance: ' || v_Balance);
END;
/


SELECT * FROM CUSTOMERS;