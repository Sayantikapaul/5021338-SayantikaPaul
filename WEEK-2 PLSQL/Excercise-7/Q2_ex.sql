BEGIN
    EmployeeManagement.HireEmployee(1, 'Alice Johnson', 'Software Developer', 5000, TO_DATE('2023-01-15', 'YYYY-MM-DD'));
END;
/


BEGIN
    EmployeeManagement.UpdateEmployeeDetails(1, 'Alice J. Johnson', 'Senior Software Developer', 6000);
END;
/


DECLARE
    v_AnnualSalary NUMBER;
BEGIN
    v_AnnualSalary := EmployeeManagement.CalculateAnnualSalary(1);
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_AnnualSalary);
END;
/
