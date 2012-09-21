-- Create table T_CODE_GENDER
create table T_CODE_GENDER
(
  ID   VARCHAR2(3) primary key,
  NAME VARCHAR2(10)
);
-- insert init data for T_CODE_GENDER
insert into T_CODE_GENDER (ID, NAME) values ('1','男');
insert into T_CODE_GENDER (ID, NAME) values ('0','女');
insert into T_CODE_GENDER (ID, NAME) values ('3', 'g3');
insert into T_CODE_GENDER (ID, NAME) values ('4', 'g4');
insert into T_CODE_GENDER (ID, NAME) values ('5', 'g5');
insert into T_CODE_GENDER (ID, NAME) values ('6', 'g6');
insert into T_CODE_GENDER (ID, NAME) values ('7', 'g7');
insert into T_CODE_GENDER (ID, NAME) values ('8', 'g8');
insert into T_CODE_GENDER (ID, NAME) values ('9', 'g9');
-- Create table T_CODE_GROUP
create table T_CODE_GROUP
(
  ID   VARCHAR2(3) primary key,
  NAME VARCHAR2(10)
);
-- Create table T_CHECK_BOOLEAN
create table T_CHECK_BOOLEAN
(
  ID          VARCHAR2(32) primary key,
  BOOLEAN_INT INTEGER,
  BOOLEAN_STR VARCHAR2(20)
);
-- Create table T_USER
create table T_USER
(
  ID       VARCHAR2(32) primary key,
  NAME     VARCHAR2(200),
  AGE      INTEGER,
  BIRTHDAY DATE,
  MONEY    LONG,
  GENDER   VARCHAR2(3) CONSTRAINT fk_gender_id  REFERENCES  t_code_gender(id),
  GROUPIDS VARCHAR2(300) CONSTRAINT fk_group_id  REFERENCES  t_code_group(id)
);
-- Create Procedure testprc
create or replace procedure testprc(newname in varchar2,uid in varchar2) is

begin
  update t_code_group set name = newname where id = trim(uid);
  commit;
end testprc;
