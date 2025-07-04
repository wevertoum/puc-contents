-- MySQL Script generated by MySQL Workbench
-- Tue Jun 18 00:00:35 2025
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET
    @OLD_UNIQUE_CHECKS = @ @UNIQUE_CHECKS,
    UNIQUE_CHECKS = 0;

SET
    @OLD_FOREIGN_KEY_CHECKS = @ @FOREIGN_KEY_CHECKS,
    FOREIGN_KEY_CHECKS = 0;

SET
    @OLD_SQL_MODE = @ @SQL_MODE,
    SQL_MODE = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SistemaProdutos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SistemaProdutos` DEFAULT CHARACTER SET utf8;

USE `SistemaProdutos`;

-- -----------------------------------------------------
-- Table `SistemaProdutos`.`tipo_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaProdutos`.`tipo_produto` (
    `tip_codigo` INT NOT NULL,
    `tip_descricao` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`tip_codigo`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `SistemaProdutos`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SistemaProdutos`.`produto` (
    `pro_codigo` INT NOT NULL,
    `pro_descricao` VARCHAR(255) NOT NULL,
    `tip_codigo` INT NOT NULL,
    PRIMARY KEY (`pro_codigo`),
    INDEX `fk_produto_tipo_produto_idx` (`tip_codigo` ASC) VISIBLE,
    CONSTRAINT `fk_produto_tipo_produto` FOREIGN KEY (`tip_codigo`) REFERENCES `SistemaProdutos`.`tipo_produto` (`tip_codigo`) ON DELETE NO ACTION -- Ou SET NULL se for permitido que um produto exista sem um tipo
    ON UPDATE CASCADE -- Se o código do tipo de produto mudar, atualiza aqui
) ENGINE = InnoDB;

SET
    SQL_MODE = @OLD_SQL_MODE;

SET
    FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;

SET
    UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;