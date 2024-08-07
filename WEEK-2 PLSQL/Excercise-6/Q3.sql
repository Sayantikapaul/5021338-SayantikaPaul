DECLARE
    -- Define a cursor to retrieve all loans
    CURSOR loan_cur IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;  -- Lock the rows for update to prevent concurrent changes

    -- Variables to hold the data fetched by the cursor
    v_loanID Loans.LoanID%TYPE;
    v_interestRate Loans.InterestRate%TYPE;

    -- New policy interest rates (example: increase by 1%)
    c_new_interest_rate CONSTANT NUMBER := 1.0;

BEGIN
    -- Open the cursor
    OPEN loan_cur;

    -- Loop through all loans
    LOOP
        -- Fetch the next row into variables
        FETCH loan_cur INTO v_loanID, v_interestRate;

        -- Exit the loop if no more rows are found
        EXIT WHEN loan_cur%NOTFOUND;

        -- Apply the new interest rate policy (e.g., increase by 1%)
        v_interestRate := v_interestRate + c_new_interest_rate;

        -- Update the loan interest rate
        UPDATE Loans
        SET InterestRate = v_interestRate
        WHERE LoanID = v_loanID;

        -- Output the updated interest rate for debugging purposes
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loanID || ', New Interest Rate: ' || v_interestRate);
    END LOOP;

    -- Commit the changes
    COMMIT;

    -- Close the cursor
    CLOSE loan_cur;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated for all loans.');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error updating interest rates: ' || SQLERRM);
        ROLLBACK;
END;
/
