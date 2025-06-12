-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`artista`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`artista` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`artista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`disquera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`disquera` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`disquera` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`genero_musical`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`genero_musical` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`genero_musical` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`disco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`disco` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`disco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NOT NULL,
  `precio` FLOAT(5,2) NOT NULL,
  `existencia` INT NOT NULL,
  `descuento` FLOAT(2,2) NOT NULL,
  `fecha_lanzamiento` DATE NOT NULL,
  `imagen` VARCHAR(120) NOT NULL,
  `id_artista` INT NOT NULL,
  `id_disquera` INT NOT NULL,
  `id_genero_musical` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_disco_artista`
    FOREIGN KEY (`id_artista`)
    REFERENCES `mydb`.`artista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disco_Disquera1`
    FOREIGN KEY (`id_disquera`)
    REFERENCES `mydb`.`disquera` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disco_genero_musical1`
    FOREIGN KEY (`id_genero_musical`)
    REFERENCES `mydb`.`genero_musical` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_disco_artista_idx` ON `mydb`.`disco` (`id_artista` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_disco_Disquera1_idx` ON `mydb`.`disco` (`id_disquera` ASC) ;

SHOW WARNINGS;
CREATE INDEX `fk_disco_genero_musical1_idx` ON `mydb`.`disco` (`id_genero_musical` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `mydb`.`cancion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`cancion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `mydb`.`cancion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(100) NOT NULL,
  `duracion` TIME NOT NULL,
  `disco_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cancion_disco1`
    FOREIGN KEY (`disco_id`)
    REFERENCES `mydb`.`disco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_cancion_disco1_idx` ON `mydb`.`cancion` (`disco_id` ASC) ;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
