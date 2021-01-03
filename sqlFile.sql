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

 Date: 03/01/2021 21:55:11
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
-- Table structure for backbook
-- ----------------------------
DROP TABLE IF EXISTS `backbook`;
CREATE TABLE `backbook`  (
  `backBookid` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `borrowid` int(0) NULL DEFAULT NULL,
  `bookid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cardid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `outdate` datetime(0) NULL DEFAULT NULL,
  `backdate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`backBookid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bookid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookname` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isbn` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `classifynum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` int(0) NULL DEFAULT NULL,
  `introduction` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `publishdate` date NULL DEFAULT NULL,
  PRIMARY KEY (`bookid`) USING BTREE,
  INDEX `FK_publishbook`(`id`) USING BTREE,
  CONSTRAINT `"FK_publishbook"` FOREIGN KEY () REFERENCES `"publishing"` () ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for borrowbook
-- ----------------------------
DROP TABLE IF EXISTS `borrowbook`;
CREATE TABLE `borrowbook`  (
  `borrowid` int(0) NOT NULL AUTO_INCREMENT,
  `bookid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cardid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `adm_adminid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adminid` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `outdate` date NULL DEFAULT NULL,
  `backdate` date NULL DEFAULT NULL,
  `continuetime` smallint(0) NULL DEFAULT NULL,
  `continuedate` date NULL DEFAULT NULL,
  `outofdate` int(0) NULL DEFAULT NULL,
  `outmoney` float NULL DEFAULT 0,
  PRIMARY KEY (`borrowid`) USING BTREE,
  INDEX `""A""`(`bookid`) USING BTREE,
  INDEX `B`(`cardid`) USING BTREE,
  INDEX `C`(`adm_adminid`) USING BTREE,
  INDEX `D`(`adminid`) USING BTREE,
  CONSTRAINT `"""A"""` FOREIGN KEY () REFERENCES `"book"` () ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `"B"` FOREIGN KEY () REFERENCES `"reader"` () ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `"C"` FOREIGN KEY () REFERENCES `"admin"` () ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `"D"` FOREIGN KEY () REFERENCES `"admin"` () ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for publishing
-- ----------------------------
DROP TABLE IF EXISTS `publishing`;
CREATE TABLE `publishing`  (
  `id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `place` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `cardid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `readercategoryid` int(0) NOT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `location` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `unitid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `borrownum` smallint(0) NULL DEFAULT NULL,
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`cardid`) USING BTREE,
  INDEX `FK_belongcateglory`(`readercategoryid`) USING BTREE,
  INDEX `FK_belongunit2`(`unitid`) USING BTREE,
  CONSTRAINT `"FK_belongcateglory"` FOREIGN KEY () REFERENCES `"readercategory"` () ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `"FK_belongunit2"` FOREIGN KEY () REFERENCES `"unit"` () ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for readercategory
-- ----------------------------
DROP TABLE IF EXISTS `readercategory`;
CREATE TABLE `readercategory`  (
  `readercategoryid` int(0) NOT NULL,
  `num` smallint(0) NULL DEFAULT NULL,
  `borrowdate` smallint(0) NULL DEFAULT NULL,
  `keepdate` smallint(0) NULL DEFAULT NULL,
  `Authority` smallint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`readercategoryid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `unitid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nature` smallint(0) NULL DEFAULT NULL,
  `location` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`unitid`) USING BTREE,
  INDEX `FK_belongunit`(`unitid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Triggers structure for table borrowbook
-- ----------------------------
DROP TRIGGER IF EXISTS `deleteBorrow`;
delimiter ;;
CREATE TRIGGER `deleteBorrow` BEFORE DELETE ON `borrowbook` FOR EACH ROW begin   

	INSERT INTO `backbook` (borrowid,bookid,cardid,outdate,backdate)
		VALUES (old.borrowid,old.bookid,old.cardid,old.outdate,NOW());
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
