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

 Date: 30/11/2018 09:24:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bumen
-- ----------------------------
DROP TABLE IF EXISTS `bumen`;
CREATE TABLE `bumen`  (
  `Bid` int(255) NOT NULL,
  `Bname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Bprice` int(255) DEFAULT NULL,
  `Zname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Bid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bumen
-- ----------------------------
INSERT INTO `bumen` VALUES (1001, '生鲜', 2000, '齐子鸣');
INSERT INTO `bumen` VALUES (1002, '饮料', 1000, '张盛泽');
INSERT INTO `bumen` VALUES (1003, '烟酒', 5000, '李牧恒');

SET FOREIGN_KEY_CHECKS = 1;
