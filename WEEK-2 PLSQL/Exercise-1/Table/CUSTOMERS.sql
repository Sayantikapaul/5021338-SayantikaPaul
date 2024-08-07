CREATE TABLE Customers (
CustomerID NUMBER PRIMARY KEY,
Name VARCHAR2(100),
DOB DATE,
Balance NUMBER,
LastModified DATE
);

INSERT ALL
    INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (1, 'John Doe', TO_DATE('1985-05-15', 'YYYY-MM-DD'), 1000, SYSDATE)
    INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE)
SELECT * FROM DUAL;

 INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (3, 'Sayantika Paul', TO_DATE('1960-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);


SELECT * FROM Customers;