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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(45) NOT NULL,
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_posts`;

CREATE TABLE `nfl_posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `post_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `post_content` longtext,
  `post_status` int(2)NOT NULL DEFAULT '0',
  `post_type` int(1) NOT NULL,
  `comment_count` int(11) NOT NULL DEFAULT '0',
  `like_count` int(11) NOT NULL DEFAULT '0',
  `share_count` int(11) NOT NULL DEFAULT '0',
  `topic_id` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_post_tag`;

--CREATE TABLE `nfl_post_tag` (
--  `id` int(11) NOT NULL AUTO_INCREMENT,
--  `post_id` int(11) NOT NULL DEFAULT 0,
--  `topic_id` int(11) NOT NULL DEFAULT 0,
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_topics`;

CREATE TABLE `nfl_topics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(30) NOT NULL,
  `add_ts` datetime,
  `count` int(30) NOT NULL DEFAULT 0,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `nfl_users`;

CREATE TABLE `nfl_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_email` varchar(100),
  `user_phone` varchar(100),
  `user_pwd` varchar(100) NOT NULL,
  `user_registered_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_status` int(11) NOT NULL,
  `user_activationKey` varchar(24),
  `user_avatar` varchar(100),
  `user_desc` varchar(200),
  `resetpwd_key` varchar(100),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `nfl_post_relation`;

CREATE TABLE `nfl_post_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commented_msg_id` int(11) NOT NULL,
  `commented_user_id` int(11) NOT NULL,
  `comment_msg_id` int(11) NOT NULL,
  `comment_user_id` int(11) NOT NULL,
  `comment_type` int(1) NOT NULL,
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `page_index` int(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
