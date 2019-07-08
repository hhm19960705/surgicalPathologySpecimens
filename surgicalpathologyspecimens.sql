/*
Navicat MySQL Data Transfer

Source Server         : hhm
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : surgicalpathologyspecimens

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2019-03-05 22:11:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` varchar(255) NOT NULL COMMENT '病理单编号',
  `pid` varchar(255) NOT NULL COMMENT '患者住院号',
  `oname` varchar(255) NOT NULL COMMENT '手术名称',
  `oposition` varchar(255) NOT NULL COMMENT '手术部位',
  `blzy` varchar(255) NOT NULL COMMENT '病历摘要',
  `crbxx` varchar(255) NOT NULL COMMENT '传染病信息',
  `htime` datetime NOT NULL COMMENT '病理单创建时间',
  `czstate` int(255) DEFAULT '0' COMMENT '初步诊断状态：0未取材诊断，1已取材诊断',
  `czperson` varchar(255) DEFAULT NULL COMMENT '初步诊断人',
  `cztime` datetime DEFAULT NULL COMMENT '初步诊断时间',
  `cbzd` varchar(255) DEFAULT NULL COMMENT '初步诊断',
  `shstate` int(255) DEFAULT '0' COMMENT '最终审核诊断状态：0表示未审核，1表示已审核',
  `shperson` varchar(255) DEFAULT NULL COMMENT '最终审核诊断人',
  `shtime` datetime DEFAULT NULL COMMENT '最终审核诊断时间',
  `images` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `radio` varchar(255) DEFAULT NULL COMMENT '音频路径',
  PRIMARY KEY (`id`),
  KEY `h_fk_pid` (`pid`),
  KEY `id` (`id`),
  CONSTRAINT `h_fk_pid` FOREIGN KEY (`pid`) REFERENCES `patient` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('002', '02', '器官移植手术', '心脏', '心脏病', '无传染性', '2019-02-11 08:45:08', '1', 'ls', '2019-03-02 00:00:00', 'sdsa', '1', 'ewq', '2019-02-28 00:00:00', null, null);
INSERT INTO `history` VALUES ('003', '03', '皮肤移植手术', '大腿', '双腿严重烧伤', '无传染性', '2019-02-13 00:00:00', '1', 'ls', '2019-03-03 00:00:00', 'zsd', '1', 'we', '2019-02-27 00:00:00', null, null);
INSERT INTO `history` VALUES ('008', '09', 'gdsag', 'asdg', 'asdg', 'sadg', '2019-02-26 20:20:03', '1', 'w', '2019-02-28 00:00:00', 'asd', '0', '', '2019-02-28 00:00:00', null, null);
INSERT INTO `history` VALUES ('12312', '02', 'dsa', 'adsd', 'dasd', 'asd', '2019-03-10 00:00:00', '1', 'ls', '2019-03-04 00:00:00', '', '0', '', null, '', '');
INSERT INTO `history` VALUES ('24214', '03', 'dfsd', 'fsdf', 'sdf', 'sdf', '2019-03-19 00:00:00', '1', 'ls', '2019-03-04 00:00:00', 'gsddsdg', '0', '', null, '', '');
INSERT INTO `history` VALUES ('322222324', '08', 'asd', 'asd', 'ad', 'asd', '2019-03-04 00:00:00', '1', 'ls', '2019-03-05 00:00:00', 'sdfds', '0', '', null, 'upload/2345_image_file_copy_7.jpg', 'upload/周鑫儿 - 触电的感觉.mp3');
INSERT INTO `history` VALUES ('443', '08', 'cxzc', 'cxzc', 'zxc', 'xzc', '2019-03-04 00:00:00', '1', 'ls', '2019-03-04 00:00:00', 'dgsgsd', '0', '', null, '', '');
INSERT INTO `history` VALUES ('4567', '02', 'sda', 'asf', 'asf', 'asf', '2019-02-25 00:00:00', '1', 'ls', '2019-03-04 00:00:00', 'scs', '0', '', '2019-03-01 00:00:00', '', '');
INSERT INTO `history` VALUES ('567567', '03', '鬼地方个', '大范甘迪', '鬼地方个', '山东干啥', '2019-03-04 00:00:00', '1', 'ls', '2019-03-04 00:00:00', 'xsx', '0', '', null, '', '');
INSERT INTO `history` VALUES ('65464', '03', 'fdg', 'dfg', 'dfg', 'dfg', '2019-03-04 00:00:00', '0', '', null, '', '0', '', null, '', '');
INSERT INTO `history` VALUES ('7894', '02', 'fg', 'df', 'dfg', 'dfh', '2019-03-12 00:00:00', '1', 'ls', '2019-03-05 00:00:00', 'cxcxz', '0', '', null, 'upload/timg.jpg', 'upload/廖大大 - 失守.mp3');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `pid` varchar(255) NOT NULL COMMENT '患者住院号',
  `pname` varchar(8) NOT NULL COMMENT '患者姓名',
  `sex` int(11) NOT NULL COMMENT '性别:0表示男，1表示女',
  `age` int(3) NOT NULL COMMENT '年龄',
  `date` datetime NOT NULL COMMENT '入院时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pid`),
  KEY `pname` (`pname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('01', '张三', '0', '22', '2019-01-01 00:00:00', '有中度贫血');
INSERT INTO `patient` VALUES ('02', '李四', '1', '24', '2019-02-11 00:00:00', '无');
INSERT INTO `patient` VALUES ('03', '赵六', '0', '22', '2019-02-26 00:00:00', '身体易受感染');
INSERT INTO `patient` VALUES ('08', 'fdsaf', '0', '23', '2019-02-10 00:00:00', 'dsaf');
INSERT INTO `patient` VALUES ('09', 'sdafd', '0', '12', '2019-02-11 20:17:05', 'saf');
INSERT INTO `patient` VALUES ('1234', 'dasd', '1', '12', '2019-02-11 00:00:00', 'saf');
INSERT INTO `patient` VALUES ('12345', 'asdasd', '1', '12', '2019-01-28 00:00:00', 'dasdas');
INSERT INTO `patient` VALUES ('567', 'rw', '1', '32', '2019-02-25 00:00:00', 'wd');

-- ----------------------------
-- Table structure for specimen
-- ----------------------------
DROP TABLE IF EXISTS `specimen`;
CREATE TABLE `specimen` (
  `id` varchar(255) NOT NULL COMMENT '标本编号',
  `pid` varchar(255) NOT NULL COMMENT '病理单编号',
  `hid` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '标本名称',
  `type` varchar(255) NOT NULL COMMENT '标本类型',
  `otime` datetime NOT NULL COMMENT '手术时间',
  `ctime` datetime NOT NULL COMMENT '切取时间',
  `ltime` datetime NOT NULL COMMENT '离体时间',
  `time` datetime NOT NULL COMMENT '标本创建时间',
  `sstate` int(255) DEFAULT '0' COMMENT '送检状态：0表示未送检，1表示已送检',
  `stime` datetime DEFAULT NULL COMMENT '送检时间',
  `sperson` varchar(255) DEFAULT NULL COMMENT '送检人',
  `jsstate` int(255) DEFAULT '0' COMMENT '标本接收状态:0表示未接收，1表示确认接收，2表示接收失败',
  `jstime` datetime DEFAULT NULL COMMENT '接收时间',
  `jsperson` varchar(255) DEFAULT NULL COMMENT '接收人',
  `jsfalse` varchar(255) DEFAULT NULL COMMENT '标本接收失败问题描述',
  `hdstate` int(255) DEFAULT '0' COMMENT '标本核对状态：0表示未核对，1表示核对成功，2表示核对失败',
  `hdtime` datetime DEFAULT NULL COMMENT '标本核对时间',
  `hdfalse` varchar(255) DEFAULT NULL COMMENT '标本核对失败问题描述',
  `location` varchar(255) DEFAULT NULL COMMENT '标本位置',
  PRIMARY KEY (`id`),
  KEY `s_fk_pid` (`pid`),
  KEY `s_fk_hid` (`hid`),
  CONSTRAINT `s_fk_hid` FOREIGN KEY (`hid`) REFERENCES `history` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `s_fk_pid` FOREIGN KEY (`pid`) REFERENCES `patient` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specimen
-- ----------------------------
INSERT INTO `specimen` VALUES ('0003', '01', '002', '眼睛', '器官', '2019-02-23 00:00:00', '2019-02-05 00:00:00', '2019-02-23 00:00:00', '2019-02-23 00:00:00', '1', '2019-02-28 00:00:00', 'zs', '1', '2019-02-28 00:00:00', 'hhm', '', '1', '2019-02-28 00:00:00', '', '1号柜, ');
INSERT INTO `specimen` VALUES ('0006', '09', '003', 'sdfsd', 'sdf', '2019-02-03 00:00:00', '2019-02-10 00:00:00', '2019-02-24 00:00:00', '2019-02-03 00:00:00', '0', null, '', '0', null, '', '', '1', '2019-02-28 00:00:00', '', '');
INSERT INTO `specimen` VALUES ('0039', '03', '008', 'der', 'sds', '2019-01-28 00:00:00', '2019-02-05 00:00:00', '2019-02-13 00:00:00', '2019-02-28 00:00:00', '0', null, '', '0', null, '', '', '2', null, 'sasfasf', '');
INSERT INTO `specimen` VALUES ('010203', '03', '002', 'weqee', 'qweqw', '2019-02-04 00:00:00', '2019-01-29 00:00:00', '2019-02-05 00:00:00', '2019-02-28 00:00:00', '0', null, '', '0', null, '', '', '1', '2019-03-01 00:00:00', '', '');
INSERT INTO `specimen` VALUES ('12345', '02', '003', '大公司', '十多个', '2019-01-29 00:00:00', '2019-02-05 00:00:00', '2019-02-06 00:00:00', '2019-02-28 00:00:00', '0', null, '', '0', null, '', '', '2', null, 'wefsdf', '');
INSERT INTO `specimen` VALUES ('347', '02', '008', 'dsd', 'sdd', '2019-03-11 00:00:00', '2019-03-10 00:00:00', '2019-03-07 00:00:00', '2019-03-01 00:00:00', '0', null, '', '0', null, '', '', '1', '2019-03-01 00:00:00', '', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL COMMENT '用户ID',
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `status` int(255) NOT NULL COMMENT '用户身份:0表示管理人员，1表示手术室护士，2表示病理科工作人员，3表示送检人员，4表示医生',
  `wtfk` varchar(255) DEFAULT NULL COMMENT '问题反馈',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('07053829', 'hmm', '123', '3', '');
INSERT INTO `user` VALUES ('1', 'xs', '123', '0', 'eqwcsa');
INSERT INTO `user` VALUES ('11', 'sfd', '123', '3', '');
INSERT INTO `user` VALUES ('123', 'hhx', '123', '1', '');
INSERT INTO `user` VALUES ('12345', 'wsd', '123', '1', 'ert');
INSERT INTO `user` VALUES ('2', 'hhm', '123', '2', '');
INSERT INTO `user` VALUES ('3', 'zs', '123', '3', null);
INSERT INTO `user` VALUES ('4', 'ls', '123', '4', null);
INSERT INTO `user` VALUES ('5217', 'ly', '123', '2', '');
INSERT INTO `user` VALUES ('6', 'wy', '123', '0', null);
INSERT INTO `user` VALUES ('7', 'hcs', '123', '0', null);
