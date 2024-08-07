-- Enable DBMS_OUTPUT to see messages
SET SERVEROUTPUT ON;

-- Execute the UpdateEmployeeBonus procedure to update the salaries of employees in the 'Sales' department with a 10% bonus
BEGIN
    UpdateEmployeeBonus('HR', 10);
END;
/

-- Check the updated salaries of the employees in the 'Sales' department
SELECT * FROM employees;
