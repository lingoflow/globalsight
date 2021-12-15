#For GBS-2073
ALTER TABLE `ms_office_doc_filter` CHANGE COLUMN `SECOND_FILTER_ID` `CONTENT_POST_FILTER_ID` bigint(20) NOT NULL;
ALTER TABLE `ms_office_doc_filter` CHANGE COLUMN `SECOND_FILTER_TABLE_NAME` `CONTENT_POST_FILTER_TABLE_NAME` varchar(45) NOT NULL;
ALTER TABLE `ms_office_doc_filter` ADD COLUMN `IS_ALT_TRANSLATE` CHAR(1) NOT NULL DEFAULT 'N';

ALTER TABLE `ms_office_excel_filter` CHANGE COLUMN `SECOND_FILTER_ID` `CONTENT_POST_FILTER_ID` bigint(20) NOT NULL;
ALTER TABLE `ms_office_excel_filter` CHANGE COLUMN `SECOND_FILTER_TABLE_NAME` `CONTENT_POST_FILTER_TABLE_NAME` varchar(45) NOT NULL;
ALTER TABLE `ms_office_excel_filter` ADD COLUMN `IS_ALT_TRANSLATE` CHAR(1) NOT NULL DEFAULT 'N';

ALTER TABLE `ms_office_ppt_filter` CHANGE COLUMN `SECOND_FILTER_ID` `CONTENT_POST_FILTER_ID` bigint(20) NOT NULL;
ALTER TABLE `ms_office_ppt_filter` CHANGE COLUMN `SECOND_FILTER_TABLE_NAME` `CONTENT_POST_FILTER_TABLE_NAME` varchar(45) NOT NULL;
ALTER TABLE `ms_office_ppt_filter` CHANGE COLUMN `EXTRACT_ALT` `IS_ALT_TRANSLATE` CHAR(1) NOT NULL DEFAULT 'N';
