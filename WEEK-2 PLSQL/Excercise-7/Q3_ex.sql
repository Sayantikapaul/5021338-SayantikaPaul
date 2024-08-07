BEGIN
    AccountOperations.OpenAccount(1, 1, 'Savings', 1000);
END;
/


BEGIN
    AccountOperations.CloseAccount(1);
END;
/


DECLARE
    v_TotalBalance NUMBER;
BEGIN
    v_TotalBalance := AccountOperations.GetTotalBalance(1);
    DBMS_OUTPUT.PUT_LINE('Total Balance: ' || v_TotalBalance);
END;
/


