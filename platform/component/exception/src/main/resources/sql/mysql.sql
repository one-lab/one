drop table if exists GE_Monitor_AppException;

/*==============================================================*/
/* Table: GE_Monitor_AppException          应用异常表                   */
/*==============================================================*/
create table GE_Monitor_AppException
(
   SerialNo             VARCHAR(32) not null comment '序号',
   AppName              VARCHAR(100)  not null comment '异常来自的应用系统',
   ExceptionKind        VARCHAR(2)  not null comment '异常大类代码',
   UserExceptionCode    VARCHAR(4) comment '用户异常代码',
   SubUserExceptionCode VARCHAR(6) comment '子用户异常代码',
   ConcreteExceptionCode VARCHAR(3)  comment '具体异常代码',
   ExceptionDesc        VARCHAR(500)  not null comment '异常描述',
   ExceptionReason      LONGTEXT comment '异常原因',
   ExceptionTime        DATE not null comment '异常时间',
   ExceptionGrade       VARCHAR(1)  not null comment '异常级别：0 不严重，1 严重，2 很严重，3 极其严重',
   primary key (SerialNo)
);


