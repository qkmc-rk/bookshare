/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : bookshare

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 25/03/2019 14:39:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `position` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '书籍的位置信息',
  `catalogid` int(11) DEFAULT NULL COMMENT '书籍的分类',
  `userid` int(11) DEFAULT NULL COMMENT '书籍发布者id',
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '书籍名称',
  `price` double(10,0) DEFAULT NULL COMMENT '书籍价格',
  `realprice` double(10,2) DEFAULT NULL COMMENT '书籍原价',
  `createtime` datetime DEFAULT NULL COMMENT '书籍信息上传时间',
  `content` text COLLATE utf8mb4_general_ci COMMENT '书籍信息',
  `sold` tinyint(2) DEFAULT NULL COMMENT '是否已出售',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论',
  `bookid` int(11) DEFAULT NULL COMMENT '书本的id',
  `userid` int(11) DEFAULT NULL COMMENT '评论者id',
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `createtime` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for failedorder
-- ----------------------------
DROP TABLE IF EXISTS `failedorder`;
CREATE TABLE `failedorder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bookid` int(11) DEFAULT NULL COMMENT '书籍号',
  `userid` int(11) DEFAULT NULL COMMENT '下单人员',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(11) NOT NULL COMMENT '发布者id',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '发布公告的内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bookid` int(11) DEFAULT NULL COMMENT '下单的书籍id',
  `userid` int(11) DEFAULT NULL COMMENT '下单者',
  `createtime` datetime DEFAULT NULL COMMENT '订单创建时间',
  `status` int(11) DEFAULT NULL COMMENT '10-买家确认 01卖家确认  11完成的订单',
  `sellerid` int(11) DEFAULT NULL COMMENT '卖家id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL COMMENT 'id',
  `userid` int(11) DEFAULT NULL COMMENT '回复人id',
  `commentid` int(11) DEFAULT NULL COMMENT '回复的哪条评论',
  `content` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '回复内容',
  `createtime` datetime DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for successorder
-- ----------------------------
DROP TABLE IF EXISTS `successorder`;
CREATE TABLE `successorder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bookid` int(11) DEFAULT NULL COMMENT '书籍编号',
  `userid` int(11) DEFAULT NULL COMMENT '用户编号',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(11) DEFAULT NULL COMMENT '某个用户',
  `token` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '令牌',
  `createtime` datetime DEFAULT NULL COMMENT '令牌创建时间',
  `frame` int(11) DEFAULT NULL COMMENT '有效期ms',
  `freshtime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户电话',
  `account` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `nickname` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户昵称',
  `qq` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户的QQ号',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '账号创建时间',
  `ugrant` tinyint(10) NOT NULL COMMENT '权限，0普通用户，1管理员',
  `ulock` int(10) NOT NULL COMMENT '0未锁，1锁定用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-24 05:52:25', 1, 0);
INSERT INTO `user` VALUES (2, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:04:11', 1, 0);
INSERT INTO `user` VALUES (3, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:26', 1, 0);
INSERT INTO `user` VALUES (4, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:42', 1, 0);
INSERT INTO `user` VALUES (5, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:44', 1, 0);
INSERT INTO `user` VALUES (6, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:44', 1, 0);
INSERT INTO `user` VALUES (7, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:45', 1, 0);
INSERT INTO `user` VALUES (8, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:46', 1, 0);
INSERT INTO `user` VALUES (9, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:46', 1, 0);
INSERT INTO `user` VALUES (10, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:48', 1, 0);
INSERT INTO `user` VALUES (11, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:50', 1, 0);
INSERT INTO `user` VALUES (12, NULL, 'xx', 'xxxx', NULL, NULL, '2019-03-25 04:09:50', 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
