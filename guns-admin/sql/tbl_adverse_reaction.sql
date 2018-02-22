
USE guns;

DROP TABLE IF EXISTS `tbl_adverse_reaction`;

CREATE TABLE `tbl_adverse_reaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `patient_number` varchar(32) not NULL COMMENT '住院号',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `radiotherapy_count` int(11) DEFAULT NULL COMMENT '放疗次数',
  `chemotherapy_count` int(11) DEFAULT NULL COMMENT '化疗次数',
  `weight` DECIMAL(5,2) DEFAULT NULL COMMENT '体重，单位kg',
  `Dietary_status` int(11) DEFAULT NULL COMMENT '目前饮食：○ 1 正常饮食  ○ 2 半流质  ○ 3 流质  ○ 4 完全梗阻',
  `weak_status` int(11) DEFAULT NULL COMMENT '乏力  ○ 0 无  ○ 1 休息后可缓解  ○ 2 休息后不能缓解，影响日常生活  ○ 3 生活无法自理',
  `nausea_status` int(11) DEFAULT NULL COMMENT '恶心  ○ 0 无  ○ 1 食欲降低但进食量不变  ○ 2 进食量减少   ○ 3 静脉或鼻饲营养 ',
  `Vomit_status` int(11) DEFAULT NULL COMMENT '呕吐  ○ 0 无  ○ 1 每天 1-2 次      ○ 2 每天 3-5 次       ○ 3 每天 6 次及以上 ',
  `diarrhea_status` int(11) DEFAULT NULL COMMENT '腹泻  ○ 0 无  ○ 1 与治疗前相比增加少于 4 次/天   ○ 2 4-6 次/天  ○ 3 7 次/天及以上',
  `constipation_status` int(11) DEFAULT NULL COMMENT '便秘  ○ 0 无  ○ 1 偶尔需用药物    ○ 2 持续使用药物     ○ 3 需手工疏通 ',
  `Muscle_joint_pain_status` int(11) DEFAULT NULL COMMENT '肌肉关节痛  ○ 0 无  ○ 1 轻微，无须处理  ○ 2 影响日常生活     ○ 3 生活无法自理 ',
  `nervous_system_status` int(11) DEFAULT NULL COMMENT '神经系统  ○ 0 无  ○ 1 手脚麻木，不影响日常生活  ○ 2 影响日常生活  ○ 3 生活无法自理 ',
  `Alopecia_status` int(11) DEFAULT NULL COMMENT '脱发  ○ 0 无  ○ 1 较治疗前头发减少少于一半  ○ 2 头发减少大于一半或需佩戴假发',
  `fever_status` int(11) DEFAULT NULL COMMENT '发热 ○ 0 无  ○ 1 38.0－39.0 度             ○ 2 39.1-40.0 度   ○ 3 高于 40.0 度小于 24 小时    ○ 4 高于 40.0 度大于 24 小时 ',
  `cough_status` int(11) DEFAULT NULL COMMENT '咳嗽 ○ 0 无  ○ 1 症状轻微，仅需非处方药（如甘草口服液）          ○ 2 影响日常生活，需处方药（如可待因）      ○ 3 生活无法自理 ',
  `skin_status` int(11) DEFAULT NULL COMMENT '放射性 皮肤损伤 ○ 0 无  ○ 1 点状红斑或干性脱皮  ○ 2 片状红斑或小块湿性脱皮或水肿       ○ 3 大片湿性脱皮        ○ 4 溃疡、出血 ',
  `Hiccup_status` int(11) DEFAULT NULL COMMENT '打嗝  ○ 0 无  ○ 1 症状轻微不需药物  ○ 2 影响日常生活，需要药物  ○ 3 影响睡眠 ',
  `Oral_mucositis_status` int(11) DEFAULT NULL COMMENT '口腔黏膜炎  ○ 0 无  ○ 1 稍有疼痛  ○ 2 因口腔黏膜需要调整饮食  ○ 3 因口腔黏膜进食困难',
  `Hoarseness_status` int(11) DEFAULT NULL COMMENT '声嘶  ○ 0 无  ○ 1 话语不影响理解   ○ 2 需偶尔重复   ○ 3 症状持续且话语难以理解 ',
  `hearing_status` int(11) DEFAULT NULL COMMENT '听力损伤  ○ 0 无  ○ 1 感觉听力下降，无须处理    ○ 2 需用助听器 ',
  `Dizzy_status` int(11) DEFAULT NULL COMMENT '头晕  ○ 0 无  ○ 1 轻微，无须处理   ○ 2 影响日常生活   ○ 3 生活无法自理 ',
  `headache_status` int(11) DEFAULT NULL COMMENT '头痛  ○ 0 无  ○ 1 轻微，无须处理   ○ 2 影响日常生活   ○ 3 生活无法自理 ',
  `pneumonia_status` int(11) DEFAULT NULL COMMENT '肺炎 ○ 0 无  ○ 1 轻度干咳，无需处理或仅需口服药 ○ 2 持续性咳嗽需静脉用药（激素）  ○ 3 止咳药无作用或休息时呼吸困难、需吸氧        ○ 4 需呼吸机 ',
  `Esophagitis_status` int(11) DEFAULT NULL COMMENT '进食痛   ○ 0 无  ○ 1 疼痛轻微，无须处理或仅需口服药  ○ 2 疼痛中等，需静脉输液治疗  ○ 3 疼痛严重，需鼻饲（经管道进食）或肠外营养    ○ 4 食管穿孔 ',
  `other_statuses_desc` varchar(1000) DEFAULT NULL COMMENT '其他症状，请在下面详细描述：',

  `createtime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '填表日期',
  `updatetime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',

  `create_user` varchar(45) DEFAULT NULL COMMENT '创建者',
  `version` int(11) DEFAULT NULL COMMENT '保留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='治疗过程中不良反应记录（病人填表）';

