-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Update a customer's record
UPDATE Customers
SET Name = 'Updated Name'
WHERE CustomerID = 1;

-- Check the updated LastModified column
SELECT CustomerID, Name, LastModified
FROM Customers
WHERE CustomerID = 1;
