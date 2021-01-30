create database jmd;
use jmd;
CREATE TABLE `jmd`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

insert into user values(103,'Spiderman','web');
insert into user values(104,'Superman','fly');

select * from user;

ALTER TABLE `jmd`.`user` 
CHANGE COLUMN `password` `password` VARCHAR(200) NULL DEFAULT NULL ;

insert into user values(101,'rohit','$2a$10$Ezd6s61bBDdTN4vl6nSAYObBGtIy0j1bzx9C8LbRiuTrv6TqxMEre');
select * from user;