-- for GBS-357
ALTER TABLE workflow MODIFY COLUMN DURATION BIGINT(20);

commit;