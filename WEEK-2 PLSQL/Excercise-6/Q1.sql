DECLARE
    CURSOR TRANSACTIONS_CUR IS 
        SELECT T.transactionid, T.accountid, T.transactiondate, T.amount, t.TransactionType, A.CustomerID
        FROM TRANSACTIONS T, ACCOUNTS A
        WHERE T.transactionid = A.accountid AND
        TRUNC(T.transactiondate, 'MM') = TRUNC(SYSDATE,'MM');

    V_transactionid TRANSACTIONS.TRANSACTIONID%TYPE;
    V_accountid  TRANSACTIONS.ACCOUNTID%TYPE;
    V_TRANSACTIONDATE TRANSACTIONS.TRANSACTIONDATE%TYPE;
    V_AMOUNT TRANSACTIONS.AMOUNT%TYPE;
    V_TransactionType TRANSACTIONS.TRANSACTIONTYPE%TYPE;
    V_CUSTOMERID ACCOUNTS.CUSTOMERID%TYPE;


    V_CUSTOMERNAME CUSTOMERS.NAME%TYPE;

BEGIN
    OPEN TRANSACTIONS_CUR;

    LOOP 
        FETCH TRANSACTIONS_CUR INTO V_transactionid, V_accountid, V_TRANSACTIONDATE, V_AMOUNT, V_TransactionType, V_CUSTOMERID;

        EXIT WHEN TRANSACTIONS_CUR%NOTFOUND;

        SELECT NAME INTO V_CUSTOMERNAME
        FROM CUSTOMERS
        WHERE CUSTOMERID = V_CUSTOMERID;

        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_customerName);
        DBMS_OUTPUT.PUT_LINE('Transaction ID: ' || v_transactionID);
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || v_accountID);
        DBMS_OUTPUT.PUT_LINE('Date: ' || TO_CHAR(v_transactionDate, 'YYYY-MM-DD'));
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('Type: ' || v_transactionType);
        DBMS_OUTPUT.PUT_LINE('-----------------------------');

    END LOOP;

    CLOSE TRANSACTIONS_CUR;


    DBMS_OUTPUT.PUT_LINE('Monthly statements generated successfully.');

    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Error generating monthly statements: ' || SQLERRM);
END;
/
    

    
    





