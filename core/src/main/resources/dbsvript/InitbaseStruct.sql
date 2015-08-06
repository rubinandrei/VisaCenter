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
-- Table structure for table `availablereg`
--

DROP TABLE IF EXISTS `availablereg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `availablereg` (
  `ar_id` int(11) NOT NULL AUTO_INCREMENT,
  `ar_count` bit(19) DEFAULT NULL,
  `ar_day` date DEFAULT NULL,
  PRIMARY KEY (`ar_id`),
  UNIQUE KEY `ar_day_UNIQUE` (`ar_day`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availablereg`
--

LOCK TABLES `availablereg` WRITE;
/*!40000 ALTER TABLE `availablereg` DISABLE KEYS */;
INSERT INTO `availablereg` VALUES (1,'\0\0d','2015-08-03'),(2,'\0\0d','2015-08-04'),(3,'\0\0d','2015-08-05'),(4,'\0\0d','2015-08-06'),(5,'\0\0d','2015-08-07'),(6,'\0\0d','2015-08-10'),(7,'\0\0d','2015-08-11'),(8,'\0\0d','2015-08-12'),(9,'\0\0d','2015-08-13'),(10,'\0\0d','2015-08-14'),(11,'\0\0d','2015-08-17'),(12,'\0\0d','2015-08-18'),(13,'\0\0d','2015-08-19'),(14,'\0\0d','2015-08-20'),(15,'\0\0d','2015-08-21'),(16,'\0\0d','2015-08-24'),(17,'\0\0d','2015-08-25'),(18,'\0\0d','2015-08-26'),(19,'\0\0d','2015-08-27'),(20,'\0\0d','2015-08-28'),(21,'\0\0d','2015-08-31'),(32,'\0\0\0','2015-08-01'),(33,'\0\0\0','2015-08-02'),(34,'\0\0\0','2015-08-08'),(35,'\0\0\0','2015-08-09'),(36,'\0\0\0','2015-08-15'),(37,'\0\0\0','2015-08-16'),(38,'\0\0\0','2015-08-22'),(39,'\0\0\0','2015-08-23'),(40,'\0\0\0','2015-08-29'),(41,'\0\0\0','2015-08-30');
/*!40000 ALTER TABLE `availablereg` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `declarpassport`
--

LOCK TABLES `declarpassport` WRITE;
/*!40000 ALTER TABLE `declarpassport` DISABLE KEYS */;
INSERT INTO `declarpassport` VALUES (1,'Andrei','Rubin','MP24354345','1974-08-11','2019-08-11','234D234hhh2342344y5654'),(2,'Mishail','Rubin','MP34554345','2003-10-24','2016-05-19','234D234hhh23423Asy5654');
/*!40000 ALTER TABLE `declarpassport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regisrtform`
--

DROP TABLE IF EXISTS `regisrtform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regisrtform` (
  `rf_id` bigint(16) NOT NULL AUTO_INCREMENT,
  `rf_datareg` datetime NOT NULL,
  `rt_visatype` bigint(16) NOT NULL,
  `rf_declarant_email` varchar(250) DEFAULT NULL,
  `rf_declarant_password` varchar(250) DEFAULT NULL,
  `rf_status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rf_id`),
  KEY `rf_declarant_password` (`rf_declarant_password`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regisrtform`
--

LOCK TABLES `regisrtform` WRITE;
/*!40000 ALTER TABLE `regisrtform` DISABLE KEYS */;
INSERT INTO `regisrtform` VALUES (1,'2015-07-31 17:08:01',1,'Andrew.a.Rubin@gmail.com','1',0),(2,'2015-07-31 17:08:01',2,'Rubin@gmail.com','2',0);
/*!40000 ALTER TABLE `regisrtform` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemusers`
--

DROP TABLE IF EXISTS `systemusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemusers` (
  `su_id` int(10) unsigned NOT NULL,
  `su_login` varchar(45) DEFAULT NULL,
  `su_password` varchar(255) DEFAULT NULL,
  `su_admintyp` int(11) DEFAULT NULL,
  PRIMARY KEY (`su_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemusers`
--

LOCK TABLES `systemusers` WRITE;
/*!40000 ALTER TABLE `systemusers` DISABLE KEYS */;
/*!40000 ALTER TABLE `systemusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa`
--

DROP TABLE IF EXISTS `visa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visa`
--

LOCK TABLES `visa` WRITE;
/*!40000 ALTER TABLE `visa` DISABLE KEYS */;
INSERT INTO `visa` VALUES (1,1,'2015-09-24','2016-09-24',2,'2015-07-31',1,120),(2,2,'2015-09-24','2016-09-24',2,'2015-07-31',1,120);
/*!40000 ALTER TABLE `visa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa_type`
--

DROP TABLE IF EXISTS `visa_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visa_type`
--

LOCK TABLES `visa_type` WRITE;
/*!40000 ALTER TABLE `visa_type` DISABLE KEYS */;
INSERT INTO `visa_type` VALUES (1,'Разовая 90 дней',90,0,NULL,65,1,'C'),(2,'Разовая 120 дней',120,0,NULL,100,1,'D'),(3,'Name_for test11',300,1,NULL,61,1,'test');
/*!40000 ALTER TABLE `visa_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-06 17:06:03
