# for gbs-1173
ALTER TABLE ISSUE ADD COLUMN SHARE CHAR(1) NOT NULL;
ALTER TABLE ISSUE ADD COLUMN OVERWRITE CHAR(1) NOT NULL;
update ISSUE set SHARE = 'N';
update ISSUE set OVERWRITE = 'N';