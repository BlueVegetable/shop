/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.19-log : Database - shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `shop`;

/*Table structure for table `cartitem` */

DROP TABLE IF EXISTS `cartitem`;

CREATE TABLE `cartitem` (
  `cartItemID` bigint(20) NOT NULL,
  `goodsID` bigint(20) NOT NULL,
  `goodsNumber` int(11) NOT NULL,
  `userID` varchar(10) NOT NULL,
  PRIMARY KEY (`cartItemID`),
  KEY `goodsID` (`goodsID`),
  KEY `userID` (`userID`),
  CONSTRAINT `cartitem_ibfk_1` FOREIGN KEY (`goodsID`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cartitem_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `cartitem` */

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` double NOT NULL,
  `image` varchar(50) NOT NULL,
  `info` varchar(300) NOT NULL,
  `varietyID` bigint(20) NOT NULL,
  `register` tinyint(1) NOT NULL,
  `shopID` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shopID` (`shopID`),
  KEY `varietyID` (`varietyID`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`shopID`) REFERENCES `shop` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`varietyID`) REFERENCES `variety` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `orderID` bigint(20) NOT NULL,
  `userID` varchar(10) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`orderID`,`userID`),
  KEY `userID` (`userID`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `orderitem` */

DROP TABLE IF EXISTS `orderitem`;

CREATE TABLE `orderitem` (
  `orderItemID` bigint(20) NOT NULL,
  `time` date NOT NULL,
  `orderID` bigint(20) NOT NULL,
  `userID` varchar(10) NOT NULL,
  `goodsID` bigint(20) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`orderItemID`),
  KEY `orderID` (`orderID`),
  KEY `userID` (`userID`),
  KEY `goodsID` (`goodsID`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `order` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `orderitem_ibfk_3` FOREIGN KEY (`goodsID`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderitem` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `title` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`id`,`name`,`title`) values ('1','user','用户'),('2','manager','商家'),('3','admin','管理员');

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `register` tinyint(1) NOT NULL,
  `userID` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userID` (`userID`),
  CONSTRAINT `shop_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shop` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`gender`,`email`,`phoneNumber`) values ('1000000001','蔡荣镔','1000000001','boy','2601042086@qq.com','15521131057');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` varchar(10) NOT NULL,
  `role_id` varchar(10) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

/*Table structure for table `variety` */

DROP TABLE IF EXISTS `variety`;

CREATE TABLE `variety` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `variety` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
