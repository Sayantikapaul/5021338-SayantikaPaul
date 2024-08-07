-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Execute the SafeTransferFunds procedure to transfer $1000 from account 1 to account 2
BEGIN
    SafeTransferFunds(2, 1, 500);
END;
/

--Check the balances of the accounts after the transfer
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);

-- Check the balances of the customers after the transfer
SELECT CustomerID, Balance FROM Customers WHERE CustomerID IN (1, 2);