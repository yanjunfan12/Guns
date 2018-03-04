/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : guns

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-12-10 11:34:35
*/

DROP DATABASE IF EXISTS guns_flowable;
CREATE DATABASE IF NOT EXISTS guns_flowable DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

DROP DATABASE IF EXISTS guns;
CREATE DATABASE IF NOT EXISTS guns DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE guns;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('24', '1', '0', '[0],', '总公司', '总公司', '', null);
INSERT INTO `sys_dept` VALUES ('25', '2', '24', '[0],[24],', '开发部', '开发部', '', null);
INSERT INTO `sys_dept` VALUES ('26', '3', '24', '[0],[24],', '运营部', '运营部', '', null);
INSERT INTO `sys_dept` VALUES ('27', '4', '24', '[0],[24],', '战略部', '战略部', '', null);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='字典表';

alter table `sys_dict` add constraint `name_pid_unique_key` unique (`name`,`pid`);

--alter table `sys_dict` add constraint `num_pid_unique_key` unique (`num`,`pid`);

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (29, 0, 0, '性别', NULL);
INSERT INTO `sys_dict` VALUES (30, 1, 29, '男', NULL);
INSERT INTO `sys_dict` VALUES (31, 2, 29, '女', NULL);
INSERT INTO `sys_dict` VALUES (35, 0, 0, '账号状态', NULL);
INSERT INTO `sys_dict` VALUES (36, 1, 35, '启用', NULL);
INSERT INTO `sys_dict` VALUES (37, 2, 35, '冻结', NULL);
INSERT INTO `sys_dict` VALUES (38, 3, 35, '已删除', NULL);
INSERT INTO `sys_dict` VALUES (39, 0, 0, '目前饮食', NULL);
INSERT INTO `sys_dict` VALUES (40, 1, 39, '正常饮食', NULL);
INSERT INTO `sys_dict` VALUES (41, 2, 39, '半流质', NULL);
INSERT INTO `sys_dict` VALUES (42, 3, 39, '流质', NULL);
INSERT INTO `sys_dict` VALUES (43, 4, 39, '完全梗阻', NULL);
INSERT INTO `sys_dict` VALUES (128, 0, 0, '发热', NULL);
INSERT INTO `sys_dict` VALUES (129, 0, 128, '无发热或低于37.9度', NULL);
INSERT INTO `sys_dict` VALUES (130, 1, 128, '38.0－39.0 度', NULL);
INSERT INTO `sys_dict` VALUES (131, 2, 128, '39.1-40.0 度', NULL);
INSERT INTO `sys_dict` VALUES (132, 3, 128, '高于 40.0 度小于 24 小时', NULL);
INSERT INTO `sys_dict` VALUES (133, 4, 128, '高于 40.0度 大于 24 小时 ', NULL);
INSERT INTO `sys_dict` VALUES (134, 0, 0, '咳嗽', NULL);
INSERT INTO `sys_dict` VALUES (135, 0, 134, '无咳嗽', NULL);
INSERT INTO `sys_dict` VALUES (136, 1, 134, '症状轻微，仅需非处方药（如甘草口服液） ', NULL);
INSERT INTO `sys_dict` VALUES (137, 2, 134, '影响日常生活，需处方药（如可待因）', NULL);
INSERT INTO `sys_dict` VALUES (138, 3, 134, '生活无法自理', NULL);
INSERT INTO `sys_dict` VALUES (139, 0, 0, '放射性皮肤损伤', NULL);
INSERT INTO `sys_dict` VALUES (140, 0, 139, '无皮肤损伤', NULL);
INSERT INTO `sys_dict` VALUES (141, 1, 139, '点状红斑或干性脱皮', NULL);
INSERT INTO `sys_dict` VALUES (142, 2, 139, '片状红斑或小块湿性脱皮或水肿', NULL);
INSERT INTO `sys_dict` VALUES (143, 3, 139, '大片湿性脱皮', NULL);
INSERT INTO `sys_dict` VALUES (144, 0, 0, '打嗝', NULL);
INSERT INTO `sys_dict` VALUES (145, 0, 144, '无打嗝', NULL);
INSERT INTO `sys_dict` VALUES (146, 1, 144, '症状轻微不需药物', NULL);
INSERT INTO `sys_dict` VALUES (147, 2, 144, '影响日常生活，需要药物', NULL);
INSERT INTO `sys_dict` VALUES (148, 3, 144, '影响睡眠', NULL);
INSERT INTO `sys_dict` VALUES (149, 0, 0, '口腔黏膜炎', NULL);
INSERT INTO `sys_dict` VALUES (150, 0, 149, '无口腔黏膜炎', NULL);
INSERT INTO `sys_dict` VALUES (151, 1, 149, '口腔稍有疼痛', NULL);
INSERT INTO `sys_dict` VALUES (152, 2, 149, '因口腔黏膜需要调整饮食', NULL);
INSERT INTO `sys_dict` VALUES (153, 3, 149, '因口腔黏膜进食困难 ', NULL);
INSERT INTO `sys_dict` VALUES (154, 0, 0, '声嘶', NULL);
INSERT INTO `sys_dict` VALUES (155, 0, 154, '无声嘶', NULL);
INSERT INTO `sys_dict` VALUES (156, 1, 154, '有嘶哑，但话语不影响理解', NULL);
INSERT INTO `sys_dict` VALUES (157, 2, 154, '话语需偶尔重复', NULL);
INSERT INTO `sys_dict` VALUES (158, 3, 154, '症状持续且话语难以理解', NULL);
INSERT INTO `sys_dict` VALUES (159, 0, 0, '听力损伤', NULL);
INSERT INTO `sys_dict` VALUES (160, 0, 159, '无听力损伤', NULL);
INSERT INTO `sys_dict` VALUES (161, 1, 159, '感觉听力下降，无须处理 ', NULL);
INSERT INTO `sys_dict` VALUES (162, 2, 159, '需用助听器', NULL);
INSERT INTO `sys_dict` VALUES (166, 0, 0, '头晕', NULL);
INSERT INTO `sys_dict` VALUES (167, 0, 166, '无头晕', NULL);
INSERT INTO `sys_dict` VALUES (168, 1, 166, '轻微，无须处理', NULL);
INSERT INTO `sys_dict` VALUES (169, 2, 166, '影响日常生活', NULL);
INSERT INTO `sys_dict` VALUES (170, 3, 166, '生活无法自理', NULL);
INSERT INTO `sys_dict` VALUES (171, 0, 0, '头痛', NULL);
INSERT INTO `sys_dict` VALUES (172, 0, 171, '无头痛', NULL);
INSERT INTO `sys_dict` VALUES (173, 1, 171, '轻微，无须处理 ', NULL);
INSERT INTO `sys_dict` VALUES (174, 2, 171, '影响日常生活 ', NULL);
INSERT INTO `sys_dict` VALUES (175, 3, 171, '生活无法自理', NULL);
INSERT INTO `sys_dict` VALUES (176, 0, 0, '肺炎', NULL);
INSERT INTO `sys_dict` VALUES (177, 0, 176, '无肺炎', NULL);
INSERT INTO `sys_dict` VALUES (178, 1, 176, '轻度干咳，无需处理或仅需口服药', NULL);
INSERT INTO `sys_dict` VALUES (179, 2, 176, '持续性咳嗽需静脉用药（激素等）', NULL);
INSERT INTO `sys_dict` VALUES (180, 3, 176, '止咳药无作用或休息时呼吸困难、需吸氧', NULL);
INSERT INTO `sys_dict` VALUES (181, 4, 176, '需呼吸机', NULL);
INSERT INTO `sys_dict` VALUES (182, 0, 0, '进食痛', NULL);
INSERT INTO `sys_dict` VALUES (183, 0, 182, '无进食痛', NULL);
INSERT INTO `sys_dict` VALUES (184, 1, 182, '疼痛轻微，无须处理或仅需口服药', NULL);
INSERT INTO `sys_dict` VALUES (185, 2, 182, '疼痛中等，需静脉输液治疗', NULL);
INSERT INTO `sys_dict` VALUES (186, 3, 182, '疼痛严重，需鼻饲（经管道进食）或肠外营养', NULL);
INSERT INTO `sys_dict` VALUES (187, 4, 182, '食管穿孔', NULL);
INSERT INTO `sys_dict` VALUES (193, 0, 0, '恶心', NULL);
INSERT INTO `sys_dict` VALUES (194, 0, 193, '无恶心及食欲减退', NULL);
INSERT INTO `sys_dict` VALUES (195, 1, 193, '食欲降低但进食量不变 ', NULL);
INSERT INTO `sys_dict` VALUES (196, 2, 193, '进食量减少', NULL);
INSERT INTO `sys_dict` VALUES (197, 3, 193, '静脉或鼻饲营养', NULL);
INSERT INTO `sys_dict` VALUES (198, 0, 0, '乏力', NULL);
INSERT INTO `sys_dict` VALUES (199, 0, 198, '无乏力', NULL);
INSERT INTO `sys_dict` VALUES (200, 1, 198, '休息后可缓解', NULL);
INSERT INTO `sys_dict` VALUES (201, 2, 198, '休息后不能缓解，影响日常生活', NULL);
INSERT INTO `sys_dict` VALUES (202, 3, 198, '生活无法自理', NULL);
INSERT INTO `sys_dict` VALUES (203, 0, 0, '呕吐', NULL);
INSERT INTO `sys_dict` VALUES (204, 0, 203, '无呕吐', NULL);
INSERT INTO `sys_dict` VALUES (205, 1, 203, '每天1-2次', NULL);
INSERT INTO `sys_dict` VALUES (206, 2, 203, '每天3-5次', NULL);
INSERT INTO `sys_dict` VALUES (207, 3, 203, '每天6次及以上', NULL);
INSERT INTO `sys_dict` VALUES (208, 0, 0, '腹泻', NULL);
INSERT INTO `sys_dict` VALUES (209, 0, 208, '无腹泻', NULL);
INSERT INTO `sys_dict` VALUES (210, 1, 208, '与治疗前相比增加少于 4 次/天', NULL);
INSERT INTO `sys_dict` VALUES (211, 2, 208, '增加4-6 次/天 ', NULL);
INSERT INTO `sys_dict` VALUES (212, 3, 208, '7 次/天及以上 ', NULL);
INSERT INTO `sys_dict` VALUES (213, 0, 0, '便秘', NULL);
INSERT INTO `sys_dict` VALUES (214, 0, 213, '无便秘', NULL);
INSERT INTO `sys_dict` VALUES (215, 1, 213, '偶尔需用药物', NULL);
INSERT INTO `sys_dict` VALUES (216, 2, 213, '持续使用药物 ', NULL);
INSERT INTO `sys_dict` VALUES (217, 3, 213, '需人工疏通', NULL);
INSERT INTO `sys_dict` VALUES (218, 0, 0, '肌肉关节痛', NULL);
INSERT INTO `sys_dict` VALUES (219, 0, 218, '无肌肉关节痛', NULL);
INSERT INTO `sys_dict` VALUES (220, 1, 218, '轻微，无须处理', NULL);
INSERT INTO `sys_dict` VALUES (221, 2, 218, '影响日常生活', NULL);
INSERT INTO `sys_dict` VALUES (222, 3, 218, '生活无法自理', NULL);
INSERT INTO `sys_dict` VALUES (223, 0, 0, '神经系统', NULL);
INSERT INTO `sys_dict` VALUES (224, 0, 223, '无手脚麻木', NULL);
INSERT INTO `sys_dict` VALUES (225, 1, 223, '手脚麻木，不影响日常生活', NULL);
INSERT INTO `sys_dict` VALUES (226, 2, 223, '影响日常生活', NULL);
INSERT INTO `sys_dict` VALUES (227, 3, 223, '生活无法自理', NULL);
INSERT INTO `sys_dict` VALUES (228, 0, 0, '脱发', NULL);
INSERT INTO `sys_dict` VALUES (229, 0, 228, '无脱发', NULL);
INSERT INTO `sys_dict` VALUES (230, 1, 228, '较治疗前头发稍减少', NULL);
INSERT INTO `sys_dict` VALUES (231, 2, 228, '头发减少大于一半或需佩戴假发', NULL);
INSERT INTO `sys_dict` VALUES (238, 0, 0, '分类', NULL);
INSERT INTO `sys_dict` VALUES (239, 1, 238, 'TF', NULL);
INSERT INTO `sys_dict` VALUES (240, 2, 238, 'TP', NULL);
INSERT INTO `sys_dict` VALUES (241, 3, 238, 'TC', NULL);
INSERT INTO `sys_dict` VALUES (242, 4, 238, '术后大野', NULL);
INSERT INTO `sys_dict` VALUES (243, 5, 238, '高剂量', NULL);
INSERT INTO `sys_dict` VALUES (244, 6, 238, '低剂量', NULL);
INSERT INTO `sys_dict` VALUES (245, 7, 238, '华蟾素', NULL);
INSERT INTO `sys_dict` VALUES (246, 8, 238, '艾坦', NULL);
INSERT INTO `sys_dict` VALUES (247, 9, 238, 'SBRT', NULL);


-- ----------------------------
-- Table structure for sys_expense
-- ----------------------------
DROP TABLE IF EXISTS `sys_expense`;
CREATE TABLE `sys_expense` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` decimal(20,2) DEFAULT NULL COMMENT '报销金额',
  `desc` varchar(255) DEFAULT '' COMMENT '描述',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT NULL COMMENT '状态: 1.待提交  2:待审核   3.审核通过 4:驳回',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `processId` varchar(255) DEFAULT NULL COMMENT '流程定义id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='报销表';

-- ----------------------------
-- Records of sys_expense
-- ----------------------------

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (105, 'system', '0', '[0],', '系统管理', 'fa-user', '#', 4, 1, 1, NULL, 1, 1);
INSERT INTO `sys_menu` VALUES (106, 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', 1, 2, 1, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (107, 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', NULL, '/mgr/add', 1, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (108, 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', NULL, '/mgr/edit', 2, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (109, 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', NULL, '/mgr/delete', 3, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (110, 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', NULL, '/mgr/reset', 4, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (111, 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', NULL, '/mgr/freeze', 5, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (112, 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', NULL, '/mgr/unfreeze', 6, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (113, 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', NULL, '/mgr/setRole', 7, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (114, 'role', 'system', '[0],[system],', '角色管理', NULL, '/role', 2, 2, 1, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (115, 'role_add', 'role', '[0],[system],[role],', '添加角色', NULL, '/role/add', 1, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (116, 'role_edit', 'role', '[0],[system],[role],', '修改角色', NULL, '/role/edit', 2, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (117, 'role_remove', 'role', '[0],[system],[role],', '删除角色', NULL, '/role/remove', 3, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (118, 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', NULL, '/role/setAuthority', 4, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (119, 'menu', 'system', '[0],[system],', '菜单管理', NULL, '/menu', 4, 2, 1, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (120, 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', NULL, '/menu/add', 1, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (121, 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', NULL, '/menu/edit', 2, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (122, 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', NULL, '/menu/remove', 3, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (128, 'log', 'system', '[0],[system],', '业务日志', NULL, '/log', 6, 2, 1, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (130, 'druid', 'system', '[0],[system],', '监控管理', NULL, '/druid', 7, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (131, 'dept', 'system', '[0],[system],', '部门管理', NULL, '/dept', 3, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (132, 'dict', 'system', '[0],[system],', '字典管理', NULL, '/dict', 4, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (133, 'loginLog', 'system', '[0],[system],', '登录日志', NULL, '/loginLog', 6, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (134, 'log_clean', 'log', '[0],[system],[log],', '清空日志', NULL, '/log/delLog', 3, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (135, 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', NULL, '/dept/add', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (136, 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', NULL, '/dept/update', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (137, 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', NULL, '/dept/delete', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (138, 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', NULL, '/dict/add', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (139, 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', NULL, '/dict/update', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (140, 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', NULL, '/dict/delete', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (141, 'notice', 'system', '[0],[system],', '通知管理', NULL, '/notice', 9, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (142, 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', NULL, '/notice/add', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (143, 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', NULL, '/notice/update', 2, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (144, 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', NULL, '/notice/delete', 3, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (145, 'hello', '0', '[0],', '通知', 'fa-rocket', '/notice/hello', 1, 1, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (148, 'code', '0', '[0],', '代码生成', 'fa-code', '/code', 3, 1, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (149, 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/swagger-ui.html', 2, 1, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (150, 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', 4, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (151, 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', 5, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (152, 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', 4, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (153, 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', 5, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (154, 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', 6, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (155, 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', 4, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (156, 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', 5, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (157, 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', 6, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (158, 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', 2, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (159, 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', 3, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (160, 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', 1, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (161, 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', 2, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (162, 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', 5, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (163, 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', 6, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (164, 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', 7, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (165, 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', 8, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (166, 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', 9, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (167, 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', 10, 3, 0, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (168, 'expense', '0', '[0],', '报销管理', 'fa-clone', '#', 5, 1, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (169, 'expense_fill', 'expense', '[0],[expense],', '报销申请', '', '/expense', 1, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (170, 'expense_progress', 'expense', '[0],[expense],', '报销审批', '', '/process', 2, 2, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (171, 'therapeutic_records', '0', '[0],', '治疗记录', 'fa-clone', '#', 1, 1, 1, NULL, 1, NULL);
INSERT INTO `sys_menu` VALUES (945, 'adverseReaction', 'therapeutic_records', '[0],[therapeutic_records],', '不良反应记录', '', '/adverseReaction', 1, 2, 1, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (946, 'adverseReaction_list', 'adverseReaction', '[0],[therapeutic_records],[adverseReaction],', '不良反应记录列表', '', '/adverseReaction/list', 1, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (947, 'adverseReaction_add', 'adverseReaction', '[0],[therapeutic_records],[adverseReaction],', '不良反应记录添加', '', '/adverseReaction/add', 2, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (948, 'adverseReaction_update', 'adverseReaction', '[0],[therapeutic_records],[adverseReaction],', '不良反应记录更新', '', '/adverseReaction/update', 3, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (950, 'adverseReaction_detail', 'adverseReaction', '[0],[therapeutic_records],[adverseReaction],', '不良反应记录详情', '', '/adverseReaction/detail', 5, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (6161, 'adverseReactionPhoto', 'therapeutic_records', '[0],[therapeutic_records],', '不良反应记录附件', '', '/adverseReactionPhoto', 99, 2, 1, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (6162, 'adverseReactionPhoto_list', 'adverseReactionPhoto', '[0],[therapeutic_records],[adverseReactionPhoto],', '不良反应记录附件列表', '', '/adverseReactionPhoto/list', 99, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (6164, 'adverseReactionPhoto_exportAll', 'adverseReactionPhoto', '[0],[therapeutic_records],[adverseReactionPhoto],', '不良反应记录附件全部导出', '', '/adverseReactionPhoto/exportAll', 99, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (6165, 'adverseReactionPhoto_downloadAll', 'adverseReactionPhoto', '[0],[therapeutic_records],[adverseReactionPhoto],', '下载全部不良反应记录附件', '', '/adverseReactionPhoto/downloadAll', 99, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (8164, 'adverseReaction_exportOne', 'adverseReaction', '[0],[system],[adverseReaction],', '下载不良反应附件', '', '/adverseReactionPhoto/exportOne', 99, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (8165, 'adverseReaction_exportAll', 'adverseReaction', '[0],[system],[adverseReaction],', '下载不良反应列表', '', '/adverseReaction/exportAll', 99, 3, 0, NULL, 1, 0);
INSERT INTO `sys_menu` VALUES (8166, 'adverseReaction_category', 'adverseReaction', '[0],[therapeutic_records],[adverseReaction],', '分类不良反应记录', '', '/adverseReaction/category', 3, 3, 0, NULL, 1, NULL);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('6', '世界', '10', '欢迎使用Guns管理系统', '2017-01-11 08:53:20', '1');
INSERT INTO `sys_notice` VALUES ('8', '你好', null, '你好', '2017-05-10 19:28:57', '1');

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=550 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3737 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('3377', '105', '5');
INSERT INTO `sys_relation` VALUES ('3378', '106', '5');
INSERT INTO `sys_relation` VALUES ('3379', '107', '5');
INSERT INTO `sys_relation` VALUES ('3380', '108', '5');
INSERT INTO `sys_relation` VALUES ('3381', '109', '5');
INSERT INTO `sys_relation` VALUES ('3382', '110', '5');
INSERT INTO `sys_relation` VALUES ('3383', '111', '5');
INSERT INTO `sys_relation` VALUES ('3384', '112', '5');
INSERT INTO `sys_relation` VALUES ('3385', '113', '5');
INSERT INTO `sys_relation` VALUES ('3386', '114', '5');
INSERT INTO `sys_relation` VALUES ('3387', '115', '5');
INSERT INTO `sys_relation` VALUES ('3388', '116', '5');
INSERT INTO `sys_relation` VALUES ('3389', '117', '5');
INSERT INTO `sys_relation` VALUES ('3390', '118', '5');
INSERT INTO `sys_relation` VALUES ('3391', '119', '5');
INSERT INTO `sys_relation` VALUES ('3392', '120', '5');
INSERT INTO `sys_relation` VALUES ('3393', '121', '5');
INSERT INTO `sys_relation` VALUES ('3394', '122', '5');
INSERT INTO `sys_relation` VALUES ('3395', '150', '5');
INSERT INTO `sys_relation` VALUES ('3396', '151', '5');
INSERT INTO `sys_relation` VALUES ('3679', '105', '1');
INSERT INTO `sys_relation` VALUES ('3680', '106', '1');
INSERT INTO `sys_relation` VALUES ('3681', '107', '1');
INSERT INTO `sys_relation` VALUES ('3682', '108', '1');
INSERT INTO `sys_relation` VALUES ('3683', '109', '1');
INSERT INTO `sys_relation` VALUES ('3684', '110', '1');
INSERT INTO `sys_relation` VALUES ('3685', '111', '1');
INSERT INTO `sys_relation` VALUES ('3686', '112', '1');
INSERT INTO `sys_relation` VALUES ('3687', '113', '1');
INSERT INTO `sys_relation` VALUES ('3688', '165', '1');
INSERT INTO `sys_relation` VALUES ('3689', '166', '1');
INSERT INTO `sys_relation` VALUES ('3690', '167', '1');
INSERT INTO `sys_relation` VALUES ('3691', '114', '1');
INSERT INTO `sys_relation` VALUES ('3692', '115', '1');
INSERT INTO `sys_relation` VALUES ('3693', '116', '1');
INSERT INTO `sys_relation` VALUES ('3694', '117', '1');
INSERT INTO `sys_relation` VALUES ('3695', '118', '1');
INSERT INTO `sys_relation` VALUES ('3696', '162', '1');
INSERT INTO `sys_relation` VALUES ('3697', '163', '1');
INSERT INTO `sys_relation` VALUES ('3698', '164', '1');
INSERT INTO `sys_relation` VALUES ('3699', '119', '1');
INSERT INTO `sys_relation` VALUES ('3700', '120', '1');
INSERT INTO `sys_relation` VALUES ('3701', '121', '1');
INSERT INTO `sys_relation` VALUES ('3702', '122', '1');
INSERT INTO `sys_relation` VALUES ('3703', '150', '1');
INSERT INTO `sys_relation` VALUES ('3704', '151', '1');
INSERT INTO `sys_relation` VALUES ('3705', '128', '1');
INSERT INTO `sys_relation` VALUES ('3706', '134', '1');
INSERT INTO `sys_relation` VALUES ('3707', '158', '1');
INSERT INTO `sys_relation` VALUES ('3708', '159', '1');
INSERT INTO `sys_relation` VALUES ('3709', '130', '1');
INSERT INTO `sys_relation` VALUES ('3710', '131', '1');
INSERT INTO `sys_relation` VALUES ('3711', '135', '1');
INSERT INTO `sys_relation` VALUES ('3712', '136', '1');
INSERT INTO `sys_relation` VALUES ('3713', '137', '1');
INSERT INTO `sys_relation` VALUES ('3714', '152', '1');
INSERT INTO `sys_relation` VALUES ('3715', '153', '1');
INSERT INTO `sys_relation` VALUES ('3716', '154', '1');
INSERT INTO `sys_relation` VALUES ('3717', '132', '1');
INSERT INTO `sys_relation` VALUES ('3718', '138', '1');
INSERT INTO `sys_relation` VALUES ('3719', '139', '1');
INSERT INTO `sys_relation` VALUES ('3720', '140', '1');
INSERT INTO `sys_relation` VALUES ('3721', '155', '1');
INSERT INTO `sys_relation` VALUES ('3722', '156', '1');
INSERT INTO `sys_relation` VALUES ('3723', '157', '1');
INSERT INTO `sys_relation` VALUES ('3724', '133', '1');
INSERT INTO `sys_relation` VALUES ('3725', '160', '1');
INSERT INTO `sys_relation` VALUES ('3726', '161', '1');
INSERT INTO `sys_relation` VALUES ('3727', '141', '1');
INSERT INTO `sys_relation` VALUES ('3728', '142', '1');
INSERT INTO `sys_relation` VALUES ('3729', '143', '1');
INSERT INTO `sys_relation` VALUES ('3730', '144', '1');
INSERT INTO `sys_relation` VALUES ('3731', '148', '1');
INSERT INTO `sys_relation` VALUES ('3732', '145', '1');
INSERT INTO `sys_relation` VALUES ('3733', '149', '1');
INSERT INTO `sys_relation` VALUES ('3734', '168', '1');
INSERT INTO `sys_relation` VALUES ('3735', '169', '1');
INSERT INTO `sys_relation` VALUES ('3736', '170', '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'girl.gif', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', '张三', '2017-05-05 00:00:00', '2', 'sn93@qq.com', '18200000000', '1', '27', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `sys_user` VALUES ('44', null, 'test', '45abb7879f6a8268f1ef600e6038ac73', 'ssts3', 'test', '2017-05-01 00:00:00', '1', 'abc@123.com', '', '5', '26', '3', '2017-05-16 20:33:37', null);
INSERT INTO `sys_user` VALUES ('45', null, 'boss', '71887a5ad666a18f709e1d4e693d5a35', '1f7bf', '老板', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:02', null);
INSERT INTO `sys_user` VALUES ('46', null, 'manager', 'b53cac62e7175637d4beb3b16b2f7915', 'j3cs9', '经理', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:24', null);
