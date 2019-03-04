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
