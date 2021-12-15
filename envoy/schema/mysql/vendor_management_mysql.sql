-- 
--  Migration script for adding Vendor information
-- 

DELETE FROM SEQUENCE WHERE NAME = 'VENDOR_SEQ';             
DELETE FROM SEQUENCE WHERE NAME = 'VENDOR_ROLE_SEQ';
DROP TABLE IF EXISTS PROJECT_VENDOR CASCADE;
DROP TABLE IF EXISTS VENDOR_ROLE CASCADE;
DROP TABLE IF EXISTS VENDOR_COMMUNICATION CASCADE;
DROP TABLE IF EXISTS VENDOR CASCADE;                                      
DROP TABLE IF EXISTS VENDOR_CUSTOM_FIELD CASCADE;
DROP TABLE IF EXISTS CUSTOM_FIELD CASCADE;
DROP TABLE IF EXISTS CUSTOM_FORM CASCADE;
DROP TABLE IF EXISTS VENDOR_FIELD_SECURITY CASCADE;
DROP TABLE IF EXISTS VENDOR_RATING CASCADE;
COMMIT;

--  VENDOR table
-- 
CREATE TABLE VENDOR
(
   ID BIGINT
      AUTO_INCREMENT
      PRIMARY KEY,
   CUSTOM_VENDOR_ID VARCHAR(40)
      NOT NULL
      UNIQUE,
   FIRST_NAME VARCHAR(40)
      NOT NULL,
   LAST_NAME VARCHAR(40)
      NOT NULL,
   PSEUDONYM VARCHAR(40)
      NOT NULL
      UNIQUE,
   TITLE VARCHAR(40),
   ADDRESS VARCHAR(4000),
   COMPANY  VARCHAR(80),
   COUNTRY VARCHAR(1000),
   NATIONALITIES VARCHAR(2000),
   DOB VARCHAR(20),
   NOTES TEXT,
   RESUME TEXT,
   RESUME_FILENAME VARCHAR(4000),
   APPLICATION_STATUS VARCHAR(10)
      NOT NULL
      CHECK (APPLICATION_STATUS IN ('PENDING', 'APPROVED', 'REJECTED','ON-HOLD')),
   IS_INTERNAL CHAR(1)
      CHECK (IS_INTERNAL IN ('Y','N')),
   ALLOW_AMBASSADOR_ACCESS CHAR(1)
      NOT NULL
      CHECK (ALLOW_AMBASSADOR_ACCESS IN ('Y', 'N')),
   IN_ALL_PROJECTS CHAR(1)
      NOT NULL
      CHECK (IN_ALL_PROJECTS IN ('Y','N')),
   COMMUNICATION_LOCALE VARCHAR(5)
      NOT NULL,
   USER_ID VARCHAR(80),
   `TIMESTAMP` DATETIME
      NOT NULL
) AUTO_INCREMENT = 1000;

--  VENDOR COMMUNICATION
-- 
CREATE TABLE VENDOR_COMMUNICATION
(
   VENDOR_ID BIGINT
      NOT NULL,
   COMMUNICATION_TYPE CHAR(1)
      NOT NULL,
   COMMUNICATION_VALUE VARCHAR(200),
   PRIMARY KEY(VENDOR_ID, COMMUNICATION_TYPE)
);

--  VENDOR ROLE
-- 
CREATE TABLE VENDOR_ROLE
(
   ID BIGINT
      AUTO_INCREMENT
      PRIMARY KEY,
   VENDOR_ID BIGINT
      NOT NULL,
   ACTIVITY_ID BIGINT
      NOT NULL,
   LOCALE_PAIR_ID BIGINT
      NOT NULL,
   RATE_ID BIGINT,
   CONSTRAINT FK_VENDOR_ROLE_VENDOR_ID FOREIGN KEY(VENDOR_ID) REFERENCES VENDOR(ID), 
   CONSTRAINT FK_VENDOR_ROLE_ACTIVITY_ID FOREIGN KEY(ACTIVITY_ID) REFERENCES ACTIVITY(ID),
   CONSTRAINT FK_VENDOR_ROLE_LOCALE_PAIR_ID FOREIGN KEY(LOCALE_PAIR_ID) REFERENCES LOCALE_PAIR(ID),
   CONSTRAINT FK_VENDOR_ROLE_RATE_ID FOREIGN KEY(RATE_ID) REFERENCES RATE(ID)
) AUTO_INCREMENT = 1000;

--  VENDOR PROJECT
-- 
CREATE TABLE PROJECT_VENDOR
(
   VENDOR_ID BIGINT
      NOT NULL,
   PROJECT_ID BIGINT
      NOT NULL,
   PRIMARY KEY(VENDOR_ID, PROJECT_ID)
);

--  CUSTOM_FORM
--    
CREATE TABLE CUSTOM_FORM
(
   ID BIGINT
      AUTO_INCREMENT
      PRIMARY KEY,
   PAGE_NAME VARCHAR(30) 
      NOT NULL,
   MODIFIER_USER_ID	VARCHAR(80)
      NOT NULL,
   MODIFIED_DATE DATETIME
      NOT NULL,
   FORM_XML	TEXT,
   LOCALE_ID BIGINT
      NOT NULL,
   CONSTRAINT FK_CUSTOM_FORM_LOCALE_ID FOREIGN KEY(LOCALE_ID) REFERENCES LOCALE(ID)
) AUTO_INCREMENT = 1000;

--  CUSTOM_FIELD
-- 
CREATE TABLE CUSTOM_FIELD
(
   ID BIGINT
      AUTO_INCREMENT
      PRIMARY KEY,
   FIELD_KEY VARCHAR(201)
      NOT NULL,
   FIELD_VALUE VARCHAR(100)
) AUTO_INCREMENT = 1000;

--  VENDOR_CUSTOM_FIELD
-- 
CREATE TABLE VENDOR_CUSTOM_FIELD
(
   VENDOR_ID BIGINT
      NOT NULL,
   CUSTOM_FIELD_ID BIGINT
      NOT NULL,
   PRIMARY KEY (VENDOR_ID, CUSTOM_FIELD_ID)
);

CREATE TABLE VENDOR_FIELD_SECURITY
(
   ID BIGINT
      AUTO_INCREMENT
      PRIMARY KEY,
   VENDOR_ID BIGINT
      NOT NULL
      UNIQUE,
   SECURITIES_XML VARCHAR(2000)
      NOT NULL,
   CONSTRAINT FK_VENDOR_FIELD_SECURITY_VENDOR_ID FOREIGN KEY(VENDOR_ID) REFERENCES VENDOR(ID)
) AUTO_INCREMENT = 1000;

--  Vendor Rating
CREATE TABLE VENDOR_RATING
(
  ID BIGINT
     AUTO_INCREMENT
     PRIMARY KEY,
  VENDOR_ID BIGINT 
     NOT NULL,  
  TASK_ID BIGINT,  
  VALUE INT(3)
     NOT NULL, 
  MODIFY_DATE DATETIME 
     NOT NULL,  
  MODIFY_USERID VARCHAR(80)
     NOT NULL, 
  COMMENTS VARCHAR(4000),
  CONSTRAINT FK_VENDOR_RATING_VENDOR_ID FOREIGN KEY(VENDOR_ID) REFERENCES VENDOR(ID),
  CONSTRAINT FK_VENDOR_RATING_TASK_ID FOREIGN KEY(TASK_ID) REFERENCES TASK_INFO(TASK_ID)
) AUTO_INCREMENT = 1000;



-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -
--  Begin Indexes 
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -

-- -- -- - Begin Vendor Indexes

CREATE INDEX  INDEX_USER_ID ON 
   VENDOR(USER_ID);    

CREATE INDEX  INDEX_COMPANY ON 
   VENDOR(COMPANY);    

CREATE INDEX  INDEX_FIRST_NAME ON 
   VENDOR(FIRST_NAME);

CREATE INDEX  INDEX_LAST_NAME ON 
   VENDOR(LAST_NAME);

CREATE INDEX  INDEX_FIELD_VALUE ON 
   CUSTOM_FIELD(FIELD_VALUE);  

CREATE INDEX  INDEX_RATING_VENDOR_ID ON 
   VENDOR_RATING(VENDOR_ID);


CREATE INDEX  INDEX_TASK_ID ON 
   VENDOR_RATING(TASK_ID);


CREATE INDEX  INDEX_ROLE_VENDOR_ID ON 
   VENDOR_ROLE(VENDOR_ID);

CREATE INDEX  INDEX_LOCALE_ID ON 
   VENDOR_ROLE(LOCALE_PAIR_ID);


CREATE INDEX  INDEX_ACTIVITY_ID ON 
   VENDOR_ROLE(ACTIVITY_ID);


CREATE INDEX  INDEX_RATE_ID ON 
   VENDOR_ROLE(RATE_ID);


-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -
--  Insert initial data
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 


INSERT INTO SEQUENCE VALUES('VENDOR_SEQ',1000);
INSERT INTO SEQUENCE VALUES('VENDOR_ROLE_SEQ', 1000);
INSERT INTO SEQUENCE VALUES('CUSTOM_FORM_SEQ', 1000);
INSERT INTO SEQUENCE VALUES('CUSTOM_FIELD_SEQ', 1000);
INSERT INTO SEQUENCE VALUES('VENDOR_FIELD_SECURITY_SEQ', 1000);
INSERT INTO SEQUENCE VALUES('RATING_SEQ', 1000);
COMMIT;

