-- MySQL Script generated for Projeto Integrador - Controle de Vacinas
-- Wed Jun 18 16:50:00 2025
-- Model: Controle de Vacinas      Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ControleVacinas
-- -----------------------------------------------------
-- Schema para armazenar dados de vacinação da população.
DROP SCHEMA IF EXISTS `ControleVacinas` ;
CREATE SCHEMA IF NOT EXISTS `ControleVacinas` DEFAULT CHARACTER SET utf8mb4 ;
USE `ControleVacinas` ;

-- -----------------------------------------------------
-- Table `ControleVacinas`.`Regiao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Regiao` (
  `ID_Regiao` INT NOT NULL AUTO_INCREMENT,
  `Nome_Regiao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID_Regiao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Escolaridade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Escolaridade` (
  `ID_Escolaridade` INT NOT NULL AUTO_INCREMENT,
  `Nivel` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID_Escolaridade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Paciente` (
  `ID_Paciente` INT NOT NULL AUTO_INCREMENT,
  `Nome` VARCHAR(255) NOT NULL,
  `Data_Nascimento` DATE NOT NULL,
  `Endereco` VARCHAR(255) NULL,
  `ID_Regiao` INT NOT NULL,
  `ID_Escolaridade` INT NOT NULL,
  PRIMARY KEY (`ID_Paciente`),
  INDEX `fk_Paciente_Regiao_idx` (`ID_Regiao` ASC) VISIBLE,
  INDEX `fk_Paciente_Escolaridade_idx` (`ID_Escolaridade` ASC) VISIBLE,
  CONSTRAINT `fk_Paciente_Regiao`
    FOREIGN KEY (`ID_Regiao`)
    REFERENCES `ControleVacinas`.`Regiao` (`ID_Regiao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paciente_Escolaridade`
    FOREIGN KEY (`ID_Escolaridade`)
    REFERENCES `ControleVacinas`.`Escolaridade` (`ID_Escolaridade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Vacina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Vacina` (
  `ID_Vacina` INT NOT NULL AUTO_INCREMENT,
  `Nome_Vacina` VARCHAR(100) NOT NULL,
  `Fabricante` VARCHAR(100) NULL,
  PRIMARY KEY (`ID_Vacina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Aplicacao_Vacina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Aplicacao_Vacina` (
  `ID_Aplicacao` INT NOT NULL AUTO_INCREMENT,
  `Data_Aplicacao` DATE NOT NULL,
  `Numero_Dose` INT NOT NULL,
  `ID_Paciente` INT NOT NULL,
  `ID_Vacina` INT NOT NULL,
  PRIMARY KEY (`ID_Aplicacao`),
  INDEX `fk_Aplicacao_Vacina_Paciente_idx` (`ID_Paciente` ASC) VISIBLE,
  INDEX `fk_Aplicacao_Vacina_Vacina_idx` (`ID_Vacina` ASC) VISIBLE,
  CONSTRAINT `fk_Aplicacao_Vacina_Paciente`
    FOREIGN KEY (`ID_Paciente`)
    REFERENCES `ControleVacinas`.`Paciente` (`ID_Paciente`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aplicacao_Vacina_Vacina`
    FOREIGN KEY (`ID_Vacina`)
    REFERENCES `ControleVacinas`.`Vacina` (`ID_Vacina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Doenca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Doenca` (
  `ID_Doenca` INT NOT NULL AUTO_INCREMENT,
  `Nome_Doenca` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID_Doenca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Diagnostico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Diagnostico` (
  `ID_Diagnostico` INT NOT NULL AUTO_INCREMENT,
  `Data_Diagnostico` DATE NOT NULL,
  `ID_Paciente` INT NOT NULL,
  `ID_Doenca` INT NOT NULL,
  PRIMARY KEY (`ID_Diagnostico`),
  INDEX `fk_Diagnostico_Paciente_idx` (`ID_Paciente` ASC) VISIBLE,
  INDEX `fk_Diagnostico_Doenca_idx` (`ID_Doenca` ASC) VISIBLE,
  CONSTRAINT `fk_Diagnostico_Paciente`
    FOREIGN KEY (`ID_Paciente`)
    REFERENCES `ControleVacinas`.`Paciente` (`ID_Paciente`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Diagnostico_Doenca`
    FOREIGN KEY (`ID_Doenca`)
    REFERENCES `ControleVacinas`.`Doenca` (`ID_Doenca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ControleVacinas`.`Vacina_Previne_Doenca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ControleVacinas`.`Vacina_Previne_Doenca` (
  `ID_Vacina` INT NOT NULL,
  `ID_Doenca` INT NOT NULL,
  PRIMARY KEY (`ID_Vacina`, `ID_Doenca`),
  INDEX `fk_Vacina_has_Doenca_Doenca_idx` (`ID_Doenca` ASC) VISIBLE,
  INDEX `fk_Vacina_has_Doenca_Vacina_idx` (`ID_Vacina` ASC) VISIBLE,
  CONSTRAINT `fk_Vacina_has_Doenca_Vacina`
    FOREIGN KEY (`ID_Vacina`)
    REFERENCES `ControleVacinas`.`Vacina` (`ID_Vacina`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vacina_has_Doenca_Doenca`
    FOREIGN KEY (`ID_Doenca`)
    REFERENCES `ControleVacinas`.`Doenca` (`ID_Doenca`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

