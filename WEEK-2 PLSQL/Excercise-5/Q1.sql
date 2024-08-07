-- Create a sequence
CREATE SEQUENCE AuditLogSeq
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create the table without the identity column
CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogDate DATE
);

-- Create a trigger to populate the AuditID using the sequence
CREATE OR REPLACE TRIGGER AuditLogTrigger
BEFORE INSERT ON AuditLog
FOR EACH ROW
BEGIN
    :NEW.AuditID := AuditLogSeq.NEXTVAL;
END;
/
