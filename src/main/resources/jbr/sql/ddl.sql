CREATE DATABASE IF NOT EXISTS spring_mvc;

USE spring_mvc;

DROP TABLE IF EXISTS `spring_mvc`.`users`;

CREATE TABLE `spring_mvc`.`users` (
  `userid` NUMBER(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `role` VARCHAR(45)  NULL
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`username`));