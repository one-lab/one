-- Drop table
drop table GE_EXCEPTION_INFO;
-- Create table
create table GE_EXCEPTION_INFO
(
  id                    VARCHAR2(32) not null,
  appname               VARCHAR2(32) not null,
  exceptionkind         VARCHAR2(10) not null,
  userexceptioncode     VARCHAR2(10) not null,
  subuserexceptioncode  VARCHAR2(10) not null,
  concreteexceptioncode VARCHAR2(10),
  exceptiondesc         VARCHAR2(500) not null,
  exceptionstacktrace   BLOB not null,
  exceptiontime         DATE not null,
  exceptionlevel        VARCHAR2(10) not null
);

-- Add comments to the columns
comment on column GE_EXCEPTION_INFO.id
  is '主键ID';
comment on column GE_EXCEPTION_INFO.appname
  is '应用系统名称';
comment on column GE_EXCEPTION_INFO.exceptionkind
  is '异常大类代码';
comment on column GE_EXCEPTION_INFO.userexceptioncode
  is '用户异常代码';
comment on column GE_EXCEPTION_INFO.subuserexceptioncode
  is '子用户异常代码';
comment on column GE_EXCEPTION_INFO.concreteexceptioncode
  is '具体异常代码';
comment on column GE_EXCEPTION_INFO.exceptiondesc
  is '异常描述';
comment on column GE_EXCEPTION_INFO.exceptionstacktrace
  is '异常堆栈';
comment on column GE_EXCEPTION_INFO.exceptiontime
  is '异常时间';
comment on column GE_EXCEPTION_INFO.exceptionlevel
  is '异常级别';
-- Create/Recreate primary, unique and foreign key constraints
alter table GE_EXCEPTION_INFO
  add constraint PK_GE_EXCEPTION_INFO primary key (ID);