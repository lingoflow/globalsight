ALTER TABLE MODULE_MAPPING MODIFY COLUMN IS_ACTIVE CHAR(1) DEFAULT 'Y';
ALTER TABLE MODULE_MAPPING ADD COLUMN SUB_FOLDER_MAPPED CHAR(1) DEFAULT '0';
ALTER TABLE CVS_SOURCE_FILES ADD COLUMN JOB_NOTES VARCHAR(1000) NULL;