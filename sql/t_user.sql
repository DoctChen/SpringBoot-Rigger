/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.34-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `users` (
	`id` int (11),
	`name` varchar (180),
	`order_id` varchar (1800),
	`address` varchar (1800)
); 
insert into `users` (`id`, `name`, `order_id`, `address`) values('1','cx','2','黄埔区');
insert into `users` (`id`, `name`, `order_id`, `address`) values('2','wy','3','静安区');
insert into `users` (`id`, `name`, `order_id`, `address`) values('3','lisi','5','闵行区');
