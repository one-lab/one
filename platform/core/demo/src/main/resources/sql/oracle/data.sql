insert into acct_group values(1,'管理员');
insert into acct_group values(2,'用户');

insert into acct_group_permission values(1,'user:view');
insert into acct_group_permission values(1,'user:edit');
insert into acct_group_permission values(1,'group:view');
insert into acct_group_permission values(1,'group:edit');
insert into acct_group_permission values(2,'user:view');
insert into acct_group_permission values(2,'group:view');
  
insert into acct_user values(1,'admin@springside.org.cn','admin','Admin','admin',sysdate);
insert into acct_user values(2,'user@springside.org.cn','user','User','user',sysdate);
insert into acct_user values(3,'jack@springside.org.cn','user2','Jack','user2',sysdate);
insert into acct_user values(4,'kate@springside.org.cn','user3','Kate','user3',sysdate);
insert into acct_user values(5,'sawyer@springside.org.cn','user4','Sawyer','user4',sysdate);
insert into acct_user values(6,'ben@springside.org.cn','user5','Ben','user5',sysdate);

insert into acct_userinfo values(1,'1390000000','1101','MALE','1');
insert into acct_userinfo values(2,'1390000001','1102','MALE','2');
insert into acct_userinfo values(3,'1390000002','1103','MALE','3');
insert into acct_userinfo values(4,'1390000003','1104','FEMALE','4');
insert into acct_userinfo values(5,'1390000004','1105','FEMALE','5');
insert into acct_userinfo values(6,'1390000005','1106','FEMALE','6');
  
insert into acct_user_group values(1,1);
insert into acct_user_group values(1,2);
insert into acct_user_group values(2,2);
insert into acct_user_group values(3,2);
insert into acct_user_group values(4,2);
insert into acct_user_group values(5,2);
insert into acct_user_group values(6,2);

CREATE OR REPLACE PROCEDURE ORACLE_PRO_FOR_DEMO(P_ID IN ACCT_USER.ID%TYPE,P_NAME IN ACCT_USER.NAME%TYPE,
P_OUTPRO1 OUT SYS_REFCURSOR,P_OUTPRO2 OUT SYS_REFCURSOR) IS
BEGIN
          OPEN P_OUTPRO1 FOR SELECT * FROM ACCT_USER a WHERE a.ID>=P_ID AND a.Name LIKE P_NAME;
          OPEN P_OUTPRO2 FOR SELECT PHONE FROM ACCT_USERINFO b WHERE b.ID IN
          (SELECT a.ID FROM ACCT_USER a WHERE a.ID>=P_ID AND a.Name LIKE P_NAME);
END ORACLE_PRO_FOR_DEMO;
