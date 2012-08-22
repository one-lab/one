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
  
insert into acct_user_group values(1,1);
insert into acct_user_group values(1,2);
insert into acct_user_group values(2,2);
insert into acct_user_group values(3,2);
insert into acct_user_group values(4,2);
insert into acct_user_group values(5,2);
insert into acct_user_group values(6,2);