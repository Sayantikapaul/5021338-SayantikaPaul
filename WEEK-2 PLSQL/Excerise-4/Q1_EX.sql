-- Test the CalculateAge function with a sample date of birth
DECLARE
    v_dateOfBirth DATE := TO_DATE('1990-07-15', 'YYYY-MM-DD');
    v_age NUMBER;
BEGIN
    v_age := CalculateAge(v_dateOfBirth);
    DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);
END;
/

-- Test with another sample date of birth
DECLARE
    v_dateOfBirth DATE := TO_DATE('2000-01-01', 'YYYY-MM-DD');
    v_age NUMBER;
BEGIN
    v_age := CalculateAge(v_dateOfBirth);
    DBMS_OUTPUT.PUT_LINE('Age: ' || v_age);
END;
/
