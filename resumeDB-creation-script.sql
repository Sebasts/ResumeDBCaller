-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema resume
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `resume` ;

-- -----------------------------------------------------
-- Schema resume
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `resume` DEFAULT CHARACTER SET utf8 ;
USE `resume` ;

-- -----------------------------------------------------
-- Table `resume`.`resume`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`resume` ;

CREATE TABLE IF NOT EXISTS `resume`.`resume` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `owner` VARCHAR(255) NOT NULL,
  `isDefault` TINYINT(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idresume_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resume`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`address` ;

CREATE TABLE IF NOT EXISTS `resume`.`address` (
  `id` INT(11) NOT NULL,
  `street_address` VARCHAR(150) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(2) NOT NULL,
  `zipcode` VARCHAR(10) NOT NULL,
  `apt_number` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `address_resume_id`
    FOREIGN KEY (`id`)
    REFERENCES `resume`.`resume` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resume`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`organization` ;

CREATE TABLE IF NOT EXISTS `resume`.`organization` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `from_date` DATETIME NOT NULL,
  `to_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `org_resume_id`
    FOREIGN KEY (`id`)
    REFERENCES `resume`.`resume` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resume`.`bullet_points`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`bullet_points` ;

CREATE TABLE IF NOT EXISTS `resume`.`bullet_points` (
  `bullet_point_id` INT NOT NULL AUTO_INCREMENT,
  `id` INT(11) NOT NULL,
  `content` VARCHAR(4000) NOT NULL,
  PRIMARY KEY (`bullet_point_id`, `id`),
  UNIQUE INDEX `bullet_point_id_UNIQUE` (`bullet_point_id` ASC) VISIBLE,
  CONSTRAINT `bullet-organization-fk`
    FOREIGN KEY (`id`)
    REFERENCES `resume`.`organization` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resume`.`education`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`education` ;

CREATE TABLE IF NOT EXISTS `resume`.`education` (
  `id` INT(11) NOT NULL,
  `to_date` DATE NOT NULL,
  `from_date` DATE NOT NULL,
  `content` VARCHAR(4000) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `education_resume_id`
    FOREIGN KEY (`id`)
    REFERENCES `resume`.`resume` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resume`.`intro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`intro` ;

CREATE TABLE IF NOT EXISTS `resume`.`intro` (
  `id` INT(11) NOT NULL,
  `content` VARCHAR(4000) CHARACTER SET 'cp1257' NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `intro_resume_id`
    FOREIGN KEY (`id`)
    REFERENCES `resume`.`resume` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 25
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `resume`.`skills`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume`.`skills` ;

CREATE TABLE IF NOT EXISTS `resume`.`skills` (
  `skill_id` INT NOT NULL AUTO_INCREMENT,
  `id` INT(11) NOT NULL,
  `content` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`skill_id`, `id`),
  CONSTRAINT `skills_resume_id`
    FOREIGN KEY (`id`)
    REFERENCES `resume`.`resume` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
