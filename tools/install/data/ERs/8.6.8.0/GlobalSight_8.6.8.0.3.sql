# GBS-4285:make mt char limit configurable

ALTER TABLE TM_PROFILE ADD COLUMN IS_MTED_SEG_SAVED_TO_PROJ_TM CHAR(1) DEFAULT 'Y';

ALTER TABLE MT_PROFILE ADD COLUMN LOG_DEBUG_INFO CHAR(1) DEFAULT 'N';

ALTER TABLE MT_PROFILE ADD COLUMN IGNORE_TM_MATCHES CHAR(1) DEFAULT 'N';

ALTER TABLE MT_PROFILE ADD COLUMN MS_TRANS_TYPE CHAR(1) DEFAULT '2';

ALTER TABLE MT_PROFILE ADD COLUMN MS_MAX_LENGTH BIGINT(20) DEFAULT 1000;

ALTER TABLE MT_PROFILE DROP COLUMN SHOW_IN_EDITOR;

commit;