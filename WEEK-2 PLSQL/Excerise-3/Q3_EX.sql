-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Execute the TransferFunds procedure to transfer $500 from account 1 to account 2
BEGIN
    TransferFunds(1, 2, 500);
END;
/

-- Try to transfer an amount that exceeds the balance of the source account to test the error handling
BEGIN
    TransferFunds(1, 2, 100000);
END;
/

-- Check the updated balances of the accounts
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);
