SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `acct_group`
-- ----------------------------
DROP TABLE IF EXISTS `acct_group`;
CREATE TABLE `acct_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `acct_group_permission`
-- ----------------------------
DROP TABLE IF EXISTS `acct_group_permission`;
CREATE TABLE `acct_group_permission` (
  `group_id` bigint(20) NOT NULL,
  `permission` varchar(255) NOT NULL,
  KEY `FKAE243466DE3FB930` (`group_id`),
  CONSTRAINT `acct_group_permission_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `acct_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `acct_user`
-- ----------------------------
DROP TABLE IF EXISTS `acct_user`;
CREATE TABLE `acct_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1343915760944 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `acct_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `acct_user_group`;
CREATE TABLE `acct_user_group` (
  `user_id` bigint(20) NOT NULL,
  `group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`group_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `acct_user_group_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `acct_user` (`id`),
  CONSTRAINT `acct_user_group_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `acct_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `acct_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `acct_userinfo`;
CREATE TABLE `acct_userinfo` (
  `ID` bigint(20) NOT NULL,
  `PHONE` varchar(255),
  `IDCODE` varchar(255),
  `GENDER` varchar(255),
  `USER_ID` bigint(20),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

