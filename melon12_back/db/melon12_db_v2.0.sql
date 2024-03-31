
-- ----------------------------
-- Table structure for t_Data_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Data_Table`;
CREATE TABLE `t_Data_Table` (
  `id` integer(10) not null auto_increment,
  `name` varchar(10) NOT NULL DEFAULT '',
  `classes` varchar(10) NOT NULL DEFAULT '',
  `province` varchar(10) NOT NULL DEFAULT '',
  `market` varchar(10) NOT NULL DEFAULT '',
  `source_id` integer(4) NOT NULL,
  `date` date NOT NULL,
  `price` double NOT NULL,
  `sales` int NOT NULL,
  `fetchamount` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Records of t_Data_Table
-- ----------------------------

-- ----------------------------
-- Table structure for t_Source_Table
-- ----------------------------
DROP TABLE IF EXISTS `t_Source_Table`;
CREATE TABLE `t_Source_Table` (
  `source_id` integer(4) not null auto_increment,
  `name` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(50) NOT NULL DEFAULT '',
  `fetchamount` int NOT NULL,
  PRIMARY KEY (`source_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

-- ----------------------------
-- Records of t_Source_Table
-- ----------------------------

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
INSERT INTO `t_User_Table` VALUES ('100001', '123456', '138xxx9857', '刘隆琦', '1');
INSERT INTO `t_User_Table` VALUES ('100002', '123456', '156xxx1234', '洪焕荣', '2');

INSERT INTO `t_Source_Table` VALUES ('1001', '百度', 'www.xxxxx.com', '300');
INSERT INTO `t_Source_Table` VALUES ('1002', '谷歌', 'www.xxxxx.com', '400');

INSERT INTO `t_Data_Table` VALUES ('1000000001', '蔬菜' , '白菜' , '江苏省' , 'A市场' , '1001' , '20-7-22' , '20.1' , '50', '300');
INSERT INTO `t_Data_Table` VALUES ('1000000002', '水果' , '苹果' , '湖北省' , 'B市场' , '1002' , '20-7-22' , '2.1' , '30', '400');
