-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BASEDATOS
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BASEDATOS
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BASEDATOS` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema nomina
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema nomina
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nomina` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `BASEDATOS` ;

-- -----------------------------------------------------
-- Table `BASEDATOS`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`rol` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombre_rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` VARCHAR(100) NULL,
  `password` VARCHAR(400) NULL,
  `correo_electronico` VARCHAR(100) NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`temporada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`temporada` (
  `idtemporada` INT NOT NULL,
  `year` INT NULL,
  `mes` INT NULL,
  `temporada` VARCHAR(45) NULL,
  PRIMARY KEY (`idtemporada`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`cosecha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`cosecha` (
  `idcosecha` INT NOT NULL,
  `fecha_de_siembra` VARCHAR(45) NOT NULL,
  `cantidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcosecha`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`invernadero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`invernadero` (
  `idinvernadero` INT NOT NULL,
  `numero_invernadero` INT NULL,
  `cultivo` VARCHAR(100) NULL,
  `cosecha_idcosecha` INT NOT NULL,
  PRIMARY KEY (`idinvernadero`),
  INDEX `fk_invernadero_cosecha1_idx` (`cosecha_idcosecha` ASC) VISIBLE,
  CONSTRAINT `fk_invernadero_cosecha1`
    FOREIGN KEY (`cosecha_idcosecha`)
    REFERENCES `BASEDATOS`.`cosecha` (`idcosecha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`variedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`variedad` (
  `idvariedad` INT NOT NULL,
  `orden_proceso` INT NULL,
  `foundation` INT NULL,
  `descripcion` VARCHAR(100) NULL,
  `numero_bass` INT NULL,
  `fecha_inicio` DATE NULL,
  `fecha_parado` DATE NULL,
  `invernadero_idinvernadero` INT NULL,
  `parental` VARCHAR(45) NULL,
  `cosecha_idcosecha` INT NOT NULL,
  PRIMARY KEY (`idvariedad`),
  INDEX `fk_variedad_invernadero1_idx` (`invernadero_idinvernadero` ASC) VISIBLE,
  INDEX `fk_variedad_cosecha1_idx` (`cosecha_idcosecha` ASC) VISIBLE,
  CONSTRAINT `fk_variedad_invernadero1`
    FOREIGN KEY (`invernadero_idinvernadero`)
    REFERENCES `BASEDATOS`.`invernadero` (`idinvernadero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_variedad_cosecha1`
    FOREIGN KEY (`cosecha_idcosecha`)
    REFERENCES `BASEDATOS`.`cosecha` (`idcosecha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`rendimiento_variedad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`rendimiento_variedad` (
  `idrendimiento_variedad` INT NOT NULL,
  `numero_bancas` INT NULL,
  `rendimiento_total` INT NULL,
  `variedad_idvariedad` INT NULL,
  PRIMARY KEY (`idrendimiento_variedad`),
  INDEX `fk_rendimiento_variedad_variedad1_idx` (`variedad_idvariedad` ASC) VISIBLE,
  CONSTRAINT `fk_rendimiento_variedad_variedad1`
    FOREIGN KEY (`variedad_idvariedad`)
    REFERENCES `BASEDATOS`.`variedad` (`idvariedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`dato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`dato` (
  `iddato` INT NOT NULL,
  `fecha` DATE NULL,
  `temporada_idtemporada` INT NULL,
  `variedad_idvariedad` INT NULL,
  PRIMARY KEY (`iddato`),
  INDEX `fk_dato_temporada1_idx` (`temporada_idtemporada` ASC) VISIBLE,
  INDEX `fk_dato_variedad1_idx` (`variedad_idvariedad` ASC) VISIBLE,
  CONSTRAINT `fk_dato_temporada1`
    FOREIGN KEY (`temporada_idtemporada`)
    REFERENCES `BASEDATOS`.`temporada` (`idtemporada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dato_variedad1`
    FOREIGN KEY (`variedad_idvariedad`)
    REFERENCES `BASEDATOS`.`variedad` (`idvariedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`comentario` (
  `idcomentario` INT NOT NULL,
  `nombre_completo` VARCHAR(100) NULL,
  `descripcion` VARCHAR(300) NULL,
  `codigo_trabajador` INT NULL,
  `usuario_idusuario` INT NULL,
  `variedad_idvariedad` INT NULL,
  PRIMARY KEY (`idcomentario`),
  INDEX `fk_comentario_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  INDEX `fk_comentario_variedad1_idx` (`variedad_idvariedad` ASC) VISIBLE,
  CONSTRAINT `fk_comentario_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BASEDATOS`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentario_variedad1`
    FOREIGN KEY (`variedad_idvariedad`)
    REFERENCES `BASEDATOS`.`variedad` (`idvariedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`enviomensaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`enviomensaje` (
  `idenviomensaje` INT NOT NULL,
  `mensaje` VARCHAR(45) NULL,
  `usuario_idusuario` INT NULL,
  `invernadero_idinvernadero` INT NULL,
  PRIMARY KEY (`idenviomensaje`),
  INDEX `fk_enviomensaje_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  INDEX `fk_enviomensaje_invernadero1_idx` (`invernadero_idinvernadero` ASC) VISIBLE,
  CONSTRAINT `fk_enviomensaje_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BASEDATOS`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_enviomensaje_invernadero1`
    FOREIGN KEY (`invernadero_idinvernadero`)
    REFERENCES `BASEDATOS`.`invernadero` (`idinvernadero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`bolsa_de_semilla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`bolsa_de_semilla` (
  `idbolsa_de_semilla` INT NOT NULL,
  `cantidad_semilla` INT NULL,
  `calidad_semilla` VARCHAR(4000) NULL,
  `fecha_recepcion` DATE NULL,
  `usuario_idusuario` INT NULL,
  `variedad_idvariedad` INT NULL,
  `invernadero_idinvernadero` INT NULL,
  PRIMARY KEY (`idbolsa_de_semilla`),
  INDEX `fk_bolsa_de_semilla_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  INDEX `fk_bolsa_de_semilla_variedad1_idx` (`variedad_idvariedad` ASC) VISIBLE,
  INDEX `fk_bolsa_de_semilla_invernadero1_idx` (`invernadero_idinvernadero` ASC) VISIBLE,
  CONSTRAINT `fk_bolsa_de_semilla_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BASEDATOS`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bolsa_de_semilla_variedad1`
    FOREIGN KEY (`variedad_idvariedad`)
    REFERENCES `BASEDATOS`.`variedad` (`idvariedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bolsa_de_semilla_invernadero1`
    FOREIGN KEY (`invernadero_idinvernadero`)
    REFERENCES `BASEDATOS`.`invernadero` (`idinvernadero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`catalogo_trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`catalogo_trabajador` (
  `idcatalogo_trabajador` INT NOT NULL,
  `usuario_idusuario` INT NULL,
  `invernadero_idinvernadero` INT NULL,
  PRIMARY KEY (`idcatalogo_trabajador`),
  INDEX `fk_catalogo_trabajador_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  INDEX `fk_catalogo_trabajador_invernadero1_idx` (`invernadero_idinvernadero` ASC) VISIBLE,
  CONSTRAINT `fk_catalogo_trabajador_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BASEDATOS`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_catalogo_trabajador_invernadero1`
    FOREIGN KEY (`invernadero_idinvernadero`)
    REFERENCES `BASEDATOS`.`invernadero` (`idinvernadero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`quimico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`quimico` (
  `idquimico` INT NOT NULL,
  `nombre_quimico` VARCHAR(45) NULL,
  `fecha_fumigacion` DATE NULL,
  `descripcion` VARCHAR(45) NULL,
  `invernadero_idinvernadero` INT NULL,
  PRIMARY KEY (`idquimico`),
  INDEX `fk_quimico_invernadero1_idx` (`invernadero_idinvernadero` ASC) VISIBLE,
  CONSTRAINT `fk_quimico_invernadero1`
    FOREIGN KEY (`invernadero_idinvernadero`)
    REFERENCES `BASEDATOS`.`invernadero` (`idinvernadero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`participacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`participacion` (
  `cosecha_idcosecha` INT NOT NULL,
  `usuario_idusuario` INT NOT NULL,
  INDEX `fk_participacion_cosecha1_idx` (`cosecha_idcosecha` ASC) VISIBLE,
  INDEX `fk_participacion_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_participacion_cosecha1`
    FOREIGN KEY (`cosecha_idcosecha`)
    REFERENCES `BASEDATOS`.`cosecha` (`idcosecha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_participacion_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BASEDATOS`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`reporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`reporte` (
  `idreporte` INT NOT NULL,
  `fecha_reporte` DATE NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `observaciones` VARCHAR(45) NOT NULL,
  `variedad_idvariedad` INT NOT NULL,
  PRIMARY KEY (`idreporte`),
  INDEX `fk_reporte_variedad1_idx` (`variedad_idvariedad` ASC) VISIBLE,
  CONSTRAINT `fk_reporte_variedad1`
    FOREIGN KEY (`variedad_idvariedad`)
    REFERENCES `BASEDATOS`.`variedad` (`idvariedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`modulo` (
  `idmodulo` INT NOT NULL,
  `nombre_modulo` VARCHAR(45) NOT NULL,
  `orden_modulo` INT NOT NULL,
  PRIMARY KEY (`idmodulo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`anuncio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`anuncio` (
  `idanuncio` INT NOT NULL,
  `texto` VARCHAR(200) NOT NULL,
  `fecha_inicio` DATETIME NULL,
  `fecha_fin` DATETIME NULL,
  `imagen` BLOB NULL,
  PRIMARY KEY (`idanuncio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`usuario_rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`usuario_rol` (
  `usuario_idusuario` INT NOT NULL,
  `rol_idrol` INT NOT NULL,
  INDEX `fk_usuario_rol_usuario1_idx` (`usuario_idusuario` ASC) VISIBLE,
  INDEX `fk_usuario_rol_rol1_idx` (`rol_idrol` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_rol_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `BASEDATOS`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rol_rol1`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `BASEDATOS`.`rol` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`menu` (
  `idmenu` INT NOT NULL AUTO_INCREMENT,
  `nombre_menu` VARCHAR(45) NOT NULL,
  `orden_menu` INT NOT NULL,
  `modulo_idmodulo` INT NOT NULL,
  PRIMARY KEY (`idmenu`),
  INDEX `fk_menu_modulo1_idx` (`modulo_idmodulo` ASC) VISIBLE,
  CONSTRAINT `fk_menu_modulo1`
    FOREIGN KEY (`modulo_idmodulo`)
    REFERENCES `BASEDATOS`.`modulo` (`idmodulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`opcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`opcion` (
  `idopcion` INT NOT NULL AUTO_INCREMENT,
  `nombre_opcion` VARCHAR(45) NOT NULL,
  `orden_opcion` INT NOT NULL,
  `menu_idmenu` INT NOT NULL,
  `url` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`idopcion`),
  INDEX `fk_opcion_menu1_idx` (`menu_idmenu` ASC) VISIBLE,
  CONSTRAINT `fk_opcion_menu1`
    FOREIGN KEY (`menu_idmenu`)
    REFERENCES `BASEDATOS`.`menu` (`idmenu`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BASEDATOS`.`rol_opcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BASEDATOS`.`rol_opcion` (
  `rol_idrol` INT NOT NULL,
  `opcion_idopcion` INT NOT NULL,
  `crear` TINYINT NULL,
  `consultar` TINYINT NULL,
  `eliminar` TINYINT NULL,
  `editar` TINYINT NULL,
  `imprimir` TINYINT NULL,
  `exportar` TINYINT NULL,
  INDEX `fk_rol_permiso_rol1_idx` (`rol_idrol` ASC) VISIBLE,
  INDEX `fk_rol_permiso_opcion1_idx` (`opcion_idopcion` ASC) VISIBLE,
  CONSTRAINT `fk_rol_permiso_rol1`
    FOREIGN KEY (`rol_idrol`)
    REFERENCES `BASEDATOS`.`rol` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rol_permiso_opcion1`
    FOREIGN KEY (`opcion_idopcion`)
    REFERENCES `BASEDATOS`.`opcion` (`idopcion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `nomina` ;

-- -----------------------------------------------------
-- Table `nomina`.`modulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`modulo` (
  `IdModulo` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `OrdenMenu` INT NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdModulo`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`menu` (
  `IdMenu` INT NOT NULL AUTO_INCREMENT,
  `IdModulo` INT NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  `OrdenMenu` INT NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdMenu`),
  INDEX `IdModulo` (`IdModulo` ASC) VISIBLE,
  CONSTRAINT `menu_ibfk_1`
    FOREIGN KEY (`IdModulo`)
    REFERENCES `nomina`.`modulo` (`IdModulo`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`opcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`opcion` (
  `IdOpcion` INT NOT NULL AUTO_INCREMENT,
  `IdMenu` INT NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  `OrdenMenu` INT NOT NULL,
  `Pagina` VARCHAR(100) NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdOpcion`),
  INDEX `IdMenu` (`IdMenu` ASC) VISIBLE,
  CONSTRAINT `opcion_ibfk_1`
    FOREIGN KEY (`IdMenu`)
    REFERENCES `nomina`.`menu` (`IdMenu`))
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`role` (
  `IdRole` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdRole`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`role_opcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`role_opcion` (
  `IdRole` INT NOT NULL,
  `IdOpcion` INT NOT NULL,
  `Alta` INT NOT NULL,
  `Baja` INT NOT NULL,
  `Cambio` INT NOT NULL,
  `Imprimir` INT NOT NULL,
  `Exportar` INT NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdRole`, `IdOpcion`),
  INDEX `IdOpcion` (`IdOpcion` ASC) VISIBLE,
  CONSTRAINT `role_opcion_ibfk_1`
    FOREIGN KEY (`IdRole`)
    REFERENCES `nomina`.`role` (`IdRole`),
  CONSTRAINT `role_opcion_ibfk_2`
    FOREIGN KEY (`IdOpcion`)
    REFERENCES `nomina`.`opcion` (`IdOpcion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`status_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`status_usuario` (
  `IdStatusUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(100) NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdStatusUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`usuario` (
  `IdUsuario` VARCHAR(100) NOT NULL,
  `Nombre` VARCHAR(100) NOT NULL,
  `Apellido` VARCHAR(100) NOT NULL,
  `FechaNacimiento` DATE NOT NULL,
  `IdStatusUsuario` INT NOT NULL,
  `Password` VARCHAR(100) NOT NULL,
  `IdGenero` INT NOT NULL,
  `UltimaFechaIngreso` DATETIME NULL DEFAULT NULL,
  `IntentosDeAcceso` INT NULL DEFAULT NULL,
  `SesionActual` VARCHAR(100) NULL DEFAULT NULL,
  `UltimaFechaCambioPassword` DATETIME NULL DEFAULT NULL,
  `CorreoElectronico` VARCHAR(100) NULL DEFAULT NULL,
  `RequiereCambiarPassword` INT NULL DEFAULT NULL,
  `Fotografia` MEDIUMBLOB NULL DEFAULT NULL,
  `TelefonoMovil` VARCHAR(30) NULL DEFAULT NULL,
  `IdSucursal` INT NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`),
  INDEX `IdStatusUsuario` (`IdStatusUsuario` ASC) VISIBLE,
  CONSTRAINT `usuario_ibfk_1`
    FOREIGN KEY (`IdStatusUsuario`)
    REFERENCES `nomina`.`status_usuario` (`IdStatusUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`usuario_pregunta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`usuario_pregunta` (
  `IdPregunta` INT NOT NULL AUTO_INCREMENT,
  `IdUsuario` VARCHAR(100) NOT NULL,
  `Pregunta` VARCHAR(100) NOT NULL,
  `Respuesta` VARCHAR(100) NOT NULL,
  `OrdenPregunta` INT NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdPregunta`),
  INDEX `IdUsuario` (`IdUsuario` ASC) VISIBLE,
  CONSTRAINT `usuario_pregunta_ibfk_1`
    FOREIGN KEY (`IdUsuario`)
    REFERENCES `nomina`.`usuario` (`IdUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `nomina`.`usuario_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `nomina`.`usuario_role` (
  `IdUsuario` VARCHAR(100) NOT NULL,
  `IdRole` INT NOT NULL,
  `FechaCreacion` DATETIME NOT NULL,
  `UsuarioCreacion` VARCHAR(100) NOT NULL,
  `FechaModificacion` DATETIME NULL DEFAULT NULL,
  `UsuarioModificacion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`, `IdRole`),
  INDEX `IdRole` (`IdRole` ASC) VISIBLE,
  CONSTRAINT `usuario_role_ibfk_1`
    FOREIGN KEY (`IdUsuario`)
    REFERENCES `nomina`.`usuario` (`IdUsuario`),
  CONSTRAINT `usuario_role_ibfk_2`
    FOREIGN KEY (`IdRole`)
    REFERENCES `nomina`.`role` (`IdRole`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
