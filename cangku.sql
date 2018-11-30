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

 Date: 30/11/2018 09:25:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cangku
-- ----------------------------
DROP TABLE IF EXISTS `cangku`;
CREATE TABLE `cangku`  (
  `Cid` int(255) NOT NULL,
  `Cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Ctel` int(255) NOT NULL,
  PRIMARY KEY (`Cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cangku
-- ----------------------------
INSERT INTO `cangku` VALUES (4001, '顺丰仓库', 444);
INSERT INTO `cangku` VALUES (4002, '韵达仓库', 555);

SET FOREIGN_KEY_CHECKS = 1;
