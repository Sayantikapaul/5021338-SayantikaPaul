DECLARE
    -- Define a constant for the annual maintenance fee
    c_annual_fee CONSTANT NUMBER := 50;

    -- Define a cursor to retrieve all accounts
    CURSOR account_cur IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;  -- Lock the rows for update to prevent concurrent changes

    -- Variables to hold the data fetched by the cursor
    v_accountID Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;

BEGIN
    -- Open the cursor
    OPEN account_cur;

    -- Loop through all accounts
    LOOP
        -- Fetch the next row into variables
        FETCH account_cur INTO v_accountID, v_balance;

        -- Exit the loop if no more rows are found
        EXIT WHEN account_cur%NOTFOUND;

        -- Deduct the annual fee from the account balance
        v_balance := v_balance - c_annual_fee;

        -- Update the account balance
        UPDATE Accounts
        SET Balance = v_balance,
            LastModified = SYSDATE
        WHERE AccountID = v_accountID;

        -- Output the updated balance for debugging purposes
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_accountID || ', New Balance: ' || v_balance);
    END LOOP;

    -- Commit the changes
    COMMIT;

    -- Close the cursor
    CLOSE account_cur;

    DBMS_OUTPUT.PUT_LINE('Annual fee applied to all accounts.');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error applying annual fee: ' || SQLERRM);
        ROLLBACK;
END;
/
