-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Execute the UpdateSalary procedure to increase the salary of employee 1 by 10%
BEGIN
    UpdateSalary(1, 10);
END;
/

-- Try to update the salary of a non-existing employee to test the error handling
BEGIN
    UpdateSalary(9999, 10);
END;
/

-- Check the updated salaries of the employees
SELECT EmployeeID, Salary FROM Employees WHERE EmployeeID = 1;
