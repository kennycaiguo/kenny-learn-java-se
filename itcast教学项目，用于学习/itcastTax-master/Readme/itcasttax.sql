/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.20 : Database - itcasttax
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`itcasttax` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `itcasttax`;

/*Table structure for table `complain` */

DROP TABLE IF EXISTS `complain`;

CREATE TABLE `complain` (
  `comp_id` varchar(32) NOT NULL,
  `comp_company` varchar(100) DEFAULT NULL,
  `comp_name` varchar(20) DEFAULT NULL,
  `comp_mobile` varchar(20) DEFAULT NULL,
  `is_NM` bit(1) DEFAULT NULL,
  `comp_time` datetime DEFAULT NULL,
  `comp_title` varchar(200) NOT NULL,
  `to_comp_name` varchar(20) DEFAULT NULL,
  `to_comp_dept` varchar(100) DEFAULT NULL,
  `comp_content` longtext,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `complain` */

insert  into `complain`(`comp_id`,`comp_company`,`comp_name`,`comp_mobile`,`is_NM`,`comp_time`,`comp_title`,`to_comp_name`,`to_comp_dept`,`comp_content`,`state`) values ('402881e461fb76890161fba70e3a0000','1','faye','18810278525','','2018-03-06 22:11:25','test',NULL,'部门A','<p>sdfsfs</p>','1'),('402881e461fb76890161fba79a540001','1','faye','18810278525','\0','2018-01-06 22:12:01','test2',NULL,'部门B','<p>wer</p>','0'),('402881e46200707f01620093dabd0000','1','faye','18810278525','','2018-02-07 21:08:33','wer',NULL,'部门A','<p>wer232</p>','0'),('402881e46206049f0162060952fb0005','部门A','faye','18810278525','','2018-01-08 22:34:57','特他','Ellie','部门A','<p>尔特瑞特他</p>','0'),('402881e46214d5b601621a6d1b4a0000','部门B','faye','12345678911','','2018-03-12 21:36:21','水电费水电费','faye','部门B','<p>法规的规定</p>','0'),('402881e46214d5b601621a6f3fe10001','部门B','faye','12345678911','\0','2018-03-12 21:38:41','电饭锅电饭锅','test2','部门A','<p>地方郭德纲</p>','0'),('402881e4621f84250162247a63b10001','部门B','faye','12345678911','\0','2018-03-14 20:27:03','test8','test3','部门A','<p>胜多负少的规定发给对方</p>','0');

/*Table structure for table `complain_reply` */

DROP TABLE IF EXISTS `complain_reply`;

CREATE TABLE `complain_reply` (
  `reply_id` varchar(32) NOT NULL,
  `comp_id` varchar(32) NOT NULL,
  `replyer` varchar(20) DEFAULT NULL,
  `reply_dept` varchar(100) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `reply_content` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `FK6A0B84141EF57131` (`comp_id`),
  CONSTRAINT `FK6A0B84141EF57131` FOREIGN KEY (`comp_id`) REFERENCES `complain` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `complain_reply` */

insert  into `complain_reply`(`reply_id`,`comp_id`,`replyer`,`reply_dept`,`reply_time`,`reply_content`) values ('402881e46206049f01620606ce7e0003','402881e461fb76890161fba70e3a0000','faye','部门A','2018-03-08 22:32:12','tongyi');

/*Table structure for table `emp_role` */

DROP TABLE IF EXISTS `emp_role`;

CREATE TABLE `emp_role` (
  `emp_id` varchar(32) NOT NULL,
  `role_id` varchar(32) NOT NULL,
  `state` int(11) DEFAULT NULL COMMENT 'tzgg ֪ͨ����',
  PRIMARY KEY (`emp_id`,`role_id`),
  KEY `FK_emp_role2` (`role_id`),
  CONSTRAINT `FK_emp_role` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`emp_id`),
  CONSTRAINT `FK_emp_role2` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp_role` */

/*Table structure for table `info` */

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
  `info_id` varchar(32) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` longtext,
  `memo` varchar(200) DEFAULT NULL,
  `creator` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `info` */

insert  into `info`(`info_id`,`type`,`source`,`title`,`content`,`memo`,`creator`,`create_time`,`state`) values ('402881e46206049f01620608c3d40004','tzgg','sky','美国要打贸易战了','<p style=\"text-align: left;\">热让他让他而特特他TV</p>','同仁堂','faye','2018-03-08 22:32:58','1');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`name`,`state`) values ('1','管理员1','1'),('402881e4620098ab016200ca06720000','一般用户','1'),('402881e4620098ab016200cc917e0001','二般用户','1'),('402881e46205cfc6016205f66eb70004','管理员','0'),('402881e4621f64ce01621f6572b80000','test3',NULL),('402881e4621f64ce01621f65e6bd0001','test ','1'),('402881e4621f84250162247843bb0000','test6','0');

/*Table structure for table `role_pri` */

DROP TABLE IF EXISTS `role_pri`;

CREATE TABLE `role_pri` (
  `role_id` varchar(32) NOT NULL,
  `pri_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`pri_id`),
  KEY `FK_own` (`pri_id`),
  CONSTRAINT `FK_belong` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK_own` FOREIGN KEY (`pri_id`) REFERENCES `t_privilege` (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_pri` */

insert  into `role_pri`(`role_id`,`pri_id`) values ('1','1');

/*Table structure for table `role_privilege` */

DROP TABLE IF EXISTS `role_privilege`;

CREATE TABLE `role_privilege` (
  `role_id` varchar(32) NOT NULL,
  `code` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`,`code`),
  KEY `FK45FBD62869372004` (`role_id`),
  CONSTRAINT `FK45FBD62869372004` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_privilege` */

insert  into `role_privilege`(`role_id`,`code`) values ('1','hqfw'),('1','nsfw'),('1','space'),('1','xzgl'),('1','zxxx'),('402881e4620098ab016200ca06720000','space'),('402881e4620098ab016200cc917e0001','nsfw'),('402881e4620098ab016200cc917e0001','space'),('402881e46205cfc6016205f66eb70004','hqfw'),('402881e46205cfc6016205f66eb70004','nsfw'),('402881e46205cfc6016205f66eb70004','space'),('402881e46205cfc6016205f66eb70004','xzgl'),('402881e46205cfc6016205f66eb70004','zxxx'),('402881e4621f64ce01621f6572b80000','zxxx'),('402881e4621f64ce01621f65e6bd0001','zxxx'),('402881e4621f84250162247843bb0000','zxxx');

/*Table structure for table `t_dept` */

DROP TABLE IF EXISTS `t_dept`;

CREATE TABLE `t_dept` (
  `dept_id` varchar(32) NOT NULL,
  `org_id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dept_id`),
  KEY `FK_org_dept` (`org_id`),
  CONSTRAINT `FK_org_dept` FOREIGN KEY (`org_id`) REFERENCES `t_org` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_dept` */

/*Table structure for table `t_employee` */

DROP TABLE IF EXISTS `t_employee`;

CREATE TABLE `t_employee` (
  `emp_id` varchar(32) NOT NULL,
  `dept_id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_dept_emp` (`dept_id`),
  CONSTRAINT `FK_dept_emp` FOREIGN KEY (`dept_id`) REFERENCES `t_dept` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_employee` */

/*Table structure for table `t_leader` */

DROP TABLE IF EXISTS `t_leader`;

CREATE TABLE `t_leader` (
  `emp_id` varchar(32) NOT NULL,
  `dept_id` varchar(32) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  CONSTRAINT `FK_Inheritance_1` FOREIGN KEY (`emp_id`) REFERENCES `t_employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_leader` */

/*Table structure for table `t_org` */

DROP TABLE IF EXISTS `t_org`;

CREATE TABLE `t_org` (
  `org_id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_org` */

/*Table structure for table `t_privilege` */

DROP TABLE IF EXISTS `t_privilege`;

CREATE TABLE `t_privilege` (
  `pri_id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_privilege` */

insert  into `t_privilege`(`pri_id`,`name`) values ('1','nsfw');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `role_id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`role_id`,`name`) values ('1','管理员');

/*Table structure for table `tmonth` */

DROP TABLE IF EXISTS `tmonth`;

CREATE TABLE `tmonth` (
  `imonth` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmonth` */

insert  into `tmonth`(`imonth`) values ('1'),('2'),('3'),('4'),('5'),('6'),('7'),('8'),('9'),('10'),('11'),('12');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `dept` varchar(20) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `headImg` varchar(100) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`dept`,`account`,`password`,`headImg`,`gender`,`email`,`mobile`,`birthday`,`state`,`memo`) values ('402881e46205cfc6016205d51c680001','test','部门A','werw','wer',NULL,'\0','wer','2342342423','2018-03-21 00:00:00','1',''),('402881e46205cfc6016205d66fb50002','faye','部门B','admin','admin','user/31193e173349423ca834587b642f1588.png','','faye@163.com','12345678911','2018-03-08 00:00:00','1','a good boy\r\n'),('402881e46205cfc6016205ed68d50003','Ellie','部门A','ellie','ellie','user/fb2685561a684c9589713ad4e1b5bb4f.png','','ellie@163.com','12345678911','2018-03-28 00:00:00','1','a pretty girl\r\n'),('402881e46205fcf9016206011fba0000','test2','部门A','而我','玩儿',NULL,'\0','34','',NULL,'1',''),('402881e46206049f01620605a1ad0000','test3','部门A','test3','3test',NULL,'\0','','',NULL,'1',''),('402881e46206049f01620605d32b0001','3test','部门A','3test','3test',NULL,'\0','','',NULL,'1',''),('402881e46206049f016206062d210002','3test','部门A','3test1','3test',NULL,'\0','','',NULL,'1',''),('402881e462060b9501620629f28d0000','test1000','部门A','user9','123456',NULL,'','user1@itcast.com','13888888888','1999-10-10 00:00:00','1',NULL),('402881e462060b9501620629f2920001','test','部门B','user4','123456',NULL,'\0','user2@itcast.com','13888888888','1999-10-11 00:00:00','1',NULL),('402881e4621f4b3301621f5772140000','ere','部门A','faye','sdfs',NULL,'\0','','',NULL,'1','');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK143BF46A69372004` (`role_id`),
  CONSTRAINT `FK143BF46A69372004` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`role_id`,`user_id`) values ('1','402881e46205cfc6016205ed68d50003'),('1','402881e46205fcf9016206011fba0000'),('402881e4620098ab016200ca06720000','402881e46205cfc6016205d51c680001'),('402881e46205cfc6016205f66eb70004','402881e46205cfc6016205d66fb50002');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
