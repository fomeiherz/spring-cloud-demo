CREATE DATABASE `sso` CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `interface_limit` (
`id`  int NOT NULL ,
`interfaceId`  int NULL ,
`unitTime`  int NULL ,
`unitNum`  int NULL ,
PRIMARY KEY (`id`)
)

INSERT INTO `sso`.`interface_limit` (`id`, `interfaceId`, `unitTime`, `unitNum`) VALUES ('1', '23', '60', '10');
