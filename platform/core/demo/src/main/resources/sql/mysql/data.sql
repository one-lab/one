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

insert into acct_userinfo values(1,'1390000000','1101','MALE','1');
insert into acct_userinfo values(2,'1390000001','1102','MALE','2');
insert into acct_userinfo values(3,'1390000002','1103','MALE','3');
insert into acct_userinfo values(4,'1390000003','1104','FEMALE','4');
insert into acct_userinfo values(5,'1390000004','1105','FEMALE','5');
insert into acct_userinfo values(6,'1390000005','1106','FEMALE','6');
  
INSERT INTO acct_user_group VALUES(1,1);
INSERT INTO acct_user_group VALUES(1,2);
INSERT INTO acct_user_group VALUES(2,2);
INSERT INTO acct_user_group VALUES(3,2);
INSERT INTO acct_user_group VALUES(4,2);
INSERT INTO acct_user_group VALUES(5,2);
INSERT INTO acct_user_group VALUES(6,2);