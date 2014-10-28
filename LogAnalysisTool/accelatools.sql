/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : accelatools

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2014-09-15 14:49:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `log_info_type`
-- ----------------------------
DROP TABLE IF EXISTS `log_info_type`;
CREATE TABLE `log_info_type` (
  `id` int(8) NOT NULL,
  `serverHost` varchar(25) NOT NULL,
  `agency` varchar(15) NOT NULL,
  `category` varchar(15) NOT NULL,
  `type` varchar(25) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_info_type
-- ----------------------------

-- ----------------------------
-- Table structure for `report_type`
-- ----------------------------
DROP TABLE IF EXISTS `report_type`;
CREATE TABLE `report_type` (
  `ID` int(8) NOT NULL auto_increment,
  `REPORT_TYPE` varchar(25) NOT NULL,
  `REPORT_COMMENTS` varchar(150) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report_type
-- ----------------------------

-- ----------------------------
-- Table structure for `serverloginfo`
-- ----------------------------
DROP TABLE IF EXISTS `serverloginfo`;
CREATE TABLE `serverloginfo` (
  `ID` int(14) NOT NULL auto_increment,
  `LogDate` datetime default NULL,
  `SimpleDescription` longtext collate utf8_bin,
  `ClassName` text collate utf8_bin,
  `Level` varchar(8) collate utf8_bin default NULL,
  `CreateDate` datetime default NULL,
  `Type` varchar(8) collate utf8_bin default NULL,
  `StackInfo` longtext collate utf8_bin,
  `DetailDescription` longtext collate utf8_bin,
  `clientType` varchar(20) collate utf8_bin default NULL,
  `clientSequence` varchar(20) collate utf8_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11223 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of serverloginfo
-- ----------------------------

-- ----------------------------
-- Table structure for `systemmemory`
-- ----------------------------
DROP TABLE IF EXISTS `systemmemory`;
CREATE TABLE `systemmemory` (
  `ID` int(11) NOT NULL auto_increment,
  `logDate` datetime default NULL,
  `totalMemory` bigint(50) default NULL,
  `maxMemory` bigint(100) default NULL,
  `totalFreeMemory` bigint(50) default NULL,
  `maxFreeMemory` bigint(60) default NULL,
  `totalMemoryUsed` varchar(50) collate utf8_bin default NULL,
  `maxMemoryUsed` varchar(50) collate utf8_bin default NULL,
  `type` varchar(8) collate utf8_bin default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of systemmemory
-- ----------------------------

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL auto_increment,
  `taskName` varchar(50) NOT NULL,
  `logStartTime` datetime NOT NULL,
  `logEndTime` datetime NOT NULL,
  `taskExecuteTime` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
