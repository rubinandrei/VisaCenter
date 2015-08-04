DROP database IF EXISTS `visacenter`;
CREATE DATABASE  IF NOT EXISTS `visacenter` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `visacenter`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: visacenter
-- ------------------------------------------------------
-- Server version	5.6.24-enterprise-commercial-advanced-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `declarpassport`
--

DROP TABLE IF EXISTS `declarpassport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `declarpassport` (
  `dp_id` int(16) NOT NULL AUTO_INCREMENT,
  `dp_first_name` varchar(45) NOT NULL,
  `dp_second_name` varchar(45) NOT NULL,
  `dp_passport_nb` varchar(45) NOT NULL,
  `dp_date_birth` date NOT NULL,
  `dp_passport_valid_data` date NOT NULL,
  `dp_password_indent_nb` varchar(45) NOT NULL,
  PRIMARY KEY (`dp_id`),
  UNIQUE KEY `dp_passport_nb_UNIQUE` (`dp_passport_nb`),
  UNIQUE KEY `dp_id_UNIQUE` (`dp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `declarpassport`
--

LOCK TABLES `declarpassport` WRITE;
/*!40000 ALTER TABLE `declarpassport` DISABLE KEYS */;
/*!40000 ALTER TABLE `declarpassport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regisrtform`
--

DROP TABLE IF EXISTS `regisrtform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regisrtform` (
  `rf_id` bigint(16) NOT NULL,
  `rf_datareg` datetime NOT NULL,
  `rt_visatype` bigint(16) NOT NULL,
  `rf_declarant_email` varchar(250) DEFAULT NULL,
  `rf_declarant_password` int(16) DEFAULT NULL,
  `rf_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rf_id`),
  KEY `rf_declarant_password` (`rf_declarant_password`),
  CONSTRAINT `regisrtform_ibfk_1` FOREIGN KEY (`rf_declarant_password`) REFERENCES `declarpassport` (`dp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regisrtform`
--

LOCK TABLES `regisrtform` WRITE;
/*!40000 ALTER TABLE `regisrtform` DISABLE KEYS */;
/*!40000 ALTER TABLE `regisrtform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa`
--

DROP TABLE IF EXISTS `visa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visa` (
  `visa_id` bigint(16) NOT NULL,
  `visa_declarpassword_id` bigint(16) NOT NULL,
  `visa_do_from` date NOT NULL,
  `visa_do_until` varchar(45) NOT NULL,
  `visa_type_id` bigint(16) NOT NULL,
  `visa_date` date NOT NULL,
  `visa_nb_entires` int(11) NOT NULL,
  `visa_duration_stay` int(11) NOT NULL,
  PRIMARY KEY (`visa_id`),
  UNIQUE KEY `visa_id_UNIQUE` (`visa_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visa`
--

LOCK TABLES `visa` WRITE;
/*!40000 ALTER TABLE `visa` DISABLE KEYS */;
/*!40000 ALTER TABLE `visa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa_type`
--

DROP TABLE IF EXISTS `visa_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visa_type` (
  `vt_id` bigint(16) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visa_type`
--

LOCK TABLES `visa_type` WRITE;
/*!40000 ALTER TABLE `visa_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `visa_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'visacenter'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-31 14:25:03
