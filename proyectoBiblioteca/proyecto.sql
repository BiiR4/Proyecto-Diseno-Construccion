-- MySQL Script generated by MySQL Workbench
-- sáb 09 dic 2017 19:58:50 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ProyectoPrueba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ProyectoPrueba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ProyectoPrueba` DEFAULT CHARACTER SET utf8 ;
USE `ProyectoPrueba` ;

-- -----------------------------------------------------
-- Table `ProyectoPrueba`.`UsuarioSistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProyectoPrueba`.`UsuarioSistema` (
  `noPersonalSistema` VARCHAR(10) NOT NULL,
  `nombreUsuario` VARCHAR(15) NOT NULL,
  `apellidoPaterno` VARCHAR(15) NOT NULL,
  `apellidoMaterno` VARCHAR(15) NOT NULL,
  `nivelAcceso` INT NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`noPersonalSistema`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProyectoPrueba`.`Academico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProyectoPrueba`.`Academico` (
  `nombreAc` VARCHAR(15) NOT NULL,
  `apellidoPaterno` VARCHAR(15) NOT NULL,
  `apellidoMaterno` VARCHAR(15) NOT NULL,
  `telefono` INT(11) NULL,
  `email` VARCHAR(45) NOT NULL,
  `moroso` BIT(0) NOT NULL,
  `noPersonal` VARCHAR(10) NOT NULL,
  `programaAdscripcion` VARCHAR(40) NOT NULL,
  `tipoAcademico` INT(11) NOT NULL,
  PRIMARY KEY (`noPersonal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProyectoPrueba`.`Alumno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProyectoPrueba`.`Alumno` (
  `nombreAl` VARCHAR(15) NOT NULL,
  `apellidoPaterno` VARCHAR(15) NOT NULL,
  `apellidoMaterno` VARCHAR(15) NOT NULL,
  `telefono` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `moroso` BIT(0) NOT NULL,
  `matricula` VARCHAR(10) NOT NULL,
  `carrera` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProyectoPrueba`.`MaterialBibliografico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProyectoPrueba`.`MaterialBibliografico` (
  `identificador` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(45) NOT NULL,
  `tematicaArea` VARCHAR(45) NOT NULL,
  `tipoAdquisicion` VARCHAR(45) NOT NULL,
  `refDocumento` VARCHAR(45) NULL,
  `ubicacion` VARCHAR(45) NULL,
  `tituloMaterial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`identificador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ProyectoPrueba`.`Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ProyectoPrueba`.`Prestamo` (
  `idPrestamo` INT NOT NULL AUTO_INCREMENT,
  `fechaPedido` DATE NOT NULL,
  `fechaEntrega` DATE NULL,
  `deuda` INT NULL,
  PRIMARY KEY (`idPrestamo`),
  CONSTRAINT `tituloMaterial`
    FOREIGN KEY (tituloMaterial)
    REFERENCES `ProyectoPrueba`.`MaterialBibliografico` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nombre`
    FOREIGN KEY (nombreUsuario)
    REFERENCES `ProyectoPrueba`.`UsuarioSistema` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nombreAc`
    FOREIGN KEY (nombreAc)
    REFERENCES `ProyectoPrueba`.`Academico` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `nombreAl`
    FOREIGN KEY (nombreAl)
    REFERENCES `ProyectoPrueba`.`Alumno` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
