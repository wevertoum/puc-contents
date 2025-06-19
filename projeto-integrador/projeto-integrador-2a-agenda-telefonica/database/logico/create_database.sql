-- MySQL Script generated for Projeto Agenda Telefônica
-- Thu Jun 19 17:30:00 2025
-- Model: Agenda Simples     Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema AgendaTelefonica
-- -----------------------------------------------------
-- Schema para armazenar contatos de uma agenda pessoal.
DROP SCHEMA IF EXISTS `AgendaTelefonica` ;
CREATE SCHEMA IF NOT EXISTS `AgendaTelefonica` DEFAULT CHARACTER SET utf8mb4 ;
USE `AgendaTelefonica` ;

-- -----------------------------------------------------
-- Table `AgendaTelefonica`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AgendaTelefonica`.`contato` (
  `id_contato` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(30) NOT NULL,
  `email` VARCHAR(255) NULL,
  PRIMARY KEY (`id_contato`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

