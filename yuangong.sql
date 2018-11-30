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

 Date: 30/11/2018 09:30:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yuangong
-- ----------------------------
DROP TABLE IF EXISTS `yuangong`;
CREATE TABLE `yuangong`  (
  `Yid` int(255) NOT NULL,
  `Yname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Yjob` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Ytel` int(255) NOT NULL,
  `Yaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Yage` int(255) NOT NULL,
  `Yb` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Yid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yuangong
-- ----------------------------
INSERT INTO `yuangong` VALUES (1, '齐子鸣', '主管', 110, '河南', 18, '1001');
INSERT INTO `yuangong` VALUES (2, '张盛泽', '主管', 120, '浙江', 18, '1002');
INSERT INTO `yuangong` VALUES (3, '李牧恒', '主管', 119, '云南', 19, '1003');
INSERT INTO `yuangong` VALUES (4, '王梦飞', '员工', 12580, '江苏', 18, '1002');
INSERT INTO `yuangong` VALUES (5, '库里', '员工', 521, '美国', 31, '1003');

SET FOREIGN_KEY_CHECKS = 1;
