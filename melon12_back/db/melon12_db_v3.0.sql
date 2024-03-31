-- ----------------------------
-- Table structure for t_Provence_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Provence_Table`;
CREATE TABLE `t_Provence_Table` (
  `id` integer(10) not null auto_increment,
  `provence` varchar(10) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_Market_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Market_Table`;
CREATE TABLE `t_Market_Table` (
  `id` integer(10) not null auto_increment,
  `id_provence` integer(10) not null,
  `market` varchar(20) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_Type_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Type_Table`;
CREATE TABLE `t_Type_Table` (
  `id` integer(10) not null auto_increment,
  `id_market` integer(10) not null,
  `type` varchar(20) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_Variety_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Variety_Table`;
CREATE TABLE `t_Variety_Table` (
  `id` integer(6) not null auto_increment,
  `id_type` integer(10) not null,
  `variety` varchar(20) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_Data_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Data_Table`;
CREATE TABLE `t_Data_Table` (
  `id` integer(10) not null auto_increment,
  `id_variety` integer(10) not null,
  `date` date NOT NULL,
  `max` double NOT NULL,
  `min` double NOT NULL,
  `ave` double NOT NULL,
  `sales` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_Fetch_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Fetch_Table`;
CREATE TABLE `t_Fetch_Table` (
  `id` integer(10) not null auto_increment,
  `id_type` integer(10) not null,
  `date` date NOT NULL,
  `fetches` integer(10) not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_Price_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Price_Table`;
CREATE TABLE `t_Price_Table` (
  `id` integer(10) not null auto_increment,
  `type` varchar(10) not null,
  `id_provence` integer(10) not null,
  `price` double not null,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;


-- ----------------------------
-- Table structure for t_Source_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Source_Table`;
CREATE TABLE `t_Source_Table` (
  `source_id` integer(4) not null auto_increment,
  `name` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Table structure for t_User_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_User_Table`;
CREATE TABLE `t_User_Table` (
  `id` integer(6) not null auto_increment,
  `password` varchar(16) NOT NULL DEFAULT '',
  `tele` varchar(11) NOT NULL DEFAULT '',
  `name` varchar(8) NOT NULL DEFAULT '',
  `identity` varchar(5) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Records of t_User_Table
-- ----------------------------
INSERT INTO `t_User_Table` (id, password, tele, name, identity) VALUES ('100001', '123456', '138xxx9857', '刘隆琦', '1');
INSERT INTO `t_User_Table` (id, password, tele, name, identity) VALUES ('100002', '123456', '156xxx1234', '洪焕荣', '2');

INSERT INTO `t_Provence_Table` (id, provence) VALUES ('1001', '江苏');
INSERT INTO `t_Provence_Table` (id, provence) VALUES ('1002', '浙江');

INSERT INTO `t_Market_Table` (id, id_provence, market) VALUES ('100001', '1001','A市场');
INSERT INTO `t_Market_Table` (id, id_provence, market) VALUES ('100002', '1002','B市场');

INSERT INTO `t_Type_Table` (id, id_market, type) VALUES ('100001', '100001','水果');
INSERT INTO `t_Type_Table` (id, id_market, type) VALUES ('100002', '100002','蔬菜');

INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100001', '100001','西瓜');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100002', '100001','芒果');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100003', '100001','苹果');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100004', '100001','梨');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100005', '100002','白菜');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100006', '100002','生菜');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100007', '100002','辣椒');
INSERT INTO `t_Variety_Table` (id, id_type, variety) VALUES ('100008', '100002','西红柿');

INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000001','100001','20-7-27','30.1','28.2','29.1','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000002','100002','20-7-27','15.1','12.2','13.1','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000003','100003','20-7-27','37.6','28.9','32.3','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000004','100004','20-7-27','11.1','9.2','10.7','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000005','100005','20-7-28','3.3','1.2','2.1','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000006','100006','20-7-28','30.1','28.2','29.1','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000007','100007','20-7-28','9.1','8.2','2.0','300');
INSERT INTO `t_Data_Table` (id, id_variety, date, max, min, ave, sales) VALUES ('10000008','100008','20-7-28','3.1','2.2','2.1','300');

INSERT INTO `t_Fetch_Table` (id, id_type, date, `fetches`) VALUES ('10000001','100001','20-7-27','300');
INSERT INTO `t_Fetch_Table` (id, id_type, date, `fetches`) VALUES ('10000002','100001','20-7-28','400');
INSERT INTO `t_Fetch_Table` (id, id_type, date, `fetches`) VALUES ('10000003','100002','20-7-27','500');
INSERT INTO `t_Fetch_Table` (id, id_type, date, `fetches`) VALUES ('10000004','100002','20-7-28','600');

INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000001','土豆','1001','12.3');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000002','白菜','1001','15.1');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000003','西红柿','1001','15.4');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000004','胡萝卜','1001','1.9');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000005','土豆','1002','12.7');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000006','白菜','1002','15.3');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000007','西红柿','1002','14.7');
INSERT INTO `t_Price_Table` (id, type, id_provence, price) VALUES ('10000008','胡萝卜','1002','1.3');
