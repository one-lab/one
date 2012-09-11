/*
MySQL Backup
Source Server Version: 5.0.24
Source Database: mini-web
Date: 2012-9-10 20:35:32
*/


-- ----------------------------
--  Table structure for `t_check_boolean`
-- ----------------------------
DROP TABLE IF EXISTS `t_check_boolean`;
CREATE TABLE `t_check_boolean` (
  `ID` varchar(32) NOT NULL,
  `BOOLEAN_INT` int(11) default NULL,
  `BOOLEAN_STR` varchar(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_code_gender`
-- ----------------------------
DROP TABLE IF EXISTS `t_code_gender`;
CREATE TABLE `t_code_gender` (
  `ID` varchar(3) NOT NULL,
  `NAME` varchar(10) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_code_group`
-- ----------------------------
DROP TABLE IF EXISTS `t_code_group`;
CREATE TABLE `t_code_group` (
  `ID` varchar(3) NOT NULL,
  `NAME` varchar(10) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` varchar(32) NOT NULL,
  `NAME` varchar(200) default NULL,
  `AGE` int(11) default NULL,
  `BIRTHDAY` date default NULL,
  `MONEY` bigint(20) default NULL,
  `GENDER` varchar(3) default NULL,
  `GROUPIDS` varchar(3) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `fk_gender_id` (`GENDER`),
  KEY `fk_group_id` (`GROUPIDS`),
  CONSTRAINT `fk_group_id` FOREIGN KEY (`GROUPIDS`) REFERENCES `t_code_group` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gender_id` FOREIGN KEY (`GENDER`) REFERENCES `t_code_gender` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `t_code_gender` VALUES ('0','女'),  ('1','男');

-- Create Procedure testprc
create procedure testprc(in newname varchar(10), in uid varchar(3))
begin
  update t_code_group set name = newname where id = trim(uid);
end;

