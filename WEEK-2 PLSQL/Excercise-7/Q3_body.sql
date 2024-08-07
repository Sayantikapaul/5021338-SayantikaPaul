CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    -- Procedure to open a new account
    PROCEDURE OpenAccount(
        p_AccountID IN NUMBER,
        p_CustomerID IN NUMBER,
        p_AccountType IN VARCHAR2,
        p_Balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_AccountID, p_CustomerID, p_AccountType, p_Balance, SYSDATE);
        
        DBMS_OUTPUT.PUT_LINE('Account ' || p_AccountID || ' opened for Customer ' || p_CustomerID);
    END OpenAccount;

    -- Procedure to close an account
    PROCEDURE CloseAccount(
        p_AccountID IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_AccountID;
        
        DBMS_OUTPUT.PUT_LINE('Account ' || p_AccountID || ' closed.');
    END CloseAccount;

    -- Function to get the total balance of a customer across all accounts
    FUNCTION GetTotalBalance(
        p_CustomerID IN NUMBER
    ) RETURN NUMBER IS
        v_TotalBalance NUMBER;
    BEGIN
        SELECT SUM(Balance)
        INTO v_TotalBalance
        FROM Accounts
        WHERE CustomerID = p_CustomerID;
        
        RETURN v_TotalBalance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetTotalBalance;

END AccountOperations;
/
