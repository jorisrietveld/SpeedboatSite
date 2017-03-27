DROP DATABASE IF EXISTS `SpeedboatRentalSite`;
CREATE DATABASE `SpeedboatRentalSite`;

USE `SpeedboatRentalSite`;

/**
 * The speedboat table this table contains all speedboats that the Titanic Speedboat rental company owns.
 */
DROP TABLE IF EXISTS `Speedboat`;
CREATE TABLE `Speedboat` (
  `id`           INT UNSIGNED UNIQUE AUTO_INCREMENT                             NOT NULL,
  `weight`       SMALLINT UNSIGNED                                              NOT NULL,
  `horsePower`   SMALLINT UNSIGNED                                              NOT NULL,
  `boatNumber`   INT UNSIGNED UNIQUE                                            NOT NULL,
  `rent`         DECIMAL(6, 2)                                                  NOT NULL,
  `dateAdded`    DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  `dateModified` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,

  CONSTRAINT pk_speedboat PRIMARY KEY Speedboat(`id`)
);

/**
 * The customer table this table contains all Titanic speedboat rentals customers.
 */
DROP TABLE IF EXISTS `Customer`;
CREATE TABLE `Customer` (
  `id`              INT UNSIGNED UNIQUE AUTO_INCREMENT                             NOT NULL,
  `firstName`       VARCHAR(100)                                                   NOT NULL,
  `lastName`        VARCHAR(100)                                                   NOT NULL,
  `email`           VARCHAR(255)                                                   NULL,
  `telephoneNumber` VARCHAR(50)                                                    NULL,
  `dateAdded`       DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  `dateModified`    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,

  CONSTRAINT pk_customer PRIMARY KEY Customer(`id`),
  CONSTRAINT CHECK ( Customer.email IS NOT NULL OR Customer.telephoneNumber IS NOT NULL )
);

/**
 * The rental table this table contains all speedboat rental records.
 */
DROP TABLE IF EXISTS `Rental`;
CREATE TABLE `Rental` (
  `id`              INT UNSIGNED UNIQUE AUTO_INCREMENT                             NOT NULL,
  `speedboatId`     INT UNSIGNED                                                   NOT NULL,
  `customerId`      INT UNSIGNED                                                   NOT NULL,
  `fuelLevelStart`  INT UNSIGNED                                                   NOT NULL,
  `fuelLevelEnd`    INT UNSIGNED                                                   NULL,
  `currentlyRented` BOOLEAN DEFAULT TRUE                                           NOT NULL,
  `rentedStartDate` DATETIME                                                       NOT NULL,
  `rentedEndDate`   DATETIME                                                       NULL,
  `dateAdded`       DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  `dateModified`    DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,

  CONSTRAINT pk_rental PRIMARY KEY Rental(`id`),
  CONSTRAINT fk_speedboat FOREIGN KEY Rental(`speedboatId`) REFERENCES Speedboat (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_customer FOREIGN KEY Rental(`customerId`) REFERENCES Customer (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

/**
 * The damage report table this table contains all damage reports that are filed to an certain rental.
 */
DROP TABLE IF EXISTS `DamageReport`;
CREATE TABLE `DamageReport` (
  `id`           INT UNSIGNED UNIQUE AUTO_INCREMENT                             NOT NULL,
  `rentalId`     INT UNSIGNED                                                   NOT NULL,
  `title`        VARCHAR(100) DEFAULT 'Damage Report'                           NOT NULL,
  `description`  MEDIUMTEXT                                                     NOT NULL,
  `cost`         DECIMAL(6, 2)                                                  NOT NULL,
  `dateAdded`    DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  `dateModified` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,

  CONSTRAINT pk_damageReport PRIMARY KEY DamageReport(`id`),
  CONSTRAINT fk_rental FOREIGN KEY DamageReport(`rentalId`) REFERENCES Rental (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User`(
  `id` INT UNSIGNED UNIQUE AUTO_INCREMENT NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `dateAdded`    DATETIME DEFAULT CURRENT_TIMESTAMP                             NOT NULL,
  `dateModified` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,

  CONSTRAINT pk_user PRIMARY KEY User(`id`)
);

SELECT `id`, `username` FROM `SpeedboatRentalSite`.`User` WHERE `User`.`username` = 1;