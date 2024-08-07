CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_accountID IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN
IS
    v_balance Accounts.Balance%TYPE;
BEGIN
    -- Fetch the current balance of the specified account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountID;

    -- Check if the balance is sufficient
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle the case where the account ID does not exist
        RETURN FALSE;
    WHEN OTHERS THEN
        -- Handle any other exceptions
        DBMS_OUTPUT.PUT_LINE('Error checking balance: ' || SQLERRM);
        RETURN FALSE;
END HasSufficientBalance;
/
