# GBS-3704: McAfee SaaS: Trisoft (LiveContent Architect) Checker.

ALTER TABLE company ADD COLUMN ENABLE_DITA_CHECKS CHAR(1) DEFAULT 'N';

ALTER TABLE activity ADD COLUMN RUN_DITA_QA_CHECKS CHAR(1) DEFAULT 'N';

ALTER TABLE project ADD COLUMN MANUAL_RUN_DITA_CHECKS CHAR(1) DEFAULT 'N';
ALTER TABLE project ADD COLUMN AUTO_ACCEPT_DITA_QA_TASK CHAR(1) DEFAULT 'N';
ALTER TABLE project ADD COLUMN AUTO_SEND_DITA_QA_REPORT CHAR(1) DEFAULT 'N';
