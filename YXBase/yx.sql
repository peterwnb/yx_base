/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50713
Source Host           : 127.0.0.1:3306
Source Database       : yx

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-05-22 18:07:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aas_account
-- ----------------------------
DROP TABLE IF EXISTS `aas_account`;
CREATE TABLE `aas_account` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `account_type` int(2) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aas_account
-- ----------------------------
INSERT INTO `aas_account` VALUES ('1', '15902783101', null, '1');

-- ----------------------------
-- Table structure for aas_user
-- ----------------------------
DROP TABLE IF EXISTS `aas_user`;
CREATE TABLE `aas_user` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '用户昵称',
  `phone` varchar(16) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `avatar` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB AUTO_INCREMENT=866585552215019521 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aas_user
-- ----------------------------
INSERT INTO `aas_user` VALUES ('866585552215019520', '张三丰', '丿不羁的风', '13401933341', 'zhangsf@yahoo.cn', '武汉市洪山区街道口', 'www.baidu.com/img/001.jpg', '2017-05-22 17:24:30', '2017-05-22 17:24:30');

-- ----------------------------
-- Table structure for group_member
-- ----------------------------
DROP TABLE IF EXISTS `group_member`;
CREATE TABLE `group_member` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `user_type` int(2) DEFAULT NULL COMMENT '群组成员类型   0：普通成员   1：创建者  2：普通管理员',
  `join_status` int(2) DEFAULT NULL COMMENT '0:已申请加入  1：已通过  ',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB AUTO_INCREMENT=866594014701432833 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of group_member
-- ----------------------------
INSERT INTO `group_member` VALUES ('866585552361820160', '866585552332460032', '866585552215019520', '2', '1', '2017-05-22 17:24:30', '2017-05-22 17:24:30');
INSERT INTO `group_member` VALUES ('866594014701432832', '866594014550437888', '866585552215019520', '2', '1', '2017-05-22 17:58:08', '2017-05-22 17:58:08');

-- ----------------------------
-- Table structure for user_friend
-- ----------------------------
DROP TABLE IF EXISTS `user_friend`;
CREATE TABLE `user_friend` (
  `id_` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL COMMENT '0:邀请方发起加好友请求  1：接收方不通过  2：接收方通过，互为好友',
  `friend_id` bigint(20) NOT NULL,
  `status_` int(2) DEFAULT NULL,
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_friend
-- ----------------------------

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `group_name` varchar(32) DEFAULT NULL,
  `remark_` varchar(128) DEFAULT NULL COMMENT '群组名称介绍',
  `group_avatar` varchar(128) DEFAULT NULL COMMENT '群组头像地址',
  `enable_` int(2) DEFAULT NULL COMMENT '是否可用  ：  0:不可用   ，  1：可用',
  `type` int(2) DEFAULT NULL COMMENT '群组类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id_`)
) ENGINE=InnoDB AUTO_INCREMENT=866594014550437889 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('866585552332460032', '866585552215019520', '默认群组', '默认群组', 'default.png', '1', '0', '2017-05-22 17:24:30', '2017-05-22 17:24:30');
INSERT INTO `user_group` VALUES ('866593377897033728', '866585552215019520', '我的好友', '我的好友', 'default.png', '1', '0', '2017-05-22 17:55:36', '2017-05-22 17:55:36');
INSERT INTO `user_group` VALUES ('866594014550437888', '866585552215019520', '我的同事', '我的同事', 'default.png', '1', '0', '2017-05-22 17:58:08', '2017-05-22 17:58:08');
