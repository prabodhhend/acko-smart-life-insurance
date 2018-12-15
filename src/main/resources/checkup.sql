create database checkup;

use checkup;

CREATE TABLE `checkup` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(128) NOT NULL,
  `parameter` varchar(128) NOT NULL,
  `value` varchar(128) NOT NULL,
  `data_type` enum('DOUBLE','STRING','BOOLEAN') NOT NULL DEFAULT 'STRING',
  `checkup_date` timestamp NULL DEFAULT NULL,
  `is_rewarded` tinyint(1) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_checkup_date` (`checkup_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


create table user_activity(
id long auto_increment,
user_id long,
total_calories int,
 is_deleted tinyint(1) ,
  created_at timestamp ,
  created_by varchar(128)  ,
  updated_at timestamp ,
  updated_by varchar(128)
)


