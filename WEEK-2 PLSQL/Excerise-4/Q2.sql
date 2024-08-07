CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loanAmount NUMBER,
    p_interestRate NUMBER,
    p_durationYears NUMBER
) RETURN NUMBER
IS
    v_monthlyRate NUMBER;
    v_totalMonths NUMBER;
    v_monthlyInstallment NUMBER;
BEGIN
    -- Convert annual interest rate to monthly interest rate
    v_monthlyRate := p_interestRate / 12 / 100;

    -- Convert loan duration in years to total number of months
    v_totalMonths := p_durationYears * 12;

    -- Calculate the monthly installment using the formula for EMI (Equated Monthly Installment)
    v_monthlyInstallment := p_loanAmount * v_monthlyRate / (1 - POWER(1 + v_monthlyRate, -v_totalMonths));

    -- Return the calculated monthly installment
    RETURN v_monthlyInstallment;
EXCEPTION
    WHEN OTHERS THEN
        -- Handle any exceptions
        DBMS_OUTPUT.PUT_LINE('Error calculating monthly installment: ' || SQLERRM);
        RETURN NULL;
END CalculateMonthlyInstallment;
/
