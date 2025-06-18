-- MySQL Script generated for MySQL Workbench
-- Wed Jun 18 01:01:00 2025
-- Model: Adapted Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema EmpresaEngenharia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `EmpresaEngenharia` DEFAULT CHARACTER SET utf8 ;
USE `EmpresaEngenharia` ;

-- -----------------------------------------------------
-- Table `EmpresaEngenharia`.`Departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EmpresaEngenharia`.`Departamento` (
  `CodDepto` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`CodDepto`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `EmpresaEngenharia`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EmpresaEngenharia`.`Funcionario` (
  `CodFuncionario` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(50) NOT NULL,
  `Nome` VARCHAR(255) NOT NULL,
  `CPF` VARCHAR(14) NOT NULL,
  `CodDepto` INT NULL,
  PRIMARY KEY (`CodFuncionario`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC) VISIBLE,
  INDEX `fk_Funcionario_Departamento_idx` (`CodDepto` ASC) VISIBLE,
  CONSTRAINT `fk_Funcionario_Departamento`
    FOREIGN KEY (`CodDepto`)
    REFERENCES `EmpresaEngenharia`.`Departamento` (`CodDepto`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `EmpresaEngenharia`.`Engenheiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EmpresaEngenharia`.`Engenheiro` (
  `CodEng` INT NOT NULL AUTO_INCREMENT,
  `CREA` VARCHAR(20) NOT NULL,
  `CodFunc` INT NULL,
  PRIMARY KEY (`CodEng`),
  UNIQUE INDEX `CREA_UNIQUE` (`CREA` ASC) VISIBLE,
  INDEX `fk_Engenheiro_Funcionario_idx` (`CodFunc` ASC) VISIBLE,
  CONSTRAINT `fk_Engenheiro_Funcionario`
    FOREIGN KEY (`CodFunc`)
    REFERENCES `EmpresaEngenharia`.`Funcionario` (`CodFuncionario`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `EmpresaEngenharia`.`Projeto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `EmpresaEngenharia`.`Projeto` (
  `CodProjeto` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(255) NOT NULL,
  `CodEng` INT NULL,
  PRIMARY KEY (`CodProjeto`),
  INDEX `fk_Projeto_Engenheiro_idx` (`CodEng` ASC) VISIBLE,
  CONSTRAINT `fk_Projeto_Engenheiro`
    FOREIGN KEY (`CodEng`)
    REFERENCES `EmpresaEngenharia`.`Engenheiro` (`CodEng`)
    ON DELETE SET NULL
    ON UPDATE CASCADE
) ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;