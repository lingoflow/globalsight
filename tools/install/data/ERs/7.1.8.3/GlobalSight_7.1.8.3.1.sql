# For GBS-1587 : office 2010 to extract master data
ALTER TABLE `office2010_filter` ADD COLUMN `IS_MASTER_TRANSLATE` CHAR(1) NOT NULL DEFAULT 'N' AFTER `IS_HEADER_TRANSLATE`;