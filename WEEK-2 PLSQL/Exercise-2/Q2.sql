CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employeeID IN NUMBER,
    p_percentage IN NUMBER
)
IS
    v_currentSalary NUMBER;
    v_errorMessage VARCHAR2(1000);

    -- Custom exception for employee not found
    employee_not_found EXCEPTION;

BEGIN
    -- Fetch the current salary of the employee
    BEGIN
        SELECT Salary INTO v_currentSalary
        FROM Employees
        WHERE EmployeeID = p_employeeID
        FOR UPDATE; -- Lock the row for update to prevent concurrent changes

        -- If the employee does not exist, this SELECT will raise a NO_DATA_FOUND exception
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE employee_not_found;
    END;

    -- Calculate the new salary
    v_currentSalary := v_currentSalary * (1 + p_percentage / 100);

    -- Update the salary of the employee
    UPDATE Employees
    SET Salary = v_currentSalary
    WHERE EmployeeID = p_employeeID;

    -- Commit the transaction
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');

EXCEPTION
    WHEN employee_not_found THEN
        v_errorMessage := 'Error: Employee with ID ' || p_employeeID || ' does not exist.';
        DBMS_OUTPUT.PUT_LINE(v_errorMessage);
        ROLLBACK;
    WHEN OTHERS THEN
        v_errorMessage := 'Error during salary update: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE(v_errorMessage);
        ROLLBACK;
END UpdateSalary;
/
