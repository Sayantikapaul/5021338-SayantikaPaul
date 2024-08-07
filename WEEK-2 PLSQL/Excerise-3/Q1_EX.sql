-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Execute the ProcessMonthlyInterest procedure to update the balances of all savings accounts
BEGIN
    ProcessMonthlyInterest;
END;
/

-- Check the updated balances of savings accounts
SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'Savings';
