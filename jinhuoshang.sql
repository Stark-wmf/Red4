/*
 Navicat Premium Data Transfer

 Source Server         : Red4
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : 3306

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 30/11/2018 09:26:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jinhuoshang
-- ----------------------------
DROP TABLE IF EXISTS `jinhuoshang`;
CREATE TABLE `jinhuoshang`  (
  `Jid` int(255) NOT NULL AUTO_INCREMENT,
  `Jname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Jtel` int(255) NOT NULL,
  `Jaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Jid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3003 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jinhuoshang
-- ----------------------------
INSERT INTO `jinhuoshang` VALUES (3001, '阿里', 888, '杭州');
INSERT INTO `jinhuoshang` VALUES (3002, '京东', 666, '北京');

SET FOREIGN_KEY_CHECKS = 1;
