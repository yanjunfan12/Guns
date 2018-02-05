
USE guns;

DROP TABLE IF EXISTS `tbl_adverse_reaction_photo`;

CREATE TABLE `tbl_adverse_reaction_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `adverse_reaction_id` int(11) NOT NULL COMMENT '治疗过程中不良反应记录（病人填表）主键id',
  `photo_path` varchar(245) NOT NULL COMMENT '图片路径',

  `createtime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '填表日期',
  `updatetime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',

  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='治疗过程中不良反应记录（病人填表）的图片附件';
