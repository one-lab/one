drop table if exists GE_Monitor_AppException;

/*==============================================================*/
/* Table: GE_Monitor_AppException          Ӧ���쳣��                   */
/*==============================================================*/
create table GE_Monitor_AppException
(
   SerialNo             VARCHAR(32) not null comment '���',
   AppName              VARCHAR(100)  not null comment '�쳣���Ե�Ӧ��ϵͳ',
   ExceptionKind        VARCHAR(2)  not null comment '�쳣�������',
   UserExceptionCode    VARCHAR(4) comment '�û��쳣����',
   SubUserExceptionCode VARCHAR(6) comment '���û��쳣����',
   ConcreteExceptionCode VARCHAR(3)  comment '�����쳣����',
   ExceptionDesc        VARCHAR(500)  not null comment '�쳣����',
   ExceptionReason      LONGTEXT comment '�쳣ԭ��',
   ExceptionTime        DATE not null comment '�쳣ʱ��',
   ExceptionGrade       VARCHAR(1)  not null comment '�쳣����0 �����أ�1 ���أ�2 �����أ�3 ��������',
   primary key (SerialNo)
);


