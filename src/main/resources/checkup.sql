create database checkup;

use checkup;

CREATE TABLE `checkup` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `checkup_date` timestamp NULL DEFAULT NULL,
  `checkup_id` varchar(128) NOT NULL,
  `doctor_name` varchar(128) ,
  `checkup_type` varchar(128) ,
  `bill_generated` DECIMAL( 10, 2 ),
  `amount_paid` DECIMAL( 10, 2 ),
  `amount_due` DECIMAL( 10, 2 ),
  `is_rewarded` tinyint(1) NOT NULL DEFAULT '0',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_checkup_id` (`checkup_id`),
  KEY `idx_checkup_date` (`checkup_date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `checkup_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `checkup_id` varchar(128) NOT NULL,
  `parameter` varchar(128) NOT NULL,
  `value` varchar(128) NOT NULL,
  `data_type` enum('DOUBLE','STRING','BOOLEAN') NOT NULL DEFAULT 'STRING',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_checkup_id` (`checkup_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

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

create table user_activity(
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 `user_id` int(11) NOT NULL,
 `total_calories` DECIMAL( 10, 2 ),
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_by` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(128) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`)
);

