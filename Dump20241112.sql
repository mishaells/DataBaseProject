CREATE DATABASE  IF NOT EXISTS `blancadatabase` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blancadatabase`;
SET foreign_key_checks = 0;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BRANCH`
--

DROP TABLE IF EXISTS `BRANCH`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `BRANCH` (
  `Bcode` char(4) NOT NULL,
  `District` varchar(30) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Bphone_num` char(10) DEFAULT NULL,
  `Manager_ID` char(10) DEFAULT NULL,
  PRIMARY KEY (`Bcode`),
  UNIQUE KEY `Bphone_num_UNIQUE` (`Bphone_num`),
  KEY `Manager_ID_Ref` (`Manager_ID`),
  CONSTRAINT `Manager_ID_Ref` FOREIGN KEY (`Manager_ID`) REFERENCES `EMPLOYEE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BRANCH`
--

LOCK TABLES `BRANCH` WRITE;
/*!40000 ALTER TABLE `BRANCH` DISABLE KEYS */;
INSERT INTO `BRANCH` VALUES ('1122','Riyadh Front','Riyadh','0115792386',NULL),('1234','Al-Sulimaniya','Riyadh','0111234567','1122334455'),('2964','Al Khalidiyyah','Jeddah','0117382378',NULL),('6509','Olaya','Al Khobar','0117539786',NULL),('9567','Al Rabwah','Tabuk','0117676745',NULL);
/*!40000 ALTER TABLE `BRANCH` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER`
--

DROP TABLE IF EXISTS `CUSTOMER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CUSTOMER` (
  `C_Fname` varchar(15) NOT NULL,
  `C_Lname` varchar(15) NOT NULL,
  `Cphone_num` char(10) NOT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Cphone_num`),
  UNIQUE KEY `Email_UNIQUE` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER`
--

LOCK TABLES `CUSTOMER` WRITE;
/*!40000 ALTER TABLE `CUSTOMER` DISABLE KEYS */;
INSERT INTO `CUSTOMER` VALUES ('Rayan','Abdulmajeed','0525835682','raayaan@gmail.com'),('Abdulmalik','Anas','0552349876','malook123@gmail.com'),('Latifah','Abdullah','0557856342','tifah@gmail.com');
/*!40000 ALTER TABLE `CUSTOMER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLOYEE`
--

DROP TABLE IF EXISTS `EMPLOYEE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EMPLOYEE` (
  `ID` char(10) NOT NULL,
  `E_Fname` varchar(15) NOT NULL,
  `E_Mname` varchar(15) DEFAULT NULL,
  `E_Lname` varchar(15) NOT NULL,
  `Position` varchar(15) DEFAULT NULL,
  `Salary` float DEFAULT NULL,
  `Ephone_num` char(10) NOT NULL,
  `Street` varchar(30) DEFAULT NULL,
  `District` varchar(30) DEFAULT NULL,
  `Postal_code` char(5) DEFAULT NULL,
  `City` varchar(30) DEFAULT NULL,
  `Nationality` varchar(30) DEFAULT NULL,
  `Bcode` char(4) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Emp_Bcode` (`Bcode`),
  CONSTRAINT `Emp_Bcode` FOREIGN KEY (`Bcode`) REFERENCES `BRANCH` (`Bcode`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE`
--

LOCK TABLES `EMPLOYEE` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE` DISABLE KEYS */;
INSERT INTO `EMPLOYEE` VALUES ('1122334455','Mohammed','Abdullah','Alharbi','Manager',17000,'0555123456','King Abdullah','Al-Rayan','12345','Riyadh','Saudi','1234'),('1234567890','Sarah','Mohammed','Alrajhi','Waiter',10000,'0583492583','Prince Turki St','Takkasusi','11223','Riyadh','Saudi','1234');
/*!40000 ALTER TABLE `EMPLOYEE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITEM`
--

DROP TABLE IF EXISTS `ITEM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ITEM` (
  `Item_code` char(3) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Category` varchar(30) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  PRIMARY KEY (`Item_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEM`
--

LOCK TABLES `ITEM` WRITE;
/*!40000 ALTER TABLE `ITEM` DISABLE KEYS */;
INSERT INTO `ITEM` VALUES ('001','Buffalo Pizza','Pizza',51),('002','Blanca Pizza','Pizza',66),('015','Penne Arabiatta','Pasta',49),('016','Penne Cream Mushroom','Pasta',53),('023','Lasagna','Oven Pasta',49),('024','Eggplant Spaghetti','Oven Pasta',49),('028','Bruschetta Burrata','Sharing',53),('029','Saffron Roseto Chicken','Sharing',49),('035','Buratta','Salad',54),('036','Caesar','Salad',49),('039','Cream Mushroom Soup','Soup',37),('040','Tiramisu','Sweets',54),('041','Nutella Calzone','Sweets',45),('042','Mojito Classic','Drink',35),('043','Mojito Berry','Drink',35);
/*!40000 ALTER TABLE `ITEM` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDERED_BY`
--

DROP TABLE IF EXISTS `ORDERED_BY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ORDERED_BY` (
  `Item_code` char(3) NOT NULL,
  `Ref_no` char(6) NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Item_code`,`Ref_no`),
  KEY `Item_ref_idx` (`Ref_no`),
  CONSTRAINT `Item_code` FOREIGN KEY (`Item_code`) REFERENCES `ITEM` (`Item_code`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Ref_no` FOREIGN KEY (`Ref_no`) REFERENCES `RESERVATION` (`Ref_no`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDERED_BY`
--

LOCK TABLES `ORDERED_BY` WRITE;
/*!40000 ALTER TABLE `ORDERED_BY` DISABLE KEYS */;
INSERT INTO `ORDERED_BY` VALUES ('002','H72K8F',2);
/*!40000 ALTER TABLE `ORDERED_BY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RESERVATION`
--

DROP TABLE IF EXISTS `RESERVATION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RESERVATION` (
  `Ref_no` char(6) NOT NULL,
  `Date` date DEFAULT NULL,
  `Start_time` time DEFAULT NULL,
  `Table_num` int DEFAULT NULL,
  `Num_of_ppl` int DEFAULT NULL,
  `Bcode` char(4) NOT NULL,
  `Servers_ID` char(10) DEFAULT NULL,
  `Cphone_num` char(10) NOT NULL,
  PRIMARY KEY (`Ref_no`),
  KEY `Res_ServerID` (`Servers_ID`),
  KEY `Res_Bcode` (`Bcode`),
  KEY `Res_Cphone` (`Cphone_num`),
  CONSTRAINT `Res_Bcode` FOREIGN KEY (`Bcode`) REFERENCES `BRANCH` (`Bcode`) ON UPDATE CASCADE,
  CONSTRAINT `Res_Cphone` FOREIGN KEY (`Cphone_num`) REFERENCES `CUSTOMER` (`Cphone_num`) ON UPDATE CASCADE,
  CONSTRAINT `Res_ServerID` FOREIGN KEY (`Servers_ID`) REFERENCES `EMPLOYEE` (`ID`),
  CONSTRAINT `C` CHECK ((`Num_of_ppl` between 1 and 10)),
  CONSTRAINT `C1` CHECK ((`Table_num` between 1 and 30))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RESERVATION`
--

LOCK TABLES `RESERVATION` WRITE;
/*!40000 ALTER TABLE `RESERVATION` DISABLE KEYS */;
INSERT INTO `RESERVATION` VALUES ('H72K8F','2024-12-29','18:00:00',6,7,'1234','1234567890','0557856342');
/*!40000 ALTER TABLE `RESERVATION` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

SET foreign_key_checks = 1;
