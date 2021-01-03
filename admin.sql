/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 03/01/2021 21:52:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `office` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL,
  `workid` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`adminid`) USING BTREE,
  INDEX `workid`(`workid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1800303210', 1, 'Sobev@gmail.com', '中国计量大学', '18989452318', '图书馆203', 1, '1800', '123456', 20);
INSERT INTO `admin` VALUES ('1800303289', 1, '1889@qq.com', '衢州', '15156998956', '塞北304', 0, '1811', '123456', 22);
INSERT INTO `admin` VALUES ('1800303290', 1, '1889@qq.com', '衢州', '15156998956', '塞北304', 1, '1801', '123456', 26);
INSERT INTO `admin` VALUES ('1800303291', 0, '1889773@qq.com', '杭州', '15157001589', '图书馆2楼', 1, '1810', '123456', 19);
INSERT INTO `admin` VALUES ('1800303292', 0, '1889773@qq.com', '杭州', '15157001589', '图书馆2楼', 1, '1809', '123456', 19);
INSERT INTO `admin` VALUES ('1800303293', 0, '1889773@qq.com', '杭州', '15157001589', '图书馆2楼', 1, '1808', '123456', 19);
INSERT INTO `admin` VALUES ('1800303294', 0, '1889773@qq.com', '衢州', '15156998956', '塞北304', 1, '1807', '123456', 26);

SET FOREIGN_KEY_CHECKS = 1;
