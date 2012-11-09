-- ----------------------------
-- Records of acct_group
-- ----------------------------
INSERT INTO acct_group VALUES ('2', '用户');
INSERT INTO acct_group VALUES ('1', '管理员');

-- ----------------------------
-- Records of acct_group_permission
-- ----------------------------
INSERT INTO acct_group_permission VALUES ('1', 'user:view');
INSERT INTO acct_group_permission VALUES ('1', 'user:edit');
INSERT INTO acct_group_permission VALUES ('1', 'group:view');
INSERT INTO acct_group_permission VALUES ('1', 'group:edit');
INSERT INTO acct_group_permission VALUES ('2', 'user:view');
INSERT INTO acct_group_permission VALUES ('2', 'group:view');
  
INSERT INTO acct_user VALUES(1,'admin@springside.org.cn','admin','Admin','admin',now());
INSERT INTO acct_user VALUES(2,'user@springside.org.cn','user','User','user',now());
INSERT INTO acct_user VALUES(3,'jack@springside.org.cn','user2','Jack','user2',now());
INSERT INTO acct_user VALUES(4,'kate@springside.org.cn','user3','Kate','user3',now());
INSERT INTO acct_user VALUES(5,'sawyer@springside.org.cn','user4','Sawyer','user4',now());
INSERT INTO acct_user VALUES(6,'ben@springside.org.cn','user5','Ben','user5',now());

INSERT INTO acct_userinfo VALUES(1,'1390000000','1101','MALE','1');
INSERT INTO acct_userinfo VALUES(2,'1390000001','1102','MALE','2');
INSERT INTO acct_userinfo VALUES(3,'1390000002','1103','MALE','3');
INSERT INTO acct_userinfo VALUES(4,'1390000003','1104','FEMALE','4');
INSERT INTO acct_userinfo VALUES(5,'1390000004','1105','FEMALE','5');
INSERT INTO acct_userinfo VALUES(6,'1390000005','1106','FEMALE','6');
  
INSERT INTO acct_user_group VALUES(1,1);
INSERT INTO acct_user_group VALUES(1,2);
INSERT INTO acct_user_group VALUES(2,2);
INSERT INTO acct_user_group VALUES(3,2);
INSERT INTO acct_user_group VALUES(4,2);
INSERT INTO acct_user_group VALUES(5,2);
INSERT INTO acct_user_group VALUES(6,2);

CREATE PROCEDURE `MYSQL_PRO_FOR_DEMO`(IN `P_ID` bigint(20),IN `P_NAME` varchar(255),OUT `P_OUTPRO1` bigint(20),OUT `P_OUTPRO2` bigint(20))
BEGIN
	SELECT COUNT(*) INTO P_OUTPRO1 FROM acct_user a WHERE a.id>=P_ID;
	SELECT COUNT(*) INTO P_OUTPRO2 FROM acct_user b WHERE b.name LIKE P_NAME;
	SELECT * FROM acct_userinfo c WHERE c.id IN (SELECT a.id FROM acct_user a WHERE a.id>=P_ID AND a.name LIKE P_NAME);
END;