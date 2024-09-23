-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: new_schema
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `gcoin`
--

DROP TABLE IF EXISTS `gcoin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gcoin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `gcoin` int DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_67e5i7kvv7x1852ork14ey2b6` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gcoin`
--

LOCK TABLES `gcoin` WRITE;
/*!40000 ALTER TABLE `gcoin` DISABLE KEYS */;
INSERT INTO `gcoin` VALUES (1,10,'1'),(8,40,'3');
/*!40000 ALTER TABLE `gcoin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `gcoin_balance` int DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `p_name` varchar(255) DEFAULT NULL,
  `p_price` varchar(255) DEFAULT NULL,
  `p_status` varchar(255) DEFAULT NULL,
  `p_weight` varchar(255) DEFAULT NULL,
  `pickup_date` varchar(255) DEFAULT NULL,
  `pickup_time` varchar(255) DEFAULT NULL,
  `pincode` varchar(255) DEFAULT NULL,
  `quantity` varbinary(255) DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `u_mobile` varchar(255) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `v_address` varchar(255) DEFAULT NULL,
  `v_mobile` varchar(255) DEFAULT NULL,
  `v_name` varchar(255) DEFAULT NULL,
  `qty1` int DEFAULT NULL,
  `qty250` int DEFAULT NULL,
  `qty500` int DEFAULT NULL,
  `qty750` int DEFAULT NULL,
  `vendor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (23,'Hinjwadi pune near wakad bridge pune, 4230001','2024-08-28 21:24:40.792295',10,'Hinjewadi','Plastic','600','Completed','10','2024-08-06T16:00:32.134Z','12:00pm - 02:00pm','123456',_binary '¨\Ì\0sr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0d','5','7757872958','Test','2024-08-28 21:29:40.501154',5,'Phase 1, Hinjawadi Rajiv Gandhi Infotech Park','8830886558','abhijit',40,10,20,30,NULL),(24,'Hinjwadi pune near wakad bridge pune, 4230001','2024-08-28 21:25:04.785194',10,'Hinjewadi','Plastic','600','Completed','10','2024-08-06T16:00:32.134Z','12:00pm - 02:00pm','123456',_binary '¨\Ì\0sr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0d','5','7757872958','Test','2024-08-28 21:32:22.179225',5,'Phase 1, Hinjawadi Rajiv Gandhi Infotech Park','8830886558','abhijit',40,10,20,30,'1'),(25,'Hinjwadi pune near wakad bridge pune, 4230001','2024-08-28 21:25:12.843663',10,'Hinjewadi','Plastic','600','Pending','10','2024-08-06T16:00:32.134Z','12:00pm - 02:00pm','123456',_binary '¨\Ì\0sr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0d','5','7757872958','Test','2024-08-28 21:25:12.843663',2,'Phase 1, Hinjawadi Rajiv Gandhi Infotech Park','8830886558','abhijit',40,10,20,30,NULL),(26,'Hinjwadi pune near wakad bridge pune, 4230001','2024-08-28 21:25:21.088632',10,'Hinjewadi','Plastic','600','Pending','10','2024-08-06T16:00:32.134Z','12:00pm - 02:00pm','123456',_binary '¨\Ì\0sr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0d','5','7757872958','Test','2024-08-28 21:25:21.088632',3,'Phase 1, Hinjawadi Rajiv Gandhi Infotech Park','8830886558','abhijit',40,10,20,30,NULL),(27,'Hinjwadi pune near wakad bridge pune, 4230001','2024-08-28 21:25:31.785055',10,'Hinjewadi','Plastic','600','Pending','10','2024-08-06T16:00:32.134Z','12:00pm - 02:00pm','123456',_binary '¨\Ì\0sr\0java.lang.Integer‚†§˜Åá8\0I\0valuexr\0java.lang.NumberÜ¨ïî\‡ã\0\0xp\0\0\0d','5','7757872958','Test','2024-08-28 21:25:31.786052',5,'Phase 1, Hinjawadi Rajiv Gandhi Infotech Park','8830886558','abhijit',40,10,20,30,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `p_description` varchar(255) DEFAULT NULL,
  `p_name` varchar(255) DEFAULT NULL,
  `p_price` decimal(38,2) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2023-12-15 08:30:00.000000','Lorem ipsum dolor sit amet consectetur adipisicing elit','Plastic',10.00,'2023-12-15 08:30:00.000000','1'),(2,'2023-12-16 10:45:00.000000','Maxime mollitia,','Metal',20.00,'2023-12-16 10:45:00.000000','1'),(3,'2023-12-17 12:20:00.000000','repudiandae consequuntur voluptatum laborum','Paper',10.00,'2023-12-17 12:20:00.000000','1'),(4,'2023-12-18 14:55:00.000000','numquam blanditiis harum quisquam eius','Electronics',50.00,'2023-12-18 14:55:00.000000','1');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `schedule_time` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `landmark` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `pincode` int DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Phase 1, Hinjawadi Rajiv Gandhi Infotech Park',NULL,'abcgmail.com','dfsll','abhijit','8830886558',123456,'vendor','active',NULL),(3,'Hinjwadi pune near wakad bridge pune, 4230001','2024-08-05 23:54:16.200032','abhijitkolambe1@gmail.com','Hinjewadi','Test','7757872958',123456,'user',NULL,'2024-08-05 23:54:16.200032');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `balance` decimal(38,2) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `vendor_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (10,600.00,'2024-08-28 21:29:40.000000','2024-08-28 21:29:40.000000',5,'1'),(11,600.00,'2024-08-28 21:32:22.000000','2024-08-28 21:32:22.000000',5,'1');
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-28 22:23:01
