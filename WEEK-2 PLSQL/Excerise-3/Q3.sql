CREATE OR REPLACE PROCEDURE TransferFunds (
    p_sourceAccountID IN NUMBER,
    p_targetAccountID IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_sourceBalance Accounts.Balance%TYPE;
    v_targetBalance Accounts.Balance%TYPE;
    v_errorMessage VARCHAR2(1000);

    -- Custom exception for insufficient funds
    INSUFFICIENT_FUNDS EXCEPTION;

BEGIN
    -- Fetch the current balance of the source account and lock the row for update
    SELECT Balance INTO v_sourceBalance
    FROM Accounts
    WHERE AccountID = p_sourceAccountID
    FOR UPDATE;

    -- Check if the source account has sufficient balance
    IF v_sourceBalance < p_amount THEN
        RAISE INSUFFICIENT_FUNDS; -- Raise the custom exception
    END IF;

    -- Fetch the current balance of the target account and lock the row for update
    SELECT Balance INTO v_targetBalance
    FROM Accounts
    WHERE AccountID = p_targetAccountID
    FOR UPDATE;

    -- Update the balance of the source account
    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_sourceAccountID;

    -- Update the balance of the target account
    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_targetAccountID;

    -- Commit the transaction
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
    WHEN INSUFFICIENT_FUNDS THEN
        v_errorMessage := 'Error: Insufficient funds in source account ID: ' || p_sourceAccountID;
        DBMS_OUTPUT.PUT_LINE(v_errorMessage);
        ROLLBACK;
    WHEN OTHERS THEN
        v_errorMessage := 'Error during fund transfer: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE(v_errorMessage);
        ROLLBACK;
END TransferFunds;
/
