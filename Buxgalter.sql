CREATE DATABASE  IF NOT EXISTS `buxgalter` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci */;
USE `buxgalter`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: buxgalter
-- ------------------------------------------------------
-- Server version	5.1.53-community

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
-- Table structure for table `datain`
--

DROP TABLE IF EXISTS `datain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datain` (
  `Kod` varchar(10) NOT NULL,
  `Za2016` int(11) NOT NULL,
  `Za2017` int(11) NOT NULL,
  `Za2018` int(11) NOT NULL,
  PRIMARY KEY (`Kod`),
  UNIQUE KEY `Kod_UNIQUE` (`Kod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datain`
--

LOCK TABLES `datain` WRITE;
/*!40000 ALTER TABLE `datain` DISABLE KEYS */;
INSERT INTO `datain` VALUES ('n01290',25024,23910,40205),('n01300',34681,37179,58376),('n01490',16624,20508,25162),('n01700',34681,37179,58376),('n02010',49149,55649,48101),('n02020',44550,44433,45487),('n02029',1832,11216,2614),('n02030',0,0,0),('n02040',0,0,0),('n02050',4599,11216,2614),('n02060',0,0,0),('n02070',1682,1827,3684),('n02080',0,0,0),('n02090',3163,2828,5512),('n02100',3150,3992,2202),('n02140',2930,8225,2240),('n02190',2929,8225,2084),('n05090',8612,11283,14443),('n05102',3017,3662,4436),('n08600',47291,50775,74999),('n09750',15179,14063,15962),('n09990',26831,27320,23457);
/*!40000 ALTER TABLE `datain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `User` varchar(15) COLLATE utf8_hungarian_ci NOT NULL,
  `Password` varchar(15) COLLATE utf8_hungarian_ci NOT NULL,
  PRIMARY KEY (`User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','1234');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `minimvariant`
--

DROP TABLE IF EXISTS `minimvariant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `minimvariant` (
  `Pokazatel` varchar(10) COLLATE utf8_hungarian_ci NOT NULL,
  `Za2014` double NOT NULL,
  `Za2015` double NOT NULL,
  `Za2016` double NOT NULL,
  `Za2017` double NOT NULL,
  `Za2018` double NOT NULL,
  PRIMARY KEY (`Pokazatel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `minimvariant`
--

LOCK TABLES `minimvariant` WRITE;
/*!40000 ALTER TABLE `minimvariant` DISABLE KEYS */;
INSERT INTO `minimvariant` VALUES ('Itog',1588.21,1562.18,1534.81,1506.1,1468.26),('Level',0.0264,0.0218,0.0164,0.0101,0.0006),('Max',0.0551,0.0456,0.0343,0.021,0.0012),('Min',0.0287,0.0238,0.0179,0.011,0.0006);
/*!40000 ALTER TABLE `minimvariant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `optimalvariant`
--

DROP TABLE IF EXISTS `optimalvariant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `optimalvariant` (
  `Pokazatel` varchar(10) NOT NULL,
  `Za2014` double NOT NULL,
  `Za2015` double NOT NULL,
  `Za2016` double NOT NULL,
  `Za2017` double NOT NULL,
  `Za2018` double NOT NULL,
  PRIMARY KEY (`Pokazatel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optimalvariant`
--

LOCK TABLES `optimalvariant` WRITE;
/*!40000 ALTER TABLE `optimalvariant` DISABLE KEYS */;
INSERT INTO `optimalvariant` VALUES ('Itog',1612.93,1679.53,1726.72,1743.57,1766.78),('Level',0.0301,0.0377,0.0407,0.0413,0.0418),('Max',0.063,0.0788,0.0851,0.0864,0.0873),('Min',0.0328,0.0411,0.0444,0.045,0.0455);
/*!40000 ALTER TABLE `optimalvariant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessivariant`
--

DROP TABLE IF EXISTS `pessivariant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessivariant` (
  `Pokazatel` varchar(10) COLLATE utf8_hungarian_ci NOT NULL,
  `Za2014` double NOT NULL,
  `Za2015` double NOT NULL,
  `Za2016` double NOT NULL,
  `Za2017` double NOT NULL,
  `Za2018` double NOT NULL,
  PRIMARY KEY (`Pokazatel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessivariant`
--

LOCK TABLES `pessivariant` WRITE;
/*!40000 ALTER TABLE `pessivariant` DISABLE KEYS */;
INSERT INTO `pessivariant` VALUES ('Itog',1377.16,1419.93,1411.56,1341.29,1303.91),('Level',-0.0273,-0.0133,-0.0159,-0.0402,-0.0549),('Max',-0.057,-0.02781,-0.0333,-0.084,-0.1147),('Min',-0.0843,-0.0411,-0.0492,-0.1242,-0.1695);
/*!40000 ALTER TABLE `pessivariant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-14 10:23:49
