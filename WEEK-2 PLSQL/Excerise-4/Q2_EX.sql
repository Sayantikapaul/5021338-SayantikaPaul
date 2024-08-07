-- Test the CalculateMonthlyInstallment function with sample data
DECLARE
    v_loanAmount NUMBER := 100000;
    v_interestRate NUMBER := 5;
    v_durationYears NUMBER := 10;
    v_monthlyInstallment NUMBER;
BEGIN
    v_monthlyInstallment := CalculateMonthlyInstallment(v_loanAmount, v_interestRate, v_durationYears);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ' || v_monthlyInstallment);
END;
/

-- Test with another set of sample data
DECLARE
    v_loanAmount NUMBER := 500000;
    v_interestRate NUMBER := 7.5;
    v_durationYears NUMBER := 20;
    v_monthlyInstallment NUMBER;
BEGIN
    v_monthlyInstallment := CalculateMonthlyInstallment(v_loanAmount, v_interestRate, v_durationYears);
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ' || v_monthlyInstallment);
END;
/
