DROP database IF EXISTS `visacenter_test`;
CREATE DATABASE  IF NOT EXISTS `visacenter_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `visacenter_test`;
CREATE TABLE `availablereg` (
  `ar_id` bigint(19) NOT NULL,
  `ar_count` bit(19) DEFAULT NULL,
  `ar_day` date DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`ar_id`),
  UNIQUE KEY `ar_day_UNIQUE` (`ar_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `declarpassport` (
  `dp_id` int(16) NOT NULL AUTO_INCREMENT,
  `dp_first_name` varchar(45) NOT NULL,
  `dp_second_name` varchar(45) NOT NULL,
  `dp_passport_nb` varchar(45) NOT NULL,
  `dp_date_birth` date NOT NULL,
  `dp_passport_valid_data` date NOT NULL,
  `dp_passport_indent_nb` varchar(45) NOT NULL,
  PRIMARY KEY (`dp_id`),
  UNIQUE KEY `dp_passport_nb_UNIQUE` (`dp_passport_nb`),
  UNIQUE KEY `dp_id_UNIQUE` (`dp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `regisrtform` (
  `rf_id` bigint(16) NOT NULL AUTO_INCREMENT,
  `rf_datareg` datetime NOT NULL,
  `rt_visatype` bigint(16) NOT NULL,
  `rf_declarant_email` varchar(250) DEFAULT NULL,
  `rf_declarant_password` varchar(250) DEFAULT NULL,
  `rf_status` int(11) NOT NULL DEFAULT '0',
  `rf_declarant_passpord` bigint(19) NOT NULL,
  PRIMARY KEY (`rf_id`),
  KEY `rf_declarant_password` (`rf_declarant_password`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `systemusers` (
  `su_id` int(10) unsigned NOT NULL,
  `su_login` varchar(45) DEFAULT NULL,
  `su_password` varchar(255) DEFAULT NULL,
  `su_admintyp` int(11) DEFAULT NULL,
  PRIMARY KEY (`su_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `visa` (
  `visa_id` bigint(16) NOT NULL AUTO_INCREMENT,
  `visa_declarpassword_id` bigint(16) NOT NULL,
  `visa_do_from` date NOT NULL,
  `visa_do_until` date NOT NULL,
  `visa_type_id` bigint(16) NOT NULL,
  `visa_date` date NOT NULL,
  `visa_nb_entires` int(11) NOT NULL,
  `visa_duration_stay` int(11) NOT NULL,
  PRIMARY KEY (`visa_id`),
  UNIQUE KEY `visa_id_UNIQUE` (`visa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `visa_type` (
  `vt_id` bigint(16) NOT NULL AUTO_INCREMENT,
  `vt_name` varchar(250) NOT NULL,
  `vt_actionday_count` int(11) NOT NULL,
  `vt_status` int(11) NOT NULL DEFAULT '0',
  `vt_terminated_time` datetime DEFAULT NULL,
  `vt_cost` decimal(10,0) DEFAULT NULL,
  `vt_action_type` int(11) NOT NULL,
  `vt_short_name` varchar(4) NOT NULL,
  PRIMARY KEY (`vt_id`),
  UNIQUE KEY `vt_id_UNIQUE` (`vt_id`),
  UNIQUE KEY `vt_name_UNIQUE` (`vt_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;