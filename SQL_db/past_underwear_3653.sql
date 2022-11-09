-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: past_underwear_3653
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrators`
--

DROP TABLE IF EXISTS `administrators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrators` (
  `ausername` varchar(225) NOT NULL,
  `apassword` varchar(225) NOT NULL,
  `aname` varchar(225) NOT NULL,
  `address` varchar(225) NOT NULL,
  PRIMARY KEY (`ausername`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrators`
--

LOCK TABLES `administrators` WRITE;
/*!40000 ALTER TABLE `administrators` DISABLE KEYS */;
INSERT INTO `administrators` VALUES ('prathamesh@gmail.com','123','Prathamesh Khedkar','Mumbai (MH)'),('pratik123@gmail.com','123','Pratik Sontakke','Amravati (MH)'),('sahil@gmail.com','123','Sahil Bobade','Pune (MH)');
/*!40000 ALTER TABLE `administrators` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buses`
--

DROP TABLE IF EXISTS `buses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buses` (
  `busNo` varchar(10) NOT NULL,
  `insertBy` varchar(225) DEFAULT NULL,
  `date` date NOT NULL,
  `source` varchar(225) NOT NULL,
  `sTime` datetime NOT NULL,
  `destination` varchar(225) NOT NULL,
  `dTime` datetime NOT NULL,
  `type` varchar(225) NOT NULL,
  `bookedSeat` int DEFAULT '0',
  `totalSeat` int NOT NULL,
  `fare` int NOT NULL,
  PRIMARY KEY (`busNo`),
  KEY `insertBy` (`insertBy`),
  CONSTRAINT `buses_ibfk_1` FOREIGN KEY (`insertBy`) REFERENCES `administrators` (`ausername`) ON DELETE CASCADE ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buses`
--

LOCK TABLES `buses` WRITE;
/*!40000 ALTER TABLE `buses` DISABLE KEYS */;
INSERT INTO `buses` VALUES ('MH27BN9001','prathamesh@gmail.com','2022-09-29','Amravati','2022-09-29 13:40:00','Shimla','2022-09-30 13:40:00','AC',2,30,3000);
/*!40000 ALTER TABLE `buses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerbookedtickets`
--

DROP TABLE IF EXISTS `customerbookedtickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customerbookedtickets` (
  `cuserName` varchar(225) DEFAULT NULL,
  `busNo` varchar(225) DEFAULT NULL,
  `bookingTime` datetime NOT NULL,
  `bookedSeat` int DEFAULT '0',
  KEY `cuserName` (`cuserName`),
  KEY `busNo` (`busNo`),
  CONSTRAINT `customerbookedtickets_ibfk_1` FOREIGN KEY (`cuserName`) REFERENCES `customers` (`cuserName`) ON DELETE CASCADE ON UPDATE SET NULL,
  CONSTRAINT `customerbookedtickets_ibfk_2` FOREIGN KEY (`busNo`) REFERENCES `buses` (`busNo`) ON DELETE CASCADE ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerbookedtickets`
--

LOCK TABLES `customerbookedtickets` WRITE;
/*!40000 ALTER TABLE `customerbookedtickets` DISABLE KEYS */;
INSERT INTO `customerbookedtickets` VALUES ('pratik@gmail.com','MH27BN9001','2022-10-03 16:54:16',2);
/*!40000 ALTER TABLE `customerbookedtickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `cuserName` varchar(225) NOT NULL,
  `cpassword` varchar(225) NOT NULL,
  `cname` varchar(225) NOT NULL,
  `address` varchar(225) NOT NULL,
  PRIMARY KEY (`cuserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('akash@gmail.com','123','Akash Koli','Amravati (MH)'),('elon@gmail.com','123','Elon Musk','LA (USA)'),('kia@gmail.com','123','Kia Kia','LA (USA)'),('pratik@gmail.com','123','Pratik Sontakke','Amravati (MH)'),('vicky@gmail.com','123','Vicky Sontakke','Amravati (MH)');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-09 11:30:30
