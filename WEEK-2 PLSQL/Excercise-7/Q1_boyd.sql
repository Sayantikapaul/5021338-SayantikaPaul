CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    -- Procedure to add a new customer
    PROCEDURE AddNewCustomer(
        p_CustomerID IN NUMBER,
        p_Name IN VARCHAR2,
        p_DOB IN DATE,
        p_Balance IN NUMBER
    ) IS
    BEGIN
        -- Check if the customer already exists
        BEGIN
            INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
            VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);
        EXCEPTION
            WHEN DUP_VAL_ON_INDEX THEN
                DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' already exists.');
        END;
        
    END AddNewCustomer;

    -- Procedure to update customer details
    PROCEDURE UpdateCustomerDetails(
        p_CustomerID IN NUMBER,
        p_Name IN VARCHAR2,
        p_DOB IN DATE,
        p_Balance IN NUMBER
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, DOB = p_DOB, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_CustomerID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' does not exist.');
        END IF;
    END UpdateCustomerDetails;

    -- Function to get customer balance
    FUNCTION GetCustomerBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;

        RETURN v_Balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_CustomerID || ' does not exist.');
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
