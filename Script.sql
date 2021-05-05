--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `mailing`.`user` DROP PRIMARY KEY;

ALTER TABLE `mailing`.`user` DROP INDEX `mailing`.`id`;

DROP TABLE `mailing`.`user`;

CREATE TABLE `mailing`.`user` (
	`id` INT NOT NULL,
	`name` VARCHAR(10) NOT NULL,
	`fname` VARCHAR(10) NOT NULL,
	`user` VARCHAR(10) NOT NULL,
	`pass` VARCHAR(20) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;

CREATE UNIQUE INDEX `id` ON `mailing`.`user` (`id` ASC);

