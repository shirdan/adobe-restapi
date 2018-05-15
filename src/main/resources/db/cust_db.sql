/*
Source Server         : localhost
Source Host           : localhost:3306
Source Database       : cust_db

Target Server Type    : MYSQL
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `customer_tbl`;
CREATE TABLE `customer_tbl` (
  `cust_id` varchar(30) NOT NULL DEFAULT '',
  `firstName` varchar(30) NOT NULL DEFAULT '',
  `lastName` varchar(30) NOT NULL DEFAULT '',
  `age` int(3) NOT NULL DEFAULT 0,
  `phoneNumber` varchar(30) NOT NULL DEFAULT '',
  `email` varchar(30) NOT NULL DEFAULT '',
  `country` varchar(30) NOT NULL DEFAULT '',
  `created_at` date NOT NULL DEFAULT '0000-00-00',
  `address` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer_tbl
-- ----------------------------
INSERT INTO `customer_tbl` VALUES ('01', 'testfirst','testlast','20','4081112222',
									'test@customer.com','US','2018-05-14','test address,378 street');


-- ----------------------------
-- Table structure for `address_tbl`
-- ----------------------------
--DROP TABLE IF EXISTS `address_tbl`;
--CREATE TABLE `address_tbl` (
--  `address_id` varchar(30) NOT NULL DEFAULT '',
--  `zip` varchar(30) NOT NULL DEFAULT '',
--  `address` varchar(30) NOT NULL DEFAULT '',
--  `cust_id` varchar(30) NOT NULL DEFAULT '',
--  PRIMARY KEY (`address_id`),
--  FOREIGN KEY (`cust_id`) REFERENCES customer_tbl(cust_id)
--) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
--
---- ----------------------------
---- Records of address_tbl
---- ----------------------------
--INSERT INTO `address_tbl` VALUES ('01', '33444','testaddr 444 St - US','01');
