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

 Date: 30/11/2018 09:28:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shangping
-- ----------------------------
DROP TABLE IF EXISTS `shangping`;
CREATE TABLE `shangping`  (
  `Sid` int(255) NOT NULL,
  `Sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Scost` int(255) NOT NULL,
  `Sprice` int(255) NOT NULL,
  `Jnameint` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Cid` int(255) NOT NULL,
  PRIMARY KEY (`Sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shangping
-- ----------------------------
INSERT INTO `shangping` VALUES (2001, '萝卜', 20, 22, '阿里', 4001);
INSERT INTO `shangping` VALUES (2002, '鲈鱼', 40, 45, '阿里', 4001);
INSERT INTO `shangping` VALUES (2003, '冰阔落', 5, 6, '京东', 4002);
INSERT INTO `shangping` VALUES (2004, '茅台', 800, 1000, '阿里', 4002);
INSERT INTO `shangping` VALUES (2005, '玉溪', 20, 22, '京东', 4002);
INSERT INTO `shangping` VALUES (2006, '玉米', 4, 7, '京东', 4002);
INSERT INTO `shangping` VALUES (2007, '乐事薯片', 3, 4, '阿里', 4001);

SET FOREIGN_KEY_CHECKS = 1;
