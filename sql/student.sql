/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-03-15 18:21:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student0
-- ----------------------------
DROP TABLE IF EXISTS `t_student0`;
CREATE TABLE `t_student0` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gid` bigint(20) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `class_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student1
-- ----------------------------
DROP TABLE IF EXISTS `t_student1`;
CREATE TABLE `t_student1` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gid` bigint(13) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `class_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student2
-- ----------------------------
DROP TABLE IF EXISTS `t_student2`;
CREATE TABLE `t_student2` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `gid` bigint(13) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `class_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
