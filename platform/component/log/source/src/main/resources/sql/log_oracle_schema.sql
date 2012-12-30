-- Create table GE_USER_BEHAVIOR_LOG
drop table GE_USER_BEHAVIOR_LOG;

create table GE_USER_BEHAVIOR_LOG
(
  id          VARCHAR2(32) not null,
  url         VARCHAR2(256) not null,
  visittime   DATE not null,
  paraminfoes VARCHAR2(3000),
  sessionid   VARCHAR2(32) not null,
  userid      VARCHAR2(32),
  userip      VARCHAR2(32),
  appname     VARCHAR2(32)
);
-- Add comments to the columns 
comment on column GE_USER_BEHAVIOR_LOG.id
  is '主键ID';
comment on column GE_USER_BEHAVIOR_LOG.url
  is '请求URL';
comment on column GE_USER_BEHAVIOR_LOG.visittime
  is '访问时间';
comment on column GE_USER_BEHAVIOR_LOG.paraminfoes
  is '参数信息';
comment on column GE_USER_BEHAVIOR_LOG.sessionid
  is '会话ID';
comment on column GE_USER_BEHAVIOR_LOG.userid
  is '登录用户ID';
comment on column GE_USER_BEHAVIOR_LOG.userip
  is '用户IP';
comment on column GE_USER_BEHAVIOR_LOG.appname
  is '应用名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GE_USER_BEHAVIOR_LOG
  add constraint PK_GE_USER_BEHAVIOR_LOG primary key (ID);
  


-- Create table GE_METHOD_TRACE_LOG
drop table GE_METHOD_TRACE_LOG;
create table GE_METHOD_TRACE_LOG
(
  id             VARCHAR2(32) not null,
  urltraceid     VARCHAR2(32),
  methodname     VARCHAR2(64) not null,
  classname      VARCHAR2(128) not null,
  inparam        VARCHAR2(512),
  outparam       VARCHAR2(512),
  begintime      DATE not null,
  endtime        DATE not null,
  consumetime    NUMBER(10) not null,
  loglevel       VARCHAR2(16) not null,
  logdescription VARCHAR2(1024) not null,
  logtime        DATE not null,
  appname        VARCHAR2(32),
  userid         VARCHAR2(32),
  environment    VARCHAR2(16)
);

-- Add comments to the columns 
comment on column GE_METHOD_TRACE_LOG.id
  is '主键Id';
comment on column GE_METHOD_TRACE_LOG.urltraceid
  is 'URL追踪ID';
comment on column GE_METHOD_TRACE_LOG.methodname
  is '方法名';
comment on column GE_METHOD_TRACE_LOG.classname
  is '方法所属类名';
comment on column GE_METHOD_TRACE_LOG.inparam
  is '方法输入参数';
comment on column GE_METHOD_TRACE_LOG.outparam
  is '方法输出参数';
comment on column GE_METHOD_TRACE_LOG.begintime
  is '执行开始时间';
comment on column GE_METHOD_TRACE_LOG.endtime
  is '执行结束时间';
comment on column GE_METHOD_TRACE_LOG.consumetime
  is '执行时间';
comment on column GE_METHOD_TRACE_LOG.loglevel
  is '日志级别';
comment on column GE_METHOD_TRACE_LOG.logdescription
  is '日志描述';
comment on column GE_METHOD_TRACE_LOG.logtime
  is '日志记录时间';
comment on column GE_METHOD_TRACE_LOG.appname
  is '应用名称';
comment on column GE_METHOD_TRACE_LOG.userid
  is '操作用户ID';
comment on column GE_METHOD_TRACE_LOG.environment
  is '环境级别';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GE_METHOD_TRACE_LOG
  add constraint PK_GE_METHOD_TRACE_LOG primary key (ID);
  
-- Create table GE_URL_TRACE_LOG
drop table GE_URL_TRACE_LOG;
create table GE_URL_TRACE_LOG
(
  id          VARCHAR2(32) not null,
  url         VARCHAR2(256) not null,
  begintime   DATE not null,
  endtime     DATE not null,
  consumetime NUMBER(10) not null,
  sessionid   VARCHAR2(32) not null,
  userid      VARCHAR2(32),
  userip      VARCHAR2(32),
  appname     VARCHAR2(32),
  requestinfo BLOB
);

-- Add comments to the columns 
comment on column GE_URL_TRACE_LOG.id
  is '主键Id';
comment on column GE_URL_TRACE_LOG.url
  is '请求URL';
comment on column GE_URL_TRACE_LOG.begintime
  is '开始时间';
comment on column GE_URL_TRACE_LOG.endtime
  is '结束时间';
comment on column GE_URL_TRACE_LOG.consumetime
  is '执行时间';
comment on column GE_URL_TRACE_LOG.sessionid
  is '会话ID';
comment on column GE_URL_TRACE_LOG.userid
  is '用户ID';
comment on column GE_URL_TRACE_LOG.userip
  is '用户IP';
comment on column GE_URL_TRACE_LOG.appname
  is '应用名称';
comment on column GE_URL_TRACE_LOG.requestinfo
  is '请求信息';
-- Create/Recreate primary, unique and foreign key constraints 
alter table GE_URL_TRACE_LOG
  add constraint PK_GE_URL_TRACE_LOG primary key (ID);

  
