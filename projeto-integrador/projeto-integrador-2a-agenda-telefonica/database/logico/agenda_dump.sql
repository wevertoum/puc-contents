-- MySQL dump 10.13  Distrib 9.3.0, for macos13.7 (x86_64)
--
-- Host: localhost    Database: AgendaTelefonica
-- ------------------------------------------------------
-- Server version	9.3.0

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
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contato` (
  `id_contato` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(30) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_contato`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (4,'Ana Clara Souza','(62) 99876-5432','ana.souza@example.com'),(5,'Bruno Carvalho','62 98765-4321','bruno.c@example.com'),(6,'Carlos Eduardo Lima','(62) 99123-4567','carlos.lima@work.net'),(7,'Daniela Martins','98855-1122','dani.martins@email.org'),(8,'Eduardo Ferreira','(62) 3223-3344','edu.ferreira@gmail.com'),(9,'Fernanda Gonçalves','62996543210','fernanda.g@yahoo.com'),(10,'Gustavo Rodrigues','062981112233','gustavo.rodrigues@live.com'),(11,'Helena Almeida','(62) 98234-5678','helena.a@me.com'),(12,'Igor Nogueira','99988-7766','igor.n@corp.com'),(13,'Juliana Ribeiro','62 98555-4433','juliana.ribeiro@example.com'),(14,'Kleber Santos','(62) 99654-3210','kleber.santos@mail.com'),(15,'Larissa Neves','62 98123-9876','larissa.neves@hotmail.com'),(16,'Marcos Vinícius Rocha','(62) 99221-3344','marcos.v.rocha@gmail.com'),(17,'Natália Costa','62 98777-2233','natalia.costa@outlook.com'),(18,'Otávio Bernardes','62987654321','otavio.b@empresa.com'),(19,'Paula Menezes','(62) 99444-5566','paula.menezes@email.com'),(20,'Rafael Barros','06299887766','rafael.barros@workmail.com'),(21,'Sabrina Oliveira','(62) 98111-3344','sabrina.oliveira@web.com'),(22,'Thiago Silva','62 99000-1122','thiago.silva@gmail.com'),(23,'Úrsula Farias','6299554433','ursula.farias@outlook.com'),(24,'Vinícius Teixeira','(62) 98765-0099','vinicius.t@gmail.com'),(25,'Wesley Lopes','6299442211','wesley.lopes@email.org'),(26,'Yasmin Duarte','62 98123-4455','yasmin.duarte@example.com'),(27,'Zuleica Mendes','(62) 99222-6677','zuleica.mendes@dominio.com'),(28,'Alexandre Prado','62 98080-8080','alex.prado@me.com'),(29,'Beatriz Antunes','62998887755','bia.antunes@yahoo.com'),(30,'Cíntia Leal','(62) 98333-1122','cintia.leal@corp.net'),(31,'Diego Moura','62 97777-6666','diego.moura@workmail.com'),(32,'Érica Campos','(62) 97654-3211','erica.campos@gmail.com'),(33,'Fábio Trindade','62 96543-2109','fabio.trindade@empresa.com');
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-19 18:28:08
