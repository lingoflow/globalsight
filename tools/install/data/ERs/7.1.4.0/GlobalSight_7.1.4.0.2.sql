-- for GBS-471
ALTER TABLE file_profile ADD COLUMN IS_HEADER_TRANSLATE CHAR(1);

commit;