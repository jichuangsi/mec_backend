/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50540
 Source Host           : 127.0.0.1:3306
 Source Schema         : mes

 Target Server Type    : MySQL
 Target Server Version : 50540
 File Encoding         : 65001

 Date: 30/12/2020 10:11:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audit_pocess
-- ----------------------------
DROP TABLE IF EXISTS `audit_pocess`;
CREATE TABLE `audit_pocess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_order_id` int(11) NULL DEFAULT NULL,
  `audit_setting_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audit_setting` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 295 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of audit_pocess
-- ----------------------------
INSERT INTO `audit_pocess` VALUES (166, 39, '0', 1607999601666, 0, '是的发生', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (167, 39, '528', 1607999613841, 0, '通过', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (168, 39, '0', 1608000078633, 0, '驳回', '订单审核(在-----1------中被驳回)', 'CG');
INSERT INTO `audit_pocess` VALUES (169, 39, '0', 1608000089529, 0, '是的发生', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (170, 39, '528', 1608000149871, 0, '1', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (171, 39, '0', 1608000519108, 0, '我觉得要及时撤回', '采购订单--撤回', 'CG');
INSERT INTO `audit_pocess` VALUES (172, 39, '0', 1608000530447, 0, '是的发生', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (173, 40, '0', 1608000565168, 0, '暗示法撒范德萨发', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (174, 40, '0', 1608000723600, 0, '撤回', '采购订单--撤回', 'CG');
INSERT INTO `audit_pocess` VALUES (175, 40, '0', 1608000726790, 0, '暗示法撒范德萨发', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (176, 40, '542', 1608000734925, 0, '1', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (177, 40, '543', 1608004677896, 0, '2', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (178, 40, '543', 1608004682717, 0, '3', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (179, 40, '543', 1608004700902, 0, '4', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (180, 40, '543', 1608004782037, 0, '2', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (181, 40, '543', 1608005030162, 0, '2', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (182, 40, '544', 1608005043315, 0, '3', '订单审核(3)', 'CG');
INSERT INTO `audit_pocess` VALUES (183, 40, '545', 1608005091578, 0, '11', '来料检验(11)', 'LL');
INSERT INTO `audit_pocess` VALUES (184, 40, '546', 1608005102440, 0, '22', '来料检验(22)', 'LL');
INSERT INTO `audit_pocess` VALUES (185, 40, '0', 1608005231592, 0, '结束采购', '采购订单--结束采购', 'CG');
INSERT INTO `audit_pocess` VALUES (186, 40, '0', 1608005936052, 0, '要退回', '采购订单--采购退回', 'CG');
INSERT INTO `audit_pocess` VALUES (187, 40, '0', 1608005980360, 0, '结束退回算了', '采购订单--结束退回', 'CG');
INSERT INTO `audit_pocess` VALUES (188, 41, '0', 1608006136299, 0, '撒旦飞洒发生', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (189, 41, '549', 1608006146952, 0, '123', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (190, 41, '550', 1608006161043, 0, '2', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (191, 41, '0', 1608006171027, 0, '驳回3', '订单审核(在-----3------中被驳回)', 'CG');
INSERT INTO `audit_pocess` VALUES (192, 41, '0', 1608006183513, 0, '撒旦飞洒发生', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (193, 41, '549', 1608006201082, 0, '1', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (194, 41, '550', 1608006205833, 0, '2', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (195, 41, '551', 1608006211313, 0, '3', '订单审核(3)', 'CG');
INSERT INTO `audit_pocess` VALUES (196, 41, '552', 1608006217729, 0, '11', '来料检验(11)', 'LL');
INSERT INTO `audit_pocess` VALUES (197, 41, '553', 1608006235456, 0, '22', '来料检验(22)', 'LL');
INSERT INTO `audit_pocess` VALUES (198, 41, '0', 1608006265700, 0, '我觉得要退回', '采购订单--采购退回', 'CG');
INSERT INTO `audit_pocess` VALUES (199, 41, '0', 1608006286699, 0, '已经退回', '采购订单--结束退回', 'CG');
INSERT INTO `audit_pocess` VALUES (200, 33, '0', 1608006483417, 0, NULL, '创建销售订单', 'XX');
INSERT INTO `audit_pocess` VALUES (201, 33, '0', 1608006543952, 0, '先撤回', '订单审核状态-撤回', 'XX');
INSERT INTO `audit_pocess` VALUES (202, 33, '0', 1608006547803, 0, NULL, '创建销售订单', 'XX');
INSERT INTO `audit_pocess` VALUES (203, 33, '556', 1608006556101, 0, '1', '订单审核(1)', 'XX');
INSERT INTO `audit_pocess` VALUES (204, 33, '557', 1608006561511, 0, '2', '订单审核(2)', 'XX');
INSERT INTO `audit_pocess` VALUES (205, 33, '558', 1608006567198, 0, '3', '订单审核(3)', 'XX');
INSERT INTO `audit_pocess` VALUES (206, 33, '0', 1608006587547, 0, '可以出库了', '出库', NULL);
INSERT INTO `audit_pocess` VALUES (207, 33, '0', 1608006605754, 0, '结束销售吧', '结束销售', 'XX');
INSERT INTO `audit_pocess` VALUES (208, 33, '0', 1608006619010, 0, '甲方爸爸说要退回', '销售退回', 'XX');
INSERT INTO `audit_pocess` VALUES (209, 33, '0', 1608007168273, 0, '退回', '已退回()', 'TH');
INSERT INTO `audit_pocess` VALUES (210, 42, '0', 1608018169864, 0, 'f', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (211, 42, '559', 1608018179130, 0, '11', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (212, 42, '560', 1608018183580, 0, '12', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (213, 42, '561', 1608018188402, 0, '2', '订单审核(3)', 'CG');
INSERT INTO `audit_pocess` VALUES (214, 42, '562', 1608018196201, 0, '2', '来料检验(11)', 'LL');
INSERT INTO `audit_pocess` VALUES (215, 42, '563', 1608018200705, 0, '3', '来料检验(22)', 'LL');
INSERT INTO `audit_pocess` VALUES (216, 42, '0', 1608018215486, 0, '33', '采购订单--结束采购', 'CG');
INSERT INTO `audit_pocess` VALUES (217, 42, '0', 1608018954909, 0, '大啊', '入库', NULL);
INSERT INTO `audit_pocess` VALUES (218, 43, '0', 1608019008065, 0, '12', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (219, 43, '0', 1608033547031, 0, '撤回撤回', '采购订单--撤回', 'CG');
INSERT INTO `audit_pocess` VALUES (220, 43, '0', 1608033573880, 0, '12', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (221, 43, '566', 1608033580254, 0, '1', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (222, 43, '567', 1608033584463, 0, '2', '订单审核(2)', 'CG');
INSERT INTO `audit_pocess` VALUES (223, 43, '568', 1608033588278, 0, '3', '订单审核(3)', 'CG');
INSERT INTO `audit_pocess` VALUES (224, 43, '569', 1608033603398, 0, '11', '来料检验(11)', 'LL');
INSERT INTO `audit_pocess` VALUES (225, 43, '570', 1608033607655, 0, '22', '来料检验(22)', 'LL');
INSERT INTO `audit_pocess` VALUES (226, 43, '0', 1608033652113, 0, '结束采购啦', '采购订单--结束采购', 'CG');
INSERT INTO `audit_pocess` VALUES (227, 43, '0', 1608033665490, 0, '完成入库', '入库', NULL);
INSERT INTO `audit_pocess` VALUES (233, 5, '0', 1608199042199, 0, '机器出现异常响动', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (234, 5, '0', 1608199067463, 0, '批准停用该机器，由维修人员进行维修', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (235, 5, '0', 1608199149549, 0, '左侧转动轴处螺丝松动，已更换螺丝', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (236, 6, '0', 1608199261267, 0, '机器出现异常响动', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (237, 6, '0', 1608199299269, 0, '同意该设备修改', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (238, 6, '0', 1608199318683, 0, '左侧转动轴处螺丝松动，已更换螺丝', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (239, 7, '0', 1608199832013, 0, '机器出现异常响动', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (240, 7, '0', 1608199851651, 0, '处理', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (241, 7, '0', 1608199864004, 0, '维修', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (242, 7, '0', 1608199869900, 0, '检验', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (243, 5, '0', 1608257966478, 0, '我大多数阿瓦达打算打算大道发', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (244, 8, '0', 1608264445170, 0, '提交报修', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (245, 8, '0', 1608271637588, 0, 'awd', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (246, 8, '0', 1608271651057, 0, 'adwa', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (247, 8, '0', 1608271665826, 0, 'qwqweqw', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (248, 9, '0', 1608271815930, 0, '提交下处理意见', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (249, 9, '0', 1608271838489, 0, '处理', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (250, 9, '0', 1608271855201, 0, '维修', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (251, 10, '0', 1608271949522, 0, '撒范德萨', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (252, 10, '0', 1608271995904, 0, '的故事地方', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (253, 10, '0', 1608272044523, 0, '维修好了', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (254, 11, '0', 1608272089913, 0, '1', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (255, 12, '0', 1608272778246, 0, 'asd', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (256, 12, '0', 1608272783431, 0, 'sad', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (257, 12, '0', 1608272788597, 0, 'dsada', '检修记录', 'BX');
INSERT INTO `audit_pocess` VALUES (258, 12, '0', 1608272795560, 0, 'sad', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (259, 13, '0', 1608272805233, 0, 'dasda', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (260, 13, '0', 1608272824886, 0, 'asd', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (261, 13, '0', 1608273071233, 0, 'sadas', '检修记录', 'BX');
INSERT INTO `audit_pocess` VALUES (262, 13, '0', 1608273087482, 0, 'asd', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (263, 14, '0', 1608273271477, 0, 'aaa', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (264, 14, '0', 1608273324834, 0, 'bbb', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (265, 14, '0', 1608273332168, 0, 'ccc', '检修记录', 'BX');
INSERT INTO `audit_pocess` VALUES (266, 14, '0', 1608273337962, 0, 'ddd', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (267, 2, '0', 1608624385869, 0, '创建计划单', '创建计划单', 'PP');
INSERT INTO `audit_pocess` VALUES (268, 3, '0', 1608624632112, 0, '创建计划单', '创建计划单', 'PP');
INSERT INTO `audit_pocess` VALUES (269, 3, '0', 1608624750354, 0, '我是备注：通过吧', '创建计划单()', NULL);
INSERT INTO `audit_pocess` VALUES (270, 3, '613', 1608625566850, 0, '我是备注：通过吧', '审核中(1)', 'PP');
INSERT INTO `audit_pocess` VALUES (271, 15, '0', 1608693624691, 0, '我看', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (272, 15, '0', 1608693635141, 0, '这个', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (273, 15, '0', 1608693646501, 0, '好', '检修记录', 'BX');
INSERT INTO `audit_pocess` VALUES (274, 15, '0', 1608693654643, 0, '吧', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (275, 16, '0', 1608693834423, 0, 'w ', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (276, 16, '0', 1608693861855, 0, 'daw', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (277, 39, '0', 1608712841710, 0, '123', '订单审核(在-----1------中被驳回)', '');
INSERT INTO `audit_pocess` VALUES (278, 34, '0', 1608777326415, 0, NULL, '创建销售订单', 'XX');
INSERT INTO `audit_pocess` VALUES (279, 34, '621', 1608777335441, 0, '4', '订单审核(1)', 'XX');
INSERT INTO `audit_pocess` VALUES (280, 34, '622', 1608777340256, 0, '6', '订单审核(2)', 'XX');
INSERT INTO `audit_pocess` VALUES (281, 34, '623', 1608777344614, 0, '6', '订单审核(3)', 'XX');
INSERT INTO `audit_pocess` VALUES (282, 35, '0', 1608777380564, 0, NULL, '创建销售订单', 'XX');
INSERT INTO `audit_pocess` VALUES (283, 35, '628', 1608777401769, 0, '1', '订单审核(1)', 'XX');
INSERT INTO `audit_pocess` VALUES (284, 35, '629', 1608777406478, 0, '1', '订单审核(2)', 'XX');
INSERT INTO `audit_pocess` VALUES (285, 35, '630', 1608777411348, 0, '1', '订单审核(3)', 'XX');
INSERT INTO `audit_pocess` VALUES (286, 44, '0', 1608886148994, 0, '备注', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (287, 17, '0', 1609050123880, 0, '我想要报修', '故障名称现象简述', 'BX');
INSERT INTO `audit_pocess` VALUES (288, 17, '0', 1609050130483, 0, '12', '处理意见', 'BX');
INSERT INTO `audit_pocess` VALUES (289, 17, '0', 1609050139311, 0, '23', '检修记录', 'BX');
INSERT INTO `audit_pocess` VALUES (290, 17, '0', 1609050145334, 0, '343434', '验收情况', 'BX');
INSERT INTO `audit_pocess` VALUES (291, 44, '0', 1609151522641, 0, '11', '采购订单--撤回', 'CG');
INSERT INTO `audit_pocess` VALUES (292, 45, '0', 1609151563435, 0, '11', '创建采购订单', 'CG');
INSERT INTO `audit_pocess` VALUES (293, 45, '643', 1609151577850, 0, '1', '订单审核(1)', 'CG');
INSERT INTO `audit_pocess` VALUES (294, 46, '0', 1609151613668, 0, 'qq', '创建采购订单', 'CG');

-- ----------------------------
-- Table structure for audit_setting
-- ----------------------------
DROP TABLE IF EXISTS `audit_setting`;
CREATE TABLE `audit_setting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_level` int(11) NULL DEFAULT NULL,
  `audit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `delete_no` int(11) NULL DEFAULT 0,
  `level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of audit_setting
-- ----------------------------
INSERT INTO `audit_setting` VALUES (23, 1, 'CG', 1607999517408, 0, '1', NULL, 2);
INSERT INTO `audit_setting` VALUES (24, 2, 'CG', 1607999521818, 0, '2', NULL, 2);
INSERT INTO `audit_setting` VALUES (25, 4, 'CG', 1609148051010, 0, '4', NULL, 6);
INSERT INTO `audit_setting` VALUES (26, 1, 'LL', 1607999581730, 0, '11', NULL, 2);
INSERT INTO `audit_setting` VALUES (27, 2, 'LL', 1607999590313, 0, '22', NULL, 6);
INSERT INTO `audit_setting` VALUES (28, 1, 'XX', 1608006514397, 0, '1', NULL, 2);
INSERT INTO `audit_setting` VALUES (29, 2, 'XX', 1608006524024, 0, '2', NULL, 6);
INSERT INTO `audit_setting` VALUES (30, 5, 'XX', 1609146852749, 0, '3', NULL, 2);
INSERT INTO `audit_setting` VALUES (31, 1, NULL, 1608188965969, 0, '1', NULL, 1);
INSERT INTO `audit_setting` VALUES (34, 1, 'BX', 1608198523273, 0, '负责人', NULL, 2);
INSERT INTO `audit_setting` VALUES (35, 2, 'BX', 1608198528009, 0, '维修人', NULL, 2);
INSERT INTO `audit_setting` VALUES (36, 3, 'BX', 1608198532072, 0, '验收人', NULL, 6);
INSERT INTO `audit_setting` VALUES (37, 1, 'PP', 1608198532072, 0, '1', NULL, 1);
INSERT INTO `audit_setting` VALUES (38, 2, NULL, 1608880512241, 0, '2', NULL, 6);
INSERT INTO `audit_setting` VALUES (39, 1, 'TH', 1608715219662, 0, '112', NULL, 2);
INSERT INTO `audit_setting` VALUES (40, 3, 'TH', 1608715226133, 0, '2', NULL, 2);
INSERT INTO `audit_setting` VALUES (41, 4, NULL, 1608880634022, 0, '3', NULL, 2);
INSERT INTO `audit_setting` VALUES (42, 5, NULL, 1608880949861, 0, '2', NULL, 2);
INSERT INTO `audit_setting` VALUES (43, 3, NULL, 1608881021704, 0, '12', NULL, 2);
INSERT INTO `audit_setting` VALUES (44, 7, NULL, 1608881076325, 0, '的', NULL, 6);
INSERT INTO `audit_setting` VALUES (45, 3, 'PP', 1608893555163, 0, '啊', NULL, 2);
INSERT INTO `audit_setting` VALUES (46, 4, 'PP', 1608882718352, 0, '是', NULL, 6);
INSERT INTO `audit_setting` VALUES (47, 5, 'CG', 1609148085630, 0, '4', NULL, 2);
INSERT INTO `audit_setting` VALUES (48, 6, 'CG', 1609148114327, 0, '6', NULL, 6);

-- ----------------------------
-- Table structure for complaint
-- ----------------------------
DROP TABLE IF EXISTS `complaint`;
CREATE TABLE `complaint`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `complaint_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `complaint_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of complaint
-- ----------------------------
INSERT INTO `complaint` VALUES (23, '那个在我是大舒服撒 阿士大夫撒放撒', '我要投诉', 1607936704426, 1, 0, NULL, 1);
INSERT INTO `complaint` VALUES (24, '1212121', '12121', 1607937882903, 8, 0, NULL, 1);
INSERT INTO `complaint` VALUES (25, '12312312312', '她说她家不好玩', 1608883821978, 24, 0, NULL, 1);

-- ----------------------------
-- Table structure for customer_detail
-- ----------------------------
DROP TABLE IF EXISTS `customer_detail`;
CREATE TABLE `customer_detail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_detail_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of customer_detail
-- ----------------------------
INSERT INTO `customer_detail` VALUES (1, '细节', 2, 0, 'string');
INSERT INTO `customer_detail` VALUES (2, '细节', 3, 0, '客户备注1');
INSERT INTO `customer_detail` VALUES (3, '细节222', 3, 0, '这是啥子客户');
INSERT INTO `customer_detail` VALUES (4, '细节33333', 3, 0, '不是把这是细节3啊');
INSERT INTO `customer_detail` VALUES (5, '客户筛子', 0, 0, '客户的备注');
INSERT INTO `customer_detail` VALUES (6, NULL, 8, 0, 'awd');
INSERT INTO `customer_detail` VALUES (7, NULL, 14, 0, '单位我');
INSERT INTO `customer_detail` VALUES (8, NULL, 14, 0, '带娃阿瓦达 ');
INSERT INTO `customer_detail` VALUES (9, NULL, 16, 0, 'aa');
INSERT INTO `customer_detail` VALUES (10, '1', 17, 0, '21');
INSERT INTO `customer_detail` VALUES (11, 'a', 18, 0, 'a');
INSERT INTO `customer_detail` VALUES (12, 'a', 18, 0, 'a');
INSERT INTO `customer_detail` VALUES (13, 'a', 20, 0, 'a');
INSERT INTO `customer_detail` VALUES (14, '她爸是村长', 24, 0, '你记得就行的');
INSERT INTO `customer_detail` VALUES (15, '她弟是时长', 24, 0, '你还是记得吧');
INSERT INTO `customer_detail` VALUES (16, '她是桑巴', 24, 0, '已确定');
INSERT INTO `customer_detail` VALUES (17, '再加一个吧', NULL, NULL, '加一个');
INSERT INTO `customer_detail` VALUES (18, '1', 26, 0, '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 0, '部门555555', '部门5555555', NULL, 1, 1);
INSERT INTO `department` VALUES (2, 0, '部门1111', '部门1111', NULL, 1, 1);
INSERT INTO `department` VALUES (3, 0, '部门222222', '部门222222', NULL, 1, 1);
INSERT INTO `department` VALUES (4, 0, '部门333333', '部门333333', NULL, 1, 1);
INSERT INTO `department` VALUES (5, 0, '部门444444', '部门44444', NULL, 1, 1);
INSERT INTO `department` VALUES (6, 0, '部门666666', '部门666666', NULL, 1, 0);
INSERT INTO `department` VALUES (7, 0, '部门123', '部门123', 'string', 1, 0);
INSERT INTO `department` VALUES (8, 0, '部门123', '部门123', 'string', 1, 0);
INSERT INTO `department` VALUES (9, 0, '部门123', '部门123', 'string', 1, 0);
INSERT INTO `department` VALUES (10, 0, '部门123', '部门123', 'string', 1, 0);
INSERT INTO `department` VALUES (11, 0, '部门666666', '部门666666', NULL, 1, 0);
INSERT INTO `department` VALUES (12, 0, '部门666666', '部门666666', NULL, 1, 0);
INSERT INTO `department` VALUES (13, 0, '部门666666', '部门666666', NULL, 1, 0);
INSERT INTO `department` VALUES (14, 0, '部门666666', '部门666666', NULL, 1, 0);
INSERT INTO `department` VALUES (15, 0, '部门666666', '部门666666', NULL, 1, 0);
INSERT INTO `department` VALUES (16, 0, '大门', '阿伟大的', NULL, 4, 1);
INSERT INTO `department` VALUES (17, 0, '大门', '阿伟大的', NULL, 4, 1);
INSERT INTO `department` VALUES (18, 0, '我是部门', '我是部门备注', NULL, 1, 0);

-- ----------------------------
-- Table structure for file_table
-- ----------------------------
DROP TABLE IF EXISTS `file_table`;
CREATE TABLE `file_table`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_route` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of file_table
-- ----------------------------
INSERT INTO `file_table` VALUES (16, 1, '0d209f31-b3c2-4c4e-b56e-b80134d70806123.doc', '4297f44b13955235245b2497399d7a93', 'D:/file/0d209f31-b3c2-4c4e-b56e-b80134d70806123.doc', 1608002541332, 1);
INSERT INTO `file_table` VALUES (17, 0, '94de158a-8df5-4be0-bd62-29a9ebb85a14aa.xls', '4297f44b13955235245b2497399d7a93', 'D:/file/94de158a-8df5-4be0-bd62-29a9ebb85a14aa.xls', 1608005129249, 1);
INSERT INTO `file_table` VALUES (18, 0, '5e148473-c55a-41b3-8ddb-bb63232828d3aa.xls', '96e79218965eb72c92a549dd5a330112', 'D:/file/5e148473-c55a-41b3-8ddb-bb63232828d3aa.xls', 1608005171770, 1);
INSERT INTO `file_table` VALUES (19, 0, '95298d52-c8a6-4310-ab66-71fba3cd8f2e123.doc', '4297f44b13955235245b2497399d7a93', 'D:/file/95298d52-c8a6-4310-ab66-71fba3cd8f2e123.doc', 1608005351476, 1);
INSERT INTO `file_table` VALUES (20, 0, 'f44ade45-26b1-49bf-ba9f-5b9df3ef9f51aa.xls', '4297f44b13955235245b2497399d7a93', 'D:/file/f44ade45-26b1-49bf-ba9f-5b9df3ef9f51aa.xls', 1608007407578, 1);
INSERT INTO `file_table` VALUES (21, 0, 'file1115f164-73a8-4c40-aa3c-da286ffd2249新建 Microsoft Excel 2007 工作表.xlsx', '96e79218965eb72c92a549dd5a330112', '/upload/file1115f164-73a8-4c40-aa3c-da286ffd2249新建 Microsoft Excel 2007 工作表.xlsx', 1608884257842, 1);
INSERT INTO `file_table` VALUES (22, 0, 'file4757ecce-a44d-4d5c-b72e-b4246d5187cames表.docx', '96e79218965eb72c92a549dd5a330112', '/upload/file4757ecce-a44d-4d5c-b72e-b4246d5187cames表.docx', 1608884296474, 1);

-- ----------------------------
-- Table structure for gx_lossbi
-- ----------------------------
DROP TABLE IF EXISTS `gx_lossbi`;
CREATE TABLE `gx_lossbi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gxid` int(11) NULL DEFAULT NULL,
  `cpend` decimal(19, 2) NULL DEFAULT NULL,
  `cpstart` decimal(19, 2) NULL DEFAULT NULL,
  `fpend` decimal(19, 2) NULL DEFAULT NULL,
  `fpstart` decimal(19, 2) NULL DEFAULT NULL,
  `lossend` decimal(19, 2) NULL DEFAULT NULL,
  `lossstart` decimal(19, 2) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of gx_lossbi
-- ----------------------------
INSERT INTO `gx_lossbi` VALUES (1, 0, 90.00, 20.00, 30.00, 40.00, 50.00, 30.00, 4, 0);
INSERT INTO `gx_lossbi` VALUES (2, 0, 80.00, 30.00, 30.00, 40.00, 50.00, 30.00, 4, 0);
INSERT INTO `gx_lossbi` VALUES (19, NULL, 1.00, 2.00, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (26, NULL, 1.00, 2.00, NULL, NULL, NULL, NULL, 7, 0);
INSERT INTO `gx_lossbi` VALUES (27, NULL, 1.00, 1.00, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (31, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (34, NULL, 1.00, 1.00, NULL, NULL, NULL, NULL, 8, 0);
INSERT INTO `gx_lossbi` VALUES (35, NULL, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 9, 0);
INSERT INTO `gx_lossbi` VALUES (36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0);
INSERT INTO `gx_lossbi` VALUES (37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, 0);
INSERT INTO `gx_lossbi` VALUES (38, NULL, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (39, NULL, 1.00, 1.00, 1.00, 1.00, 1.00, 11.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (40, NULL, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (41, NULL, 1.00, 1.00, 11.00, 1.00, 1.00, 1.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (42, NULL, 1.00, 1.00, 11.00, 1.00, 1.00, 1.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (43, NULL, 1.00, 1.00, 1.00, -11.00, 1.00, 1.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (44, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0);
INSERT INTO `gx_lossbi` VALUES (45, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 10, 0);
INSERT INTO `gx_lossbi` VALUES (46, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, 0);
INSERT INTO `gx_lossbi` VALUES (47, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 11, 0);
INSERT INTO `gx_lossbi` VALUES (48, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0);
INSERT INTO `gx_lossbi` VALUES (49, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, 0);
INSERT INTO `gx_lossbi` VALUES (50, NULL, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 13, 0);
INSERT INTO `gx_lossbi` VALUES (51, NULL, 1.00, 1.00, 1.00, 1.00, 1.00, 1.00, 13, 0);

-- ----------------------------
-- Table structure for inventory_record
-- ----------------------------
DROP TABLE IF EXISTS `inventory_record`;
CREATE TABLE `inventory_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `changequantity` int(11) NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `inventory_type` int(11) NULL DEFAULT NULL,
  `product_detailid` int(11) NULL DEFAULT NULL,
  `record_type` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surplusquantity` int(11) NULL DEFAULT NULL,
  `warehouse_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of inventory_record
-- ----------------------------
INSERT INTO `inventory_record` VALUES (58, 5, 1608014474311, 1, 20, 2, '这个原材料的id是20', 5, 1);
INSERT INTO `inventory_record` VALUES (59, 4, 1608014474312, 1, 22, 2, '这个原材料的id是22', 4, 1);
INSERT INTO `inventory_record` VALUES (60, 5, 1608014708948, 1, 20, 2, '这个原材料的id是20', 10, 1);
INSERT INTO `inventory_record` VALUES (61, 4, 1608014708968, 1, 22, 2, '这个原材料的id是22', 8, 1);
INSERT INTO `inventory_record` VALUES (62, 5, 1608014725170, 1, 20, 2, '这个原材料的id是20', 5, 2);
INSERT INTO `inventory_record` VALUES (63, 4, 1608014725171, 1, 22, 2, '这个原材料的id是22', 4, 2);
INSERT INTO `inventory_record` VALUES (64, 100, 1608014959314, 1, 21, 2, '这个原材料的id是21', 100, 2);
INSERT INTO `inventory_record` VALUES (65, 4, 1608014959315, 1, 22, 2, '这个原材料的id是22', 8, 2);
INSERT INTO `inventory_record` VALUES (66, -12, 1608015740106, 1, 21, 3, '给仓库1 12条', 88, 2);
INSERT INTO `inventory_record` VALUES (67, 12, 1608015740106, 1, 21, 3, '给仓库1 12条', 88, 1);
INSERT INTO `inventory_record` VALUES (68, -8, 1608016010952, 1, 21, 3, '给仓库1 12条', 80, 2);
INSERT INTO `inventory_record` VALUES (69, 8, 1608016010952, 1, 21, 3, '给仓库1 12条', 20, 1);
INSERT INTO `inventory_record` VALUES (70, -8, 1608016056325, 1, 21, 3, '给仓库3 12条', 72, 2);
INSERT INTO `inventory_record` VALUES (71, 8, 1608016056325, 1, 21, 3, '给仓库3 12条', 72, 3);
INSERT INTO `inventory_record` VALUES (72, -2, 1608016169069, 1, 21, 3, '给仓库4 12条', 70, 2);
INSERT INTO `inventory_record` VALUES (73, 2, 1608016169069, 1, 21, 3, '给仓库4 12条', 2, 4);
INSERT INTO `inventory_record` VALUES (74, -2, 1608016199607, 1, 21, 3, '给仓库4 12条', 68, 2);
INSERT INTO `inventory_record` VALUES (75, 2, 1608016199607, 1, 21, 3, '给仓库4 12条', 22, 1);
INSERT INTO `inventory_record` VALUES (76, -2, 1608016546046, 1, 21, 3, '给仓库4 12条', 0, 4);
INSERT INTO `inventory_record` VALUES (77, 2, 1608016546046, 1, 21, 3, '给仓库4 12条', 24, 1);
INSERT INTO `inventory_record` VALUES (78, -18, 1608016642975, 1, 21, 1, '备注备注', 50, 2);
INSERT INTO `inventory_record` VALUES (79, -24, 1608016642976, 1, 21, 1, '备注备注', 0, 1);
INSERT INTO `inventory_record` VALUES (80, 100, 1608017905034, 5, 10, 2, '入库100', 100, 1);
INSERT INTO `inventory_record` VALUES (81, 110, 1608017905035, 5, 11, 2, '入库110', 110, 1);
INSERT INTO `inventory_record` VALUES (82, 100, 1608017953713, 5, 10, 2, '入库100', 200, 1);
INSERT INTO `inventory_record` VALUES (83, 90, 1608017953719, 5, 11, 2, '入库110', 200, 1);
INSERT INTO `inventory_record` VALUES (84, -2, 1608018119506, 5, 10, 3, '给仓库2 调拨2条', 198, 1);
INSERT INTO `inventory_record` VALUES (85, 2, 1608018119506, 5, 10, 3, '给仓库2 调拨2条', 2, 2);
INSERT INTO `inventory_record` VALUES (86, -18, 1608018319706, 5, 11, 1, '备注备注', 182, 1);
INSERT INTO `inventory_record` VALUES (87, -2, 1608018319708, 5, 10, 1, '备注备注', 0, 2);
INSERT INTO `inventory_record` VALUES (88, 1, 1608018954880, 1, 7, 5, '大啊', 1, 3);
INSERT INTO `inventory_record` VALUES (89, 100, 1608028695490, 1, 7, 1, NULL, 100, 3);
INSERT INTO `inventory_record` VALUES (90, 1, 1608033665472, 1, 7, 5, '完成入库', 1, 2);
INSERT INTO `inventory_record` VALUES (91, 12, 1608033665473, 1, 18, 5, '完成入库', 12, 2);
INSERT INTO `inventory_record` VALUES (92, -1, 1608099312465, 1, 18, 3, '122', 11, 2);
INSERT INTO `inventory_record` VALUES (93, 1, 1608099312465, 1, 18, 3, '122', 1, 4);
INSERT INTO `inventory_record` VALUES (94, -1, 1608100543642, 1, 7, 3, '2', 99, 3);
INSERT INTO `inventory_record` VALUES (95, 1, 1608100543642, 1, 7, 3, '2', 1, 4);
INSERT INTO `inventory_record` VALUES (96, -1, 1608100543645, 1, 7, 3, '2', 0, 2);
INSERT INTO `inventory_record` VALUES (97, 1, 1608100543645, 1, 7, 3, '2', 1, 4);
INSERT INTO `inventory_record` VALUES (98, -1, 1608100578550, 1, 7, 1, '1', 98, 3);
INSERT INTO `inventory_record` VALUES (99, -1, 1608100578552, 1, 7, 1, '1', 0, 4);
INSERT INTO `inventory_record` VALUES (100, -1, 1608100578553, 1, 7, 1, '1', 0, 4);
INSERT INTO `inventory_record` VALUES (101, 1, 1608103199980, 1, 20, 2, 'a', 1, NULL);
INSERT INTO `inventory_record` VALUES (102, 1, 1608103199981, 1, 22, 2, 'a', 1, NULL);
INSERT INTO `inventory_record` VALUES (103, 1, 1608103264382, 1, 20, 2, 'a', 1, 4);
INSERT INTO `inventory_record` VALUES (104, 1, 1608103264383, 1, 22, 2, 'a', 1, 4);
INSERT INTO `inventory_record` VALUES (105, 123, 1608110012955, 1, 20, 6, '仓库盘点', 123, 1);
INSERT INTO `inventory_record` VALUES (106, 12, 1608110115594, 1, 20, 6, '仓库盘点', 12, 1);
INSERT INTO `inventory_record` VALUES (107, 23, 1608110187830, 1, 20, 6, '仓库盘点', 23, 1);
INSERT INTO `inventory_record` VALUES (108, 12, 1608110212518, 1, 20, 6, '仓库盘点', 12, 1);
INSERT INTO `inventory_record` VALUES (109, 1, 1608110244145, 1, 20, 6, '仓库盘点', 1, 1);
INSERT INTO `inventory_record` VALUES (110, 2, 1608110251494, 1, 20, 6, '仓库盘点', 2, 1);
INSERT INTO `inventory_record` VALUES (111, 3, 1608110255539, 1, 20, 6, '仓库盘点', 3, 1);
INSERT INTO `inventory_record` VALUES (112, 13, 1608112575169, 1, 23, 2, 'rk', 13, 4);
INSERT INTO `inventory_record` VALUES (113, 1300, 1608112575170, 1, 21, 2, 'rk', 1300, 4);
INSERT INTO `inventory_record` VALUES (114, 2, 1608707169958, 1, 20, 6, '仓库盘点', 2, 1);
INSERT INTO `inventory_record` VALUES (115, 1, 1608707267543, 1, 20, 6, '仓库盘点', 1, 1);
INSERT INTO `inventory_record` VALUES (116, -1, 1608980904118, 1, 20, 3, '2', 0, 1);
INSERT INTO `inventory_record` VALUES (117, 1, 1608980904118, 1, 20, 3, '2', 1, 1);
INSERT INTO `inventory_record` VALUES (118, -1, 1608980904121, 1, 22, 3, '2', 7, 1);
INSERT INTO `inventory_record` VALUES (119, 1, 1608980904121, 1, 22, 3, '2', 8, 1);
INSERT INTO `inventory_record` VALUES (120, -98, 1609126063996, 1, 7, 7, '生产出库', 0, 3);
INSERT INTO `inventory_record` VALUES (121, -8, 1609126315768, 1, 22, 7, '生产出库', 0, 1);
INSERT INTO `inventory_record` VALUES (122, -5, 1609126315771, 1, 20, 7, '生产出库', 0, 2);
INSERT INTO `inventory_record` VALUES (123, -1, 1609128425723, 1, 18, 7, '生产出库', 10, 2);
INSERT INTO `inventory_record` VALUES (124, -1, 1609145007485, 1, 18, 1, '啊', 9, 2);
INSERT INTO `inventory_record` VALUES (125, -1, 1609153162780, 1, 18, 7, '生产出库', 8, 2);
INSERT INTO `inventory_record` VALUES (126, -1, 1609209737963, 1, 18, 7, '生产出库', 7, 2);
INSERT INTO `inventory_record` VALUES (127, -1, 1609210196082, 1, 18, 7, '生产出库', 6, 2);
INSERT INTO `inventory_record` VALUES (128, -1, 1609229967562, 1, 18, 7, '生产出库', 5, 2);
INSERT INTO `inventory_record` VALUES (129, -2, 1609230893085, 1, 18, 7, '生产出库', 3, 2);
INSERT INTO `inventory_record` VALUES (130, -1, 1609231458555, 1, 22, 7, '生产出库', 7, 2);
INSERT INTO `inventory_record` VALUES (131, -1, 1609231458557, 1, 20, 7, '生产出库', 0, NULL);
INSERT INTO `inventory_record` VALUES (132, -1, 1609231458559, 1, 23, 7, '生产出库', 12, 4);
INSERT INTO `inventory_record` VALUES (133, -1, 1609232959693, 1, 18, 7, '生产出库', 2, 2);
INSERT INTO `inventory_record` VALUES (134, -1, 1609233960836, 1, 22, 7, '生产出库', 6, 2);
INSERT INTO `inventory_record` VALUES (135, -1, 1609233960842, 1, 23, 7, '生产出库', 11, 4);
INSERT INTO `inventory_record` VALUES (136, -5, 1609234582221, 1, 22, 7, '生产出库', 1, 2);
INSERT INTO `inventory_record` VALUES (137, -1, 1609234753049, 1, 18, 7, '生产出库', 1, 2);
INSERT INTO `inventory_record` VALUES (138, -1, 1609234851643, 1, 18, 7, '生产出库', 0, 2);
INSERT INTO `inventory_record` VALUES (139, -12, 1609292468807, 1, 21, 7, '生产出库', 1288, 4);

-- ----------------------------
-- Table structure for inventory_status
-- ----------------------------
DROP TABLE IF EXISTS `inventory_status`;
CREATE TABLE `inventory_status`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventorysum` int(11) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `warehouse_id` int(11) NULL DEFAULT NULL,
  `inventory_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of inventory_status
-- ----------------------------
INSERT INTO `inventory_status` VALUES (51, 1, 20, 1, 1);
INSERT INTO `inventory_status` VALUES (52, 0, 22, 1, 1);
INSERT INTO `inventory_status` VALUES (53, 0, 20, 2, 1);
INSERT INTO `inventory_status` VALUES (54, 1, 22, 2, 1);
INSERT INTO `inventory_status` VALUES (55, 50, 21, 2, 1);
INSERT INTO `inventory_status` VALUES (56, 0, 21, 1, 1);
INSERT INTO `inventory_status` VALUES (57, 8, 21, 3, 1);
INSERT INTO `inventory_status` VALUES (58, 1288, 21, 4, 1);
INSERT INTO `inventory_status` VALUES (59, 198, 10, 1, 5);
INSERT INTO `inventory_status` VALUES (60, 182, 11, 1, 5);
INSERT INTO `inventory_status` VALUES (61, 0, 10, 2, 5);
INSERT INTO `inventory_status` VALUES (62, 0, 7, 3, 1);
INSERT INTO `inventory_status` VALUES (63, 0, 7, 2, 1);
INSERT INTO `inventory_status` VALUES (64, 0, 18, 2, 1);
INSERT INTO `inventory_status` VALUES (65, 1, 18, 4, 1);
INSERT INTO `inventory_status` VALUES (66, 0, 7, 4, 1);
INSERT INTO `inventory_status` VALUES (67, 0, 7, 4, 1);
INSERT INTO `inventory_status` VALUES (68, 0, 20, NULL, 1);
INSERT INTO `inventory_status` VALUES (69, 1, 22, NULL, 1);
INSERT INTO `inventory_status` VALUES (70, 1, 20, 4, 1);
INSERT INTO `inventory_status` VALUES (71, 1, 22, 4, 1);
INSERT INTO `inventory_status` VALUES (72, 11, 23, 4, 1);

-- ----------------------------
-- Table structure for matters
-- ----------------------------
DROP TABLE IF EXISTS `matters`;
CREATE TABLE `matters`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `delete_no` int(11) NULL DEFAULT 0,
  `finished_no` int(11) NULL DEFAULT 0,
  `matter_news` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 414 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of matters
-- ----------------------------
INSERT INTO `matters` VALUES (1, 1606980417692, 0, NULL, '您有1个采购订单待审核', 1, 10);
INSERT INTO `matters` VALUES (2, 1606986263862, 0, NULL, '您有1个采购订单待审核', 1, 14);
INSERT INTO `matters` VALUES (4, 1606988629993, 0, NULL, '您有1个采购订单待审核', 1, 15);
INSERT INTO `matters` VALUES (5, 1606988786974, NULL, 1, NULL, 1, 14);
INSERT INTO `matters` VALUES (6, 1606988787004, 0, NULL, '您有1个采购订单待审核', 4, 14);
INSERT INTO `matters` VALUES (7, 1606988920763, NULL, 1, NULL, 4, 14);
INSERT INTO `matters` VALUES (8, 1606988920767, 0, NULL, '您有1个采购订单待审核', 3, 14);
INSERT INTO `matters` VALUES (9, 1606988981516, 0, NULL, '您有1个采购订单待审核', 1, 16);
INSERT INTO `matters` VALUES (10, 1606990403715, 0, NULL, '您有1个采购订单待审核', 1, 14);
INSERT INTO `matters` VALUES (11, 1606990428449, 0, NULL, '您有1个采购订单待审核', 1, 14);
INSERT INTO `matters` VALUES (12, 1606990433601, 0, NULL, '您有1个采购订单待审核', 1, 14);
INSERT INTO `matters` VALUES (13, 1606990479350, 0, NULL, '您有1个采购订单待审核', 1, 17);
INSERT INTO `matters` VALUES (14, 1606990639616, 0, NULL, '您有1个采购订单待审核', 1, 18);
INSERT INTO `matters` VALUES (15, 1606990819960, 0, NULL, '您有1个采购订单待审核', 1, 20);
INSERT INTO `matters` VALUES (16, 1607046215810, 0, NULL, '您有1个采购订单待审核', 1, 21);
INSERT INTO `matters` VALUES (17, 1607052233784, 0, NULL, '您有1个采购订单待审核', 1, 20);
INSERT INTO `matters` VALUES (18, 1607052852075, NULL, 1, NULL, 1, 20);
INSERT INTO `matters` VALUES (19, 1607052852109, 0, NULL, '您有1个采购订单待审核', 4, 20);
INSERT INTO `matters` VALUES (20, 1607052945386, NULL, 1, NULL, 4, 20);
INSERT INTO `matters` VALUES (21, 1607052945390, 0, NULL, '您有1个采购订单待审核', 3, 20);
INSERT INTO `matters` VALUES (23, 1607053792538, NULL, 1, NULL, 4, 20);
INSERT INTO `matters` VALUES (24, 1607053792543, 0, NULL, '您有1个采购订单待审核', 3, 20);
INSERT INTO `matters` VALUES (30, 1607055222156, NULL, 1, NULL, 3, 20);
INSERT INTO `matters` VALUES (31, 1607055376849, NULL, 1, NULL, 3, 20);
INSERT INTO `matters` VALUES (32, 1607055376880, 0, NULL, '您有1个采购来料订单待审核', 4, 20);
INSERT INTO `matters` VALUES (33, 1607056272651, NULL, 1, NULL, 4, 20);
INSERT INTO `matters` VALUES (34, 1607061552344, 0, NULL, '您有1个采购订单待审核', 1, 19);
INSERT INTO `matters` VALUES (35, 1607061615772, NULL, 1, NULL, 1, 19);
INSERT INTO `matters` VALUES (36, 1607061615775, 0, NULL, '您有1个采购订单待审核', 4, 19);
INSERT INTO `matters` VALUES (37, 1607061647530, NULL, 1, NULL, 4, 19);
INSERT INTO `matters` VALUES (38, 1607061647533, 0, NULL, '您有1个采购订单待审核', 3, 19);
INSERT INTO `matters` VALUES (39, 1607061683166, NULL, 1, NULL, 3, 19);
INSERT INTO `matters` VALUES (40, 1607061708149, NULL, 1, NULL, 3, 19);
INSERT INTO `matters` VALUES (41, 1607061708151, 0, NULL, '您有1个采购来料订单待审核', 4, 19);
INSERT INTO `matters` VALUES (42, 1607061728922, NULL, 1, NULL, 4, 19);
INSERT INTO `matters` VALUES (43, 1607065227843, 0, NULL, '您有1个采购订单待审核', 1, 21);
INSERT INTO `matters` VALUES (44, 1607065247230, NULL, 1, NULL, 1, 21);
INSERT INTO `matters` VALUES (45, 1607065247236, 0, NULL, '您有1个采购订单待审核', 4, 21);
INSERT INTO `matters` VALUES (46, 1607065281899, NULL, 1, NULL, 4, 21);
INSERT INTO `matters` VALUES (47, 1607065281902, 0, NULL, '您有1个采购订单待审核', 3, 21);
INSERT INTO `matters` VALUES (48, 1607065295574, NULL, 1, NULL, 3, 21);
INSERT INTO `matters` VALUES (49, 1607065308710, NULL, 1, NULL, 3, 21);
INSERT INTO `matters` VALUES (50, 1607065308712, 0, NULL, '您有1个采购来料订单待审核', 4, 21);
INSERT INTO `matters` VALUES (51, 1607065533521, NULL, 1, NULL, 3, 21);
INSERT INTO `matters` VALUES (52, 1607065533553, 0, NULL, '您有1个采购来料订单待审核', 4, 21);
INSERT INTO `matters` VALUES (53, 1607065612407, NULL, 1, NULL, 3, 21);
INSERT INTO `matters` VALUES (54, 1607065624187, NULL, 1, NULL, 3, 21);
INSERT INTO `matters` VALUES (55, 1607065624189, 0, NULL, '您有1个采购来料订单待审核', 4, 21);
INSERT INTO `matters` VALUES (56, 1607065636677, NULL, 1, NULL, 4, 21);
INSERT INTO `matters` VALUES (57, 1606796611424, 0, NULL, '您有1个销售订单待审核', 4, 0);
INSERT INTO `matters` VALUES (58, 1606796784165, 0, NULL, '您有1个销售订单待审核', 4, 2);
INSERT INTO `matters` VALUES (59, 1606797109439, 0, NULL, '您有1个销售订单待审核', 4, 3);
INSERT INTO `matters` VALUES (60, 1606812847570, 0, NULL, '您有1个销售订单待审核', 4, 4);
INSERT INTO `matters` VALUES (61, 1606814757913, NULL, 1, NULL, 4, 4);
INSERT INTO `matters` VALUES (62, 1606814757927, 0, NULL, '您有1个销售订单待审核', 4, 4);
INSERT INTO `matters` VALUES (63, 1606815133668, NULL, 1, NULL, 2, 4);
INSERT INTO `matters` VALUES (64, 1606815133671, 0, NULL, '您有1个销售订单待审核', 3, 4);
INSERT INTO `matters` VALUES (65, 1606815159466, NULL, 1, NULL, 3, 4);
INSERT INTO `matters` VALUES (66, 1606817213368, 0, NULL, '您有1个采购订单待审核', 1, 23);
INSERT INTO `matters` VALUES (67, 1607659389337, 0, NULL, '您有1个销售订单待审核', 2, 5);
INSERT INTO `matters` VALUES (68, 1607677626357, 0, NULL, '您有1个销售订单待审核', 2, 7);
INSERT INTO `matters` VALUES (69, 1607677850623, 0, NULL, '您有1个销售订单待审核', 2, 9);
INSERT INTO `matters` VALUES (70, 1607678905723, 0, NULL, '您有1个销售订单待审核', 2, 10);
INSERT INTO `matters` VALUES (71, 1607678963253, 0, NULL, '您有1个销售订单待审核', 2, 11);
INSERT INTO `matters` VALUES (72, 1607679215633, 0, NULL, '您有1个销售订单待审核', 2, 12);
INSERT INTO `matters` VALUES (73, 1607679338632, 0, NULL, '您有1个销售订单待审核', 2, 13);
INSERT INTO `matters` VALUES (74, 1607680557495, 0, NULL, '您有1个销售订单待审核', 2, 14);
INSERT INTO `matters` VALUES (75, 1607681595883, 0, NULL, '您有1个销售订单待审核', 2, 15);
INSERT INTO `matters` VALUES (76, 1607681666775, 0, NULL, '您有1个销售订单待审核', 2, 16);
INSERT INTO `matters` VALUES (77, 1607739245432, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (78, 1607739287655, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (79, 1607739562317, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (80, 1607739630204, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (81, 1607739643900, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (82, 1607739760799, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (83, 1607744268218, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (84, 1607744303827, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (85, 1607744383442, 0, NULL, '您有1个销售订单待审核', 2, 17);
INSERT INTO `matters` VALUES (86, 1607744720886, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (87, 1607745016748, 0, NULL, '您有1个销售订单待审核', 2, 18);
INSERT INTO `matters` VALUES (88, 1607745026794, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (89, 1607913173764, 0, NULL, '您有1个销售订单待审核', 2, 1);
INSERT INTO `matters` VALUES (90, 1607914865726, 0, NULL, '您有1个销售订单待审核', 2, 24);
INSERT INTO `matters` VALUES (91, 1607914875530, 0, NULL, '您有1个销售订单待审核', 2, 24);
INSERT INTO `matters` VALUES (92, 1607916459446, 0, NULL, '您有1个销售订单待审核', 2, 25);
INSERT INTO `matters` VALUES (93, 1607917345710, 0, NULL, '您有1个采购订单待审核', 1, 0);
INSERT INTO `matters` VALUES (94, 1607932726215, NULL, 1, NULL, 2, 25);
INSERT INTO `matters` VALUES (95, 1607932726229, 0, 0, '您有1个销售订单待审核', 3, 25);
INSERT INTO `matters` VALUES (96, 1607932766730, NULL, 1, NULL, 3, 25);
INSERT INTO `matters` VALUES (97, 1607932766733, 0, 0, '您有1个销售订单待审核', 4, 25);
INSERT INTO `matters` VALUES (98, 1607934282291, 0, NULL, '您有1个销售订单待审核', 2, 28);
INSERT INTO `matters` VALUES (99, 1607934305941, NULL, 1, NULL, 2, 28);
INSERT INTO `matters` VALUES (100, 1607934305944, 0, 0, '您有1个销售订单待审核', 3, 28);
INSERT INTO `matters` VALUES (101, 1607934768899, NULL, 1, NULL, 3, 28);
INSERT INTO `matters` VALUES (102, 1607934768902, 0, 0, '您有1个销售订单待审核', 4, 28);
INSERT INTO `matters` VALUES (103, 1607934789005, NULL, 1, NULL, 4, 28);
INSERT INTO `matters` VALUES (104, 1607934789007, 0, 0, '您有1个销售订单待审核', 6, 28);
INSERT INTO `matters` VALUES (105, 1607934807191, NULL, 1, NULL, 6, 28);
INSERT INTO `matters` VALUES (106, 1607938895687, 0, NULL, '您有1个采购订单待审核', 1, 0);
INSERT INTO `matters` VALUES (107, 1607941959219, 0, NULL, '您有1个采购订单待审核', 1, 34);
INSERT INTO `matters` VALUES (108, 1607942207789, NULL, 1, NULL, 1, 34);
INSERT INTO `matters` VALUES (109, 1607942207794, 0, 0, '您有1个采购订单待审核', 2, 34);
INSERT INTO `matters` VALUES (110, 1607942366507, NULL, 1, NULL, 2, 34);
INSERT INTO `matters` VALUES (111, 1607942366510, 0, 0, '您有1个采购订单待审核', 6, 34);
INSERT INTO `matters` VALUES (112, 1607942378820, NULL, 1, NULL, 6, 34);
INSERT INTO `matters` VALUES (113, 1607942400506, NULL, 1, NULL, 3, 34);
INSERT INTO `matters` VALUES (114, 1607942400508, 0, 0, '您有1个采购来料订单待审核', 4, 34);
INSERT INTO `matters` VALUES (115, 1607942407234, NULL, 1, NULL, 4, 34);
INSERT INTO `matters` VALUES (116, 1607942407236, 0, 0, '您有1个采购来料订单待审核', 2, 34);
INSERT INTO `matters` VALUES (117, 1607942416714, NULL, 1, NULL, 2, 34);
INSERT INTO `matters` VALUES (118, 1607942607760, 0, NULL, '您有1个销售订单待审核', 2, 29);
INSERT INTO `matters` VALUES (119, 1607944229686, 0, NULL, '您有1个销售订单待审核', 2, 29);
INSERT INTO `matters` VALUES (120, 1607944383162, 0, NULL, '您有1个销售订单待审核', 2, 29);
INSERT INTO `matters` VALUES (121, 1607944521208, 0, NULL, '您有1个销售订单待审核', 2, 30);
INSERT INTO `matters` VALUES (122, 1607944536738, NULL, 1, NULL, 2, 30);
INSERT INTO `matters` VALUES (123, 1607944536742, 0, 0, '您有1个销售订单待审核', 3, 30);
INSERT INTO `matters` VALUES (124, 1607944551187, NULL, 1, NULL, 3, 30);
INSERT INTO `matters` VALUES (125, 1607944551189, 0, 0, '您有1个销售订单待审核', 4, 30);
INSERT INTO `matters` VALUES (126, 1607944676118, 0, NULL, '您有1个销售订单待审核', 2, 30);
INSERT INTO `matters` VALUES (127, 1607944678485, 0, NULL, '您有1个采购订单待审核', 1, 35);
INSERT INTO `matters` VALUES (128, 1607944687428, NULL, 1, NULL, 2, 30);
INSERT INTO `matters` VALUES (129, 1607944687432, 0, 0, '您有1个销售订单待审核', 2, 30);
INSERT INTO `matters` VALUES (130, 1607944697709, NULL, 1, NULL, 3, 30);
INSERT INTO `matters` VALUES (131, 1607944697712, 0, 0, '您有1个销售订单待审核', 3, 30);
INSERT INTO `matters` VALUES (132, 1607944773290, 0, NULL, '您有1个销售订单待审核', 2, 30);
INSERT INTO `matters` VALUES (133, 1607944780796, NULL, 1, NULL, 2, 30);
INSERT INTO `matters` VALUES (134, 1607944780800, 0, 0, '您有1个销售订单待审核', 2, 30);
INSERT INTO `matters` VALUES (135, 1607944786131, NULL, 1, NULL, 3, 30);
INSERT INTO `matters` VALUES (136, 1607944786134, 0, 0, '您有1个销售订单待审核', 3, 30);
INSERT INTO `matters` VALUES (137, 1607944791535, NULL, 1, NULL, 4, 30);
INSERT INTO `matters` VALUES (138, 1607944791537, 0, 0, '您有1个销售订单待审核', 4, 30);
INSERT INTO `matters` VALUES (139, 1607944796865, NULL, 1, NULL, 6, 30);
INSERT INTO `matters` VALUES (140, 1607944796867, 0, 0, '您有1个销售订单待审核', 6, 30);
INSERT INTO `matters` VALUES (141, 1607945156437, 0, NULL, '您有1个销售订单待审核', 2, 31);
INSERT INTO `matters` VALUES (142, 1607945656731, NULL, 1, NULL, 2, 31);
INSERT INTO `matters` VALUES (143, 1607945656735, 0, 0, '您有1个销售订单待审核', 3, 31);
INSERT INTO `matters` VALUES (144, 1607945663708, NULL, 1, NULL, 3, 31);
INSERT INTO `matters` VALUES (145, 1607945663719, 0, 0, '您有1个销售订单待审核', 4, 31);
INSERT INTO `matters` VALUES (146, 1607945670395, NULL, 1, NULL, 4, 31);
INSERT INTO `matters` VALUES (147, 1607945670397, 0, 0, '您有1个销售订单待审核', 6, 31);
INSERT INTO `matters` VALUES (148, 1607945683741, NULL, 1, NULL, 6, 31);
INSERT INTO `matters` VALUES (149, 1607946773555, NULL, 1, NULL, 4, 31);
INSERT INTO `matters` VALUES (150, 1607946773568, 0, 0, '您有1个销售退回订单待审核', 2, 31);
INSERT INTO `matters` VALUES (151, 1607946778596, NULL, 1, NULL, 2, 31);
INSERT INTO `matters` VALUES (152, 1607946778598, 0, 0, '您有1个销售退回订单待审核', 3, 31);
INSERT INTO `matters` VALUES (157, 1607947013932, NULL, 1, NULL, 3, 31);
INSERT INTO `matters` VALUES (158, 1607947811574, 0, NULL, '您有1个销售订单待审核', 2, 32);
INSERT INTO `matters` VALUES (159, 1607947821040, NULL, 1, NULL, 2, 32);
INSERT INTO `matters` VALUES (160, 1607947821044, 0, 0, '您有1个销售订单待审核', 3, 32);
INSERT INTO `matters` VALUES (161, 1607947824845, NULL, 1, NULL, 3, 32);
INSERT INTO `matters` VALUES (162, 1607947824847, 0, 0, '您有1个销售订单待审核', 4, 32);
INSERT INTO `matters` VALUES (163, 1607947828421, NULL, 1, NULL, 4, 32);
INSERT INTO `matters` VALUES (164, 1607947828423, 0, 0, '您有1个销售订单待审核', 6, 32);
INSERT INTO `matters` VALUES (172, 1607948240528, NULL, 1, NULL, 6, 32);
INSERT INTO `matters` VALUES (173, 1607997037427, 0, NULL, '您有1个采购订单待审核', 1, 35);
INSERT INTO `matters` VALUES (174, 1607997134440, 0, NULL, '您有1个采购订单待审核', 1, 35);
INSERT INTO `matters` VALUES (175, 1607998231428, 0, NULL, '您有1个采购订单待审核', 1, 36);
INSERT INTO `matters` VALUES (176, 1607998238531, NULL, 1, NULL, 1, 36);
INSERT INTO `matters` VALUES (177, 1607998238535, 0, 0, '您有1个采购订单待审核', 2, 36);
INSERT INTO `matters` VALUES (178, 1607998373668, 0, NULL, '您有1个采购订单待审核', 1, 37);
INSERT INTO `matters` VALUES (179, 1607998384385, NULL, 1, NULL, 1, 37);
INSERT INTO `matters` VALUES (180, 1607998384388, 0, 0, '您有1个采购订单待审核', 2, 37);
INSERT INTO `matters` VALUES (181, 1607998400072, NULL, 1, NULL, 2, 37);
INSERT INTO `matters` VALUES (182, 1607998400074, 0, 0, '您有1个采购订单待审核', 6, 37);
INSERT INTO `matters` VALUES (183, 1607998416291, 0, NULL, '您有1个采购订单待审核', 1, 37);
INSERT INTO `matters` VALUES (184, 1607998425601, NULL, 1, NULL, 1, 37);
INSERT INTO `matters` VALUES (185, 1607998425605, 0, 0, '您有1个采购订单待审核', 1, 37);
INSERT INTO `matters` VALUES (186, 1607998947351, 0, NULL, '您有1个采购订单待审核', 1, 38);
INSERT INTO `matters` VALUES (187, 1607999051092, NULL, 1, NULL, 1, 38);
INSERT INTO `matters` VALUES (188, 1607999051095, 0, 0, '您有1个采购订单待审核', 2, 38);
INSERT INTO `matters` VALUES (189, 1607999058760, 0, NULL, '您有1个采购订单待审核', 6, 38);
INSERT INTO `matters` VALUES (190, 1607999155011, NULL, 1, NULL, 6, 38);
INSERT INTO `matters` VALUES (191, 1607999155013, 0, 0, '您有1个采购订单待审核', 2, 38);
INSERT INTO `matters` VALUES (192, 1607999159881, NULL, 1, NULL, 2, 38);
INSERT INTO `matters` VALUES (193, 1607999159884, 0, 0, '您有1个采购订单待审核', 2, 38);
INSERT INTO `matters` VALUES (194, 1607999411225, NULL, 1, NULL, 3, 38);
INSERT INTO `matters` VALUES (195, 1607999411237, 0, 0, '您有1个采购来料订单待审核', 4, 38);
INSERT INTO `matters` VALUES (196, 1607999419847, NULL, 1, NULL, 4, 38);
INSERT INTO `matters` VALUES (197, 1607999419850, 0, 0, '您有1个采购来料订单待审核', 2, 38);
INSERT INTO `matters` VALUES (198, 1607999426431, NULL, 1, NULL, 2, 38);
INSERT INTO `matters` VALUES (199, 1607999601661, 0, NULL, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (200, 1607999613837, NULL, 1, NULL, 2, 39);
INSERT INTO `matters` VALUES (201, 1607999613840, 0, 0, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (202, 1608000078605, NULL, 1, NULL, 2, 39);
INSERT INTO `matters` VALUES (203, 1608000078630, 0, 0, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (204, 1608000089524, 0, NULL, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (205, 1608000149867, NULL, 1, NULL, 2, 39);
INSERT INTO `matters` VALUES (206, 1608000149870, 0, 0, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (207, 1608000530440, 0, NULL, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (208, 1608000565165, 0, NULL, '您有1个采购订单待审核', 2, 40);
INSERT INTO `matters` VALUES (209, 1608000726783, 0, NULL, '您有1个采购订单待审核', 2, 40);
INSERT INTO `matters` VALUES (210, 1608000734919, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (211, 1608000734924, 0, 0, '您有1个采购订单待审核', 2, 40);
INSERT INTO `matters` VALUES (212, 1608004677869, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (213, 1608004677894, 0, 0, '您有1个采购订单待审核', 6, 40);
INSERT INTO `matters` VALUES (214, 1608004682714, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (215, 1608004682716, 0, 0, '您有1个采购订单待审核', 6, 40);
INSERT INTO `matters` VALUES (216, 1608004700898, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (217, 1608004700900, 0, 0, '您有1个采购订单待审核', 6, 40);
INSERT INTO `matters` VALUES (218, 1608004782034, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (219, 1608004782036, 0, 0, '您有1个采购订单待审核', 6, 40);
INSERT INTO `matters` VALUES (220, 1608005030135, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (221, 1608005030160, 0, 0, '您有1个采购订单待审核', 6, 40);
INSERT INTO `matters` VALUES (222, 1608005043312, NULL, 1, NULL, 6, 40);
INSERT INTO `matters` VALUES (223, 1608005091575, NULL, 1, NULL, 2, 40);
INSERT INTO `matters` VALUES (224, 1608005091577, 0, 0, '您有1个采购来料订单待审核', 6, 40);
INSERT INTO `matters` VALUES (225, 1608005102438, NULL, 1, NULL, 6, 40);
INSERT INTO `matters` VALUES (226, 1608006136291, 0, NULL, '您有1个采购订单待审核', 2, 41);
INSERT INTO `matters` VALUES (227, 1608006146947, NULL, 1, NULL, 2, 41);
INSERT INTO `matters` VALUES (228, 1608006146951, 0, 0, '您有1个采购订单待审核', 2, 41);
INSERT INTO `matters` VALUES (229, 1608006161039, NULL, 1, NULL, 2, 41);
INSERT INTO `matters` VALUES (230, 1608006161042, 0, 0, '您有1个采购订单待审核', 6, 41);
INSERT INTO `matters` VALUES (231, 1608006171022, NULL, 1, NULL, 6, 41);
INSERT INTO `matters` VALUES (232, 1608006183511, 0, NULL, '您有1个采购订单待审核', 2, 41);
INSERT INTO `matters` VALUES (233, 1608006201078, NULL, 1, NULL, 2, 41);
INSERT INTO `matters` VALUES (234, 1608006201081, 0, 0, '您有1个采购订单待审核', 2, 41);
INSERT INTO `matters` VALUES (235, 1608006205830, NULL, 1, NULL, 2, 41);
INSERT INTO `matters` VALUES (236, 1608006205832, 0, 0, '您有1个采购订单待审核', 6, 41);
INSERT INTO `matters` VALUES (237, 1608006211311, NULL, 1, NULL, 6, 41);
INSERT INTO `matters` VALUES (238, 1608006217726, NULL, 1, NULL, 2, 41);
INSERT INTO `matters` VALUES (239, 1608006217729, 0, 0, '您有1个采购来料订单待审核', 6, 41);
INSERT INTO `matters` VALUES (240, 1608006235454, NULL, 1, NULL, 6, 41);
INSERT INTO `matters` VALUES (241, 1608006483401, 0, NULL, '您有1个销售订单待审核', NULL, 33);
INSERT INTO `matters` VALUES (242, 1608006547801, 0, NULL, '您有1个销售订单待审核', 2, 33);
INSERT INTO `matters` VALUES (243, 1608006556096, NULL, 1, NULL, 2, 33);
INSERT INTO `matters` VALUES (244, 1608006556101, 0, 0, '您有1个销售订单待审核', 6, 33);
INSERT INTO `matters` VALUES (245, 1608006561508, NULL, 1, NULL, 6, 33);
INSERT INTO `matters` VALUES (246, 1608006561510, 0, 0, '您有1个销售订单待审核', 2, 33);
INSERT INTO `matters` VALUES (247, 1608006567195, NULL, 1, NULL, 2, 33);
INSERT INTO `matters` VALUES (248, 1608018169858, 0, NULL, '您有1个采购订单待审核', 2, 42);
INSERT INTO `matters` VALUES (249, 1608018179126, NULL, 1, NULL, 2, 42);
INSERT INTO `matters` VALUES (250, 1608018179129, 0, 0, '您有1个采购订单待审核', 2, 42);
INSERT INTO `matters` VALUES (251, 1608018183577, NULL, 1, NULL, 2, 42);
INSERT INTO `matters` VALUES (252, 1608018183579, 0, 0, '您有1个采购订单待审核', 6, 42);
INSERT INTO `matters` VALUES (253, 1608018188400, NULL, 1, NULL, 6, 42);
INSERT INTO `matters` VALUES (254, 1608018196197, NULL, 1, NULL, 2, 42);
INSERT INTO `matters` VALUES (255, 1608018196200, 0, 0, '您有1个采购来料订单待审核', 6, 42);
INSERT INTO `matters` VALUES (256, 1608018200703, NULL, 1, NULL, 6, 42);
INSERT INTO `matters` VALUES (257, 1608019008058, 0, NULL, '您有1个采购订单待审核', 2, 43);
INSERT INTO `matters` VALUES (258, 1608033573871, 0, NULL, '您有1个采购订单待审核', 2, 43);
INSERT INTO `matters` VALUES (259, 1608033580248, NULL, 1, NULL, 2, 43);
INSERT INTO `matters` VALUES (260, 1608033580253, 0, 0, '您有1个采购订单待审核', 2, 43);
INSERT INTO `matters` VALUES (261, 1608033584459, NULL, 1, NULL, 2, 43);
INSERT INTO `matters` VALUES (262, 1608033584462, 0, 0, '您有1个采购订单待审核', 6, 43);
INSERT INTO `matters` VALUES (263, 1608033588275, NULL, 1, NULL, 6, 43);
INSERT INTO `matters` VALUES (264, 1608033603395, NULL, 1, NULL, 2, 43);
INSERT INTO `matters` VALUES (265, 1608033603397, 0, 0, '您有1个采购来料订单待审核', 6, 43);
INSERT INTO `matters` VALUES (266, 1608033607652, NULL, 1, NULL, 6, 43);
INSERT INTO `matters` VALUES (267, 1608194724691, 0, NULL, '您有1个报修单待处理', 6, 1);
INSERT INTO `matters` VALUES (268, 1608195274697, 0, NULL, '您有1个报修单待处理', 6, 2);
INSERT INTO `matters` VALUES (269, 1608198024314, NULL, 1, NULL, 6, 1);
INSERT INTO `matters` VALUES (270, 1608198024355, 0, 0, '您有1个报修单待处理', 2, 1);
INSERT INTO `matters` VALUES (271, 1608198608581, 0, NULL, '您有1个报修单待处理', 2, 3);
INSERT INTO `matters` VALUES (272, 1608198612679, 0, NULL, '您有1个报修单待处理', 2, 4);
INSERT INTO `matters` VALUES (273, 1608198685577, NULL, 1, NULL, 2, 3);
INSERT INTO `matters` VALUES (274, 1608198685584, 0, 0, '您有1个报修单待处理', 2, 3);
INSERT INTO `matters` VALUES (275, 1608199042162, 0, NULL, '您有1个报修单待处理', 2, 5);
INSERT INTO `matters` VALUES (276, 1608199067455, NULL, 1, NULL, 2, 5);
INSERT INTO `matters` VALUES (277, 1608199067462, 0, 0, '您有1个报修单待处理', 2, 5);
INSERT INTO `matters` VALUES (278, 1608199149516, NULL, 1, NULL, 2, 5);
INSERT INTO `matters` VALUES (279, 1608199149548, 0, 0, '您有1个报修单待处理', 6, 5);
INSERT INTO `matters` VALUES (280, 1608199261229, 0, NULL, '您有1个报修单待处理', 2, 6);
INSERT INTO `matters` VALUES (281, 1608199299260, NULL, 1, NULL, 2, 6);
INSERT INTO `matters` VALUES (282, 1608199299267, 0, 0, '您有1个报修单待处理', 2, 6);
INSERT INTO `matters` VALUES (283, 1608199318680, NULL, 1, NULL, 2, 6);
INSERT INTO `matters` VALUES (284, 1608199318682, 0, 0, '您有1个报修单待处理', 6, 6);
INSERT INTO `matters` VALUES (285, 1608199831978, 0, NULL, '您有1个报修单待处理', 2, 7);
INSERT INTO `matters` VALUES (286, 1608199851641, NULL, 1, NULL, 2, 7);
INSERT INTO `matters` VALUES (287, 1608199851650, 0, 0, '您有1个报修单待处理', 2, 7);
INSERT INTO `matters` VALUES (288, 1608199864000, NULL, 1, NULL, 2, 7);
INSERT INTO `matters` VALUES (289, 1608199864003, 0, 0, '您有1个报修单待处理', 6, 7);
INSERT INTO `matters` VALUES (290, 1608199869897, NULL, 1, NULL, 6, 7);
INSERT INTO `matters` VALUES (291, 1608257966447, NULL, 1, NULL, 6, 5);
INSERT INTO `matters` VALUES (292, 1608264445127, 0, NULL, '您有1个报修单待处理', 2, 8);
INSERT INTO `matters` VALUES (293, 1608271637555, NULL, 1, NULL, 2, 8);
INSERT INTO `matters` VALUES (294, 1608271637586, 0, 0, '您有1个报修单待处理', 2, 8);
INSERT INTO `matters` VALUES (295, 1608271651053, NULL, 1, NULL, 2, 8);
INSERT INTO `matters` VALUES (296, 1608271651056, 0, 0, '您有1个报修单待处理', 6, 8);
INSERT INTO `matters` VALUES (297, 1608271665823, NULL, 1, NULL, 6, 8);
INSERT INTO `matters` VALUES (298, 1608271815925, 0, NULL, '您有1个报修单待处理', 2, 9);
INSERT INTO `matters` VALUES (299, 1608271838486, NULL, 1, NULL, 2, 9);
INSERT INTO `matters` VALUES (300, 1608271838488, 0, 0, '您有1个报修单待处理', 2, 9);
INSERT INTO `matters` VALUES (301, 1608271855198, NULL, 1, NULL, 2, 9);
INSERT INTO `matters` VALUES (302, 1608271855200, 0, 0, '您有1个报修单待处理', 6, 9);
INSERT INTO `matters` VALUES (303, 1608271949520, 0, NULL, '您有1个报修单待处理', 2, 10);
INSERT INTO `matters` VALUES (304, 1608271995901, NULL, 1, NULL, 2, 10);
INSERT INTO `matters` VALUES (305, 1608271995903, 0, 0, '您有1个报修单待处理', 2, 10);
INSERT INTO `matters` VALUES (306, 1608272044520, NULL, 1, NULL, 2, 10);
INSERT INTO `matters` VALUES (307, 1608272044522, 0, 0, '您有1个报修单待处理', 6, 10);
INSERT INTO `matters` VALUES (308, 1608272089843, 0, NULL, '您有1个报修单待处理', 2, 11);
INSERT INTO `matters` VALUES (311, 1608272778237, 0, NULL, '您有1个报修单待处理', 2, 12);
INSERT INTO `matters` VALUES (312, 1608272783427, NULL, 1, NULL, 2, 12);
INSERT INTO `matters` VALUES (313, 1608272783430, 0, 0, '您有1个报修单待处理', 2, 12);
INSERT INTO `matters` VALUES (314, 1608272788594, NULL, 1, NULL, 2, 12);
INSERT INTO `matters` VALUES (315, 1608272788596, 0, 0, '您有1个报修单待处理', 6, 12);
INSERT INTO `matters` VALUES (316, 1608272795558, NULL, 1, NULL, 6, 12);
INSERT INTO `matters` VALUES (317, 1608272805231, 0, NULL, '您有1个报修单待处理', 2, 13);
INSERT INTO `matters` VALUES (318, 1608272824882, NULL, 1, NULL, 2, 13);
INSERT INTO `matters` VALUES (319, 1608272824885, 0, 0, '您有1个报修单待处理', 2, 13);
INSERT INTO `matters` VALUES (320, 1608273071230, NULL, 1, NULL, 2, 13);
INSERT INTO `matters` VALUES (321, 1608273071232, 0, 0, '您有1个报修单待处理', 6, 13);
INSERT INTO `matters` VALUES (322, 1608273087480, NULL, 1, NULL, 6, 13);
INSERT INTO `matters` VALUES (323, 1608273271444, 0, NULL, '您有1个报修单待处理', 2, 14);
INSERT INTO `matters` VALUES (324, 1608273324826, NULL, 1, NULL, 2, 14);
INSERT INTO `matters` VALUES (325, 1608273324832, 0, 0, '您有1个报修单待处理', 2, 14);
INSERT INTO `matters` VALUES (326, 1608273332165, NULL, 1, NULL, 2, 14);
INSERT INTO `matters` VALUES (327, 1608273332167, 0, 0, '您有1个报修单待处理', 6, 14);
INSERT INTO `matters` VALUES (328, 1608273337960, NULL, 1, NULL, 6, 14);
INSERT INTO `matters` VALUES (329, 1608624385858, 0, NULL, '您有1个报修单待处理', NULL, 2);
INSERT INTO `matters` VALUES (330, 1608624632109, 0, NULL, '您有1个报修单待处理', 1, 3);
INSERT INTO `matters` VALUES (331, 1608625566814, NULL, 1, NULL, 1, 3);
INSERT INTO `matters` VALUES (332, 1608625566848, 0, 0, '您有1个生产计划单待审核', 2, 3);
INSERT INTO `matters` VALUES (333, 1608627206812, 0, NULL, '您有1个报修单待处理', 1, 6);
INSERT INTO `matters` VALUES (334, 1608627945774, NULL, 1, NULL, 1, 6);
INSERT INTO `matters` VALUES (335, 1608627945807, 0, 0, '您有1个生产计划单待审核', 2, 6);
INSERT INTO `matters` VALUES (336, 1608627986659, NULL, 1, NULL, 2, 6);
INSERT INTO `matters` VALUES (337, 1608628162831, 0, NULL, '您有1个报修单待处理', 1, 7);
INSERT INTO `matters` VALUES (338, 1608628188437, NULL, 1, NULL, 1, 7);
INSERT INTO `matters` VALUES (339, 1608628188445, 0, 0, '您有1个生产计划单待审核', 2, 7);
INSERT INTO `matters` VALUES (340, 1608628203463, NULL, 1, NULL, 2, 7);
INSERT INTO `matters` VALUES (341, 1608628226123, NULL, 1, NULL, 1, 7);
INSERT INTO `matters` VALUES (342, 1608628226125, 0, 0, '您有1个生产计划单待审核', 2, 7);
INSERT INTO `matters` VALUES (343, 1608628245350, NULL, 1, NULL, 1, 7);
INSERT INTO `matters` VALUES (344, 1608628245353, 0, 0, '您有1个生产计划单待审核', 2, 7);
INSERT INTO `matters` VALUES (345, 1608628257744, NULL, 1, NULL, 2, 7);
INSERT INTO `matters` VALUES (346, 1608693624680, 0, NULL, '您有1个报修单待处理', 2, 15);
INSERT INTO `matters` VALUES (347, 1608693635136, NULL, 1, NULL, 2, 15);
INSERT INTO `matters` VALUES (348, 1608693635140, 0, 0, '您有1个报修单待处理', 2, 15);
INSERT INTO `matters` VALUES (349, 1608693646498, NULL, 1, NULL, 2, 15);
INSERT INTO `matters` VALUES (350, 1608693646501, 0, 0, '您有1个报修单待处理', 6, 15);
INSERT INTO `matters` VALUES (351, 1608693654640, NULL, 1, NULL, 6, 15);
INSERT INTO `matters` VALUES (352, 1608693834421, 0, NULL, '您有1个报修单待处理', 2, 16);
INSERT INTO `matters` VALUES (353, 1608693861852, NULL, 1, NULL, 2, 16);
INSERT INTO `matters` VALUES (354, 1608693861854, 0, 0, '您有1个报修单待处理', 2, 16);
INSERT INTO `matters` VALUES (355, 1608712841692, NULL, 1, NULL, 2, 39);
INSERT INTO `matters` VALUES (356, 1608712841709, 0, 0, '您有1个采购订单待审核', 2, 39);
INSERT INTO `matters` VALUES (357, 1608777326408, 0, NULL, '您有1个销售订单待审核', 2, 34);
INSERT INTO `matters` VALUES (358, 1608777335437, NULL, 1, NULL, 2, 34);
INSERT INTO `matters` VALUES (359, 1608777335440, 0, 0, '您有1个销售订单待审核', 6, 34);
INSERT INTO `matters` VALUES (360, 1608777340252, NULL, 1, NULL, 6, 34);
INSERT INTO `matters` VALUES (361, 1608777340255, 0, 0, '您有1个销售订单待审核', 2, 34);
INSERT INTO `matters` VALUES (362, 1608777344612, NULL, 1, NULL, 2, 34);
INSERT INTO `matters` VALUES (363, 1608777380562, 0, NULL, '您有1个销售订单待审核', 2, 35);
INSERT INTO `matters` VALUES (364, 1608777401766, NULL, 1, NULL, 2, 35);
INSERT INTO `matters` VALUES (365, 1608777401768, 0, 0, '您有1个销售订单待审核', 6, 35);
INSERT INTO `matters` VALUES (366, 1608777406475, NULL, 1, NULL, 6, 35);
INSERT INTO `matters` VALUES (367, 1608777406477, 0, 0, '您有1个销售订单待审核', 2, 35);
INSERT INTO `matters` VALUES (368, 1608777411345, NULL, 1, NULL, 2, 35);
INSERT INTO `matters` VALUES (369, 1608809063175, 0, NULL, '您有1个报修单待处理', 1, 8);
INSERT INTO `matters` VALUES (370, 1608809437099, 0, NULL, '您有1个报修单待处理', 1, 9);
INSERT INTO `matters` VALUES (371, 1608863100899, 0, NULL, '您有1个报修单待处理', 1, 10);
INSERT INTO `matters` VALUES (372, 1608866479440, 0, NULL, '您有1个报修单待处理', 1, 11);
INSERT INTO `matters` VALUES (373, 1608884318673, NULL, 1, NULL, 1, 11);
INSERT INTO `matters` VALUES (374, 1608884318687, 0, 0, '您有1个生产计划单待审核', 2, 11);
INSERT INTO `matters` VALUES (375, 1608884471626, NULL, 1, NULL, 2, 11);
INSERT INTO `matters` VALUES (376, 1608884617118, NULL, 1, NULL, 1, 10);
INSERT INTO `matters` VALUES (377, 1608884617125, 0, 0, '您有1个生产计划单待审核', 2, 10);
INSERT INTO `matters` VALUES (378, 1608884686348, NULL, 1, NULL, 1, 10);
INSERT INTO `matters` VALUES (379, 1608884686352, 0, 0, '您有1个生产计划单待审核', 2, 10);
INSERT INTO `matters` VALUES (380, 1608884692555, NULL, 1, NULL, 2, 10);
INSERT INTO `matters` VALUES (381, 1608885709457, NULL, 1, NULL, 1, 8);
INSERT INTO `matters` VALUES (382, 1608885709492, 0, 0, '您有1个生产计划单待审核', 2, 8);
INSERT INTO `matters` VALUES (383, 1608885728632, NULL, 1, NULL, 2, 8);
INSERT INTO `matters` VALUES (384, 1608886148990, 0, NULL, '您有1个采购订单待审核', 2, 44);
INSERT INTO `matters` VALUES (388, 1608887506824, 0, NULL, '您有1个报修单待处理', 1, 15);
INSERT INTO `matters` VALUES (389, 1608892196251, 0, NULL, '您有1个报修单待处理', 1, 16);
INSERT INTO `matters` VALUES (390, 1608892336020, 0, NULL, '您有1个报修单待处理', 1, 17);
INSERT INTO `matters` VALUES (391, 1608892851760, 0, NULL, '您有1个报修单待处理', 1, 19);
INSERT INTO `matters` VALUES (392, 1608957953755, 0, NULL, '您有1个报修单待处理', 1, 20);
INSERT INTO `matters` VALUES (393, 1608958128114, 0, NULL, '您有1个报修单待处理', 1, 21);
INSERT INTO `matters` VALUES (394, 1608958160244, NULL, 1, NULL, 1, 20);
INSERT INTO `matters` VALUES (395, 1608958160251, 0, 0, '您有1个生产计划单待审核', 2, 20);
INSERT INTO `matters` VALUES (396, 1608958167280, NULL, 1, NULL, 2, 20);
INSERT INTO `matters` VALUES (397, 1608958167283, 0, 0, '您有1个生产计划单待审核', 6, 20);
INSERT INTO `matters` VALUES (398, 1608958172554, NULL, 1, NULL, 6, 20);
INSERT INTO `matters` VALUES (399, 1608964045695, 0, NULL, '您有1个报修单待处理', 1, 22);
INSERT INTO `matters` VALUES (400, 1608965155924, 0, NULL, '您有1个报修单待处理', 1, 23);
INSERT INTO `matters` VALUES (401, 1609050123867, 0, NULL, '您有1个报修单待处理', 2, 17);
INSERT INTO `matters` VALUES (402, 1609050130474, NULL, 1, NULL, 2, 17);
INSERT INTO `matters` VALUES (403, 1609050130482, 0, 0, '您有1个报修单待处理', 2, 17);
INSERT INTO `matters` VALUES (404, 1609050139307, NULL, 1, NULL, 2, 17);
INSERT INTO `matters` VALUES (405, 1609050139310, 0, 0, '您有1个报修单待处理', 6, 17);
INSERT INTO `matters` VALUES (406, 1609050145331, NULL, 1, NULL, 6, 17);
INSERT INTO `matters` VALUES (407, 1609123223334, 0, NULL, '您有1个报修单待处理', 1, 24);
INSERT INTO `matters` VALUES (408, 1609123290077, 0, NULL, '您有1个报修单待处理', 1, 25);
INSERT INTO `matters` VALUES (409, 1609124394107, 0, NULL, '您有1个报修单待处理', 1, 27);
INSERT INTO `matters` VALUES (410, 1609151563428, 0, NULL, '您有1个采购订单待审核', 2, 45);
INSERT INTO `matters` VALUES (411, 1609151577845, NULL, 1, NULL, 2, 45);
INSERT INTO `matters` VALUES (412, 1609151577849, 0, 0, '您有1个采购订单待审核', 2, 45);
INSERT INTO `matters` VALUES (413, 1609151613666, 0, NULL, '您有1个采购订单待审核', 2, 46);

-- ----------------------------
-- Table structure for mes_post
-- ----------------------------
DROP TABLE IF EXISTS `mes_post`;
CREATE TABLE `mes_post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `post_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_state` int(11) NULL DEFAULT 0,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mes_post
-- ----------------------------
INSERT INTO `mes_post` VALUES (1, 1, '10423', '单子肚子', 0, '121212121212');
INSERT INTO `mes_post` VALUES (2, 1, '10423', '单肚子', 1, '121212121212');
INSERT INTO `mes_post` VALUES (3, 1, '10423', '肚子', 0, '121212121212');
INSERT INTO `mes_post` VALUES (4, 1, '10423', '肚子', 0, '的份上');
INSERT INTO `mes_post` VALUES (5, 1, '10423', '的份上', 1, '的份上');
INSERT INTO `mes_post` VALUES (6, 1, '10423', '的份上', 0, '的份上');
INSERT INTO `mes_post` VALUES (7, 0, '123', '123', 1, '123');
INSERT INTO `mes_post` VALUES (8, 0, 'string', 'string', 0, 'string');
INSERT INTO `mes_post` VALUES (9, 0, '100', '老板', 1, '我最大');
INSERT INTO `mes_post` VALUES (10, 0, '99', '副总', 1, '一人之上万人之下');
INSERT INTO `mes_post` VALUES (11, 0, '98', '总经理', 1, '还不错');

-- ----------------------------
-- Table structure for order_auditpocess
-- ----------------------------
DROP TABLE IF EXISTS `order_auditpocess`;
CREATE TABLE `order_auditpocess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_level` int(11) NULL DEFAULT NULL,
  `audit_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `finished` int(11) NULL DEFAULT 0,
  `level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 657 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of order_auditpocess
-- ----------------------------
INSERT INTO `order_auditpocess` VALUES (528, 1, 'CG', 1607999601640, 1, '1', 39, 2);
INSERT INTO `order_auditpocess` VALUES (529, 2, 'CG', 1607999601640, 0, '2', 39, 2);
INSERT INTO `order_auditpocess` VALUES (530, 3, 'CG', 1607999601640, 0, '3', 39, 6);
INSERT INTO `order_auditpocess` VALUES (531, 1, 'LL', 1607999601640, 0, '11', 39, 2);
INSERT INTO `order_auditpocess` VALUES (532, 2, 'LL', 1607999601640, 0, '22', 39, 6);
INSERT INTO `order_auditpocess` VALUES (535, 1, 'CG', 1608000089515, 0, '1', 39, 2);
INSERT INTO `order_auditpocess` VALUES (536, 2, 'CG', 1608000089515, 0, '2', 39, 2);
INSERT INTO `order_auditpocess` VALUES (537, 3, 'CG', 1608000089515, 0, '3', 39, 6);
INSERT INTO `order_auditpocess` VALUES (538, 1, 'LL', 1608000089515, 0, '11', 39, 2);
INSERT INTO `order_auditpocess` VALUES (539, 2, 'LL', 1608000089515, 0, '22', 39, 6);
INSERT INTO `order_auditpocess` VALUES (542, 1, 'CG', 1608000726755, 1, '1', 40, 2);
INSERT INTO `order_auditpocess` VALUES (543, 2, 'CG', 1608000726755, 1, '2', 40, 2);
INSERT INTO `order_auditpocess` VALUES (544, 3, 'CG', 1608000726755, 1, '3', 40, 6);
INSERT INTO `order_auditpocess` VALUES (545, 1, 'LL', 1608000726755, 1, '11', 40, 2);
INSERT INTO `order_auditpocess` VALUES (546, 2, 'LL', 1608000726755, 1, '22', 40, 6);
INSERT INTO `order_auditpocess` VALUES (549, 1, 'CG', 1608006136258, 1, '1', 41, 2);
INSERT INTO `order_auditpocess` VALUES (550, 2, 'CG', 1608006136258, 1, '2', 41, 2);
INSERT INTO `order_auditpocess` VALUES (551, 3, 'CG', 1608006136258, 1, '3', 41, 6);
INSERT INTO `order_auditpocess` VALUES (552, 1, 'LL', 1608006136258, 1, '11', 41, 2);
INSERT INTO `order_auditpocess` VALUES (553, 2, 'LL', 1608006136258, 1, '22', 41, 6);
INSERT INTO `order_auditpocess` VALUES (556, 1, 'XX', 1608006547797, 1, '1', 33, 2);
INSERT INTO `order_auditpocess` VALUES (557, 2, 'XX', 1608006547797, 1, '2', 33, 6);
INSERT INTO `order_auditpocess` VALUES (558, 3, 'XX', 1608006547797, 1, '3', 33, 2);
INSERT INTO `order_auditpocess` VALUES (559, 1, 'CG', 1608018169834, 1, '1', 42, 2);
INSERT INTO `order_auditpocess` VALUES (560, 2, 'CG', 1608018169834, 1, '2', 42, 2);
INSERT INTO `order_auditpocess` VALUES (561, 3, 'CG', 1608018169834, 1, '3', 42, 6);
INSERT INTO `order_auditpocess` VALUES (562, 1, 'LL', 1608018169834, 1, '11', 42, 2);
INSERT INTO `order_auditpocess` VALUES (563, 2, 'LL', 1608018169834, 1, '22', 42, 6);
INSERT INTO `order_auditpocess` VALUES (566, 1, 'CG', 1608019008036, 1, '1', 43, 2);
INSERT INTO `order_auditpocess` VALUES (567, 2, 'CG', 1608019008036, 1, '2', 43, 2);
INSERT INTO `order_auditpocess` VALUES (568, 3, 'CG', 1608019008036, 1, '3', 43, 6);
INSERT INTO `order_auditpocess` VALUES (569, 1, 'LL', 1608019008036, 1, '11', 43, 2);
INSERT INTO `order_auditpocess` VALUES (570, 2, 'LL', 1608019008036, 1, '22', 43, 6);
INSERT INTO `order_auditpocess` VALUES (583, 1, 'BX', 1608199042123, 1, '负责人', 5, 2);
INSERT INTO `order_auditpocess` VALUES (584, 2, 'BX', 1608199042123, 1, '维修人', 5, 2);
INSERT INTO `order_auditpocess` VALUES (585, 3, 'BX', 1608199042123, 1, '验收人', 5, 6);
INSERT INTO `order_auditpocess` VALUES (586, 1, 'BX', 1608199261188, 1, '负责人', 6, 2);
INSERT INTO `order_auditpocess` VALUES (587, 2, 'BX', 1608199261188, 1, '维修人', 6, 2);
INSERT INTO `order_auditpocess` VALUES (588, 3, 'BX', 1608199261188, 0, '验收人', 6, 6);
INSERT INTO `order_auditpocess` VALUES (589, 1, 'BX', 1608199831939, 1, '负责人', 7, 2);
INSERT INTO `order_auditpocess` VALUES (590, 2, 'BX', 1608199831939, 1, '维修人', 7, 2);
INSERT INTO `order_auditpocess` VALUES (591, 3, 'BX', 1608199831939, 1, '验收人', 7, 6);
INSERT INTO `order_auditpocess` VALUES (592, 1, 'BX', 1608264445122, 1, '负责人', 8, 2);
INSERT INTO `order_auditpocess` VALUES (593, 2, 'BX', 1608264445122, 1, '维修人', 8, 2);
INSERT INTO `order_auditpocess` VALUES (594, 3, 'BX', 1608264445122, 1, '验收人', 8, 6);
INSERT INTO `order_auditpocess` VALUES (595, 1, 'BX', 1608271815920, 1, '负责人', 9, 2);
INSERT INTO `order_auditpocess` VALUES (596, 2, 'BX', 1608271815920, 1, '维修人', 9, 2);
INSERT INTO `order_auditpocess` VALUES (597, 3, 'BX', 1608271815920, 0, '验收人', 9, 6);
INSERT INTO `order_auditpocess` VALUES (598, 1, 'BX', 1608271949518, 1, '负责人', 10, 2);
INSERT INTO `order_auditpocess` VALUES (599, 2, 'BX', 1608271949518, 1, '维修人', 10, 2);
INSERT INTO `order_auditpocess` VALUES (600, 3, 'BX', 1608271949518, 0, '验收人', 10, 6);
INSERT INTO `order_auditpocess` VALUES (601, 1, 'BX', 1608272089838, 0, '负责人', 11, 2);
INSERT INTO `order_auditpocess` VALUES (602, 2, 'BX', 1608272089838, 0, '维修人', 11, 2);
INSERT INTO `order_auditpocess` VALUES (603, 3, 'BX', 1608272089838, 0, '验收人', 11, 6);
INSERT INTO `order_auditpocess` VALUES (604, 1, 'BX', 1608272778233, 1, '负责人', 12, 2);
INSERT INTO `order_auditpocess` VALUES (605, 2, 'BX', 1608272778233, 1, '维修人', 12, 2);
INSERT INTO `order_auditpocess` VALUES (606, 3, 'BX', 1608272778233, 1, '验收人', 12, 6);
INSERT INTO `order_auditpocess` VALUES (607, 1, 'BX', 1608272805230, 1, '负责人', 13, 2);
INSERT INTO `order_auditpocess` VALUES (608, 2, 'BX', 1608272805230, 1, '维修人', 13, 2);
INSERT INTO `order_auditpocess` VALUES (609, 3, 'BX', 1608272805230, 1, '验收人', 13, 6);
INSERT INTO `order_auditpocess` VALUES (610, 1, 'BX', 1608273271439, 1, '负责人', 14, 2);
INSERT INTO `order_auditpocess` VALUES (611, 2, 'BX', 1608273271439, 1, '维修人', 14, 2);
INSERT INTO `order_auditpocess` VALUES (612, 3, 'BX', 1608273271439, 1, '验收人', 14, 6);
INSERT INTO `order_auditpocess` VALUES (613, 1, 'PP', 1608624632106, 1, '1', 3, 1);
INSERT INTO `order_auditpocess` VALUES (614, 2, 'PP', 1608624632106, 0, '2', 3, 2);
INSERT INTO `order_auditpocess` VALUES (615, 1, 'BX', 1608693624674, 1, '负责人', 15, 2);
INSERT INTO `order_auditpocess` VALUES (616, 2, 'BX', 1608693624674, 1, '维修人', 15, 2);
INSERT INTO `order_auditpocess` VALUES (617, 3, 'BX', 1608693624674, 1, '验收人', 15, 6);
INSERT INTO `order_auditpocess` VALUES (618, 1, 'BX', 1608693834419, 1, '负责人', 16, 2);
INSERT INTO `order_auditpocess` VALUES (619, 2, 'BX', 1608693834419, 0, '维修人', 16, 2);
INSERT INTO `order_auditpocess` VALUES (620, 3, 'BX', 1608693834419, 0, '验收人', 16, 6);
INSERT INTO `order_auditpocess` VALUES (621, 1, 'XX', 1608777326398, 1, '1', 34, 2);
INSERT INTO `order_auditpocess` VALUES (622, 2, 'XX', 1608777326398, 1, '2', 34, 6);
INSERT INTO `order_auditpocess` VALUES (623, 3, 'XX', 1608777326398, 1, '3', 34, 2);
INSERT INTO `order_auditpocess` VALUES (624, 1, 'TH', 1608777326398, 0, '112', 34, 2);
INSERT INTO `order_auditpocess` VALUES (625, 3, 'TH', 1608777326398, 0, '2', 34, 2);
INSERT INTO `order_auditpocess` VALUES (628, 1, 'XX', 1608777380559, 1, '1', 35, 2);
INSERT INTO `order_auditpocess` VALUES (629, 2, 'XX', 1608777380559, 1, '2', 35, 6);
INSERT INTO `order_auditpocess` VALUES (630, 3, 'XX', 1608777380559, 1, '3', 35, 2);
INSERT INTO `order_auditpocess` VALUES (631, 1, 'TH', 1608777380559, 0, '112', 35, 2);
INSERT INTO `order_auditpocess` VALUES (632, 3, 'TH', 1608777380559, 0, '2', 35, 2);
INSERT INTO `order_auditpocess` VALUES (633, 1, 'CG', 1608886148978, 0, '1', 44, 2);
INSERT INTO `order_auditpocess` VALUES (634, 2, 'CG', 1608886148978, 0, '2', 44, 2);
INSERT INTO `order_auditpocess` VALUES (635, 3, 'CG', 1608886148978, 0, '3', 44, 6);
INSERT INTO `order_auditpocess` VALUES (636, 1, 'LL', 1608886148978, 0, '11', 44, 2);
INSERT INTO `order_auditpocess` VALUES (637, 2, 'LL', 1608886148978, 0, '22', 44, 6);
INSERT INTO `order_auditpocess` VALUES (640, 1, 'BX', 1609050123862, 1, '负责人', 17, 2);
INSERT INTO `order_auditpocess` VALUES (641, 2, 'BX', 1609050123862, 1, '维修人', 17, 2);
INSERT INTO `order_auditpocess` VALUES (642, 3, 'BX', 1609050123862, 1, '验收人', 17, 6);
INSERT INTO `order_auditpocess` VALUES (643, 1, 'CG', 1609151563416, 1, '1', 45, 2);
INSERT INTO `order_auditpocess` VALUES (644, 2, 'CG', 1609151563416, 0, '2', 45, 2);
INSERT INTO `order_auditpocess` VALUES (645, 4, 'CG', 1609151563416, 0, '4', 45, 6);
INSERT INTO `order_auditpocess` VALUES (646, 1, 'LL', 1609151563416, 0, '11', 45, 2);
INSERT INTO `order_auditpocess` VALUES (647, 2, 'LL', 1609151563416, 0, '22', 45, 6);
INSERT INTO `order_auditpocess` VALUES (648, 5, 'CG', 1609151563416, 0, '4', 45, 2);
INSERT INTO `order_auditpocess` VALUES (649, 6, 'CG', 1609151563416, 0, '6', 45, 6);
INSERT INTO `order_auditpocess` VALUES (650, 1, 'CG', 1609151613659, 0, '1', 46, 2);
INSERT INTO `order_auditpocess` VALUES (651, 2, 'CG', 1609151613659, 0, '2', 46, 2);
INSERT INTO `order_auditpocess` VALUES (652, 4, 'CG', 1609151613659, 0, '4', 46, 6);
INSERT INTO `order_auditpocess` VALUES (653, 1, 'LL', 1609151613659, 0, '11', 46, 2);
INSERT INTO `order_auditpocess` VALUES (654, 2, 'LL', 1609151613659, 0, '22', 46, 6);
INSERT INTO `order_auditpocess` VALUES (655, 5, 'CG', 1609151613659, 0, '4', 46, 2);
INSERT INTO `order_auditpocess` VALUES (656, 6, 'CG', 1609151613659, 0, '6', 46, 6);

-- ----------------------------
-- Table structure for pp_audit_pocess
-- ----------------------------
DROP TABLE IF EXISTS `pp_audit_pocess`;
CREATE TABLE `pp_audit_pocess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_order_id` int(11) NULL DEFAULT NULL,
  `audit_setting` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `audit_setting_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_audit_pocess
-- ----------------------------
INSERT INTO `pp_audit_pocess` VALUES (1, 6, '创建计划单', 0, NULL, 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (2, 6, '创建计划单()', 0, NULL, 0, '我是备注：通过吧', 1);
INSERT INTO `pp_audit_pocess` VALUES (3, 6, '1', 4, '2020-12-22 17:05:45', 0, '我是备注：通过吧', 1);
INSERT INTO `pp_audit_pocess` VALUES (4, 6, '2', 5, '2020-12-22 17:06:26', 0, '我是备注：222通过吧', 1);
INSERT INTO `pp_audit_pocess` VALUES (5, 6, '', 0, '2020-12-22 17:06:56', 0, '我是备注：222通过吧', 1);
INSERT INTO `pp_audit_pocess` VALUES (6, 7, '创建计划单', 0, '2020-12-22 17:09:22', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (7, 7, '1', 7, '2020-12-22 17:09:48', 0, '我是备注：通过吧', 1);
INSERT INTO `pp_audit_pocess` VALUES (8, 7, '在-----2------中被驳回', 0, '2020-12-22 17:10:03', 0, '我觉得很一般', 1);
INSERT INTO `pp_audit_pocess` VALUES (9, 7, '在-----1------中被驳回', 0, '2020-12-22 17:10:26', 0, '可以1', 1);
INSERT INTO `pp_audit_pocess` VALUES (10, 7, '1', 7, '2020-12-22 17:10:45', 0, '可以1', 1);
INSERT INTO `pp_audit_pocess` VALUES (11, 7, '2', 8, '2020-12-22 17:10:57', 0, '可以2', 1);
INSERT INTO `pp_audit_pocess` VALUES (12, 8, '创建计划单', 0, '2020-12-24 19:24:23', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (13, 9, '创建计划单', 0, '2020-12-24 19:30:37', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (14, 10, '创建计划单', 0, '2020-12-25 10:25:00', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (15, 11, '创建计划单', 0, '2020-12-25 11:21:19', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (16, 11, '1', 17, '2020-12-25 16:18:38', 0, '123', 1);
INSERT INTO `pp_audit_pocess` VALUES (17, 11, '2', 18, '2020-12-25 16:21:11', 0, '奥万大无', 1);
INSERT INTO `pp_audit_pocess` VALUES (18, 10, '在-----1------中被驳回', 0, '2020-12-25 16:23:37', 0, '123', 1);
INSERT INTO `pp_audit_pocess` VALUES (19, 10, '1', 14, '2020-12-25 16:24:46', 0, '打打打', 1);
INSERT INTO `pp_audit_pocess` VALUES (20, 10, '2', 15, '2020-12-25 16:24:52', 0, '阿迪王', 1);
INSERT INTO `pp_audit_pocess` VALUES (21, 8, '1', 9, '2020-12-25 16:41:49', 0, '打完大', 1);
INSERT INTO `pp_audit_pocess` VALUES (22, 8, '在-----2------中被驳回', 0, '2020-12-25 16:42:08', 0, '驳回', 1);
INSERT INTO `pp_audit_pocess` VALUES (23, 15, '创建计划单', 0, '2020-12-25 17:11:46', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (24, 16, '', 0, '2020-12-25 18:29:56', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (25, 17, '', 0, '2020-12-25 18:32:16', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (26, 19, '', 0, '2020-12-25 18:40:51', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (27, 20, '', 0, '2020-12-26 12:45:53', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (28, 21, '', 0, '2020-12-26 12:48:48', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (29, 20, '1', 41, '2020-12-26 12:49:20', 0, '啊啊', 1);
INSERT INTO `pp_audit_pocess` VALUES (30, 20, '啊', 42, '2020-12-26 12:49:27', 0, '达到', 1);
INSERT INTO `pp_audit_pocess` VALUES (31, 20, '是', 43, '2020-12-26 12:49:32', 0, '啊啊', 1);
INSERT INTO `pp_audit_pocess` VALUES (32, 22, '', 0, '2020-12-26 14:27:25', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (33, 23, '', 0, '2020-12-26 14:45:55', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (34, 24, '创建计划单', 0, '2020-12-28 10:40:23', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (35, 25, '创建计划单', 0, '2020-12-28 10:41:30', 0, '创建计划单', 1);
INSERT INTO `pp_audit_pocess` VALUES (36, 27, '', 0, '2020-12-28 10:59:54', 0, '创建计划单', 1);

-- ----------------------------
-- Table structure for pp_detour_products
-- ----------------------------
DROP TABLE IF EXISTS `pp_detour_products`;
CREATE TABLE `pp_detour_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_detour_products
-- ----------------------------

-- ----------------------------
-- Table structure for pp_finished_products
-- ----------------------------
DROP TABLE IF EXISTS `pp_finished_products`;
CREATE TABLE `pp_finished_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_finished_products
-- ----------------------------

-- ----------------------------
-- Table structure for pp_intermediate_drawing_products
-- ----------------------------
DROP TABLE IF EXISTS `pp_intermediate_drawing_products`;
CREATE TABLE `pp_intermediate_drawing_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_intermediate_drawing_products
-- ----------------------------

-- ----------------------------
-- Table structure for pp_order_auditpocess
-- ----------------------------
DROP TABLE IF EXISTS `pp_order_auditpocess`;
CREATE TABLE `pp_order_auditpocess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `audit_level` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `finished` int(11) NULL DEFAULT 0,
  `level_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_order_auditpocess
-- ----------------------------
INSERT INTO `pp_order_auditpocess` VALUES (4, 1, '2020-12-22 16:53:26', 1, '1', 6, 1);
INSERT INTO `pp_order_auditpocess` VALUES (5, 2, '2020-12-22 16:53:26', 1, '2', 6, 2);
INSERT INTO `pp_order_auditpocess` VALUES (7, 1, '2020-12-22 17:09:22', 1, '1', 7, 1);
INSERT INTO `pp_order_auditpocess` VALUES (8, 2, '2020-12-22 17:09:22', 1, '2', 7, 2);
INSERT INTO `pp_order_auditpocess` VALUES (9, 1, '2020-12-24 19:24:23', 0, '1', 8, 1);
INSERT INTO `pp_order_auditpocess` VALUES (10, 2, '2020-12-24 19:24:23', 0, '2', 8, 2);
INSERT INTO `pp_order_auditpocess` VALUES (12, 1, '2020-12-24 19:30:37', 0, '1', 9, 1);
INSERT INTO `pp_order_auditpocess` VALUES (13, 2, '2020-12-24 19:30:37', 0, '2', 9, 2);
INSERT INTO `pp_order_auditpocess` VALUES (14, 1, '2020-12-25 10:25:00', 1, '1', 10, 1);
INSERT INTO `pp_order_auditpocess` VALUES (15, 2, '2020-12-25 10:25:00', 1, '2', 10, 2);
INSERT INTO `pp_order_auditpocess` VALUES (17, 1, '2020-12-25 11:21:19', 1, '1', 11, 1);
INSERT INTO `pp_order_auditpocess` VALUES (18, 2, '2020-12-25 11:21:19', 1, '2', 11, 2);
INSERT INTO `pp_order_auditpocess` VALUES (29, 1, '2020-12-25 17:11:46', 0, '1', 15, 1);
INSERT INTO `pp_order_auditpocess` VALUES (30, 2, '2020-12-25 17:11:46', 0, '啊', 15, 2);
INSERT INTO `pp_order_auditpocess` VALUES (31, 4, '2020-12-25 17:11:46', 0, '是', 15, 6);
INSERT INTO `pp_order_auditpocess` VALUES (32, 1, '2020-12-25 18:29:56', 0, '1', 16, 1);
INSERT INTO `pp_order_auditpocess` VALUES (33, 2, '2020-12-25 18:29:56', 0, '啊', 16, 2);
INSERT INTO `pp_order_auditpocess` VALUES (34, 4, '2020-12-25 18:29:56', 0, '是', 16, 6);
INSERT INTO `pp_order_auditpocess` VALUES (35, 1, '2020-12-25 18:32:16', 0, '1', 17, 1);
INSERT INTO `pp_order_auditpocess` VALUES (36, 2, '2020-12-25 18:32:16', 0, '啊', 17, 2);
INSERT INTO `pp_order_auditpocess` VALUES (37, 4, '2020-12-25 18:32:16', 0, '是', 17, 6);
INSERT INTO `pp_order_auditpocess` VALUES (38, 1, '2020-12-25 18:40:51', 0, '1', 19, 1);
INSERT INTO `pp_order_auditpocess` VALUES (39, 2, '2020-12-25 18:40:51', 0, '啊', 19, 2);
INSERT INTO `pp_order_auditpocess` VALUES (40, 4, '2020-12-25 18:40:51', 0, '是', 19, 6);
INSERT INTO `pp_order_auditpocess` VALUES (41, 1, '2020-12-26 12:45:53', 1, '1', 20, 1);
INSERT INTO `pp_order_auditpocess` VALUES (42, 3, '2020-12-26 12:45:53', 1, '啊', 20, 2);
INSERT INTO `pp_order_auditpocess` VALUES (43, 4, '2020-12-26 12:45:53', 1, '是', 20, 6);
INSERT INTO `pp_order_auditpocess` VALUES (44, 1, '2020-12-26 12:48:48', 0, '1', 21, 1);
INSERT INTO `pp_order_auditpocess` VALUES (45, 3, '2020-12-26 12:48:48', 0, '啊', 21, 2);
INSERT INTO `pp_order_auditpocess` VALUES (46, 4, '2020-12-26 12:48:48', 0, '是', 21, 6);
INSERT INTO `pp_order_auditpocess` VALUES (47, 1, '2020-12-26 14:27:25', 0, '1', 22, 1);
INSERT INTO `pp_order_auditpocess` VALUES (48, 3, '2020-12-26 14:27:25', 0, '啊', 22, 2);
INSERT INTO `pp_order_auditpocess` VALUES (49, 4, '2020-12-26 14:27:25', 0, '是', 22, 6);
INSERT INTO `pp_order_auditpocess` VALUES (50, 1, '2020-12-26 14:45:55', 0, '1', 23, 1);
INSERT INTO `pp_order_auditpocess` VALUES (51, 3, '2020-12-26 14:45:55', 0, '啊', 23, 2);
INSERT INTO `pp_order_auditpocess` VALUES (52, 4, '2020-12-26 14:45:55', 0, '是', 23, 6);
INSERT INTO `pp_order_auditpocess` VALUES (53, 1, '2020-12-28 10:40:23', 0, '1', 24, 1);
INSERT INTO `pp_order_auditpocess` VALUES (54, 3, '2020-12-28 10:40:23', 0, '啊', 24, 2);
INSERT INTO `pp_order_auditpocess` VALUES (55, 4, '2020-12-28 10:40:23', 0, '是', 24, 6);
INSERT INTO `pp_order_auditpocess` VALUES (56, 1, '2020-12-28 10:41:30', 0, '1', 25, 1);
INSERT INTO `pp_order_auditpocess` VALUES (57, 3, '2020-12-28 10:41:30', 0, '啊', 25, 2);
INSERT INTO `pp_order_auditpocess` VALUES (58, 4, '2020-12-28 10:41:30', 0, '是', 25, 6);
INSERT INTO `pp_order_auditpocess` VALUES (59, 1, '2020-12-28 10:59:54', 0, '1', 27, 1);
INSERT INTO `pp_order_auditpocess` VALUES (60, 3, '2020-12-28 10:59:54', 0, '啊', 27, 2);
INSERT INTO `pp_order_auditpocess` VALUES (61, 4, '2020-12-28 10:59:54', 0, '是', 27, 6);

-- ----------------------------
-- Table structure for pp_outputstatistics
-- ----------------------------
DROP TABLE IF EXISTS `pp_outputstatistics`;
CREATE TABLE `pp_outputstatistics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annealing_complete_num` int(11) NULL DEFAULT NULL,
  `check_no_qualified_num` int(11) NULL DEFAULT NULL,
  `check_num` int(11) NULL DEFAULT NULL,
  `check_qualified_num` int(11) NULL DEFAULT NULL,
  `winding_complete_num` int(11) NULL DEFAULT NULL,
  `winding_no_complete_num` int(11) NULL DEFAULT NULL,
  `pp_id` int(11) NULL DEFAULT NULL,
  `wire_complete_num` int(11) NULL DEFAULT NULL,
  `wire_no_complete_num` int(11) NULL DEFAULT NULL,
  `annealing_no_complete_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_outputstatistics
-- ----------------------------
INSERT INTO `pp_outputstatistics` VALUES (5, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (6, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (7, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (8, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (9, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (10, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (14, 0, 0, 0, 0, 0, 0, 15, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (15, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (16, 0, 0, 0, 0, 0, 0, 17, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (17, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (18, 0, 0, 0, 0, 0, 0, 20, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (19, 0, 0, 0, 0, 0, 0, 21, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (20, 0, 0, 0, 0, 0, 0, 22, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (21, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (22, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (23, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0);
INSERT INTO `pp_outputstatistics` VALUES (24, 0, 0, 0, 0, 0, 0, 27, 0, 0, 0);

-- ----------------------------
-- Table structure for pp_product
-- ----------------------------
DROP TABLE IF EXISTS `pp_product`;
CREATE TABLE `pp_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `length` double NULL DEFAULT NULL,
  `pp_id` int(11) NULL DEFAULT NULL,
  `product_detail_id` int(11) NULL DEFAULT NULL,
  `quantum` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_product
-- ----------------------------
INSERT INTO `pp_product` VALUES (6, 0, 10, 6, 4, 101);
INSERT INTO `pp_product` VALUES (7, 0, 9, 7, 4, 11);
INSERT INTO `pp_product` VALUES (17, 0, 1, 6, 4, 2);
INSERT INTO `pp_product` VALUES (18, 0, 2, 6, 9, 2);
INSERT INTO `pp_product` VALUES (19, 0, 1, 8, 6, 1);
INSERT INTO `pp_product` VALUES (20, 0, 1, 9, 7, 1);
INSERT INTO `pp_product` VALUES (21, 0, 1, 10, 53, 1);
INSERT INTO `pp_product` VALUES (22, 0, 2, 10, 7, 2);
INSERT INTO `pp_product` VALUES (23, 0, 3, 10, 7, 3);
INSERT INTO `pp_product` VALUES (24, 0, 2, 10, 4, 2);
INSERT INTO `pp_product` VALUES (25, 0, 2, 11, 7, 3);
INSERT INTO `pp_product` VALUES (26, 0, 4, 11, 8, 3);
INSERT INTO `pp_product` VALUES (30, 0, 1, 15, 52, 20);
INSERT INTO `pp_product` VALUES (31, 0, 1, 15, 4, 1);
INSERT INTO `pp_product` VALUES (32, 0, 1, 16, 4, 1);
INSERT INTO `pp_product` VALUES (33, 0, 2, 16, 4, 2);
INSERT INTO `pp_product` VALUES (34, 0, 1, 17, 53, 1);
INSERT INTO `pp_product` VALUES (35, 0, 2, 17, 4, 2);
INSERT INTO `pp_product` VALUES (36, 0, 1, 17, 7, 1);
INSERT INTO `pp_product` VALUES (37, 0, 1, 19, 53, 1);
INSERT INTO `pp_product` VALUES (38, 0, 1, 19, 4, 1);
INSERT INTO `pp_product` VALUES (39, 0, 2, 19, 4, 2);
INSERT INTO `pp_product` VALUES (40, 0, 2, 20, 7, 2);
INSERT INTO `pp_product` VALUES (41, 0, 2, 21, 51, 2);
INSERT INTO `pp_product` VALUES (42, 0, 1, 21, 52, 1);
INSERT INTO `pp_product` VALUES (43, 0, 100, 22, 52, 12);
INSERT INTO `pp_product` VALUES (44, 0, 3.5, 22, 51, 4);
INSERT INTO `pp_product` VALUES (45, 0, 12, 23, 6, 33);
INSERT INTO `pp_product` VALUES (46, 0, 34, 23, 7, 6);
INSERT INTO `pp_product` VALUES (47, 0, 23, 23, 8, 1);
INSERT INTO `pp_product` VALUES (48, 0, 12, 23, 9, 23);
INSERT INTO `pp_product` VALUES (49, 0, 1, 24, 52, 2);
INSERT INTO `pp_product` VALUES (50, 0, 4, 24, 4, 5);
INSERT INTO `pp_product` VALUES (51, 0, 2, 25, 3, 3);
INSERT INTO `pp_product` VALUES (52, 0, 4, 25, 4, 5);
INSERT INTO `pp_product` VALUES (53, 0, 6, 25, 13, 7);
INSERT INTO `pp_product` VALUES (54, 0, 1, 27, 53, 1);
INSERT INTO `pp_product` VALUES (55, 0, 1, 27, 52, 1);

-- ----------------------------
-- Table structure for pp_production
-- ----------------------------
DROP TABLE IF EXISTS `pp_production`;
CREATE TABLE `pp_production`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) NULL DEFAULT NULL,
  `gxid` int(11) NULL DEFAULT NULL,
  `pv` decimal(19, 2) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `equipment_id` int(11) NULL DEFAULT NULL,
  `finish_num` int(11) NULL DEFAULT NULL,
  `frequency` int(11) NULL DEFAULT NULL,
  `mold_temp` decimal(19, 2) NULL DEFAULT NULL,
  `pay_tension` decimal(19, 2) NULL DEFAULT NULL,
  `pproduct_id` int(11) NULL DEFAULT NULL,
  `production_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `slip_rate` decimal(19, 2) NULL DEFAULT NULL,
  `speedm` decimal(19, 2) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `stop_time` int(11) NULL DEFAULT NULL,
  `suit_id` int(11) NULL DEFAULT NULL,
  `team_id` int(11) NULL DEFAULT NULL,
  `tow_parameters` int(11) NULL DEFAULT NULL,
  `tow_time` int(11) NULL DEFAULT NULL,
  `water_temp` decimal(19, 2) NULL DEFAULT NULL,
  `gx_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 96 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_production
-- ----------------------------
INSERT INTO `pp_production` VALUES (65, 0, 38, NULL, '2020-12-29 17:36:22', 0, 8, NULL, 1, 23.00, NULL, 43, '20201229000产品模型名字', NULL, NULL, 2, 1, 12, 6, 2, 21, 12, 12.00, '粗拉');
INSERT INTO `pp_production` VALUES (66, 65, 39, NULL, '2020-12-29 17:36:22', 1, 7, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 2, NULL, 6, 3, NULL, NULL, NULL, NULL);
INSERT INTO `pp_production` VALUES (67, 66, 39, NULL, '2020-12-29 17:37:43', 1, 9, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 2, NULL, 6, 3, NULL, NULL, NULL, NULL);
INSERT INTO `pp_production` VALUES (68, 67, 39, NULL, '2020-12-29 17:38:54', 1, 9, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 2, NULL, 6, 3, NULL, NULL, NULL, '粗拉2');
INSERT INTO `pp_production` VALUES (69, 0, 38, NULL, '2020-12-29 17:39:13', 0, 7, NULL, 1, 1.00, NULL, 54, '20201229004产品模型名字', NULL, NULL, NULL, 1, 1, 5, 3, 1, 1, 1.00, '粗拉');
INSERT INTO `pp_production` VALUES (70, 69, 39, NULL, '2020-12-29 17:39:13', 0, 7, 0, 1, NULL, NULL, 54, '20201229004产品模型名字', NULL, NULL, 1, 2, NULL, 5, 2, NULL, NULL, NULL, NULL);
INSERT INTO `pp_production` VALUES (71, 68, 39, NULL, '2020-12-29 17:39:19', 1, 7, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 1, NULL, 6, 3, NULL, NULL, NULL, '粗拉2');
INSERT INTO `pp_production` VALUES (72, 0, 38, NULL, '2020-12-29 17:40:51', 0, 7, NULL, 1, 3.00, NULL, 40, '20201229007产品模型名字', NULL, NULL, NULL, 1, 3, 6, 2, 3, 3, 3.00, '粗拉');
INSERT INTO `pp_production` VALUES (73, 72, 39, NULL, '2020-12-29 17:40:51', 1, 9, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 2, NULL, 6, 2, NULL, NULL, NULL, NULL);
INSERT INTO `pp_production` VALUES (74, 73, 39, NULL, '2020-12-29 17:41:13', 1, 8, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 2, NULL, 6, 2, NULL, NULL, NULL, '粗拉11');
INSERT INTO `pp_production` VALUES (75, 74, 40, NULL, '2020-12-29 17:41:34', 1, NULL, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 0, NULL, 6, 3, NULL, NULL, NULL, '中拉');
INSERT INTO `pp_production` VALUES (76, 74, 39, NULL, '2020-12-29 17:42:34', 1, 7, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 2, NULL, 6, 2, NULL, NULL, NULL, '粗拉1');
INSERT INTO `pp_production` VALUES (77, 76, 39, NULL, '2020-12-29 17:43:00', 1, 12, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 2, NULL, 6, 2, NULL, NULL, NULL, '粗拉1');
INSERT INTO `pp_production` VALUES (78, 77, 39, NULL, '2020-12-29 17:46:04', 1, 7, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 1, NULL, 6, 2, NULL, NULL, NULL, '粗拉4');
INSERT INTO `pp_production` VALUES (79, 78, 40, NULL, '2020-12-29 17:46:28', 0, 10, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 1, NULL, 6, 3, NULL, NULL, NULL, '中拉');
INSERT INTO `pp_production` VALUES (80, 79, 41, NULL, '2020-12-29 17:47:02', 1, NULL, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 0, NULL, 6, 2, NULL, NULL, NULL, '半成品(细拉)');
INSERT INTO `pp_production` VALUES (81, 79, 41, NULL, '2020-12-29 17:48:47', 0, 12, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 1, NULL, 6, 2, NULL, NULL, NULL, '半成品(细拉)');
INSERT INTO `pp_production` VALUES (82, 81, 42, 34.00, '2020-12-29 17:49:06', 0, 13, 0, 1, NULL, 34.00, 40, '20201229007产品模型名字', 4.00, 4.00, 1, 2, NULL, 6, 2, NULL, NULL, NULL, '成品(超细拉)');
INSERT INTO `pp_production` VALUES (83, 71, 40, NULL, '2020-12-29 17:49:15', 0, 7, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 1, NULL, 6, 2, NULL, NULL, NULL, '中拉');
INSERT INTO `pp_production` VALUES (84, 82, 42, NULL, '2020-12-29 17:49:36', 0, NULL, 0, 1, NULL, NULL, 40, '20201229007产品模型名字', NULL, NULL, 1, 0, NULL, 6, 2, NULL, NULL, NULL, '成品(超细拉)1');
INSERT INTO `pp_production` VALUES (85, 83, 41, NULL, '2020-12-29 17:49:42', 0, 7, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 1, NULL, 6, 2, NULL, NULL, NULL, '半成品(细拉)');
INSERT INTO `pp_production` VALUES (86, 85, 42, NULL, '2020-12-29 17:51:00', 0, NULL, 0, 2, NULL, NULL, 43, '20201229000产品模型名字', NULL, NULL, 1, 0, NULL, 6, 3, NULL, NULL, NULL, '成品(超细拉)');
INSERT INTO `pp_production` VALUES (87, 70, 39, NULL, '2020-12-29 17:56:52', 0, 7, 0, 1, NULL, NULL, 54, '20201229004产品模型名字', NULL, NULL, 1, 2, NULL, 5, 2, NULL, NULL, NULL, '粗拉1');
INSERT INTO `pp_production` VALUES (88, 87, 39, NULL, '2020-12-29 17:57:15', 0, 8, 0, 1, NULL, NULL, 54, '20201229004产品模型名字', NULL, NULL, 1, 1, NULL, 5, 2, NULL, NULL, NULL, '粗拉2');
INSERT INTO `pp_production` VALUES (93, 88, 40, NULL, '2020-12-29 18:55:06', 0, NULL, 0, 2, NULL, NULL, 54, '20201229004产品模型名字', NULL, NULL, 1, 0, NULL, 5, 3, NULL, NULL, NULL, '中拉');
INSERT INTO `pp_production` VALUES (94, 0, 38, NULL, '2020-12-30 09:41:08', 0, 8, NULL, 2, 1.00, NULL, 51, '20201230000123', NULL, NULL, 2, 1, 12, 5, 2, 2, 323, 12.00, '粗拉');
INSERT INTO `pp_production` VALUES (95, 94, 39, NULL, '2020-12-30 09:41:08', 0, NULL, 0, 1, NULL, NULL, 51, '20201230000123', NULL, NULL, 1, 0, NULL, 5, 3, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for pp_roughdrawing_products
-- ----------------------------
DROP TABLE IF EXISTS `pp_roughdrawing_products`;
CREATE TABLE `pp_roughdrawing_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_roughdrawing_products
-- ----------------------------

-- ----------------------------
-- Table structure for pp_scheduling
-- ----------------------------
DROP TABLE IF EXISTS `pp_scheduling`;
CREATE TABLE `pp_scheduling`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `frequency` int(11) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `pp_id` int(11) NULL DEFAULT NULL,
  `tteam_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 173 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_scheduling
-- ----------------------------
INSERT INTO `pp_scheduling` VALUES (21, 1, 38, 6, 2);
INSERT INTO `pp_scheduling` VALUES (22, 1, 39, 6, 2);
INSERT INTO `pp_scheduling` VALUES (23, 1, 40, 6, 2);
INSERT INTO `pp_scheduling` VALUES (24, 2, 41, 6, 3);
INSERT INTO `pp_scheduling` VALUES (25, 1, 38, 7, 2);
INSERT INTO `pp_scheduling` VALUES (26, 1, 39, 7, 2);
INSERT INTO `pp_scheduling` VALUES (27, 1, 40, 7, 2);
INSERT INTO `pp_scheduling` VALUES (28, 2, 41, 7, 3);
INSERT INTO `pp_scheduling` VALUES (29, 2, 38, 8, 2);
INSERT INTO `pp_scheduling` VALUES (30, 1, 39, 8, 3);
INSERT INTO `pp_scheduling` VALUES (31, 2, 40, 8, 2);
INSERT INTO `pp_scheduling` VALUES (32, 1, 41, 8, 3);
INSERT INTO `pp_scheduling` VALUES (33, 1, 42, 8, 2);
INSERT INTO `pp_scheduling` VALUES (34, 1, 43, 8, 2);
INSERT INTO `pp_scheduling` VALUES (35, 1, 68, 8, 2);
INSERT INTO `pp_scheduling` VALUES (36, 1, 70, 8, 2);
INSERT INTO `pp_scheduling` VALUES (37, 1, 38, 9, 3);
INSERT INTO `pp_scheduling` VALUES (38, 1, 39, 9, 2);
INSERT INTO `pp_scheduling` VALUES (39, 1, 40, 9, 3);
INSERT INTO `pp_scheduling` VALUES (40, 2, 41, 9, 2);
INSERT INTO `pp_scheduling` VALUES (41, 1, 42, 9, 2);
INSERT INTO `pp_scheduling` VALUES (42, 1, 43, 9, 2);
INSERT INTO `pp_scheduling` VALUES (43, 1, 68, 9, 2);
INSERT INTO `pp_scheduling` VALUES (44, 1, 70, 9, 2);
INSERT INTO `pp_scheduling` VALUES (45, 2, 38, 10, 2);
INSERT INTO `pp_scheduling` VALUES (46, 1, 39, 10, 3);
INSERT INTO `pp_scheduling` VALUES (47, 1, 40, 10, 3);
INSERT INTO `pp_scheduling` VALUES (48, 1, 41, 10, 2);
INSERT INTO `pp_scheduling` VALUES (49, 1, 42, 10, 2);
INSERT INTO `pp_scheduling` VALUES (50, 1, 43, 10, 3);
INSERT INTO `pp_scheduling` VALUES (51, 1, 68, 10, 3);
INSERT INTO `pp_scheduling` VALUES (52, 1, 70, 10, 2);
INSERT INTO `pp_scheduling` VALUES (53, 1, 38, 11, 3);
INSERT INTO `pp_scheduling` VALUES (54, 1, 39, 11, 3);
INSERT INTO `pp_scheduling` VALUES (55, 1, 40, 11, 2);
INSERT INTO `pp_scheduling` VALUES (56, 2, 41, 11, 2);
INSERT INTO `pp_scheduling` VALUES (57, 1, 42, 11, 3);
INSERT INTO `pp_scheduling` VALUES (58, 2, 43, 11, 3);
INSERT INTO `pp_scheduling` VALUES (59, 2, 68, 11, 2);
INSERT INTO `pp_scheduling` VALUES (60, 1, 70, 11, 2);
INSERT INTO `pp_scheduling` VALUES (85, 1, 38, 15, 2);
INSERT INTO `pp_scheduling` VALUES (86, 2, 39, 15, 3);
INSERT INTO `pp_scheduling` VALUES (87, 1, 40, 15, 3);
INSERT INTO `pp_scheduling` VALUES (88, 1, 41, 15, 3);
INSERT INTO `pp_scheduling` VALUES (89, 1, 42, 15, 2);
INSERT INTO `pp_scheduling` VALUES (90, 1, 43, 15, 2);
INSERT INTO `pp_scheduling` VALUES (91, 2, 68, 15, 3);
INSERT INTO `pp_scheduling` VALUES (92, 2, 70, 15, 2);
INSERT INTO `pp_scheduling` VALUES (93, 1, 38, 16, 2);
INSERT INTO `pp_scheduling` VALUES (94, 1, 39, 16, 3);
INSERT INTO `pp_scheduling` VALUES (95, 1, 40, 16, 2);
INSERT INTO `pp_scheduling` VALUES (96, 1, 41, 16, 2);
INSERT INTO `pp_scheduling` VALUES (97, 1, 42, 16, 3);
INSERT INTO `pp_scheduling` VALUES (98, 1, 43, 16, 2);
INSERT INTO `pp_scheduling` VALUES (99, 1, 68, 16, 3);
INSERT INTO `pp_scheduling` VALUES (100, 1, 70, 16, 2);
INSERT INTO `pp_scheduling` VALUES (101, 1, 38, 17, 2);
INSERT INTO `pp_scheduling` VALUES (102, 1, 39, 17, 2);
INSERT INTO `pp_scheduling` VALUES (103, 1, 40, 17, 2);
INSERT INTO `pp_scheduling` VALUES (104, 1, 41, 17, 2);
INSERT INTO `pp_scheduling` VALUES (105, 1, 42, 17, 2);
INSERT INTO `pp_scheduling` VALUES (106, 1, 43, 17, 2);
INSERT INTO `pp_scheduling` VALUES (107, 1, 68, 17, 2);
INSERT INTO `pp_scheduling` VALUES (108, 1, 70, 17, 2);
INSERT INTO `pp_scheduling` VALUES (109, 1, 38, 19, 3);
INSERT INTO `pp_scheduling` VALUES (110, 1, 39, 19, 3);
INSERT INTO `pp_scheduling` VALUES (111, 1, 40, 19, 3);
INSERT INTO `pp_scheduling` VALUES (112, 1, 41, 19, 2);
INSERT INTO `pp_scheduling` VALUES (113, 1, 42, 19, 3);
INSERT INTO `pp_scheduling` VALUES (114, 1, 43, 19, 2);
INSERT INTO `pp_scheduling` VALUES (115, 1, 68, 19, 2);
INSERT INTO `pp_scheduling` VALUES (116, 1, 70, 19, 2);
INSERT INTO `pp_scheduling` VALUES (117, 1, 38, 20, 2);
INSERT INTO `pp_scheduling` VALUES (118, 1, 39, 20, 2);
INSERT INTO `pp_scheduling` VALUES (119, 1, 40, 20, 3);
INSERT INTO `pp_scheduling` VALUES (120, 1, 41, 20, 2);
INSERT INTO `pp_scheduling` VALUES (121, 1, 42, 20, 2);
INSERT INTO `pp_scheduling` VALUES (122, 1, 43, 20, 2);
INSERT INTO `pp_scheduling` VALUES (123, 1, 68, 20, 2);
INSERT INTO `pp_scheduling` VALUES (124, 1, 70, 20, 2);
INSERT INTO `pp_scheduling` VALUES (125, 1, 38, 21, 2);
INSERT INTO `pp_scheduling` VALUES (126, 1, 39, 21, 3);
INSERT INTO `pp_scheduling` VALUES (127, 1, 40, 21, 3);
INSERT INTO `pp_scheduling` VALUES (128, 1, 41, 21, 2);
INSERT INTO `pp_scheduling` VALUES (129, 2, 42, 21, 3);
INSERT INTO `pp_scheduling` VALUES (130, 1, 43, 21, 2);
INSERT INTO `pp_scheduling` VALUES (131, 1, 68, 21, 2);
INSERT INTO `pp_scheduling` VALUES (132, 2, 70, 21, 2);
INSERT INTO `pp_scheduling` VALUES (133, 1, 38, 22, 2);
INSERT INTO `pp_scheduling` VALUES (134, 2, 39, 22, 3);
INSERT INTO `pp_scheduling` VALUES (135, 2, 40, 22, 2);
INSERT INTO `pp_scheduling` VALUES (136, 2, 41, 22, 2);
INSERT INTO `pp_scheduling` VALUES (137, 2, 42, 22, 3);
INSERT INTO `pp_scheduling` VALUES (138, 1, 43, 22, 3);
INSERT INTO `pp_scheduling` VALUES (139, 1, 68, 22, 2);
INSERT INTO `pp_scheduling` VALUES (140, 2, 70, 22, 2);
INSERT INTO `pp_scheduling` VALUES (141, 1, 38, 23, 2);
INSERT INTO `pp_scheduling` VALUES (142, 1, 39, 23, 2);
INSERT INTO `pp_scheduling` VALUES (143, 2, 40, 23, 3);
INSERT INTO `pp_scheduling` VALUES (144, 2, 41, 23, 3);
INSERT INTO `pp_scheduling` VALUES (145, 2, 42, 23, 3);
INSERT INTO `pp_scheduling` VALUES (146, 2, 43, 23, 2);
INSERT INTO `pp_scheduling` VALUES (147, 2, 68, 23, 2);
INSERT INTO `pp_scheduling` VALUES (148, 1, 70, 23, 2);
INSERT INTO `pp_scheduling` VALUES (149, 2, 38, 24, 2);
INSERT INTO `pp_scheduling` VALUES (150, 1, 39, 24, 2);
INSERT INTO `pp_scheduling` VALUES (151, 2, 40, 24, 2);
INSERT INTO `pp_scheduling` VALUES (152, 1, 41, 24, 2);
INSERT INTO `pp_scheduling` VALUES (153, 2, 42, 24, 3);
INSERT INTO `pp_scheduling` VALUES (154, 2, 43, 24, 2);
INSERT INTO `pp_scheduling` VALUES (155, 2, 68, 24, 2);
INSERT INTO `pp_scheduling` VALUES (156, 1, 70, 24, 2);
INSERT INTO `pp_scheduling` VALUES (157, 2, 38, 25, 2);
INSERT INTO `pp_scheduling` VALUES (158, 1, 39, 25, 3);
INSERT INTO `pp_scheduling` VALUES (159, 2, 40, 25, 2);
INSERT INTO `pp_scheduling` VALUES (160, 2, 41, 25, 2);
INSERT INTO `pp_scheduling` VALUES (161, 2, 42, 25, 3);
INSERT INTO `pp_scheduling` VALUES (162, 1, 43, 25, 2);
INSERT INTO `pp_scheduling` VALUES (163, 2, 68, 25, 2);
INSERT INTO `pp_scheduling` VALUES (164, 2, 70, 25, 2);
INSERT INTO `pp_scheduling` VALUES (165, 1, 38, 27, 3);
INSERT INTO `pp_scheduling` VALUES (166, 1, 39, 27, 2);
INSERT INTO `pp_scheduling` VALUES (167, 2, 40, 27, 3);
INSERT INTO `pp_scheduling` VALUES (168, 1, 41, 27, 2);
INSERT INTO `pp_scheduling` VALUES (169, 1, 42, 27, 2);
INSERT INTO `pp_scheduling` VALUES (170, 2, 43, 27, 3);
INSERT INTO `pp_scheduling` VALUES (171, 2, 68, 27, 3);
INSERT INTO `pp_scheduling` VALUES (172, 1, 70, 27, 2);

-- ----------------------------
-- Table structure for pp_semi_finished_products
-- ----------------------------
DROP TABLE IF EXISTS `pp_semi_finished_products`;
CREATE TABLE `pp_semi_finished_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_semi_finished_products
-- ----------------------------

-- ----------------------------
-- Table structure for pp_winding_products
-- ----------------------------
DROP TABLE IF EXISTS `pp_winding_products`;
CREATE TABLE `pp_winding_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `amount` int(11) NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `winding_type` int(11) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of pp_winding_products
-- ----------------------------

-- ----------------------------
-- Table structure for ppp_products0
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products0`;
CREATE TABLE `ppp_products0`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products0
-- ----------------------------
INSERT INTO `ppp_products0` VALUES (8, 70, '', 13, '2020-12-29 17:56:18', 1, 1.00, 0, 1.00, 1.00, 1.00, NULL, '', '', '', '', NULL, '', 1.00, 1.00);
INSERT INTO `ppp_products0` VALUES (9, 70, '', 13, '2020-12-29 17:56:52', 0, 1.00, 0, 1.00, 1.00, 1.00, NULL, '', '', '', '', NULL, '', 1.00, 1.00);

-- ----------------------------
-- Table structure for ppp_products1
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products1`;
CREATE TABLE `ppp_products1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products1
-- ----------------------------
INSERT INTO `ppp_products1` VALUES (26, 81, '', 13, '2020-12-29 17:49:06', 0, 23.00, 0, 23.00, 23.00, 35.00, NULL, '', '', '', '', NULL, '', 45.00, 23.00);
INSERT INTO `ppp_products1` VALUES (27, 71, '', 14, '2020-12-29 17:49:15', 0, 1.00, 0, 1.00, 1.00, 1.00, NULL, '', '', '', '', NULL, '', 1.00, 1.00);

-- ----------------------------
-- Table structure for ppp_products2
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products2`;
CREATE TABLE `ppp_products2`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products2
-- ----------------------------
INSERT INTO `ppp_products2` VALUES (11, 72, '', NULL, '2020-12-29 17:40:51', 0, 4.00, 38, NULL, 6.00, 4.00, NULL, '', '', '', '', NULL, '', 5.00, NULL);
INSERT INTO `ppp_products2` VALUES (12, 72, '', NULL, '2020-12-29 17:40:51', 0, 7.00, 38, NULL, 7.00, 7.00, NULL, '', '', '', '', NULL, '', 7.00, NULL);
INSERT INTO `ppp_products2` VALUES (13, 82, '', 14, '2020-12-29 17:49:36', 0, 23.00, 0, 23.00, 34.00, 234.00, NULL, '', '', '', '', NULL, '', 34.00, 34.00);

-- ----------------------------
-- Table structure for ppp_products3
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products3`;
CREATE TABLE `ppp_products3`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products3
-- ----------------------------
INSERT INTO `ppp_products3` VALUES (4, 73, '', 13, '2020-12-29 17:41:13', 0, 8.00, 0, 8.00, 8.00, 8.00, NULL, '', '', '', '', NULL, '', 8.00, 8.00);
INSERT INTO `ppp_products3` VALUES (5, 83, '1', 13, '2020-12-29 17:49:42', 0, 1.00, 0, 1.00, 1.00, 1.00, NULL, '', '', '1', '1', NULL, '1', 1.00, 1.00);

-- ----------------------------
-- Table structure for ppp_products4
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products4`;
CREATE TABLE `ppp_products4`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products4
-- ----------------------------
INSERT INTO `ppp_products4` VALUES (9, 74, '', 13, '2020-12-29 17:41:34', 0, 4.00, 0, 4.00, 6.00, 5.00, NULL, '', '', '', '', NULL, '', 6.00, 4.00);
INSERT INTO `ppp_products4` VALUES (10, 74, '', 13, '2020-12-29 17:42:34', 0, 4.00, 0, 4.00, 6.00, 5.00, NULL, '', '', '', '', NULL, '', 6.00, 4.00);
INSERT INTO `ppp_products4` VALUES (11, 94, '', NULL, '2020-12-30 09:41:08', 0, 2.00, 38, NULL, 12.00, 2.00, NULL, '', '', '', '', NULL, '', 12.00, NULL);
INSERT INTO `ppp_products4` VALUES (12, 94, '', NULL, '2020-12-30 09:41:08', 0, 23.00, 38, NULL, 12.00, 23.00, NULL, '', '', '', '', NULL, '', 12.00, NULL);

-- ----------------------------
-- Table structure for ppp_products5
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products5`;
CREATE TABLE `ppp_products5`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products5
-- ----------------------------
INSERT INTO `ppp_products5` VALUES (12, 65, '', NULL, '2020-12-29 17:36:22', 0, 23.00, 38, NULL, 21.00, 23.00, NULL, '', '', '', '', NULL, '', 34.00, NULL);
INSERT INTO `ppp_products5` VALUES (13, 65, '', NULL, '2020-12-29 17:36:22', 0, 45.00, 38, NULL, 23.00, 45.00, NULL, '', '', '', '', NULL, '', 23.00, NULL);
INSERT INTO `ppp_products5` VALUES (14, 85, '', 17, '2020-12-29 17:51:00', 0, 2.00, 0, 2.00, 2.00, 2.00, NULL, '', '', '', '', NULL, '', 2.00, 2.00);

-- ----------------------------
-- Table structure for ppp_products6
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products6`;
CREATE TABLE `ppp_products6`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products6
-- ----------------------------
INSERT INTO `ppp_products6` VALUES (4, 66, '', 13, '2020-12-29 17:37:09', 0, 23.00, 0, 2.00, 23.00, 23.00, NULL, '', '', '', '', NULL, '', 23.00, 3.00);
INSERT INTO `ppp_products6` VALUES (5, 66, '', 14, '2020-12-29 17:37:09', 0, 5.00, 0, 5.00, 8.00, 3.00, NULL, '', '', '', '', NULL, '', 2.00, 5.00);
INSERT INTO `ppp_products6` VALUES (6, 66, '', 15, '2020-12-29 17:37:09', 0, 9.00, 0, 9.00, 9.00, 9.00, NULL, '', '', '', '', NULL, '', 9.00, 9.00);
INSERT INTO `ppp_products6` VALUES (7, 76, '', 13, '2020-12-29 17:43:00', 0, 3.00, 0, 3.00, 3.00, 3.00, NULL, '', '', '', '', NULL, '', 3.00, 3.00);

-- ----------------------------
-- Table structure for ppp_products7
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products7`;
CREATE TABLE `ppp_products7`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products7
-- ----------------------------
INSERT INTO `ppp_products7` VALUES (4, 67, '', 17, '2020-12-29 17:38:54', 0, 2.00, 0, 2.00, 9.00, 2.00, NULL, '', '', '', '', NULL, '', 9.00, 1.00);
INSERT INTO `ppp_products7` VALUES (5, 77, '', 17, '2020-12-29 17:46:04', 0, 12.00, 0, 23.00, 3.00, 12.00, NULL, '', '', '', '', NULL, '', 12.00, 23.00);
INSERT INTO `ppp_products7` VALUES (6, 87, '', 17, '2020-12-29 17:57:15', 0, 1.00, 0, 1.00, 1.00, 1.00, NULL, '', '', '', '', NULL, '', 1.00, 1.00);

-- ----------------------------
-- Table structure for ppp_products8
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products8`;
CREATE TABLE `ppp_products8`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products8
-- ----------------------------
INSERT INTO `ppp_products8` VALUES (6, 68, '', 13, '2020-12-29 17:39:19', 0, 1.00, 0, 1.00, 1.00, 1.00, NULL, '', '', '', '', NULL, '', 1.00, 1.00);
INSERT INTO `ppp_products8` VALUES (7, 78, '', 13, '2020-12-29 17:46:28', 0, 4.00, 0, 3.00, 23.00, 534.00, NULL, '', '', '', '', NULL, '', 23.00, 3.00);
INSERT INTO `ppp_products8` VALUES (8, 88, '', 17, '2020-12-29 18:55:06', 0, 12.00, 0, 23.00, 23.00, 12.00, NULL, '', '', '', '', NULL, '', 23.00, 23.00);
INSERT INTO `ppp_products8` VALUES (9, 88, '', 17, '2020-12-29 18:55:06', 0, 34.00, 0, 23.00, 23.00, 23.00, NULL, '', '', '', '', NULL, '', 23.00, 23.00);

-- ----------------------------
-- Table structure for ppp_products9
-- ----------------------------
DROP TABLE IF EXISTS `ppp_products9`;
CREATE TABLE `ppp_products9`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `slip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_detail_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_id` int(11) NULL DEFAULT NULL,
  `lengthm` decimal(19, 2) NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg_sum` decimal(19, 2) NULL DEFAULT NULL,
  `paying_off` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `straight_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `surface` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `take_up_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total_length` int(11) NULL DEFAULT NULL,
  `traction_speed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  `wire_diameter_um` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ppp_products9
-- ----------------------------
INSERT INTO `ppp_products9` VALUES (6, 69, '', NULL, '2020-12-29 17:39:13', 0, 1.00, 38, NULL, 1.00, 1.00, NULL, '', '', '', '', NULL, '', 1.00, NULL);
INSERT INTO `ppp_products9` VALUES (7, 79, '9', 17, '2020-12-29 17:47:02', 1, 23.00, 0, 2.00, 9.00, 23.00, NULL, '', '', '9', '9', NULL, '9', 23.00, 23.00);
INSERT INTO `ppp_products9` VALUES (8, 79, '78', 19, '2020-12-29 17:47:02', 1, 9.00, 0, 9.00, 78.00, 67.00, NULL, '', '', '89', '89', NULL, '56', 67.00, 9.00);
INSERT INTO `ppp_products9` VALUES (9, 79, '78', 19, '2020-12-29 17:47:32', 1, 9.00, 0, 9.00, 78.00, 67.00, NULL, '', '', '89', '89', NULL, '56', 67.00, 9.00);
INSERT INTO `ppp_products9` VALUES (10, 79, '56', 17, '2020-12-29 17:47:32', 1, 56.00, 0, 56.00, 56.00, 56.00, NULL, '', '', '56', '56', NULL, '56', 56.00, NULL);
INSERT INTO `ppp_products9` VALUES (11, 79, '78', 19, '2020-12-29 17:48:47', 0, 9.00, 0, 9.00, 78.00, 67.00, NULL, '', '', '89', '89', NULL, '56', 67.00, 9.00);
INSERT INTO `ppp_products9` VALUES (12, 79, '56', 17, '2020-12-29 17:48:47', 0, 56.00, 0, 56.00, 56.00, 56.00, NULL, '', '', '56', '56', NULL, '56', 56.00, NULL);

-- ----------------------------
-- Table structure for product_plan
-- ----------------------------
DROP TABLE IF EXISTS `product_plan`;
CREATE TABLE `product_plan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `finished_time` datetime NULL DEFAULT NULL,
  `pp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pp_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sale_id` int(11) NULL DEFAULT NULL,
  `suit_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `relation_no` int(11) NULL DEFAULT NULL,
  `pp_plan_state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product_plan
-- ----------------------------
INSERT INTO `product_plan` VALUES (6, '2020-12-21 12:19:27', '2020-12-21 12:19:27', '这是生产计划单名称', '这是生产计划单编号', 30, 2, 1, 1, 0, 0);
INSERT INTO `product_plan` VALUES (7, '2020-12-21 12:19:27', '2020-12-21 12:19:27', '这是生产计划单名称22', '这是生产计划单编号222', 3, 2, 1, 0, 1, 2);
INSERT INTO `product_plan` VALUES (8, '2020-12-24 00:00:00', '2020-12-25 00:00:00', 'aaa', '10000000021', NULL, 6, 1, 1, 0, 0);
INSERT INTO `product_plan` VALUES (9, '2020-12-24 00:00:00', '2020-12-25 00:00:00', 'bbb', '10000000031', NULL, 6, 1, 0, 0, 0);
INSERT INTO `product_plan` VALUES (10, '2020-12-25 00:00:00', '2020-12-26 00:00:00', 'DWA', '10000000041', 35, 5, 1, 0, 1, 0);
INSERT INTO `product_plan` VALUES (11, '2020-12-25 00:00:00', '2020-12-31 00:00:00', '生产计划单111', '10000000051', NULL, 5, 1, 1, 0, 0);
INSERT INTO `product_plan` VALUES (15, '2020-12-25 00:00:00', '2020-12-30 00:00:00', '名称1', '10000000061', 35, 5, 1, NULL, 1, 1);
INSERT INTO `product_plan` VALUES (16, '2020-12-25 00:00:00', '2020-12-26 00:00:00', 'A', '10000000071', NULL, 1, 1, NULL, 0, 1);
INSERT INTO `product_plan` VALUES (17, '2020-12-25 00:00:00', '2020-12-26 00:00:00', 'A', '10000000081', 35, 1, 1, NULL, 1, 1);
INSERT INTO `product_plan` VALUES (19, '2020-12-25 00:00:00', '2020-12-26 00:00:00', '2', '10000000091', 35, 7, 1, NULL, 1, 1);
INSERT INTO `product_plan` VALUES (20, '2020-12-26 00:00:00', '2020-12-27 00:00:00', '123', '100000000101', NULL, 6, 0, NULL, 0, 3);
INSERT INTO `product_plan` VALUES (21, '2020-12-26 00:00:00', '2020-12-27 00:00:00', '2', '100000000111', 34, 5, 1, NULL, 1, 1);
INSERT INTO `product_plan` VALUES (22, '2020-12-26 00:00:00', '2020-12-28 00:00:00', '计划生产001', '100000000121', 34, 6, 0, NULL, 1, 0);
INSERT INTO `product_plan` VALUES (23, '2020-12-26 00:00:00', '2020-12-28 00:00:00', '不关联的销售单', '100000000131', NULL, 1, 0, NULL, 0, 0);
INSERT INTO `product_plan` VALUES (24, '2020-12-28 00:00:00', '2020-12-30 00:00:00', '我是关联的', '100000000141', 34, 6, 0, NULL, 1, 1);
INSERT INTO `product_plan` VALUES (25, '2020-12-28 00:00:00', '2020-12-31 00:00:00', '我是不关联的', '100000000151', NULL, 5, 0, NULL, 0, 1);
INSERT INTO `product_plan` VALUES (27, '2020-12-28 00:00:00', '2020-12-29 00:00:00', '啊啊', '100000000161', 35, 5, 0, NULL, 1, 0);

-- ----------------------------
-- Table structure for production_stock
-- ----------------------------
DROP TABLE IF EXISTS `production_stock`;
CREATE TABLE `production_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `inventory_status_id` int(11) NULL DEFAULT NULL,
  `quantity_choose` int(11) NULL DEFAULT NULL,
  `total_net` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of production_stock
-- ----------------------------
INSERT INTO `production_stock` VALUES (1, 1, 0, 26, 10, 260);
INSERT INTO `production_stock` VALUES (2, 1, 0, 25, 30, 900);
INSERT INTO `production_stock` VALUES (3, 1, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (4, 2, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (5, 3, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (6, 4, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (7, 5, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (8, 6, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (9, 6, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (10, 7, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (11, 8, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (12, 8, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (13, 4, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (14, 7, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (15, 6, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (16, 5, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (17, 3, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (18, 9, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (19, 9, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (20, 2, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (21, 10, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (22, 11, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (23, 11, 0, 64, 12, 1477476);
INSERT INTO `production_stock` VALUES (24, 12, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (25, 10, 0, 62, 1, NULL);
INSERT INTO `production_stock` VALUES (26, 13, 0, 52, 8, NULL);
INSERT INTO `production_stock` VALUES (27, 13, 0, 53, 5, 6155);
INSERT INTO `production_stock` VALUES (28, 14, 0, 62, 98, NULL);
INSERT INTO `production_stock` VALUES (29, 18, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (30, 19, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (33, 23, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (34, 23, 0, 65, 1, 123123);
INSERT INTO `production_stock` VALUES (35, 24, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (36, 25, 0, 64, 2, 246246);
INSERT INTO `production_stock` VALUES (37, 30, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (38, 32, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (39, 33, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (40, 31, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (41, 48, 0, 54, 1, NULL);
INSERT INTO `production_stock` VALUES (42, 48, 0, 68, 1, 1231);
INSERT INTO `production_stock` VALUES (43, 48, 0, 72, 1, NULL);
INSERT INTO `production_stock` VALUES (44, 51, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (45, 60, 0, 54, 1, NULL);
INSERT INTO `production_stock` VALUES (46, 60, 0, 72, 1, NULL);
INSERT INTO `production_stock` VALUES (47, 65, 0, 54, 5, NULL);
INSERT INTO `production_stock` VALUES (48, 69, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (49, 72, 0, 64, 1, 123123);
INSERT INTO `production_stock` VALUES (50, 94, 0, 58, 12, NULL);

-- ----------------------------
-- Table structure for rawmaterial_ratio
-- ----------------------------
DROP TABLE IF EXISTS `rawmaterial_ratio`;
CREATE TABLE `rawmaterial_ratio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NULL DEFAULT NULL,
  `ratioend` decimal(19, 2) NULL DEFAULT NULL,
  `ratiostart` decimal(19, 2) NULL DEFAULT NULL,
  `stock_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rawmaterial_ratio
-- ----------------------------
INSERT INTO `rawmaterial_ratio` VALUES (1, 4, 80.00, 50.00, 0, 0);
INSERT INTO `rawmaterial_ratio` VALUES (2, 4, 80.00, 30.00, 0, 0);
INSERT INTO `rawmaterial_ratio` VALUES (3, 7, 1.00, 1.00, 45, 0);
INSERT INTO `rawmaterial_ratio` VALUES (4, 8, 1.00, 1.00, 44, 0);
INSERT INTO `rawmaterial_ratio` VALUES (5, 10, 1.00, 1.00, 45, 0);
INSERT INTO `rawmaterial_ratio` VALUES (6, 11, NULL, 1.00, 45, 0);
INSERT INTO `rawmaterial_ratio` VALUES (7, 12, 1.00, 1.00, 45, 0);
INSERT INTO `rawmaterial_ratio` VALUES (8, 13, 1.00, 1.00, 45, 0);

-- ----------------------------
-- Table structure for s_customer
-- ----------------------------
DROP TABLE IF EXISTS `s_customer`;
CREATE TABLE `s_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fax` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_no` int(11) NULL DEFAULT NULL,
  `contacts_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contacts_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contacts_post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `e_mails` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `landline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_customer
-- ----------------------------
INSERT INTO `s_customer` VALUES (1, NULL, '士大夫似的', 1, '阿伟大的阿瓦达', NULL, NULL, 1606284985548, '客户1', '编号1', 1, NULL, NULL, NULL, 0, 1);
INSERT INTO `s_customer` VALUES (2, NULL, '士大夫似的', 1, NULL, NULL, NULL, 1606285020221, '客户2', '编号2', 1, NULL, NULL, NULL, 0, 1);
INSERT INTO `s_customer` VALUES (3, NULL, '正经客胡地址', 1, NULL, NULL, NULL, 1606285426208, '客户3', '编号3', 1, NULL, NULL, NULL, 0, 1);
INSERT INTO `s_customer` VALUES (4, '发生的', '客户地址', 1, '男的', '1545454545', '5656445', 0, '客户4', '客户编号4', 0, '电子邮件', '发士大夫撒', '阿凡达是否', 0, 1);
INSERT INTO `s_customer` VALUES (5, 'string', 'string', 0, 'string', 'string', 'string', 0, 'string', 'string', 1, 'string', 'string', 'string', 0, 1);
INSERT INTO `s_customer` VALUES (6, 'string', 'string', 0, 'string', 'string', 'string', 0, 'string', 'string', 1, 'string', 'string', 'string', 0, 1);
INSERT INTO `s_customer` VALUES (7, 'string', 'string', 0, 'string', 'string', 'string', 0, 'string', 'string', 1, 'string', 'string', 'string', 0, 1);
INSERT INTO `s_customer` VALUES (8, NULL, 'ada', 1, 'wdaw', 'awd', 'dawwd', 1606725781444, 'dawd', 'adawda', 1, 'awd', 'awd', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (9, NULL, 'awda', 0, 'dw', 'awd', 'dwa', 1606728296719, 'awd', 'adwa', 1, 'wda', 'adw', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (10, NULL, '爱的发沙发沙发', 0, '阿士大夫撒放', '12234234', 'ad', 1606806667970, '工艺十年名字', 'clint001', 1, '123123', '1414', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (11, NULL, '单位', 1, '大万达', '单位', '单位', 1606814199245, '单位', '阿迪王', 1, '万达', '阿瓦达', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (12, NULL, '123', 0, '123', '123', '123', 1606814652140, '123', '123', 1, '123', '123', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (13, '123', '111', 0, '111', '111', '111', 1606814920142, '111', '111321312', 1, '111', '111', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (14, NULL, 'aaa', 1, 'aaa', 'aaa', 'aaa', 1606815078679, 'aaa', 'aaa', 1, 'aaa', 'aaa', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (15, '1', '1', 0, '1', '1', '1', 1606815450970, '1', '1', 1, '1', '1', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (16, NULL, '001', 1, 'a', '1', 'a', 1606816229143, '001', '001', 1, 'a', 'a', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (17, 'a', 'a', 1, 'a', 'a', 'a', 1606816612021, 'a', 'a', 1, 'a', 'a', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (18, 'a', 'a', 1, 'a', 'a', 'a', 1606819355063, 'a', 'a', 1, 'a', 'a', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (19, '1', '1', 0, '1', '1', '1', 1608711808365, '1', '32', 1, '1', '1', NULL, 1, 1);
INSERT INTO `s_customer` VALUES (20, 'a', 'a', 1, 'a', 'a', 'a', 1608712023810, 'a', 'a', 1, 'a', 'a', NULL, 1, 1);
INSERT INTO `s_customer` VALUES (21, 'a', 'a', 0, 'a', 'a', 'a', 1608712058016, 'a', 'a', 1, 'a', 'a', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (22, 'a', 'a', 1, 'a', 'a', 'a', 1608712073812, 'a', 'a', 1, 'a', 'a', NULL, 1, 1);
INSERT INTO `s_customer` VALUES (23, '121564548', '家在南村万博', 0, '秦妹妹', '00000000000', '老板', 1608883365549, '秦晓晓', 'gys00001', 0, '1604535654', '020-56421564', NULL, 0, 1);
INSERT INTO `s_customer` VALUES (24, '122565444', '番禺汉溪长隆', 1, '方程程', '23545465442', '她弟', 1608883664591, '方冰冰', 'kh0001', 0, '1604535214', '020-1235645', NULL, 1, 1);
INSERT INTO `s_customer` VALUES (25, '23', '32', 0, '32', '32', '32', 1609152192861, '213', '001', 0, '32', '32', NULL, 1, 1);
INSERT INTO `s_customer` VALUES (26, '1', '1', 1, '1', '1', '1', 1609152266502, '1', '1', 0, '1', '1', NULL, 1, 1);
INSERT INTO `s_customer` VALUES (27, '2', 'dsa', 0, 'asd', '213', 'ds', 1609152314069, 'sda', 'da', 0, '2', '1', NULL, 0, 1);

-- ----------------------------
-- Table structure for s_dictionarier
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionarier`;
CREATE TABLE `s_dictionarier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `dic_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dictfid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `create_time` datetime NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_dictionarier
-- ----------------------------
INSERT INTO `s_dictionarier` VALUES (1, 0, 'XB', 0, '线别', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (2, 0, 'GG', 0, '规格', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (3, 0, 'YL', 0, '原料', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (4, 0, 'CP', 0, '成品', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (5, 0, 'BCP', 0, '半成品', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (6, 0, 'FL', 0, '废料', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (16, 1, 'jinxian', 1, '金线', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (17, 0, 'yinxian', 1, '银线', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (18, 0, 'tx', 1, '铜线', 1, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (19, 0, 'DW', 0, '单位', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (20, 0, '', 19, '克', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (21, 0, '', 19, '米', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (22, 0, '', 19, '个', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (23, 0, 'XZ', 0, '线轴', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (24, 0, '', 23, '10黄', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (25, 0, '', 23, '30黄', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (26, 0, '', 23, '50黄', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (27, 0, 'SD', 0, '始端', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (28, 0, 'MD', 0, '末端', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (29, 0, '', 27, '红', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (30, 0, '', 28, '红', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (31, 0, '', 28, '黄', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (32, 0, '', 27, '黄', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (33, 0, '', 27, '绿', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (34, 0, '', 28, '绿', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (35, 0, '', 28, '蓝', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (36, 0, '', 27, '蓝', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (37, 0, 'GX', 0, '工序', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (38, 0, NULL, 37, '熔炼', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (39, 0, NULL, 37, '粗拉', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (40, 0, NULL, 37, '中拉', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (41, 0, NULL, 37, '半成品(细拉)', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (42, 0, NULL, 37, '成品(超细拉)', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (43, 0, NULL, 37, '中间退火', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (44, 1, '', 3, '金', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (45, 0, NULL, 3, '银', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (46, 0, NULL, 3, '铜', 1, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (47, 0, 'PT', 0, '付款方式', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (48, 0, NULL, 47, '现金', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (49, 0, NULL, 47, '微信', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (50, 0, NULL, 47, '支付宝', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (51, 0, NULL, 47, '银行卡', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (52, 0, 'CGType', NULL, '采购类型', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (53, 0, NULL, 52, '成品销售', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (54, 0, NULL, 52, '原材料', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (55, 0, NULL, 52, '其他', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (56, 0, 'CGOS', NULL, '采购订单状态', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (57, 0, NULL, 56, '草稿', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (58, 0, NULL, 56, '订单审核', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (59, 0, NULL, 56, '来料检验', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (60, 0, NULL, 56, '已完成', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (61, 0, NULL, 56, '退回中', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (62, 0, NULL, 56, '已退回', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (63, 0, 'CR', NULL, '检验结果', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (64, 0, NULL, 64, '未检验', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (65, 0, NULL, 64, '检验中', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (66, 0, NULL, 64, '未通过', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (67, 0, NULL, 64, '已通过', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (68, 0, NULL, 37, '绕线', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (70, 0, NULL, 37, '改绕', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (71, 0, 'SBType', 0, '设备类型', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (72, 0, NULL, 71, '熔炼设备', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (73, 0, NULL, 71, '粗拉设备', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (74, 0, NULL, 71, '中拉设备', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (75, 0, NULL, 71, '细拉设备', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (76, 0, NULL, 71, '半成品设备', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (77, 0, NULL, 71, '成品设备', 0, '2020-12-25 00:00:00', 1);
INSERT INTO `s_dictionarier` VALUES (87, 0, NULL, 1, '线别11', NULL, '2020-12-28 14:32:26', 1);
INSERT INTO `s_dictionarier` VALUES (88, 0, NULL, 3, '原料1', NULL, '2020-12-28 14:32:54', 1);
INSERT INTO `s_dictionarier` VALUES (90, 0, NULL, 37, '成品退火', NULL, '2020-12-29 18:04:19', 1);

-- ----------------------------
-- Table structure for s_dictionarierdetail
-- ----------------------------
DROP TABLE IF EXISTS `s_dictionarierdetail`;
CREATE TABLE `s_dictionarierdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictionarier_id` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `create_time` bigint(20) NOT NULL,
  `state` int(11) NULL DEFAULT 0,
  `delete_no` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_dictionarierdetail
-- ----------------------------
INSERT INTO `s_dictionarierdetail` VALUES (3, 16, NULL, 1606358336438, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (4, 17, 1, 1606358372871, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (5, 18, 1, 1606358652143, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (6, 20, 1, 1606358737247, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (7, 21, 1, 1606358746475, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (8, 22, 1, 1606358754070, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (9, 24, 1, 1606359527177, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (10, 25, 1, 1606359535034, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (11, 26, 1, 1606359544091, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (12, 29, 1, 1606359686779, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (13, 30, 1, 1606359691639, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (14, 31, 1, 1606359695987, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (15, 32, 1, 1606359699657, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (16, 33, 1, 1606359707753, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (17, 34, 1, 1606359711559, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (18, 35, 1, 1606359720119, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (19, 36, 1, 1606359724930, 0, 0);
INSERT INTO `s_dictionarierdetail` VALUES (20, 44, NULL, 1606710161119, 0, 0);

-- ----------------------------
-- Table structure for s_notice
-- ----------------------------
DROP TABLE IF EXISTS `s_notice`;
CREATE TABLE `s_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `isshow` int(11) NULL DEFAULT NULL,
  `notice_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `notice_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notice_route` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_notice
-- ----------------------------
INSERT INTO `s_notice` VALUES (1, 1607420942300, 1, 0, '国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅', '啊啊啊啊啊', 'http://192.168.31.95:8080/fileController/saveSysAnnouncement', 0);
INSERT INTO `s_notice` VALUES (2, 1607420957647, 1, 0, '国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅国内刚刚阿萨德法师法师法撒旦法撒的飞洒的飞洒地方阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅阿萨德发顺丰的爱上法师打发士大夫撒的发生的发生的飞洒发大师傅', '00111111', 'http://192.168.31.95:8080/fileController/saveSysAnnouncement', 0);
INSERT INTO `s_notice` VALUES (3, 1608015551906, 0, 0, 'dadwadwada', 'aa', '/upload/noticed0c40375-928e-4ede-a77b-ab92c0317a74aa.xls', NULL);
INSERT INTO `s_notice` VALUES (4, 1608015569282, 0, 0, '111', '111', '/upload/notice5fed6960-1351-4d19-a7a2-6c162cc3c4d3aa.xls', NULL);
INSERT INTO `s_notice` VALUES (5, 1608884396944, 0, 1, '公告内容内容内容', '名称1', '/upload/notice8438dd45-73f6-4d2f-82a3-fabb2ed98481新建 Microsoft Excel 2007 工作表.xlsx', 0);

-- ----------------------------
-- Table structure for s_role
-- ----------------------------
DROP TABLE IF EXISTS `s_role`;
CREATE TABLE `s_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_role
-- ----------------------------
INSERT INTO `s_role` VALUES (1, 0, '管理员', '管理员', '1,2,3,4,5,6,7,8,9,10', 1);
INSERT INTO `s_role` VALUES (2, 0, '小管理员', '小管理员', '000', 1);
INSERT INTO `s_role` VALUES (3, 0, 'string', 'string', NULL, 0);

-- ----------------------------
-- Table structure for s_rolepermission
-- ----------------------------
DROP TABLE IF EXISTS `s_rolepermission`;
CREATE TABLE `s_rolepermission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `role_power_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_rolepermission
-- ----------------------------
INSERT INTO `s_rolepermission` VALUES (1, 1, 1, 0);
INSERT INTO `s_rolepermission` VALUES (2, 1, 2, 0);
INSERT INTO `s_rolepermission` VALUES (3, 1, 3, 0);
INSERT INTO `s_rolepermission` VALUES (4, 1, 9, 0);
INSERT INTO `s_rolepermission` VALUES (5, 1, 10, 0);

-- ----------------------------
-- Table structure for s_rolepower
-- ----------------------------
DROP TABLE IF EXISTS `s_rolepower`;
CREATE TABLE `s_rolepower`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_power_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节点名字',
  `fid` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `role_code_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_node` int(11) NULL DEFAULT 1 COMMENT '是否为节点(0 是 1 不是 默认1)',
  `state` int(11) NULL DEFAULT 0 COMMENT '状态',
  `sys_type` int(11) NULL DEFAULT NULL COMMENT '系统类型 (1 mes 2erp)',
  `delete_no` int(11) NULL DEFAULT 0 COMMENT '删除否',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_rolepower
-- ----------------------------
INSERT INTO `s_rolepower` VALUES (1, '系统管理', 0, '/erp_system', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (2, '厂房信息', 1, '/erp_system/workshop', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (3, '系统设置', 1, '/erp_system/system', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (4, '员工管理', 3, '/erp_system/system/user', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (5, '部门管理', 3, '/erp_system/system/department', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (6, '职称管理', 3, '/erp_system/system/mespost', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (7, '班组管理', 3, '/erp_system/system/team', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (8, '角色管理', 3, '/erp_system/system/role', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (9, '员工管理-新增', 4, 'user_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (10, '员工管理-删除', 4, 'user_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (11, '员工管理-修改', 4, 'user_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (12, '员工管理-查询', 4, 'user_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (13, '部门管理-新增', 5, 'department_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (14, '部门管理-删除', 5, 'department_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (15, '部门管理-修改', 5, 'department_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (16, '部门管理-查询', 5, 'department_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (17, '职称管理-新增', 6, 'mespost_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (18, '职称管理-删除', 6, 'mespost_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (19, '职称管理-修改', 6, 'mespost_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (20, '职称管理-查询', 6, 'mespost_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (21, '班组管理_新增', 7, 'team_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (22, '班组管理_修改', 7, 'team_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (23, '班组管理_删除', 7, 'team_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (24, '班组管理_查询', 7, 'team_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (25, '角色管理_新增', 8, 'role_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (26, '角色管理_删除', 8, 'role_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (27, '角色管理_修改', 8, 'role_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (28, '角色管理_查询', 8, 'role_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (29, '字典表维护', 1, '/erp_system/system/dictionary', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (30, '字典表维护_新增', 29, 'dictionary_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (31, '字典表维护_删除', 29, 'dictionary_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (32, '字典表维护_修改', 29, 'dictionary_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (33, '字典表维护_查询', 29, 'dictionary_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (34, '系统日志', 1, '/erp_system/system/sysdiary', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (35, '系统日志_查询', 34, 'sysdiary_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (36, '系统日志_导出', 34, 'sysdiary_export', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (37, '客户关系管理', 0, '/erp_client', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (38, '供应商管理', 37, '/erp_client/supplier', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (39, '客户管理', 37, '/erp_client/client', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (40, '客户投诉管理', 37, '/erp_client/complaints', 1, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (41, '供应商管理_新增', 38, 'supplier_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (42, '供应商管理_修改', 38, 'supplier_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (43, '供应商管理_删除', 38, 'supplier_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (44, '供应商管理_查询', 38, 'supplier_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (45, '客户管理_新增', 39, 'client_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (46, '客户管理_删除', 39, 'client_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (47, '客户管理_修改', 39, 'client_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (48, '客户管理_查询', 39, 'client_find', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (49, '客户投诉管理_新增', 40, 'complaints_add', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (50, '客户投诉管理_删除', 40, 'complaints_delete', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (51, '客户投诉管理_修改', 40, 'complaints_update', 0, 0, 2, 0);
INSERT INTO `s_rolepower` VALUES (52, '客户投诉管理_查询', 40, 'complaints_find', 0, 0, 2, 0);

-- ----------------------------
-- Table structure for s_staff
-- ----------------------------
DROP TABLE IF EXISTS `s_staff`;
CREATE TABLE `s_staff`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `department_id` int(11) NULL DEFAULT NULL,
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `post_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_age` int(11) NULL DEFAULT NULL,
  `staff_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `workshop_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_staff
-- ----------------------------
INSERT INTO `s_staff` VALUES (1, 0, 1, 'string', 0, 'hhhh', 'f379eaf3c831b04de153469d1bec345e', 'string', '9', 'string', 0, '急吼吼', '123456', 1, 1, NULL);
INSERT INTO `s_staff` VALUES (2, 0, 1, '1604532521', 0, '114445566622456541', '4297f44b13955235245b2497399d7a93', '15766666666', '9', '我的家在东北', 0, '急吼吼', '666666', 0, 1, NULL);
INSERT INTO `s_staff` VALUES (3, 0, 4, '123123123', 1, '1231231', '2bbfa55dc58149cbdc795d293e8a5f7a', '123123123', '9', '312312', 21, '天天', 'YG0003', 1, 1, NULL);
INSERT INTO `s_staff` VALUES (4, 0, 6, '213123213', 1, '3123123', '6f106aee6475d00a193095639575632b', '13213123123', '10', '21312312', 21, '大家务必大霸王', 'YG0004', 1, 1, NULL);
INSERT INTO `s_staff` VALUES (5, 0, 6, '231', 1, '123', 'b3ddbc502e307665f346cbd6e52cc10d', '21312', '11', '123', 12312, '12312312', 'YG0005', 1, 1, NULL);
INSERT INTO `s_staff` VALUES (6, 0, 1, '1604532521', 0, '114445566622456541', 'f379eaf3c831b04de153469d1bec345e', '15766666666', '11', '我的家在东北', 0, '我是叭叭叭', '888888', 0, 1, NULL);

-- ----------------------------
-- Table structure for s_staffrole
-- ----------------------------
DROP TABLE IF EXISTS `s_staffrole`;
CREATE TABLE `s_staffrole`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_staffrole
-- ----------------------------
INSERT INTO `s_staffrole` VALUES (1, 1, 1);
INSERT INTO `s_staffrole` VALUES (2, 2, 1);
INSERT INTO `s_staffrole` VALUES (3, 1, 2);
INSERT INTO `s_staffrole` VALUES (4, 2, 2);
INSERT INTO `s_staffrole` VALUES (5, 2, 3);
INSERT INTO `s_staffrole` VALUES (6, 1, 4);
INSERT INTO `s_staffrole` VALUES (7, 2, 4);
INSERT INTO `s_staffrole` VALUES (8, 2, 5);
INSERT INTO `s_staffrole` VALUES (9, 1, 6);
INSERT INTO `s_staffrole` VALUES (10, 2, 6);

-- ----------------------------
-- Table structure for s_systemlog
-- ----------------------------
DROP TABLE IF EXISTS `s_systemlog`;
CREATE TABLE `s_systemlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` bigint(20) NOT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `login_state` int(11) NULL DEFAULT NULL,
  `operater_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operates` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `request_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `request_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `request_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `requesturl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 731 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of s_systemlog
-- ----------------------------
INSERT INTO `s_systemlog` VALUES (1, 1606125859883, 0, 1, '192.168.31.92', '登录', 1, 'POST', NULL, '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (2, 1606126525144, 0, 1, '192.168.31.92', '新增', 1, 'POST', NULL, '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (3, 1606126988650, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'org.apache.catalina.util.ParameterMap@100033d', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (4, 1606127362437, 0, 1, '192.168.31.92', '新增', 1, 'POST', '', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (5, 1606127474600, 0, 1, '192.168.31.92', '新增', 1, 'POST', '', '1000', '/SysController/addMesPost');
INSERT INTO `s_systemlog` VALUES (6, 1606127592030, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@f2eda0', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (7, 1606202655351, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1b7b67', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (8, 1606202701082, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@9c3f4b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (9, 1606202778488, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1064511', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (10, 1606203236734, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@c82d15', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (11, 1606203288023, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1e95022', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (12, 1606203352990, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1244c56', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (13, 1606205084084, 0, 1, '192.168.31.92', '登录1', 1, 'POST', 'java.util.Collections$3@92254', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (14, 1606209368710, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@4e08da', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (15, 1606211380276, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@11749d8', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (16, 1606211484992, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@b1dc5f', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (17, 1606211767669, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@824016', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (18, 1606211787321, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@d1c4a6', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (19, 1606212293171, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@103dd6d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (20, 1606274621918, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@ad8eab', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (21, 1606285788551, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1d40eef', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (22, 1606287911783, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@ad9743', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (23, 1606288489891, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@14ff85b', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (24, 1606296226450, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1e90124', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (25, 1606296586101, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1c93d28', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (26, 1606296825371, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@7a368f', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (27, 1606297033900, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@c4a248', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (28, 1606354874892, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1f77134', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (29, 1606358114331, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@164e1cf', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (30, 1606358138683, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1d88a09', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (31, 1606358216307, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@d82e10', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (32, 1606372064992, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@165ff60', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (33, 1606372228820, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1547749', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (34, 1606372337437, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1195348', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (35, 1606372344662, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19aec04', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (36, 1606372352813, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@13bd279', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (37, 1606372360625, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1149168', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (38, 1606372368637, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c28d7f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (39, 1606372371992, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@225eac', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (40, 1606372615324, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@195bd37', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (41, 1606372616671, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b4f30d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (42, 1606372617619, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@37f914', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (43, 1606372618298, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a6b963', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (44, 1606372618549, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1e84473', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (45, 1606372618751, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@684cfe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (46, 1606372618959, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1528d65', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (47, 1606372619117, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@135be3c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (48, 1606373207463, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ce5e92', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (49, 1606374167574, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ffd7a8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (50, 1606374249294, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b30ec6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (51, 1606374285925, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@51e5fb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (52, 1606374330421, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f67f84', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (53, 1606374367154, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a4cfe0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (54, 1606374427788, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b094cb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (55, 1606374706225, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e21889', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (56, 1606375118978, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18b61a4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (57, 1606375329576, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@136a50a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (58, 1606375620878, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1e45779', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (59, 1606375837964, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ff0335', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (60, 1606376071905, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a1cf92', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (61, 1606376084901, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7bc8ed', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (62, 1606376217076, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c53ef9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (63, 1606376246527, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2f8bba', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (64, 1606376271722, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@188f286', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (65, 1606376340385, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b9b2f4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (66, 1606376356574, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10fb85f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (67, 1606376385138, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1fce38c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (68, 1606376514503, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@11feb8b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (69, 1606376883404, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ad996f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (70, 1606376907106, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@3cf5ac', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (71, 1606377328277, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2a30f1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (72, 1606377349297, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@90cf54', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (73, 1606377456917, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a7c316', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (74, 1606377464302, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b30234', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (75, 1606377554747, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10260bf', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (76, 1606377591617, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1199310', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (77, 1606377879708, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1df3dfe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (78, 1606377882458, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@cb6e3f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (79, 1606377930349, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c1a03a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (80, 1606377951210, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@101558b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (81, 1606378028249, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@17092b7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (82, 1606378030343, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@134cf7d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (83, 1606378066500, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f8b1bc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (84, 1606378068057, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@191a5bf', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (85, 1606378092858, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18cab60', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (86, 1606378169650, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@173f915', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (87, 1606378180829, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d1e90e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (88, 1606378194492, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ea7ce9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (89, 1606378213954, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bfde26', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (90, 1606378252499, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d0d164', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (91, 1606378257453, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@140df45', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (92, 1606378377656, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1633b9b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (93, 1606378755182, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16c1333', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (94, 1606380045420, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f61002', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (95, 1606380066575, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@88f447', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (96, 1606380484966, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b5ba96', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (97, 1606380523657, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ca4255', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (98, 1606380641387, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b5a145', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (99, 1606380647632, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@9589c4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (100, 1606380714018, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@96f4a7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (101, 1606380769748, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15e61e8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (102, 1606381141814, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a73e8c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (103, 1606381192310, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fdffff', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (104, 1606381282013, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16b83ac', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (105, 1606381766857, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1838664', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (106, 1606381810557, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b5c8ed', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (107, 1606381895381, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d9df7c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (108, 1606381950483, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19be0ef', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (109, 1606381974278, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@11c2b2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (110, 1606382294631, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@192bdc2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (111, 1606382299501, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d874cd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (112, 1606382310690, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@69c2bd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (113, 1606382397622, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@190aff6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (114, 1606382408133, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@9c5ec7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (115, 1606382436897, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@847426', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (116, 1606382481046, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a2aa54', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (117, 1606382497937, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b34e4a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (118, 1606382549936, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@5f2c2e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (119, 1606382944518, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@79021', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (120, 1606382978681, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@17bd94', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (121, 1606382980172, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c2520a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (122, 1606382981771, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ec42c8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (123, 1606383130941, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d934c5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (124, 1606383169492, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@5874f6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (125, 1606383186396, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18bf005', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (126, 1606383295167, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@25e50e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (127, 1606383544582, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@13639e0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (128, 1606383548215, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c2f8c6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (129, 1606383564106, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ac6d5e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (130, 1606383800182, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15da9bb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (131, 1606383802773, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@191ee2c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (132, 1606383806594, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@17a9645', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (133, 1606383807760, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1071ea9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (134, 1606383952800, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@165f44d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (135, 1606383952885, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14e650b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (136, 1606383954001, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1626bbb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (137, 1606384130250, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@127b274', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (138, 1606384216996, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@395e33', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (139, 1606384218565, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ecdd08', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (140, 1606384291564, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1e7006f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (141, 1606384395076, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bcc783', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (142, 1606384523163, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@660764', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (143, 1606384626918, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@56dc47', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (144, 1606384628319, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f31786', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (145, 1606384634914, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ae6a03', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (146, 1606384637154, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@40bf58', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (147, 1606384724699, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@cdccca', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (148, 1606384725383, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a33c8f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (149, 1606384782068, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1112fa8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (150, 1606384794334, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d940a8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (151, 1606386226694, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@34f5fc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (152, 1606386246728, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7177f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (153, 1606386251179, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2608eb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (154, 1606386254756, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fe01d5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (155, 1606441791019, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1b9f59d', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (156, 1606441825056, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1837640', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (157, 1606441912911, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10bb1db', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (158, 1606441921247, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@135e3c1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (159, 1606441926715, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2f9ac6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (160, 1606441929161, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b6288a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (161, 1606441931030, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@456369', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (162, 1606441932541, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14a5f43', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (163, 1606441936259, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@79c542', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (164, 1606441938125, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e0ab36', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (165, 1606441941148, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@41e5b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (166, 1606442211733, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1110cfa', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (167, 1606442214370, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@9c51e1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (168, 1606443984597, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c03ab9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (169, 1606444562837, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@cdfa65', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (170, 1606444611810, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15fb5e6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (171, 1606444630068, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1e061c3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (172, 1606444652993, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1071ea9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (173, 1606444654645, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@6c3d09', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (174, 1606445198619, 0, 1, '192.168.31.221', '新增', 1, 'POST', 'java.util.Collections$3@1a51c81', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (175, 1606445217439, 0, 1, '192.168.31.221', '新增', 1, 'POST', 'java.util.Collections$3@bec40f', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (176, 1606445238445, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@176e70b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (177, 1606445361690, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f1a702', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (178, 1606445459244, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@94f3ae', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (179, 1606445460972, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@8a7d98', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (180, 1606445463705, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@69e0e4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (181, 1606445467106, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@908a63', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (182, 1606445469901, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1fee0e0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (183, 1606445471204, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1db61ee', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (184, 1606445474498, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@5c601a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (185, 1606445643412, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@bc878a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (186, 1606445646388, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@919360', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (187, 1606445647655, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c0c701', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (188, 1606445656173, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@156d633', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (189, 1606446419593, 0, 1, '192.168.31.221', '新增', 1, 'POST', 'java.util.Collections$3@10401c4', '1000', '/SysController/addMesPost');
INSERT INTO `s_systemlog` VALUES (190, 1606446419867, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@46c567', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (191, 1606446423975, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@182351a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (192, 1606449340068, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@183f1a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (193, 1606449370107, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1b172d7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (194, 1606449401796, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1370320', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (195, 1606449403747, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f64cb1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (196, 1606449408766, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d9fdd4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (197, 1606449410111, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@57948e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (198, 1606449410708, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1288797', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (199, 1606449415279, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@38a9eb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (200, 1606449422081, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7b2732', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (201, 1606449441372, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b67879', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (202, 1606449444863, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2a7be5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (203, 1606449454022, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c29c09', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (204, 1606449461120, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@17fea12', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (205, 1606449469663, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@622cae', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (206, 1606449544901, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b6babc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (207, 1606449551612, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18fccb5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (208, 1606449702564, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d9d5e2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (209, 1606449983373, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12175f0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (210, 1606450005323, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1718b95', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (211, 1606450018661, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1df7af1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (212, 1606456956739, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1cf61ed', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (213, 1606461049868, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12570a8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (214, 1606461051921, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@3ee3ce', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (215, 1606461054890, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c0453c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (216, 1606461056673, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ac2d44', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (217, 1606461058233, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16cf51b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (218, 1606461059175, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@113ccbe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (219, 1606461083744, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@27fec4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (220, 1606461087410, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1de6151', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (221, 1606461198492, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@145c289', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (222, 1606461218059, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1875f86', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (223, 1606461220920, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e551a2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (224, 1606461222796, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10ae56a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (225, 1606461295543, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ca3615', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (226, 1606461301110, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@151b7c1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (227, 1606461301628, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16fcc92', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (228, 1606461302124, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1094571', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (229, 1606461323847, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e55c1c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (230, 1606461326672, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@17b1a13', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (231, 1606461354037, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@dc232d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (232, 1606461357935, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ee78f5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (233, 1606461360302, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e01cb1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (234, 1606461443906, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c2a1fb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (235, 1606461551357, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b1ce77', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (236, 1606461555367, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1141936', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (237, 1606461888732, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b02b99', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (238, 1606461921578, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@120f144', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (239, 1606461933261, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a0dd7f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (240, 1606462071273, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@43887d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (241, 1606462081237, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f62fe5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (242, 1606462221730, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@db18ed', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (243, 1606462226031, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@38b1bb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (244, 1606462226582, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@60611d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (245, 1606462227822, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1706fb6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (246, 1606462229946, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16c1e02', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (247, 1606462230701, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@830494', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (248, 1606462231315, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@32dd35', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (249, 1606462232453, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1129604', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (250, 1606462233588, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@66ccff', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (251, 1606462234129, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ee9b55', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (252, 1606462235459, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12a6e82', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (253, 1606462236408, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d6883e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (254, 1606462237762, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@142c36e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (255, 1606462238812, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e2edd6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (256, 1606462239870, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10773a5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (257, 1606462241400, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bb158d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (258, 1606462242781, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@13357bd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (259, 1606462245618, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d0c094', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (260, 1606462264487, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f44efd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (261, 1606462265465, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d774f3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (262, 1606462266899, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@167753d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (263, 1606462269685, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c438b3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (264, 1606463340126, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ed904f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (265, 1606463342579, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f96c9a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (266, 1606463350438, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1775b5a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (267, 1606463352117, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ae32b9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (268, 1606463355028, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18a4860', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (269, 1606463356629, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b6babc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (270, 1606463382669, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@25315e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (271, 1606463385005, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@770629', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (272, 1606463515084, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d62843', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (273, 1606463526000, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@64c449', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (274, 1606463705198, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d741b0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (275, 1606463884330, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@93a2ed', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (276, 1606463907707, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c078ad', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (277, 1606463941393, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c6adcb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (278, 1606464281127, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@80746', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (279, 1606464303922, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f6d5f1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (280, 1606464304782, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a2cf5c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (281, 1606464305893, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7203f2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (282, 1606464312324, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1825cf8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (283, 1606464860779, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f56a2f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (284, 1606464861888, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19f7f33', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (285, 1606464866625, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a3d469', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (286, 1606464868181, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18321e5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (287, 1606464871326, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a1d489', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (288, 1606464872292, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@9339ab', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (289, 1606464877092, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@6ad779', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (290, 1606464907817, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@131764d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (291, 1606464986932, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d4d4bb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (292, 1606464989238, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f790b1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (293, 1606464990592, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1af506', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (294, 1606464991836, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19b7f34', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (295, 1606464993280, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a8e8b7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (296, 1606464994210, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@92fceb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (297, 1606464994976, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12f08e6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (298, 1606464995704, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@23c816', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (299, 1606465003753, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b6cbee', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (300, 1606465004767, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@744fe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (301, 1606465005784, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a7937f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (302, 1606465006976, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2700ef', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (303, 1606465024865, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bc40b6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (304, 1606465027408, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c5108f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (305, 1606465494347, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@141642b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (306, 1606465561745, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b8b4fb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (307, 1606465579131, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c7b5b1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (308, 1606465586526, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a78133', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (309, 1606465590145, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7e25b1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (310, 1606465756492, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12bb35', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (311, 1606465909988, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@143d08b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (312, 1606465917803, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fb2f67', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (313, 1606465918497, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1560990', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (314, 1606465967471, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ec3adf', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (315, 1606467260340, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4e0d95', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (316, 1606468801800, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14f587b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (317, 1606468803291, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7c8bfd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (318, 1606468807491, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@55ff27', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (319, 1606468809162, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4a7134', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (320, 1606468811134, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@63c71', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (321, 1606468864921, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@38f1f4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (322, 1606468868082, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1058451', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (323, 1606468869687, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@119555a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (324, 1606468870988, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@13f3f06', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (325, 1606468953216, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@106d1d9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (326, 1606469013746, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d8ae13', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (327, 1606469051481, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d66532', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (328, 1606469068537, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12209a0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (329, 1606469070088, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bb4d2f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (330, 1606469072202, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@17088e4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (331, 1606469072792, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@846d93', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (332, 1606469078709, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@411649', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (333, 1606469084197, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16ec0b8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (334, 1606469085769, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@8d0d50', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (335, 1606469087955, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@3f1713', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (336, 1606469088559, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b7a22d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (337, 1606469089283, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1389866', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (338, 1606469089775, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b8bc53', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (339, 1606469130017, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c94649', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (340, 1606469155773, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15bca81', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (341, 1606469158162, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7ca588', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (342, 1606469160477, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@bdb0e6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (343, 1606469162442, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@128e50d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (344, 1606469169115, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@160312f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (345, 1606469172177, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@167d161', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (346, 1606469174017, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ec5fd0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (347, 1606469230285, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@170c5e5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (348, 1606469233983, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14fe8b8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (349, 1606469235453, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@275a06', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (350, 1606469237705, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10897c0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (351, 1606469239271, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@11d6928', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (352, 1606469240939, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@13790d1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (353, 1606469242469, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@33a58e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (354, 1606469243844, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d534fc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (355, 1606469245252, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7c161f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (356, 1606469246722, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2dc7f0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (357, 1606469250870, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b749a0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (358, 1606469256131, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fdda3c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (359, 1606469258065, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c64783', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (360, 1606469259574, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@550c9a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (361, 1606469261202, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a5b818', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (362, 1606469262221, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@653987', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (363, 1606469272207, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1450614', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (364, 1606469274023, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@844a50', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (365, 1606469277251, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@11d23a6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (366, 1606469278622, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@89edd6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (367, 1606469378288, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@127bf89', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (368, 1606469384304, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fc86ad', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (369, 1606469386240, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@126ee97', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (370, 1606469388444, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16ebfc5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (371, 1606469390314, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10bca3b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (372, 1606469391910, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c59115', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (373, 1606469405876, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16a27af', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (374, 1606469458700, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2549d5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (375, 1606469463024, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4c0826', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (376, 1606469464250, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@abd9ec', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (377, 1606469465258, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@639069', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (378, 1606469467440, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@3a1bee', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (379, 1606469469286, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14c7137', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (380, 1606469471600, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10c566f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (381, 1606469473300, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1270480', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (382, 1606469743531, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b4991a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (383, 1606469743953, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10f5866', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (384, 1606469744495, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18bbc69', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (385, 1606469745342, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@174a869', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (386, 1606472384803, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b9445b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (387, 1606472386216, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d2c977', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (388, 1606472389696, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d5daa7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (389, 1606472423737, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ec6099', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (390, 1606472458252, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f47a06', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (391, 1606472480731, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c5b4b1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (392, 1606472485427, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4ee049', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (393, 1606472571816, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@da1a56', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (394, 1606472681068, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7a78be', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (395, 1606472705604, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@665066', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (396, 1606472727548, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@dbf99', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (397, 1606472729350, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d2abff', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (398, 1606472734958, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a39e17', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (399, 1606472778141, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@bceeb8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (400, 1606472836293, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e4c18', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (401, 1606472864583, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19661d0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (402, 1606472867251, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4314d5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (403, 1606472873812, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1161f6e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (404, 1606472876323, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a9d848', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (405, 1606472992887, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d67af6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (406, 1606472993528, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@23b2ac', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (407, 1606472995031, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@48a9ef', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (408, 1606472995634, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@866b65', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (409, 1606472996814, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@155f914', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (410, 1606473007095, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@55ab57', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (411, 1606473010063, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@846a54', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (412, 1606473015595, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bc75b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (413, 1606473031055, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a65747', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (414, 1606473060844, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15e5898', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (415, 1606473067807, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fdc24', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (416, 1606473074240, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@5a0081', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (417, 1606473079382, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@151d6b3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (418, 1606473083951, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d80e09', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (419, 1606473125744, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1fbebbe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (420, 1606473130240, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4ccc2b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (421, 1606473135392, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@176818f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (422, 1606473177855, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ecb566', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (423, 1606473283033, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@11f891', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (424, 1606473288699, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f2592f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (425, 1606473329648, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ab893', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (426, 1606699904079, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@14a67ec', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (427, 1606704525700, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1d12bed', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (428, 1606705188037, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@17203ca', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (429, 1606705377863, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@19c3202', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (430, 1606705727936, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1c0b7b2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (431, 1606705741559, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@172a3eb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (432, 1606706043823, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@118372', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (433, 1606706045904, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@13a7337', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (434, 1606706440539, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@17da96b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (435, 1606706679824, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@1fce677', '1000', '/SysController/addDepartment');
INSERT INTO `s_systemlog` VALUES (436, 1606706837342, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@1a3c924', '1000', '/SysController/addMesPost');
INSERT INTO `s_systemlog` VALUES (437, 1606715847843, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1419e12', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (438, 1606715996020, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1c4d869', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (439, 1606716010134, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@52d7b9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (440, 1606716023981, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@19a5881', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (441, 1606716025611, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@5bbd1b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (442, 1606716027391, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@329d45', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (443, 1606716047019, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@e5deb0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (444, 1606716048398, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@291ade', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (445, 1606716062639, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@77276c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (446, 1606716065120, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@4ef576', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (447, 1606716069499, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@b5485f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (448, 1606716089963, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@11e3097', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (449, 1606716091820, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@16e515c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (450, 1606716097531, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@12ae280', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (451, 1606716108040, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@12e3b6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (452, 1606716113280, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1344966', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (453, 1606716115073, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@6fb120', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (454, 1606716117393, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@61d0f3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (455, 1606716121645, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@599b63', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (456, 1606716122609, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@13a7ebe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (457, 1606716122744, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@36152a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (458, 1606716123913, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d907a4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (459, 1606716128711, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@170114', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (460, 1606716128910, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@143992c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (461, 1606716129402, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1d87c3b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (462, 1606716130101, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@e7efa6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (463, 1606716132233, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@260d20', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (464, 1606716134728, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@fb5129', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (465, 1606716135144, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@4eea98', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (466, 1606716203804, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18c28', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (467, 1606716205729, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@dd6603', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (468, 1606716215253, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@3f35b2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (469, 1606716226824, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14f61b8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (470, 1606716260796, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@2c16df', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (471, 1606716274670, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7caa14', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (472, 1606716275637, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ec4e1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (473, 1606716280586, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16e7b3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (474, 1606716299146, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@19020f1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (475, 1606716339591, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@14a381', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (476, 1606716339856, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@187fb4a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (477, 1606716341395, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ea09d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (478, 1606716344829, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1adc970', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (479, 1606716351374, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f15ce2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (480, 1606716369765, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@b43a10', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (481, 1606716376420, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@e89af5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (482, 1606716378390, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c2751b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (483, 1606716392474, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@117041f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (484, 1606716480946, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@57cdef', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (485, 1606716481028, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a83e9c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (486, 1606716578280, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d9b215', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (487, 1606716578669, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@145d47', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (488, 1606716586609, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@132c689', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (489, 1606716592498, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b77dd3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (490, 1606716651902, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19531', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (491, 1606716652054, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@182308b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (492, 1606716685717, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19b6862', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (493, 1606716701271, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bd74ef', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (494, 1606716749569, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@116bbb4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (495, 1606716776808, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@104fd79', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (496, 1606716780572, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10345d3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (497, 1606716791570, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@37a57c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (498, 1606716791787, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1bbe02a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (499, 1606716802807, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@545e11', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (500, 1606716808429, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c11e71', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (501, 1606716818410, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f65f83', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (502, 1606716825937, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1ecdd97', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (503, 1606716866702, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1df3e97', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (504, 1606716867369, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@12ea5b6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (505, 1606716874969, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@efe820', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (506, 1606716879255, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1da08b9', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (507, 1606716882820, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@deb0aa', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (508, 1606716885229, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@a32ea0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (509, 1606716886811, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@19cf60c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (510, 1606716892201, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f42bdd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (511, 1606716896330, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@18d4cee', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (512, 1606716900386, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@9baeda', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (513, 1606716904109, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@d7408a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (514, 1606716915052, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@15e0e3e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (515, 1606716923019, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@143ba0f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (516, 1606716974682, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15cd1cf', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (517, 1606716975115, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@111e4d6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (518, 1606716975578, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d40f7a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (519, 1606716975982, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b114d1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (520, 1606717184830, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16dd2c8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (521, 1606717190673, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1c1b7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (522, 1606717191931, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@84be87', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (523, 1606717194386, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1a45802', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (524, 1606717195781, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@10a9dee', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (525, 1606717482194, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1e5f5e3', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (526, 1606717518671, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@125677', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (527, 1606717528447, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@106283f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (528, 1606717532181, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1021ec3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (529, 1606717533022, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d6fc4e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (530, 1606717535601, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c87b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (531, 1606717536380, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@7c103b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (532, 1606717543725, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d5b9dd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (533, 1606717545042, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f6b272', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (534, 1606717546258, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d63a71', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (535, 1606717547963, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f6a863', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (536, 1606717548365, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@93a49b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (537, 1606717641739, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@12ac1c8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (538, 1606717775906, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@120c7d2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (539, 1606717776862, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@84b832', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (540, 1606717778456, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1e88cc3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (541, 1606717778771, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@155c48a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (542, 1606717782358, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1be9ec7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (543, 1606717784048, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@43929b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (544, 1606717786373, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1f11c15', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (545, 1606717787963, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d15242', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (546, 1606717789780, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a4fe17', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (547, 1606717856210, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15de501', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (548, 1606718014687, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d3dff6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (549, 1606718016822, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14fb864', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (550, 1606718037952, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@879fd7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (551, 1606718051934, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1b08735', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (552, 1606718055262, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@746f32', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (553, 1606720158345, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@17aef8f', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (554, 1606721530361, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d15dbb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (555, 1606721535079, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b95848', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (556, 1606721535894, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@15d2e5c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (557, 1606732213975, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@b8f004', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (558, 1606786729103, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@77c005', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (559, 1606788297097, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@cc9374', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (560, 1606788424218, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@16d6432', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (561, 1606789320411, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@6a958d', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (562, 1606806519861, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@17fb6c4', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (563, 1606808209884, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@6aaabf', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (564, 1606808211977, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@181f162', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (565, 1606808215453, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@195c53', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (566, 1606810420813, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@136b985', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (567, 1606814412309, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@13ac883', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (568, 1606814417808, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@783350', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (569, 1606814427072, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@4f5a0c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (570, 1606814439235, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@808962', '1000', '/SysController/addMesPost');
INSERT INTO `s_systemlog` VALUES (571, 1606814439454, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@89eb82', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (572, 1606814445344, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@19280f6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (573, 1606814446971, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1bb63f2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (574, 1606814461709, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@9cd513', '1000', '/SysController/addMesPost');
INSERT INTO `s_systemlog` VALUES (575, 1606814461927, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@49cff4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (576, 1606814494489, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1357c38', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (577, 1606814496957, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@13a221e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (578, 1606814498900, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1126641', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (579, 1606814503076, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1bcc897', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (580, 1606814505099, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@13cb0ea', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (581, 1606814507859, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@15722f0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (582, 1606814518740, 0, 1, '192.168.31.92', '新增', 1, 'POST', 'java.util.Collections$3@17e7eeb', '1000', '/SysController/addMesPost');
INSERT INTO `s_systemlog` VALUES (583, 1606814518982, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@7042cc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (584, 1606814524005, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1b5ed91', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (585, 1606814525738, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1db670e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (586, 1606814528516, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@116ff9f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (587, 1606814574753, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@131d3d3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (588, 1606818007968, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@490376', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (589, 1606873158280, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@19cd3fc', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (590, 1606873163172, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1bc1ca0', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (591, 1606873196513, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@bd90b8', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (592, 1606873224368, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@10caa49', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (593, 1606873256417, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@11a832b', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (594, 1606873394495, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1f3962d', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (595, 1606873399266, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@4de21b', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (596, 1606873405610, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@12d59c2', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (597, 1606877375868, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@134330', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (598, 1606877382698, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@c4042a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (599, 1606877388306, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d2988d', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (600, 1606877392152, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1927c94', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (601, 1606877394374, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@fbc77f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (602, 1606877438952, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1e8bf9c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (603, 1606877446997, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4067c4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (604, 1606877473573, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@763afc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (605, 1606877478668, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a142c1', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (606, 1606877479660, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@b71e95', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (607, 1606877483118, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@16aa46c', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (608, 1606877484003, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@3ddd4', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (609, 1606877491797, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1d9bdcb', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (610, 1606877493418, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@af098f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (611, 1606877498193, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2bfe', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (612, 1606877499478, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1215692', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (613, 1606878970687, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@5eaf57', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (614, 1606879469609, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@be3e41', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (615, 1606889977668, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1020028', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (616, 1606959433190, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1bfb025', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (617, 1606981106178, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1310549', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (618, 1606981111235, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@6fb772', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (619, 1606984582471, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1570621', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (620, 1606990914855, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1684f96', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (621, 1607045587756, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@2bea2b', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (622, 1607046184855, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@969071', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (623, 1607046602208, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@cebb5b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (624, 1607047500158, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@8e0d1b', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (625, 1606787433009, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@2d4f13', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (626, 1606794698863, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@832aa2', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (627, 1606811260230, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@30a94f', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (628, 1607570800018, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@a2d4d6', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (629, 1607580136673, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@cdf880', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (630, 1607580539034, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@90fb93', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (631, 1607580539475, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1de076f', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (632, 1607650536581, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1a50889', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (633, 1607680457967, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@e6fcaa', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (634, 1607736954939, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@88e66a', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (635, 1607909630045, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@4293a3', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (636, 1607910663346, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@889d2f', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (637, 1607911952930, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@350383', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (638, 1607935669709, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1d31b1e', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (639, 1607945194989, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@bc7761', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (640, 1607945312887, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@750360', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (641, 1607945379245, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@460bb3', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (642, 1607996706652, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1a6bce2', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (643, 1607996905919, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1451921', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (644, 1607997166074, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1c8b8cc', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (645, 1608007274272, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@102b458', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (646, 1608033515610, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@78269e', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (647, 1608083162205, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@9f3b09', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (648, 1608086388992, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@4f14a2', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (649, 1608107057371, 0, 1, '192.168.31.95', '登录', 2, 'POST', 'java.util.Collections$3@14743dd', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (650, 1608110339827, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@5950a1', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (651, 1608168716224, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@6d75bf', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (652, 1608198426577, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@15eb2aa', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (653, 1608254766230, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@13341c6', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (654, 1608264427748, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@fe03e6', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (655, 1608356620130, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@93bd73', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (656, 1608360861580, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1486d5a', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (657, 1608514549388, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1b1c118', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (658, 1608601240376, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@562447', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (659, 1608622822579, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@9afb3', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (660, 1608688526847, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@97d126', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (661, 1608715169905, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@102efe5', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (662, 1608773617061, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@350c3d', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (663, 1608774194415, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@68ffac', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (664, 1608792968855, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@d7e4d7', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (665, 1608803703752, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@a4b340', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (666, 1608807322967, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@695d44', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (667, 1608860092517, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1dbcf79', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (668, 1608866371776, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1b17744', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (669, 1608884015816, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@a9e978', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (670, 1608884638420, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@7dcb8e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (671, 1608884640156, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1065a7f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (672, 1608884645985, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1d4f860', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (673, 1608884648534, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@11f24c3', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (674, 1608884649740, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1a5bf32', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (675, 1608884650606, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@bff57b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (676, 1608884651367, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@199076', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (677, 1608884653725, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@f6d8cd', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (678, 1608884657133, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@dddf7f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (679, 1608884657900, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@10481ad', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (680, 1608884658400, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@141fd48', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (681, 1608884658762, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@99dec6', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (682, 1608884660936, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@77f460', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (683, 1608884661672, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1e9d021', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (684, 1608884662719, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@7afbad', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (685, 1608884663483, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@41641a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (686, 1608884695523, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@e79712', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (687, 1608885167922, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1cc21a6', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (688, 1608957713414, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1192c3a', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (689, 1608967177613, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@cfc425', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (690, 1608971433631, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@fe48c8', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (691, 1608974150699, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@11e1f73', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (692, 1608974171157, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@15d3de2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (693, 1608974175286, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1448f61', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (694, 1608974180197, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@94b597', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (695, 1608974181969, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1bea5ce', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (696, 1608974185271, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1c04c5b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (697, 1608974185945, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@5b609b', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (698, 1608974193578, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1a9d6e8', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (699, 1608974194857, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@f42f5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (700, 1608974195807, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@14b313f', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (701, 1608978534348, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@a6ef50', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (702, 1609033470580, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@10a675e', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (703, 1609050714198, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@151efe5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (704, 1609050781759, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1da96a1', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (705, 1609054585009, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@779580', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (706, 1609119034252, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@10ab61', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (707, 1609119115945, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@170eaba', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (708, 1609123171770, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@190770e', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (709, 1609123360518, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@109ae32', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (710, 1609123363050, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@13459ef', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (711, 1609123868023, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@a7269a', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (712, 1609137127152, 0, 1, '192.168.31.92', '查询', 1, 'POST', 'java.util.Collections$3@1551fb7', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (713, 1609139628138, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@1af4322', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (714, 1609139631267, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@bbfdf5', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (715, 1609139632197, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f84ca0', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (716, 1609139633002, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4f1f11', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (717, 1609139633678, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@f2e886', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (718, 1609139634863, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@4eebae', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (719, 1609143663340, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@11299e2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (720, 1609143668867, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@d851cf', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (721, 1609143669753, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@2faaa2', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (722, 1609143670389, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@ab6bbc', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (723, 1609143671060, 0, 1, '192.168.31.221', '查询', 1, 'POST', 'java.util.Collections$3@14958df', '1000', '/SysController/getAllSysByName');
INSERT INTO `s_systemlog` VALUES (724, 1609205595007, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@ee523e', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (725, 1609205614376, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@1dd62d7', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (726, 1609208100910, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@a36c0f', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (727, 1609292046114, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@55b2dd', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (728, 1609292073671, 0, 1, '192.168.31.92', '登录', 2, 'POST', 'java.util.Collections$3@1218b3b', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (729, 1609292491754, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@bf0453', '1000', '/userController/loginUser');
INSERT INTO `s_systemlog` VALUES (730, 1609292545446, 0, 1, '192.168.31.221', '登录', 2, 'POST', 'java.util.Collections$3@146144e', '1000', '/userController/loginUser');

-- ----------------------------
-- Table structure for smelting_products
-- ----------------------------
DROP TABLE IF EXISTS `smelting_products`;
CREATE TABLE `smelting_products`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pppid` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `gross_weight` decimal(19, 2) NULL DEFAULT NULL,
  `gx_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lossg` decimal(19, 2) NULL DEFAULT NULL,
  `net_weightg` decimal(19, 2) NULL DEFAULT NULL,
  `wastageg` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of smelting_products
-- ----------------------------
INSERT INTO `smelting_products` VALUES (1, 1, '2020-12-25 14:29:24', 0, 4.00, '熔炼', 1.00, 10.00, 3.00);
INSERT INTO `smelting_products` VALUES (2, 1, '2020-12-25 14:29:24', 0, 2.00, '熔炼', 5.00, 6.00, 2.00);
INSERT INTO `smelting_products` VALUES (3, 1, '2020-12-25 14:29:24', 0, 5.00, '熔炼', 2.00, 1.00, 4.00);
INSERT INTO `smelting_products` VALUES (4, 1, '2020-12-27 16:52:26', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (5, 2, '2020-12-27 17:54:17', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (6, 3, '2020-12-27 17:55:33', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (7, 4, '2020-12-27 18:05:07', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (8, 5, '2020-12-27 18:10:06', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (9, 6, '2020-12-27 18:12:41', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (10, 6, '2020-12-27 18:12:48', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (11, 7, '2020-12-27 18:18:29', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (12, 8, '2020-12-27 18:21:54', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (13, 9, '2020-12-28 09:45:40', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (14, 10, '2020-12-28 09:58:39', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (15, 11, '2020-12-28 09:59:55', 0, 1.00, NULL, 1.00, 1.00, 1.00);
INSERT INTO `smelting_products` VALUES (16, 11, '2020-12-28 10:14:30', 0, 3.00, NULL, 3.00, 3.00, 3.00);
INSERT INTO `smelting_products` VALUES (17, 12, '2020-12-28 10:21:10', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (18, 12, '2020-12-28 10:21:13', 0, 2.00, NULL, 2.00, 2.00, 2.00);
INSERT INTO `smelting_products` VALUES (19, 13, '2020-12-28 11:23:28', 0, 2.00, NULL, 12.00, 3.00, 2.00);
INSERT INTO `smelting_products` VALUES (20, 14, '2020-12-28 11:24:29', 0, 2.00, NULL, 5.00, 3.00, 4.00);
INSERT INTO `smelting_products` VALUES (21, 18, '2020-12-28 12:05:04', 0, 2.00, NULL, 6.00, 3.00, 4.00);
INSERT INTO `smelting_products` VALUES (22, 19, '2020-12-28 12:06:57', 0, 2.00, NULL, 6.00, 4.00, 5.00);

-- ----------------------------
-- Table structure for t_bobbin
-- ----------------------------
DROP TABLE IF EXISTS `t_bobbin`;
CREATE TABLE `t_bobbin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bobbin_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbintype_id` int(11) NULL DEFAULT NULL,
  `dictionarier_id` int(11) NULL DEFAULT NULL,
  `procedure_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT 0,
  `state` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_bobbin
-- ----------------------------
INSERT INTO `t_bobbin` VALUES (1, '型号型号', '线轴名称', 'XZ0001', 21, 2, 2, '我是备注我是备注', 1, 1);
INSERT INTO `t_bobbin` VALUES (2, '型号型号', '线轴名称', 'XZ-00041', 21, 1, 1, '我是备注我是备注2222222', 0, 0);
INSERT INTO `t_bobbin` VALUES (3, '模型名字', '线轴名字', '编号', 34, 2, 2, 'string', 0, 0);
INSERT INTO `t_bobbin` VALUES (4, 'aaa', 'aaa啊', 'XZ-00041', 16, 20, 38, '12', 0, 0);

-- ----------------------------
-- Table structure for t_cuffingcheck
-- ----------------------------
DROP TABLE IF EXISTS `t_cuffingcheck`;
CREATE TABLE `t_cuffingcheck`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `deleteno` int(11) NULL DEFAULT NULL,
  `judgeresult` int(11) NULL DEFAULT NULL,
  `mouldid` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staffid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_cuffingcheck
-- ----------------------------
INSERT INTO `t_cuffingcheck` VALUES (1, '2020-12-18 11:26:45', 0, 1, 2, '日常检查哈', 1);
INSERT INTO `t_cuffingcheck` VALUES (2, '2020-12-22 15:36:45', 0, 1, 2, '日常检查哈', 1);
INSERT INTO `t_cuffingcheck` VALUES (3, '2020-12-22 15:16:43', 1, 0, 6, '123', 1);
INSERT INTO `t_cuffingcheck` VALUES (4, '2020-12-22 15:18:20', 1, 0, 6, '12', 1);
INSERT INTO `t_cuffingcheck` VALUES (5, '2020-12-22 15:51:04', 0, 0, 3, '123', 1);
INSERT INTO `t_cuffingcheck` VALUES (6, '2020-12-22 17:56:11', 0, 0, 6, '111', 1);
INSERT INTO `t_cuffingcheck` VALUES (7, '2020-12-22 17:57:06', 0, 0, 6, '123', 1);
INSERT INTO `t_cuffingcheck` VALUES (8, '2020-12-22 17:57:28', 0, 0, 6, '11', 1);
INSERT INTO `t_cuffingcheck` VALUES (9, '2020-12-23 11:14:41', 1, 0, 3, '1111111112222222222', 1);
INSERT INTO `t_cuffingcheck` VALUES (10, '2020-12-26 15:40:53', 0, 0, 14, '检查过了是合格的', 1);

-- ----------------------------
-- Table structure for t_cuffingcheckdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_cuffingcheckdetail`;
CREATE TABLE `t_cuffingcheckdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuffing_check_id` int(11) NULL DEFAULT NULL,
  `deformation_no` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `entrance_no` int(11) NULL DEFAULT NULL,
  `export_no` int(11) NULL DEFAULT NULL,
  `mould_detail_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rsm_no` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_cuffingcheckdetail
-- ----------------------------
INSERT INTO `t_cuffingcheckdetail` VALUES (1, 1, 0, 0, 0, 0, 1, '备注1', 0);
INSERT INTO `t_cuffingcheckdetail` VALUES (2, 1, 0, 0, 0, 0, 2, '备注2', 0);
INSERT INTO `t_cuffingcheckdetail` VALUES (3, 2, 0, 0, 0, 1, 4, '备注4', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (4, 2, 1, 0, 1, 1, 3, '备注3', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (5, 3, 1, 0, 1, 1, NULL, '123', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (6, 3, 1, 0, 1, 1, NULL, '123', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (7, 4, 1, 0, 1, 1, NULL, '33', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (8, 4, 1, 0, 1, 1, NULL, '23', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (9, 5, 1, 0, 1, 1, 3, '12312', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (10, 5, 0, 0, 1, 0, 4, '', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (11, 6, 1, 0, 1, 1, 10, '23', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (12, 6, 0, 0, 0, 0, 11, '', 0);
INSERT INTO `t_cuffingcheckdetail` VALUES (13, 7, 1, 0, 1, 1, 10, '1', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (14, 7, 0, 0, 0, 0, 11, '', 0);
INSERT INTO `t_cuffingcheckdetail` VALUES (15, 8, 1, 0, 1, 1, 10, '1', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (16, 8, 0, 0, 0, 0, 11, '', 0);
INSERT INTO `t_cuffingcheckdetail` VALUES (17, 9, 1, 0, 1, 1, 3, '133', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (18, 9, 1, 0, 0, 1, 4, 'jjhbhiu', 0);
INSERT INTO `t_cuffingcheckdetail` VALUES (19, 10, 0, 0, 1, 1, 15, '合格1', 1);
INSERT INTO `t_cuffingcheckdetail` VALUES (20, 10, 1, 0, 1, 1, 16, '合格2', 1);

-- ----------------------------
-- Table structure for t_equipment
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment`;
CREATE TABLE `t_equipment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `equipment_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_type_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `check_no` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_equipment
-- ----------------------------
INSERT INTO `t_equipment` VALUES (1, 1, '这是设备模型', '这是设备名称', '这是设备编号 00-09-8766', 72, 0, 0);
INSERT INTO `t_equipment` VALUES (2, 1, '321', '123', '12-17-2020-141214', 74, 1, 0);
INSERT INTO `t_equipment` VALUES (3, 1, 'BHUBUH', 'YUGU', '12-18-2020-120129', 72, 0, 0);
INSERT INTO `t_equipment` VALUES (4, 1, '设备小型号', '设备3', '12-18-2020-140929', 74, 0, 0);
INSERT INTO `t_equipment` VALUES (5, 1, 'asd', 'aa', '12-18-2020-142556', 73, 1, 0);
INSERT INTO `t_equipment` VALUES (6, 0, 'asdfasdf', '粗拉专用1', '12-18-2020-165031', 73, 1, 0);
INSERT INTO `t_equipment` VALUES (7, 0, '阿是飞洒发', '粗拉专用2', '12-18-2020-165111', 73, 0, 0);
INSERT INTO `t_equipment` VALUES (8, 0, '啊撒范德萨发', '熔炼专用1', '12-18-2020-165130', 73, 0, 0);
INSERT INTO `t_equipment` VALUES (9, 0, '的说法范德萨', '熔炼专用2', '12-18-2020-165150', 73, 0, 0);
INSERT INTO `t_equipment` VALUES (10, 0, '阿萨德发生过的覆盖', '中拉专用1', '12-18-2020-165208', 74, 0, 0);
INSERT INTO `t_equipment` VALUES (11, 0, '好舒服', '细拉专用1', '12-18-2020-165228', 75, 0, 0);
INSERT INTO `t_equipment` VALUES (12, 0, '阿萨德法师法', '半成品专用1', '12-18-2020-170556', 76, 0, 0);
INSERT INTO `t_equipment` VALUES (13, 0, 'cpasda', '成品专用1', '12-18-2020-170619', 77, 0, 0);

-- ----------------------------
-- Table structure for t_equipmentcheckdetailrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_equipmentcheckdetailrecord`;
CREATE TABLE `t_equipmentcheckdetailrecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_check_record_id` int(11) NULL DEFAULT NULL,
  `equipment_overhaul_id` int(11) NULL DEFAULT NULL,
  `overhaul_state` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 97 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_equipmentcheckdetailrecord
-- ----------------------------
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (33, 9, 33, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (34, 9, 34, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (35, 9, 35, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (36, 9, 36, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (37, 10, 33, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (38, 10, 34, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (39, 10, 35, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (40, 10, 36, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (41, 11, 40, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (42, 11, 41, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (43, 11, 42, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (44, 11, 43, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (45, 11, 44, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (46, 12, 40, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (47, 12, 41, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (48, 12, 42, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (49, 12, 43, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (50, 12, 44, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (51, 26, 51, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (52, 26, 52, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (53, 26, 53, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (54, 13, 43, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (55, 13, 44, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (56, 15, 16, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (57, 15, 17, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (58, 15, 18, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (59, 16, 16, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (60, 16, 17, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (61, 16, 18, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (62, 17, 16, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (63, 17, 17, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (64, 17, 18, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (65, 18, 16, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (66, 18, 17, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (67, 18, 18, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (68, 19, 16, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (69, 19, 17, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (70, 19, 18, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (71, 20, 16, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (72, 20, 17, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (73, 20, 18, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (74, 21, 16, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (75, 21, 17, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (76, 21, 18, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (77, 22, 16, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (78, 22, 17, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (79, 22, 18, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (80, 23, 19, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (81, 23, 20, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (82, 23, 21, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (83, 24, 19, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (84, 24, 20, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (85, 24, 21, 3);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (86, 25, 19, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (87, 25, 20, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (88, 25, 21, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (89, 27, 22, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (90, 27, 23, 4);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (91, 28, 22, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (92, 28, 23, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (93, 29, 26, 1);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (94, 29, 27, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (95, 30, 26, 2);
INSERT INTO `t_equipmentcheckdetailrecord` VALUES (96, 30, 27, 2);

-- ----------------------------
-- Table structure for t_equipmentcheckrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_equipmentcheckrecord`;
CREATE TABLE `t_equipmentcheckrecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `frequency` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `user_time` int(11) NULL DEFAULT NULL,
  `equipment_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `check_day` int(11) NULL DEFAULT NULL,
  `check_month` int(11) NULL DEFAULT NULL,
  `check_year` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_equipmentcheckrecord
-- ----------------------------
INSERT INTO `t_equipmentcheckrecord` VALUES (9, '2020-12-01', 1, 1, 9, 1, '2020-12-17 12:00:06', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (10, '2020-12-02', 1, 1, 9, 1, '2020-12-17 12:30:27', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (11, '2020-11-02', 1, 1, 9, 1, '2020-12-17 14:17:40', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (12, '2020-11-03', 1, 1, 9, 1, '2020-12-17 14:17:47', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (13, '2020-11-04', 1, 1, 9, 1, '2020-12-17 14:17:51', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (15, '2020-12', 1, 1, 9, 1, '2020-12-21 11:38:59', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (16, '2020-12-21T03:41:23.340Z', 2, 1, NULL, 1, '2020-12-21 11:41:51', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (17, '2020-01', 2, 3, 12, 1, '2020-12-21 11:53:34', NULL, NULL, NULL);
INSERT INTO `t_equipmentcheckrecord` VALUES (18, '2020-12-28', 1, 1, 2, 1, '2020-12-27 14:47:47', 28, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (19, '2020-12-27', 1, 1, 8, 1, '2020-12-27 14:48:57', 27, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (20, '2020-12-27', 2, 1, 8, 1, '2020-12-27 15:12:52', 27, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (21, '2020-12-08', 1, 1, 5, 1, '2020-12-27 15:17:56', 8, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (22, '2020-12-27', 1, 1, 2, 6, '2020-12-27 16:14:15', 27, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (23, '2020-12-27', 1, 2, 5, 7, '2020-12-27 16:15:02', 27, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (24, '2020-12-27', 2, 1, 5, 7, '2020-12-27 16:20:23', 27, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (25, '2020-12-29', 1, 1, 8, 7, '2020-12-29 10:26:24', 29, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (26, '2020-12-29', 2, 1, 8, 7, '2020-12-29 10:26:36', 29, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (27, '2020-12-29', 1, 1, 8, 8, '2020-12-29 10:36:06', 29, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (28, '2020-12-28', 1, 1, 99, 8, '2020-12-29 15:45:24', 28, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (29, '2020-12-29', 1, 1, 80, 10, '2020-12-29 15:54:23', 29, 12, 2020);
INSERT INTO `t_equipmentcheckrecord` VALUES (30, '2020-12-29', 2, 1, 9, 10, '2020-12-29 15:54:57', 29, 12, 2020);

-- ----------------------------
-- Table structure for t_equipmentitems
-- ----------------------------
DROP TABLE IF EXISTS `t_equipmentitems`;
CREATE TABLE `t_equipmentitems`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `equipment_id` int(11) NULL DEFAULT NULL,
  `equipment_items` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `equipment_items_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_equipmentitems
-- ----------------------------
INSERT INTO `t_equipmentitems` VALUES (1, 0, 1, '检查润滑液位', NULL);
INSERT INTO `t_equipmentitems` VALUES (2, 0, 1, '运行检查磁力泵是否有异常阀门接口有无漏水及损坏', NULL);
INSERT INTO `t_equipmentitems` VALUES (3, 0, 1, '检查防护罩有无破损及螺丝松动', NULL);
INSERT INTO `t_equipmentitems` VALUES (4, 0, 1, '检查牵引轮光滑度有无划痕及破损', NULL);
INSERT INTO `t_equipmentitems` VALUES (5, 0, 1, '检查变压器输入电压表，输出电压表，指示灯是否正常', NULL);
INSERT INTO `t_equipmentitems` VALUES (6, 0, 2, 'FSF', NULL);
INSERT INTO `t_equipmentitems` VALUES (7, 0, 3, 'sdfxf', NULL);
INSERT INTO `t_equipmentitems` VALUES (8, 0, 3, 'ffgfg-l-olol-', NULL);
INSERT INTO `t_equipmentitems` VALUES (9, 0, 3, '分隔符', NULL);
INSERT INTO `t_equipmentitems` VALUES (10, 0, 3, '等下发短信多谢多谢', NULL);
INSERT INTO `t_equipmentitems` VALUES (11, 0, 4, '检查1', NULL);
INSERT INTO `t_equipmentitems` VALUES (12, 0, 4, '检查2', NULL);
INSERT INTO `t_equipmentitems` VALUES (13, 0, 4, '检查3', NULL);
INSERT INTO `t_equipmentitems` VALUES (14, 0, 5, 'adas', NULL);
INSERT INTO `t_equipmentitems` VALUES (15, 0, 5, 'ads', NULL);
INSERT INTO `t_equipmentitems` VALUES (16, 0, 6, '检查1', NULL);
INSERT INTO `t_equipmentitems` VALUES (17, 0, 6, '检查2', NULL);
INSERT INTO `t_equipmentitems` VALUES (18, 0, 6, '检查3', NULL);
INSERT INTO `t_equipmentitems` VALUES (19, 0, 7, '检查1', NULL);
INSERT INTO `t_equipmentitems` VALUES (20, 0, 7, '检查2', NULL);
INSERT INTO `t_equipmentitems` VALUES (21, 0, 7, '检查3', NULL);
INSERT INTO `t_equipmentitems` VALUES (22, 0, 8, '检查12', NULL);
INSERT INTO `t_equipmentitems` VALUES (23, 0, 8, '阿萨德法师', NULL);
INSERT INTO `t_equipmentitems` VALUES (24, 0, 9, '是德国队是', NULL);
INSERT INTO `t_equipmentitems` VALUES (25, 0, 9, '是的法国大使馆', NULL);
INSERT INTO `t_equipmentitems` VALUES (26, 0, 10, '阿萨德法国是大概', NULL);
INSERT INTO `t_equipmentitems` VALUES (27, 0, 10, '和规范', NULL);
INSERT INTO `t_equipmentitems` VALUES (28, 0, 11, '阿萨德飞', NULL);
INSERT INTO `t_equipmentitems` VALUES (29, 0, 11, '122222', NULL);
INSERT INTO `t_equipmentitems` VALUES (30, 0, 11, '1', NULL);
INSERT INTO `t_equipmentitems` VALUES (31, 0, 12, '阿萨德飞', NULL);
INSERT INTO `t_equipmentitems` VALUES (32, 0, 12, '股份的发挥', NULL);
INSERT INTO `t_equipmentitems` VALUES (33, 0, 13, '阿萨德法师法', NULL);
INSERT INTO `t_equipmentitems` VALUES (34, 0, 13, '的法国大使馆', NULL);

-- ----------------------------
-- Table structure for t_equipmentoverhaul
-- ----------------------------
DROP TABLE IF EXISTS `t_equipmentoverhaul`;
CREATE TABLE `t_equipmentoverhaul`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_id` int(255) NULL DEFAULT NULL,
  `equipment_item_id` int(255) NULL DEFAULT NULL,
  `equipment_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_equipmentoverhaul
-- ----------------------------
INSERT INTO `t_equipmentoverhaul` VALUES (26, 1, 1, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (27, 1, 2, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (28, 1, 3, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (29, 1, 4, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (33, 1, 1, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (34, 1, 2, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (35, 1, 3, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (36, 1, 4, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (40, 1, 1, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (41, 1, 2, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (42, 1, 3, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (43, 1, 4, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (44, 1, 5, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (45, 6, 16, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (46, 6, 17, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (47, 6, 18, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (48, 6, 16, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (49, 6, 17, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (50, 6, 18, '2020-10');
INSERT INTO `t_equipmentoverhaul` VALUES (54, 8, 22, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (55, 8, 23, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (57, 6, 16, '2020-06');
INSERT INTO `t_equipmentoverhaul` VALUES (58, 6, 17, '2020-06');
INSERT INTO `t_equipmentoverhaul` VALUES (59, 6, 18, '2020-06');
INSERT INTO `t_equipmentoverhaul` VALUES (60, 8, 22, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (61, 8, 23, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (63, 10, 26, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (64, 10, 27, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (66, 9, 24, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (67, 9, 25, '2020-12');
INSERT INTO `t_equipmentoverhaul` VALUES (69, 9, 24, '2020-11');
INSERT INTO `t_equipmentoverhaul` VALUES (70, 9, 25, '2020-11');

-- ----------------------------
-- Table structure for t_finishedproducecheck
-- ----------------------------
DROP TABLE IF EXISTS `t_finishedproducecheck`;
CREATE TABLE `t_finishedproducecheck`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `density` double NULL DEFAULT NULL,
  `lengthm` double NULL DEFAULT NULL,
  `measureddiam_um` double NULL DEFAULT NULL,
  `mould_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `weight_mg0` double NULL DEFAULT NULL,
  `weight_mg1` double NULL DEFAULT NULL,
  `weight_mg2` double NULL DEFAULT NULL,
  `weight_mg3` double NULL DEFAULT NULL,
  `weight_mg4` double NULL DEFAULT NULL,
  `weight_mg5` double NULL DEFAULT NULL,
  `weight_mg6` double NULL DEFAULT NULL,
  `weight_mg7` double NULL DEFAULT NULL,
  `weight_mg8` double NULL DEFAULT NULL,
  `weight_mg9` double NULL DEFAULT NULL,
  `weightavage_mg` double NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_finishedproducecheck
-- ----------------------------
INSERT INTO `t_finishedproducecheck` VALUES (1, '2020-12-22 17:20:57', 0, 19.32, 2, 12.576422614190374, 1, '这是备注', 1, 3, 4, 5, 6, 7, 8, 3, 3.5, 4, 4.5, 4.8);
INSERT INTO `t_finishedproducecheck` VALUES (2, '2020-12-18 15:24:37', 1, 20.32, 2, 3.45, 1, '我是备注', 1, 3.12, 4.23, 5, 6, 7, 8, 3, 3.5, 4, 4.5, 6.66);
INSERT INTO `t_finishedproducecheck` VALUES (3, '2020-12-22 17:47:07', 0, 1, 1, 35.682482627394194, 1, '这是备注', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_finishedproducecheck` VALUES (4, '2020-12-22 17:50:17', 1, 2, 2, 25.231325435401608, 1, 'awqwd', 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
INSERT INTO `t_finishedproducecheck` VALUES (5, '2020-12-26 15:42:16', 0, 12.56, 12, 2.906495268460474, 15, '新增检查信息', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `t_finishedproducecheck` VALUES (6, '2020-12-26 15:49:07', 1, 1, 1, NULL, 15, '', 1, 1, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_finishedproducecheck` VALUES (7, '2020-12-26 17:14:00', 0, 1, 1, 35.6824823231232, 16, '备注123', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- ----------------------------
-- Table structure for t_mould
-- ----------------------------
DROP TABLE IF EXISTS `t_mould`;
CREATE TABLE `t_mould`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuffingmould_nno` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `linetype_id` int(11) NULL DEFAULT NULL,
  `modelused_id` int(11) NULL DEFAULT NULL,
  `mould_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mould_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mould_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scrap_no` int(11) NULL DEFAULT NULL,
  `warn_racc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredraw_down` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredraw_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredraw_sum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredraw_up` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredrawg_down` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredrawg_pip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wiredrawg_up` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_mould
-- ----------------------------
INSERT INTO `t_mould` VALUES (1, 0, 1, 16, 8, '这是模具模型', '这是模具名称22', 'CT-12', '这是备注', 0, '2', '262.62', '1447-262.62um', '1800000', '1447', '2200000', '2000000', '1800000');
INSERT INTO `t_mould` VALUES (2, 1, 1, NULL, NULL, '这是模具模型', '这是模具名称', 'CP-7', NULL, 0, '220000', '262.62', '1447-262.62um', '1800000', '1447', '2200000', '2000000', '1800000');
INSERT INTO `t_mould` VALUES (3, 1, 1, 17, 8, '这是模具模型1', '这是模具名称1', '这是模具编号1', '这是备注1', 1, '220000', '262.62', '1447-262.62um', '1800000', '1447', '2200000', '2000000', '1800000');
INSERT INTO `t_mould` VALUES (4, 1, 1, 17, 10, '这是模具模型1', '这是模具名称1', 'CP-4', '这是备注1', 1, '220000', '262.62', '1447-262.62um', '1800000', '1447', '2200000', '2000000', '1800000');
INSERT INTO `t_mould` VALUES (5, 1, 1, 16, 6, 'DAS', 'AAA', 'CP-11', NULL, 0, '123', '2123', 'DASDA', '123312', '211', '21312', '2131', '123123');
INSERT INTO `t_mould` VALUES (6, 1, 0, NULL, 10, 'modeuibji', 'mc', 'CP-9', NULL, 0, '1222', '2', 'jhjhjjkljklk;lkl;kl;', '112313', '1', '3', '2', '1');
INSERT INTO `t_mould` VALUES (7, 0, 1, 16, 11, 'a', 'a', 'CT-12', NULL, 1, '1', '2', 'a', '2', '1', '2', '2', '2');
INSERT INTO `t_mould` VALUES (8, 0, 1, 16, 12, 'awd', 'daw', 'CT-12', NULL, 0, '1', NULL, 'ad', '1', '1', '1', '1', NULL);
INSERT INTO `t_mould` VALUES (9, 0, 1, 16, 12, '1', '1', 'CT-12', NULL, 0, '1', NULL, '1', '1', '1', '1', '1', NULL);
INSERT INTO `t_mould` VALUES (10, 0, 1, 17, 11, '3', '3', 'CT-12', NULL, 0, '3', NULL, '3', '3', '3', '3', '3', NULL);
INSERT INTO `t_mould` VALUES (11, 0, 1, 16, 11, '5', '5', 'CT-12', NULL, 0, '5', NULL, '5', '5', '5', '5', '5', NULL);
INSERT INTO `t_mould` VALUES (12, 0, 0, 16, 10, 'xh001', '成品模具', 'CT-12', NULL, 0, '12', NULL, '230000', '232323', '12000', '22000', '18000', NULL);
INSERT INTO `t_mould` VALUES (13, 1, 0, 16, 12, 'ct001', '成套名称', 'CP-12', NULL, 0, '20000', '12000', '0.1-0.02', '20000', '11000', '12000', '11000', '1000');
INSERT INTO `t_mould` VALUES (14, 1, 0, 18, 13, 'ct002', '模具成套的002', 'CP-14', NULL, 0, '2300', '35000', '12.023', '5600', '23000', '36000', '23000', '12000');
INSERT INTO `t_mould` VALUES (15, 0, 0, 17, 7, 'cula002', '粗拉模具', 'CT-16', NULL, 0, '220000', NULL, '23056', '0', '12000', '56000', '23000', NULL);
INSERT INTO `t_mould` VALUES (16, 0, 0, 17, 11, 'aa', 'aa', 'CT-16', NULL, 0, '2300000', NULL, '123', '2300000', '23000', '23000000', '23000000', NULL);
INSERT INTO `t_mould` VALUES (17, 0, 0, 18, 7, 'a', 'a', 'CT-16', NULL, 0, '1', NULL, '12', '1', '1', '1', '1', NULL);

-- ----------------------------
-- Table structure for t_moulddetail
-- ----------------------------
DROP TABLE IF EXISTS `t_moulddetail`;
CREATE TABLE `t_moulddetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `mould_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sonmould_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sonmould_spa_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_moulddetail
-- ----------------------------
INSERT INTO `t_moulddetail` VALUES (1, 0, 2, 'string', 'JZB1-1', '1500');
INSERT INTO `t_moulddetail` VALUES (2, 0, 2, 'string', 'JZB1-2', '1200');
INSERT INTO `t_moulddetail` VALUES (3, 0, 3, 'string', 'JZB2-1', '1500');
INSERT INTO `t_moulddetail` VALUES (4, 0, 3, 'string', 'JZB2-2', '1200');
INSERT INTO `t_moulddetail` VALUES (5, 0, 4, 'string', 'JZB2-1', '1500');
INSERT INTO `t_moulddetail` VALUES (6, 0, 4, 'string', 'JZB2-2', '1200');
INSERT INTO `t_moulddetail` VALUES (7, 0, 2, NULL, 'ASAS', 'ASSDASD');
INSERT INTO `t_moulddetail` VALUES (8, 0, 5, NULL, '123', 'ADS');
INSERT INTO `t_moulddetail` VALUES (9, 0, 5, NULL, 'ASD', 'ASD');
INSERT INTO `t_moulddetail` VALUES (10, 0, 6, NULL, '1', '2');
INSERT INTO `t_moulddetail` VALUES (11, 0, 6, NULL, '2', '3');
INSERT INTO `t_moulddetail` VALUES (12, 0, 5, NULL, 'DA', 'ADASDA');
INSERT INTO `t_moulddetail` VALUES (13, 0, 13, NULL, 'xh1001', '12000');
INSERT INTO `t_moulddetail` VALUES (14, 0, 13, NULL, 'xh1002', '23000');
INSERT INTO `t_moulddetail` VALUES (15, 0, 14, NULL, 'xh002', '3600');
INSERT INTO `t_moulddetail` VALUES (16, 0, 14, NULL, 'xh006', '3600');

-- ----------------------------
-- Table structure for t_printer
-- ----------------------------
DROP TABLE IF EXISTS `t_printer`;
CREATE TABLE `t_printer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `printer_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `printer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `printer_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `printer_type_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_printer
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `begin_id` int(11) NULL DEFAULT NULL,
  `bobbin_id` int(11) NULL DEFAULT NULL,
  `end_id` int(11) NULL DEFAULT NULL,
  `product_line_id` int(11) NULL DEFAULT NULL,
  `product_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_unit_id` int(11) NULL DEFAULT NULL,
  `product_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `delete_no` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, 1, 1, 1, 20, '型号1', '产品1', 'TP001', 1, '备注', 1, 1);
INSERT INTO `t_product` VALUES (2, 1, 1, 1, 21, '型号1', '产品1', 'TP002', 1, '备注', 0, 0);
INSERT INTO `t_product` VALUES (3, 0, 0, 0, 25, '产品模型名字', '产品名字', '我是n编号', 0, 'string', 1, 0);
INSERT INTO `t_product` VALUES (4, 2, 1, 0, 0, '产品模型名字', '产品名字', '1212121', 21, '我是备注啊啊啊啊啊', 0, 0);
INSERT INTO `t_product` VALUES (7, 32, 24, 34, 16, 'a', 'a', '', 20, 'a', 0, 0);
INSERT INTO `t_product` VALUES (8, 33, 25, 30, 16, '123', '123', 'TP0005', 21, '123', 0, 0);
INSERT INTO `t_product` VALUES (9, 32, 24, 31, 17, '1', '啊啊', 'TP0006', 21, '2', 0, 0);
INSERT INTO `t_product` VALUES (10, 29, 24, 30, 17, '0.00', '0.00', 'TP0007', 20, '0.00', 0, 0);
INSERT INTO `t_product` VALUES (11, 29, 24, 30, 17, '1', '1', 'TP0008', 20, '1', 0, 1);
INSERT INTO `t_product` VALUES (12, 29, 24, 30, 17, '1', '1', 'TP0009', 20, '1', 0, 0);
INSERT INTO `t_product` VALUES (13, 33, 25, 31, 17, '12', '名称', 'TP00010', 21, '阿达', 0, 0);

-- ----------------------------
-- Table structure for t_proloss
-- ----------------------------
DROP TABLE IF EXISTS `t_proloss`;
CREATE TABLE `t_proloss`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `los_srate_eend` decimal(19, 2) NULL DEFAULT NULL,
  `los_srate_start` decimal(19, 2) NULL DEFAULT NULL,
  `process_id` int(11) NULL DEFAULT NULL,
  `waste_rate_end` decimal(19, 2) NULL DEFAULT NULL,
  `waste_rate_start` decimal(19, 2) NULL DEFAULT NULL,
  `yield_rate_end` decimal(19, 2) NULL DEFAULT NULL,
  `yield_rate_start` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_proloss
-- ----------------------------

-- ----------------------------
-- Table structure for t_prostandard
-- ----------------------------
DROP TABLE IF EXISTS `t_prostandard`;
CREATE TABLE `t_prostandard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bl_eend` decimal(19, 8) NULL DEFAULT NULL,
  `bl_start` decimal(19, 8) NULL DEFAULT NULL,
  `coarse_end` decimal(19, 8) NULL DEFAULT NULL,
  `coarse_start` decimal(19, 8) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT 0,
  `diam_end` decimal(19, 8) NULL DEFAULT NULL,
  `diam_start` decimal(19, 8) NULL DEFAULT NULL,
  `el_end` decimal(19, 8) NULL DEFAULT NULL,
  `el_start` decimal(19, 8) NULL DEFAULT NULL,
  `mil_start` decimal(19, 8) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `semi_end` decimal(19, 8) NULL DEFAULT NULL,
  `semi_start` decimal(19, 8) NULL DEFAULT NULL,
  `um_start` decimal(19, 8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_prostandard
-- ----------------------------
INSERT INTO `t_prostandard` VALUES (1, 0.20000000, 0.20000000, 0.20000000, 0.20000000, 0, 0.20000000, 0.20000000, 0.30000000, 0.00000000, 0.20000000, 1, 0.20000000, 0.20000000, 0.20000000);
INSERT INTO `t_prostandard` VALUES (2, 0.20000000, 0.20000000, 0.20000000, 0.20000000, 0, 0.20000000, 0.20000000, 0.30000000, 0.50000000, 0.20000000, 1, 0.20000000, 0.20000000, 0.20000000);
INSERT INTO `t_prostandard` VALUES (3, 0.20000000, 0.20000000, 0.20000000, 0.20000000, 0, 0.20000000, 0.20000000, 0.30000000, 0.50000000, 0.20000000, 8, 0.20000000, 0.20000000, 0.20000000);
INSERT INTO `t_prostandard` VALUES (4, 0.20000000, 0.20000000, 0.20000000, 0.20000000, 0, 0.20000000, 0.20000000, 0.30000000, 0.50000000, 0.20000000, 8, 0.20000000, 0.20000000, 0.20000000);
INSERT INTO `t_prostandard` VALUES (5, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 3, 0.00000000, 0.00000000, 0.00000000);
INSERT INTO `t_prostandard` VALUES (6, 0.90000000, 0.10000000, 0.90000000, 0.30000000, 0, 0.80000000, 0.60000000, 0.80000000, 0.40000000, 0.30000000, 4, 2.00000000, 1.00000000, 1.00000000);
INSERT INTO `t_prostandard` VALUES (7, 0.90000000, 0.10000000, 0.90000000, 0.30000000, 0, 0.80000000, 0.60000000, 0.80000000, 0.40000000, 0.30000000, 4, 2.00000000, 1.00000000, 2.00000000);
INSERT INTO `t_prostandard` VALUES (8, 0.90000000, 0.10000000, 0.90000000, 0.30000000, 0, 0.80000000, 0.60000000, 0.80000000, 0.40000000, 0.30000000, 4, 2.00000000, 1.00000000, 1.00000000);
INSERT INTO `t_prostandard` VALUES (9, 0.90000000, 0.10000000, 0.90000000, 0.30000000, 0, 0.80000000, 0.60000000, 0.80000000, 0.40000000, 0.30000000, 4, 2.00000000, 1.00000000, 2.00000000);
INSERT INTO `t_prostandard` VALUES (12, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0, 0.00000000, 0.00000000, 0.00000000, 2.00000000, 0.07874015, 7, 0.00000000, 0.00000000, 2.00000000);
INSERT INTO `t_prostandard` VALUES (13, 2.00000000, 2.00000000, 2.00000000, 2.00000000, 0, 2.00000000, 2.00000000, 1.00000000, 1.00000000, 0.07874015, 8, 2.00000000, 2.00000000, 2.00000000);
INSERT INTO `t_prostandard` VALUES (14, 0.00000000, 0.00000000, 0.00000000, 1.00000000, 0, 0.00000000, 0.00000000, 1.00000000, 1.00000000, 0.03937007, 9, 0.00000000, 1.00000000, 1.00000000);
INSERT INTO `t_prostandard` VALUES (15, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0.07874015, 10, 0.00000000, 0.00000000, 2.00000000);
INSERT INTO `t_prostandard` VALUES (16, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0.03937007, 11, 0.00000000, 0.00000000, 1.00000000);
INSERT INTO `t_prostandard` VALUES (17, 1.00000000, 1.00000000, 1.00000000, 1.00000000, 0, 1.00000000, 1.00000000, 1.00000000, 1.00000000, 0.03937007, 12, 1.00000000, 1.00000000, 1.00000000);
INSERT INTO `t_prostandard` VALUES (18, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0.03937007, 13, 0.00000000, 0.00000000, 1.00000000);
INSERT INTO `t_prostandard` VALUES (19, 0.00000000, 0.00000000, 0.00000000, 0.00000000, 0, 0.00000000, 0.00000000, 0.00000000, 1.00000000, 0.00000000, 13, 0.00000000, 0.00000000, 0.00000000);

-- ----------------------------
-- Table structure for t_purchase
-- ----------------------------
DROP TABLE IF EXISTS `t_purchase`;
CREATE TABLE `t_purchase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `check_state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT 0,
  `finished_time` datetime NULL DEFAULT NULL,
  `order_state` int(11) NULL DEFAULT NULL,
  `paytype_id` int(11) NULL DEFAULT NULL,
  `purchase_order` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `purchasetype_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `warehousei_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_purchase
-- ----------------------------
INSERT INTO `t_purchase` VALUES (39, NULL, '2020-12-15 00:00:00', 7, 0, '2020-12-16 00:00:00', 0, 48, 'CG-0001', 54, '是的发生', 6, 3);
INSERT INTO `t_purchase` VALUES (40, NULL, '2020-12-15 00:00:00', 7, 0, '2020-12-16 00:00:00', 8, 49, 'CG-0002', 53, '暗示法撒范德萨发', 6, 3);
INSERT INTO `t_purchase` VALUES (41, NULL, '2020-12-15 00:00:00', 9, 0, '2020-12-16 00:00:00', 8, 49, 'CG-0003', 54, '撒旦飞洒发生', 6, 3);
INSERT INTO `t_purchase` VALUES (42, NULL, '2020-12-15 00:00:00', 7, 0, '2020-12-16 00:00:00', 9, 50, 'CG-0004', 54, 'f', 6, 3);
INSERT INTO `t_purchase` VALUES (43, NULL, '2020-12-15 00:00:00', 6, 0, '2020-12-16 00:00:00', 9, 48, 'CG-0005', 53, '12', 2, 2);
INSERT INTO `t_purchase` VALUES (44, NULL, '2020-12-25 00:00:00', 23, 0, '2020-12-26 00:00:00', 0, 49, 'CG-0006', 54, '备注', 6, 5);
INSERT INTO `t_purchase` VALUES (45, NULL, '2020-12-28 00:00:00', 23, 0, '2020-12-29 00:00:00', 2, 48, 'CG-0007', 54, '11', 2, 5);
INSERT INTO `t_purchase` VALUES (46, NULL, '2020-12-28 00:00:00', 23, 0, '2020-12-29 00:00:00', 1, 48, 'CG-0008', 54, 'qq', 6, 4);

-- ----------------------------
-- Table structure for t_purchasedetail
-- ----------------------------
DROP TABLE IF EXISTS `t_purchasedetail`;
CREATE TABLE `t_purchasedetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `purchase_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock_amount` int(11) NULL DEFAULT NULL,
  `stock_id` int(11) NULL DEFAULT NULL,
  `stock_sum` decimal(19, 0) NULL DEFAULT NULL,
  `stock_unit_price` decimal(19, 2) NULL DEFAULT NULL,
  `unit_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_purchasedetail
-- ----------------------------
INSERT INTO `t_purchasedetail` VALUES (110, 0, 39, '撒旦法萨芬撒', 2, 8, NULL, 1.00, 21);
INSERT INTO `t_purchasedetail` VALUES (111, 0, 40, '阿萨德法师法萨芬', 2, 8, NULL, 323.00, 21);
INSERT INTO `t_purchasedetail` VALUES (112, 0, 41, '阿士大夫撒放撒', 33, 8, NULL, 33.00, 20);
INSERT INTO `t_purchasedetail` VALUES (113, 0, 41, '打法是否撒发生', 222, 16, NULL, 2.00, 20);
INSERT INTO `t_purchasedetail` VALUES (114, 0, 42, '2', 1, 7, NULL, 1.00, 20);
INSERT INTO `t_purchasedetail` VALUES (115, 0, 43, '2', 1, 7, NULL, 1.00, 20);
INSERT INTO `t_purchasedetail` VALUES (116, 0, 43, '按时打算放', 12, 18, NULL, 100.00, 20);
INSERT INTO `t_purchasedetail` VALUES (117, 0, 44, '备注', 1, 8, NULL, 3.00, 21);
INSERT INTO `t_purchasedetail` VALUES (118, 0, 45, '1', 1, 13, NULL, 2.00, 20);
INSERT INTO `t_purchasedetail` VALUES (119, 0, 46, '3', 1, 13, NULL, 1.00, 20);

-- ----------------------------
-- Table structure for t_repairreport
-- ----------------------------
DROP TABLE IF EXISTS `t_repairreport`;
CREATE TABLE `t_repairreport`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `equipment_id` int(11) NULL DEFAULT NULL,
  `repair_report_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `delete_no` int(11) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_repairreport
-- ----------------------------
INSERT INTO `t_repairreport` VALUES (5, '2020-12-17 17:57:22', 2, 'BX-12-17-2020-175722', 0, 1);
INSERT INTO `t_repairreport` VALUES (6, '2020-12-17 18:01:01', 1, 'BX-12-17-2020-180101', 3, 0);
INSERT INTO `t_repairreport` VALUES (7, '2020-12-17 18:10:31', 1, 'BX-12-17-2020-181031', 0, 0);
INSERT INTO `t_repairreport` VALUES (8, '2020-12-18 12:07:25', 3, 'BX-12-18-2020-120725', 0, 0);
INSERT INTO `t_repairreport` VALUES (9, '2020-12-18 14:10:15', 4, 'BX-12-18-2020-141015', 3, 0);
INSERT INTO `t_repairreport` VALUES (10, '2020-12-18 14:12:29', 4, 'BX-12-18-2020-141229', 3, 1);
INSERT INTO `t_repairreport` VALUES (11, '2020-12-18 14:14:49', 4, 'BX-12-18-2020-141449', 0, 0);
INSERT INTO `t_repairreport` VALUES (12, '2020-12-18 14:26:18', 5, 'BX-12-18-2020-142618', 3, 1);
INSERT INTO `t_repairreport` VALUES (13, '2020-12-18 14:26:45', 5, 'BX-12-18-2020-142645', 3, 1);
INSERT INTO `t_repairreport` VALUES (14, '2020-12-18 14:34:31', 5, 'BX-12-18-2020-143431', 3, 0);
INSERT INTO `t_repairreport` VALUES (15, '2020-12-23 11:20:24', 13, 'BX-12-23-2020-112024', 3, 1);
INSERT INTO `t_repairreport` VALUES (16, '2020-12-23 11:23:54', 13, 'BX-12-23-2020-112354', 1, 0);
INSERT INTO `t_repairreport` VALUES (17, '2020-12-27 14:22:03', 6, 'BX-12-27-2020-142203', 3, 0);

-- ----------------------------
-- Table structure for t_saleorder
-- ----------------------------
DROP TABLE IF EXISTS `t_saleorder`;
CREATE TABLE `t_saleorder`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `customer_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `finished_time` datetime NULL DEFAULT NULL,
  `pay_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sale_order` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sale_type_id` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `transport_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehouse_id` int(11) NULL DEFAULT NULL,
  `order_state_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_saleorder
-- ----------------------------
INSERT INTO `t_saleorder` VALUES (30, '2020-12-14 00:00:00', 1, 0, '2020-12-15 00:00:00', '49', '阿士大夫撒', NULL, 'XS-0001', 54, 6, '阿萨德法师法', 3, 2);
INSERT INTO `t_saleorder` VALUES (31, '2020-12-14 00:00:00', 1, 0, '2020-12-16 00:00:00', '49', '阿萨德法师', NULL, 'XS-0002', 53, 6, '撒旦飞洒', 3, 8);
INSERT INTO `t_saleorder` VALUES (32, '2020-12-15 00:00:00', 3, 0, '2020-12-28 00:00:00', '50', '阿士大夫撒放撒法萨芬的的萨芬', NULL, 'XS-0003', 53, 6, '阿士大夫撒', 2, 4);
INSERT INTO `t_saleorder` VALUES (33, '2020-12-15 00:00:00', 1, 0, '2020-12-16 00:00:00', '48', '12是的飞洒发的飒飒的', NULL, 'XS-0004', 54, 6, '123', 2, 8);
INSERT INTO `t_saleorder` VALUES (34, '2020-12-23 00:00:00', 3, 0, '2020-12-30 00:00:00', '48', '就', NULL, 'XS-0005', 53, 6, '哈哈', 5, 3);
INSERT INTO `t_saleorder` VALUES (35, '2020-12-24 00:00:00', 3, 0, '2020-12-25 00:00:00', '49', 'QQ', NULL, 'XS-0006', 54, 2, 'QQ', 4, 3);

-- ----------------------------
-- Table structure for t_saleorderdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_saleorderdetail`;
CREATE TABLE `t_saleorderdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  `product_num` int(11) NULL DEFAULT NULL,
  `product_price` decimal(19, 2) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `saleorder_id` int(11) NULL DEFAULT NULL,
  `unit_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_saleorderdetail
-- ----------------------------
INSERT INTO `t_saleorderdetail` VALUES (43, 0, 4, 1, 22.00, '是非得失', 30, NULL);
INSERT INTO `t_saleorderdetail` VALUES (44, 0, 8, 3, 5.00, '阿士大夫撒', 30, NULL);
INSERT INTO `t_saleorderdetail` VALUES (45, 0, 4, 1, 2.00, '是的范德萨', 30, NULL);
INSERT INTO `t_saleorderdetail` VALUES (46, 0, 4, 12, 1.00, '1111', 31, NULL);
INSERT INTO `t_saleorderdetail` VALUES (47, 0, 4, 2, 2.00, '222', 32, NULL);
INSERT INTO `t_saleorderdetail` VALUES (48, 0, 8, 20, 0.39, ' 阿士大夫撒', 32, NULL);
INSERT INTO `t_saleorderdetail` VALUES (49, 0, 4, 1, 1.00, '是的发生分', 33, NULL);
INSERT INTO `t_saleorderdetail` VALUES (50, 0, 4, 32, 0.56, ' 暗示法萨芬撒放', 33, NULL);
INSERT INTO `t_saleorderdetail` VALUES (51, 0, 4, 4, 44.00, '4', 34, NULL);
INSERT INTO `t_saleorderdetail` VALUES (52, 0, 8, 44, 4.00, ' 4', 34, NULL);
INSERT INTO `t_saleorderdetail` VALUES (53, 0, 7, 1, 1.00, '1', 35, NULL);

-- ----------------------------
-- Table structure for t_standards
-- ----------------------------
DROP TABLE IF EXISTS `t_standards`;
CREATE TABLE `t_standards`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `material_id` int(11) NULL DEFAULT NULL,
  `material_type` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `standards` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bobbin_weight` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_standards
-- ----------------------------
INSERT INTO `t_standards` VALUES (1, 0, 0, 1, '我是规格的备注', '1g', NULL);
INSERT INTO `t_standards` VALUES (2, 0, 0, 1, '我是规格的备注222', '3g', NULL);
INSERT INTO `t_standards` VALUES (3, 0, 0, 1, '我是规格的备注333', '2g', NULL);
INSERT INTO `t_standards` VALUES (4, 0, 0, 1, '我是规格的备注', '1g', NULL);
INSERT INTO `t_standards` VALUES (5, 0, 0, 1, '我是规格的备注222', '3g', NULL);
INSERT INTO `t_standards` VALUES (6, 0, 0, 1, '我是规格的备注333', '2g', NULL);
INSERT INTO `t_standards` VALUES (7, 0, 3, 1, '我是规格的备注', '1g', NULL);
INSERT INTO `t_standards` VALUES (8, 0, 3, 1, '我是规格的备注222', '3g', NULL);
INSERT INTO `t_standards` VALUES (9, 0, 3, 1, '我是规格的备注333', '2g', NULL);
INSERT INTO `t_standards` VALUES (10, 0, 1, 2, 'string', '100m', NULL);
INSERT INTO `t_standards` VALUES (11, 0, 1, 2, 'string', '200m', NULL);
INSERT INTO `t_standards` VALUES (12, 0, 1, 2, 'string', '300m', NULL);
INSERT INTO `t_standards` VALUES (13, 0, 2, 2, 'string', '100m', NULL);
INSERT INTO `t_standards` VALUES (14, 0, 2, 2, 'string', '200m', NULL);
INSERT INTO `t_standards` VALUES (15, 0, 2, 2, 'string', '300m', NULL);
INSERT INTO `t_standards` VALUES (16, 0, 4, 1, 'string', 'string', NULL);
INSERT INTO `t_standards` VALUES (17, 0, 3, 2, 'string', 'string', NULL);
INSERT INTO `t_standards` VALUES (18, 0, 5, 1, NULL, '123123', NULL);
INSERT INTO `t_standards` VALUES (19, 0, 4, 2, '123123', '1312', NULL);
INSERT INTO `t_standards` VALUES (20, 0, 6, 1, NULL, '1231', NULL);
INSERT INTO `t_standards` VALUES (21, 0, 7, 1, NULL, 'qwe', NULL);
INSERT INTO `t_standards` VALUES (22, 0, 6, 1, NULL, 'hj', NULL);
INSERT INTO `t_standards` VALUES (23, 0, 6, 1, NULL, ' nlkklk', NULL);
INSERT INTO `t_standards` VALUES (24, 0, 6, 1, NULL, 'aszsaedsa', NULL);
INSERT INTO `t_standards` VALUES (25, 0, 8, 3, NULL, '213123', NULL);
INSERT INTO `t_standards` VALUES (26, 0, 2, 2, '阿士大夫撒放', '40000', NULL);
INSERT INTO `t_standards` VALUES (27, 1, 9, 3, NULL, '1', NULL);
INSERT INTO `t_standards` VALUES (28, 0, 9, 3, NULL, '2', NULL);
INSERT INTO `t_standards` VALUES (29, 0, 9, 3, NULL, '1', NULL);

-- ----------------------------
-- Table structure for t_stock
-- ----------------------------
DROP TABLE IF EXISTS `t_stock`;
CREATE TABLE `t_stock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `dictionarier_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `stock_model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock_remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock_type_id` int(11) NULL DEFAULT NULL,
  `material_type` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_stock
-- ----------------------------
INSERT INTO `t_stock` VALUES (1, 0, 21, 1, '我是原料型号1跟2', '我是原料1', 'YL0001', '备注备注', 44, NULL);
INSERT INTO `t_stock` VALUES (2, 0, 21, 0, '我是原料型号1跟2', '我是原料1', 'YL0002', '备注备注', 45, NULL);
INSERT INTO `t_stock` VALUES (3, 0, 22, 0, '我是原料型号1跟2', '我是原料1', 'YL00012', '备注备注', 46, NULL);
INSERT INTO `t_stock` VALUES (4, 0, 22, 0, '原材料模型', 'string', '我是原材料编码', 'string', 46, NULL);
INSERT INTO `t_stock` VALUES (5, 0, 22, 0, '31232', '12312312', '123123', '12312', 16, NULL);
INSERT INTO `t_stock` VALUES (6, 0, 20, 0, '13', 'aaajkl;l;l/', 'YL-00051', '123', 16, 1);
INSERT INTO `t_stock` VALUES (7, 0, 20, 1, 'qwe', 'qwe', 'YL-00061', 'ewq', 16, 1);
INSERT INTO `t_stock` VALUES (8, 1, 20, 0, '123', 'w', 'QT-00071', '3', 16, 2);
INSERT INTO `t_stock` VALUES (9, 0, 20, 0, 'qt09-032', '其他1', 'QT-00091', '这是个其他类型的。', 17, 2);

-- ----------------------------
-- Table structure for t_stockratio
-- ----------------------------
DROP TABLE IF EXISTS `t_stockratio`;
CREATE TABLE `t_stockratio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock_id` int(11) NULL DEFAULT NULL,
  `stock_number` int(11) NULL DEFAULT NULL,
  `stock_ratio_end` decimal(19, 2) NULL DEFAULT NULL,
  `stock_ratio_start` decimal(19, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_stockratio
-- ----------------------------

-- ----------------------------
-- Table structure for t_suit
-- ----------------------------
DROP TABLE IF EXISTS `t_suit`;
CREATE TABLE `t_suit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `constitute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `constitute_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `line_type_id` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope_application` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scrap_no` int(11) NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_suit
-- ----------------------------
INSERT INTO `t_suit` VALUES (1, '组合名称', 'MJ-12-19-2020-142128', 0, 16, '我是组合的备注', '拉丝描述范围比如：1447-262.62um', 0, 1);
INSERT INTO `t_suit` VALUES (2, '组合名称', 'MJ-12-19-2020-185619', 0, 16, '我是组合的备注', '拉丝描述范围比如：1447-262.62um', 1, 1);
INSERT INTO `t_suit` VALUES (3, '组合名称', 'MJ-12-23-2020-102121', 0, 16, '我是组合的备注', '拉丝描述范围比如：1447-262.62um', 1, 1);
INSERT INTO `t_suit` VALUES (4, '组合名称', 'MJ-12-23-2020-102335', 0, 16, '我是组合的备注', '拉丝描述范围比如：1447-262.62um', 1, 1);
INSERT INTO `t_suit` VALUES (5, '组合名称', 'MJ-12-23-2020-102456', 0, 16, '我是组合的备注', '拉丝描述范围比如：1447-262.62um', 0, 1);
INSERT INTO `t_suit` VALUES (6, 'aaaa', 'MJ-12-23-2020-110829', 0, 16, 'aaa', 'aaa', 0, 1);
INSERT INTO `t_suit` VALUES (7, '组合2', 'MJ-12-25-2020-122311', 0, 17, '我是备注', '阿萨德法师法师', 0, 1);
INSERT INTO `t_suit` VALUES (10, '啊', 'MJ-12-26-2020-151556', 0, 16, '2', '3', 0, 1);
INSERT INTO `t_suit` VALUES (11, 'new组合', 'MJ-12-26-2020-151702', 0, 17, 'new组合备注', '230000-3600000', 0, 1);
INSERT INTO `t_suit` VALUES (12, '啊啊', 'MJ-12-26-2020-152032', 0, 16, '啊', '啊', 0, 1);
INSERT INTO `t_suit` VALUES (13, 'dw', 'MJ-12-26-2020-152403', 0, 16, 'da', 'ddd', 0, 1);
INSERT INTO `t_suit` VALUES (14, '123', 'MJ-12-26-2020-153148', 0, 17, '12', '12423121', 0, 1);
INSERT INTO `t_suit` VALUES (15, 'a', 'MJ-12-26-2020-154330', 0, 16, 'a', 'a', 0, 1);
INSERT INTO `t_suit` VALUES (16, 'a', 'MJ-12-26-2020-155550', 0, 16, 'a', 'a', 0, 1);
INSERT INTO `t_suit` VALUES (17, 'qw', 'MJ-12-26-2020-160234', 0, 16, 'w', 'w', 1, 1);

-- ----------------------------
-- Table structure for t_suitdetail
-- ----------------------------
DROP TABLE IF EXISTS `t_suitdetail`;
CREATE TABLE `t_suitdetail`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `composite_type_id` int(11) NULL DEFAULT NULL,
  `delete_no` int(11) NULL DEFAULT NULL,
  `mould_id` int(11) NULL DEFAULT NULL,
  `mould_type` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `suit_id` int(11) NULL DEFAULT NULL,
  `mould_detail_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_suitdetail
-- ----------------------------
INSERT INTO `t_suitdetail` VALUES (1, 1, 0, NULL, 2, NULL, 4, '1,2');
INSERT INTO `t_suitdetail` VALUES (2, 1, 0, NULL, 0, NULL, 4, NULL);
INSERT INTO `t_suitdetail` VALUES (3, 1, 0, 2, 2, '我是备注', 2, '1,2');
INSERT INTO `t_suitdetail` VALUES (4, 1, 0, 1, 0, '我是粗拉的备注', 2, '');
INSERT INTO `t_suitdetail` VALUES (5, 1, 0, NULL, 2, NULL, 4, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (6, 1, 0, NULL, 1, NULL, 4, '');
INSERT INTO `t_suitdetail` VALUES (7, 2, 0, NULL, 2, NULL, 4, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (8, 1, 0, NULL, 2, NULL, 4, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (9, 1, 0, 3, 2, NULL, 5, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (10, 1, 0, NULL, 1, NULL, 5, '');
INSERT INTO `t_suitdetail` VALUES (11, 1, 0, NULL, 2, NULL, 6, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (12, 2, 0, NULL, 2, NULL, 6, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (13, 1, 0, 3, 2, NULL, 7, 'JZB2-1,JZB2-2,');
INSERT INTO `t_suitdetail` VALUES (14, 1, 0, NULL, 0, NULL, 10, '');
INSERT INTO `t_suitdetail` VALUES (15, 2, 0, NULL, 0, NULL, 10, '');
INSERT INTO `t_suitdetail` VALUES (16, 3, 0, NULL, 0, NULL, 10, '');
INSERT INTO `t_suitdetail` VALUES (17, 4, 0, NULL, 0, NULL, 10, '');
INSERT INTO `t_suitdetail` VALUES (18, 1, 0, NULL, 0, NULL, 11, '');
INSERT INTO `t_suitdetail` VALUES (19, 1, 0, NULL, 1, NULL, 11, '');
INSERT INTO `t_suitdetail` VALUES (20, 2, 0, 6, 2, NULL, 11, '1,2,');
INSERT INTO `t_suitdetail` VALUES (21, 2, 0, NULL, 1, NULL, 11, '');
INSERT INTO `t_suitdetail` VALUES (22, 2, 0, NULL, 0, NULL, 11, '');
INSERT INTO `t_suitdetail` VALUES (23, 3, 0, 13, 2, NULL, 11, 'xh1001,xh1002,');
INSERT INTO `t_suitdetail` VALUES (24, 4, 0, NULL, 0, NULL, 11, '');
INSERT INTO `t_suitdetail` VALUES (25, 4, 0, 14, 2, NULL, 11, 'xh002,xh006,');
INSERT INTO `t_suitdetail` VALUES (26, 1, 0, NULL, 1, NULL, 12, '');
INSERT INTO `t_suitdetail` VALUES (27, 2, 0, 6, 2, NULL, 12, '10,');
INSERT INTO `t_suitdetail` VALUES (28, 3, 0, 13, 2, NULL, 12, '13,');
INSERT INTO `t_suitdetail` VALUES (29, 4, 0, 14, 2, NULL, 12, '15,');
INSERT INTO `t_suitdetail` VALUES (30, 1, 0, NULL, 1, NULL, 13, '');
INSERT INTO `t_suitdetail` VALUES (31, 2, 0, NULL, 1, NULL, 13, '');
INSERT INTO `t_suitdetail` VALUES (32, 3, 0, NULL, 2, NULL, 13, '13,');
INSERT INTO `t_suitdetail` VALUES (33, 4, 0, 14, 2, NULL, 13, '15,');
INSERT INTO `t_suitdetail` VALUES (34, 4, 0, 14, 2, NULL, 13, '15,16,');
INSERT INTO `t_suitdetail` VALUES (35, 1, 0, NULL, 0, NULL, 14, '');
INSERT INTO `t_suitdetail` VALUES (36, 1, 0, NULL, 1, NULL, 14, '');
INSERT INTO `t_suitdetail` VALUES (37, 2, 0, NULL, 0, NULL, 14, '');
INSERT INTO `t_suitdetail` VALUES (38, 2, 0, 6, 2, NULL, 14, '10,');
INSERT INTO `t_suitdetail` VALUES (39, 3, 0, 13, 2, NULL, 14, '13,');
INSERT INTO `t_suitdetail` VALUES (40, 4, 0, NULL, 0, NULL, 14, '');
INSERT INTO `t_suitdetail` VALUES (41, 4, 0, 14, 2, NULL, 14, '15,16,');
INSERT INTO `t_suitdetail` VALUES (42, 2, 0, NULL, 1, NULL, 15, '12');
INSERT INTO `t_suitdetail` VALUES (43, 2, 0, 12, 1, NULL, 16, '');
INSERT INTO `t_suitdetail` VALUES (44, 1, 0, 15, 1, NULL, 17, '');
INSERT INTO `t_suitdetail` VALUES (45, 1, 0, 17, 1, NULL, 17, '');
INSERT INTO `t_suitdetail` VALUES (46, 2, 0, 12, 1, NULL, 17, '');
INSERT INTO `t_suitdetail` VALUES (47, 3, 0, 13, 2, NULL, 17, '13,');

-- ----------------------------
-- Table structure for t_team
-- ----------------------------
DROP TABLE IF EXISTS `t_team`;
CREATE TABLE `t_team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT NULL,
  `frequency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL,
  `team_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `team_staff_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_team
-- ----------------------------
INSERT INTO `t_team` VALUES (1, 0, '1', '备注', 1, 1, 'a组', '1,2,');
INSERT INTO `t_team` VALUES (2, 0, '1,2', 'a', 4, 0, 'aa', 'YG0004,');
INSERT INTO `t_team` VALUES (3, 0, 'string', 'string', 0, 0, 'string', 'string');
INSERT INTO `t_team` VALUES (4, 0, '1,2', 'daw', 1, 1, 'awda', '123456,');

-- ----------------------------
-- Table structure for t_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `t_warehouse`;
CREATE TABLE `t_warehouse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delete_no` int(11) NULL DEFAULT 0,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `staff_id` int(11) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT 0,
  `warehouse_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `warehousen_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_warehouse
-- ----------------------------
INSERT INTO `t_warehouse` VALUES (1, 1, '我是仓库一号', 1, 1, 'CK0001', '仓库一号');
INSERT INTO `t_warehouse` VALUES (2, 1, '我是仓库二号', 1, 0, 'CK0002', '仓库二号');
INSERT INTO `t_warehouse` VALUES (3, 0, '我是备注备注', 6, 1, 'CK0001', '仓库2');
INSERT INTO `t_warehouse` VALUES (4, 0, '我的娃啊', 6, 0, 'CK-0004', '仓库3号');
INSERT INTO `t_warehouse` VALUES (5, 0, '', NULL, 0, 'CK-0005', '');
INSERT INTO `t_warehouse` VALUES (6, 0, '', NULL, 0, 'CK-0006', '');
INSERT INTO `t_warehouse` VALUES (7, 0, '', 6, 0, 'CK-0007', 'aaa');
INSERT INTO `t_warehouse` VALUES (8, 0, '3', 6, 1, 'CK-0008', '123');

-- ----------------------------
-- Table structure for workshop
-- ----------------------------
DROP TABLE IF EXISTS `workshop`;
CREATE TABLE `workshop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `workshop_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workshop_contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workshop_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workshop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workshop_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of workshop
-- ----------------------------
INSERT INTO `workshop` VALUES (1, '在东北', '66666666', '图片路径', '一号厂房', '我是备注一号厂房的');
INSERT INTO `workshop` VALUES (2, '厂房地址', '手机联系', '地址httpd', '我是大厂房', '我是大厂房我是大厂房我是大厂房我是大厂房');
INSERT INTO `workshop` VALUES (3, 'dasdas', 'asdasdas', '/upload/0c8aae96-6864-40ae-8890-8e3f5735cd6f.jpg', 'dadas', 'asdasd');
INSERT INTO `workshop` VALUES (4, 'a', 'a', '/upload/29224da6-9a19-46b2-8575-d17803481e95.jpg', 'a', 'a');
INSERT INTO `workshop` VALUES (5, '厂房地址地址', '15765220', '/upload/754edf0c-ab72-48cb-a1ec-48411ad58696.jpg', '这个厂房是在哪里的', '这是介绍');

SET FOREIGN_KEY_CHECKS = 1;
