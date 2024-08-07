CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customerID IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
)
IS
    -- Variable to hold the count of existing customers with the same ID
    v_count NUMBER;

    -- Error message to be logged
    v_errorMessage VARCHAR2(4000);

    -- Custom exception for duplicate customer ID
    duplicate_id EXCEPTION;
BEGIN
    -- Check if a customer with the given ID already exists
    SELECT COUNT(*)
    INTO v_count
    FROM Customers
    WHERE CustomerID = p_customerID;

    -- If a customer with the same ID already exists, raise an exception
    IF v_count > 0 THEN
        RAISE duplicate_id;
    END IF;

    -- Insert the new customer into the Customers table
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customerID, p_name, p_dob, p_balance, SYSDATE);

    -- Commit the transaction
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN duplicate_id THEN
        v_errorMessage := 'Error: Customer with ID ' || p_customerID || ' already exists.';
        DBMS_OUTPUT.PUT_LINE(v_errorMessage);
        ROLLBACK;
    WHEN OTHERS THEN
        v_errorMessage := 'Error during customer insertion: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE(v_errorMessage);
        ROLLBACK;
END AddNewCustomer;
/
