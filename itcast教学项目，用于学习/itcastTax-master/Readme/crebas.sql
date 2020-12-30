/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/6/22 18:10:42                           */
/*==============================================================*/


drop table if exists emp_role;

drop table if exists role_pri;

drop table if exists t_dept;

drop table if exists t_employee;

drop table if exists t_leader;

drop table if exists t_org;

drop table if exists t_privilege;

drop table if exists t_role;

drop table if exists tmonth;

/*==============================================================*/
/* Table: emp_role                                              */
/*==============================================================*/
create table emp_role
(
   emp_id               varchar(32) not null,
   role_id              varchar(32) not null,
   state                int comment 'tzgg ֪ͨ����',
   primary key (emp_id, role_id)
);

/*==============================================================*/
/* Table: role_pri                                              */
/*==============================================================*/
create table role_pri
(
   role_id              varchar(32) not null,
   pri_id               varchar(32) not null,
   primary key (role_id, pri_id)
);

/*==============================================================*/
/* Table: t_dept                                                */
/*==============================================================*/
create table t_dept
(
   dept_id              varchar(32) not null,
   org_id               varchar(32) not null,
   name                 varchar(50),
   primary key (dept_id)
);

/*==============================================================*/
/* Table: t_employee                                            */
/*==============================================================*/
create table t_employee
(
   emp_id               varchar(32) not null,
   dept_id              varchar(32) not null,
   name                 varchar(50) not null,
   primary key (emp_id)
);

/*==============================================================*/
/* Table: t_leader                                              */
/*==============================================================*/
create table t_leader
(
   emp_id               varchar(32) not null,
   dept_id              varchar(32),
   name                 varchar(50) not null,
   position             int,
   primary key (emp_id)
);

/*==============================================================*/
/* Table: t_org                                                 */
/*==============================================================*/
create table t_org
(
   org_id               varchar(32) not null,
   name                 varchar(50),
   primary key (org_id)
);

/*==============================================================*/
/* Table: t_privilege                                           */
/*==============================================================*/
create table t_privilege
(
   pri_id               varchar(32) not null,
   name                 varchar(50),
   primary key (pri_id)
);

/*==============================================================*/
/* Table: t_role                                                */
/*==============================================================*/
create table t_role
(
   role_id              varchar(32) not null,
   name                 varchar(50),
   primary key (role_id)
);

/*==============================================================*/
/* Table: tmonth                                      */
/*==============================================================*/
CREATE TABLE tmonth (
  imonth varchar(20) DEFAULT NULL
);

/*Data for the table `tmonth` */
insert  into `tmonth`(`imonth`) values ('1'),('2'),('3'),('4'),('5'),('6'),('7'),('8'),('9'),('10'),('11'),('12');

alter table emp_role add constraint FK_emp_role foreign key (emp_id)
      references t_employee (emp_id) on delete restrict on update restrict;

alter table emp_role add constraint FK_emp_role2 foreign key (role_id)
      references t_role (role_id) on delete restrict on update restrict;

alter table role_pri add constraint FK_belong foreign key (role_id)
      references t_role (role_id) on delete restrict on update restrict;

alter table role_pri add constraint FK_own foreign key (pri_id)
      references t_privilege (pri_id) on delete restrict on update restrict;

alter table t_dept add constraint FK_org_dept foreign key (org_id)
      references t_org (org_id) on delete restrict on update restrict;

alter table t_employee add constraint FK_dept_emp foreign key (dept_id)
      references t_dept (dept_id) on delete restrict on update restrict;

alter table t_leader add constraint FK_Inheritance_1 foreign key (emp_id)
      references t_employee (emp_id) on delete restrict on update restrict;

