/*
SQLyog v10.2 
MySQL - 5.5.15 : Database - nfl
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nfl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nfl`;

DROP TABLE IF EXISTS `nfl_photos`;

CREATE TABLE `nfl_photos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `key` VARCHAR(45) NOT NULL,
  `ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `post_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_posts`;

CREATE TABLE `nfl_posts` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `post_ts` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `post_content` LONGTEXT,
  `post_status` INT(2)NOT NULL DEFAULT '0',
  `post_type` INT(1) NOT NULL,
  `comment_count` INT(11) NOT NULL DEFAULT '0',
  `like_count` INT(11) NOT NULL DEFAULT '0',
  `share_count` INT(11) NOT NULL DEFAULT '0',
  `topic_id` INT(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_post_tag`;

-- CREATE TABLE `nfl_post_tag` (
--  `id` int(11) NOT NULL AUTO_INCREMENT,
--  `post_id` int(11) NOT NULL DEFAULT 0,
--  `topic_id` int(11) NOT NULL DEFAULT 0,
--  PRIMARY KEY (`id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_topics`;

CREATE TABLE `nfl_topics` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `topic_name` VARCHAR(30) NOT NULL,
  `add_ts` DATETIME,
  `count` INT(30) NOT NULL DEFAULT 0,
   PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_users`;

CREATE TABLE `nfl_users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(50) NOT NULL,
  `user_email` VARCHAR(100),
  `user_phone` VARCHAR(100),
  `user_pwd` VARCHAR(100) NOT NULL,
  `user_registered_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_status` INT(11) NOT NULL,
  `user_activationKey` VARCHAR(24),
  `user_avatar` VARCHAR(100),
  `user_desc` VARCHAR(200),
  `resetpwd_key` VARCHAR(100),
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `nfl_post_relation`;

CREATE TABLE `nfl_post_relation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `commented_msg_id` INT(11) NOT NULL,
  `commented_user_id` INT(11) NOT NULL,
  `comment_msg_id` INT(11) NOT NULL,
  `comment_user_id` INT(11) NOT NULL,
  `comment_type` INT(1) NOT NULL,
  `comment_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `page_index` INT(3),
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
