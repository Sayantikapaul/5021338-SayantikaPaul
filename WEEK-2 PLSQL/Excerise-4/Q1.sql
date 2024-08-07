CREATE OR REPLACE FUNCTION CalculateAge (
    p_dateOfBirth DATE
) RETURN NUMBER
IS
    v_age NUMBER;
BEGIN
    -- Calculate the age in years
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dateOfBirth) / 12);

    -- Return the calculated age
    RETURN v_age;
END CalculateAge;
/
