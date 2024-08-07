CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    -- Procedure to hire a new employee
    PROCEDURE HireEmployee(
        p_EmployeeID IN NUMBER,
        p_Name IN VARCHAR2,
        p_JobTitle IN VARCHAR2,
        p_Salary IN NUMBER,
        p_HireDate IN DATE
    ) IS
    BEGIN
        -- Check if the employee already exists
        BEGIN
            INSERT INTO Employees (EmployeeID, Name, JobTitle, Salary, HireDate, LastModified)
            VALUES (p_EmployeeID, p_Name, p_JobTitle, p_Salary, p_HireDate, SYSDATE);
        EXCEPTION
            WHEN DUP_VAL_ON_INDEX THEN
                DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_EmployeeID || ' already exists.');
        END;
    END HireEmployee;

    -- Procedure to update employee details
    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID IN NUMBER,
        p_Name IN VARCHAR2,
        p_JobTitle IN VARCHAR2,
        p_Salary IN NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_Name, JobTitle = p_JobTitle, Salary = p_Salary, LastModified = SYSDATE
        WHERE EmployeeID = p_EmployeeID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_EmployeeID || ' does not exist.');
        END IF;
    END UpdateEmployeeDetails;

    -- Function to calculate annual salary
    FUNCTION CalculateAnnualSalary(
        p_EmployeeID IN NUMBER
    ) RETURN NUMBER IS
        v_AnnualSalary NUMBER;
        v_MonthlySalary NUMBER;
    BEGIN
        SELECT Salary INTO v_MonthlySalary
        FROM Employees
        WHERE EmployeeID = p_EmployeeID;

        v_AnnualSalary := v_MonthlySalary * 12;
        RETURN v_AnnualSalary;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_EmployeeID || ' does not exist.');
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
