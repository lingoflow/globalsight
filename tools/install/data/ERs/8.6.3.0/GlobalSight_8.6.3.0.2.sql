#GBS-3945:Workflow Notifications & Listener URL
CREATE TABLE `workflow_state_posts` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) NOT NULL,
  `DESCRIPTION` varchar(4000) DEFAULT NULL,
  `LISTENER_URL` varchar(100) NOT NULL,
  `SECRET_KEY` varchar(100) DEFAULT NULL,
  `TIMEOUT_PERIOD` int(3) DEFAULT NULL,
  `RETRY_NUMBER` int(3) DEFAULT NULL,
  `NOTIFY_EMAIL` varchar(100) DEFAULT NULL,
  `COMPANY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


ALTER TABLE COMPANY ADD COLUMN ENABLE_WORKFLOW_STATE_POSTS CHAR(1) DEFAULT 'N';

ALTER TABLE L10N_PROFILE ADD COLUMN WF_STATE_POST_ID BIGINT(20) DEFAULT '-1';