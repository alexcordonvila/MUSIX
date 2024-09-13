-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: db_musix
-- ------------------------------------------------------
-- Server version	9.0.0

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
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL,
  `rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'usuario'),(3,'baneado');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `userpassword` varchar(45) NOT NULL,
  `FK_rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','123','1'),(2,'user1','userpass123','2'),(3,'user2','userpass456','2'),(4,'banned','123','3'),(5,'user','123','2'),(6,'user3','123','3'),(7,'banned2','123','3');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_videos`
--

DROP TABLE IF EXISTS `v_videos`;
/*!50001 DROP VIEW IF EXISTS `v_videos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_videos` AS SELECT 
 1 AS `video_id`,
 1 AS `video_link`,
 1 AS `video_title`,
 1 AS `video_description`,
 1 AS `user_id`,
 1 AS `username`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `link` varchar(45) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `FK_usuario` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (3,'https://www.youtube.com/watch?v=cRaFCr9irRw','Cómo hacer una API REST','Aprende a construir una API REST desde cero.',3),(4,'https://www.youtube.com/watch?v=cRaFCr9irRw','JavaScript avanzado','Conceptos avanzados en JavaScript.',1),(5,'https://www.youtube.com/watch?v=cRaFCr9irRw','Diseño de bases de datos','Cómo diseñar una base de datos relacional.',1),(6,'https://www.youtube.com/watch?v=Sagg08DrO5U','Gandalf','Gandalf 10 hour video',2),(14,'https://www.youtube.com/watch?v=cRaFCr9irRw','sdfgdfgdfsgfd','			asdfasdfsafsdf',7),(15,'https://www.youtube.com/watch?v=cRaFCr9irRw','asdfsadfsadfsafdsdfsfdsadfsfsfsf','wsdafsdfdsfsadfsafdsdafsdf			',7),(21,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','			asdasdsad',5),(24,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','			asdasd',5),(25,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','			asdasd',5),(26,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','			adssda',5),(34,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','		sasdasdsad	',5),(35,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','		sasdasdsad	',5),(36,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','		sasdasdsad	',5),(39,'https://www.youtube.com/watch?v=Sagg08DrO5U','asdasd','		',5),(40,'https://www.youtube.com/watch?v=Sagg08DrO5U','asdasd','		',5),(41,'https://www.youtube.com/watch?v=Sagg08DrO5U','test','		',5),(44,'https://www.youtube.com/watch?v=Sagg08DrO5U','asdasd','		',5);
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `v_videos`
--

/*!50001 DROP VIEW IF EXISTS `v_videos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_videos` AS select `v`.`id` AS `video_id`,`v`.`link` AS `video_link`,`v`.`titulo` AS `video_title`,`v`.`descripcion` AS `video_description`,`u`.`id` AS `user_id`,`u`.`usuario` AS `username` from (`videos` `v` join `usuarios` `u` on((`v`.`FK_usuario` = `u`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-13 10:10:51
