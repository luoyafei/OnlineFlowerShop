create database onlineFlowerShop;

use onlineFlowerShop;

用来记录注册的用户
create table user (
	userId int primary key auto_increment,
	email varchar(255) not null,
	userPassword varchar(255) not null,
	userRole int default 0
);

用来记录上传的鲜花
create table flower (
	flowerId int primary key auto_increment,
	flowerName varchar(255) unique,
	flowerCategary varchar(255) not null,
	flowerPicture varchar(255) not null,
	flowePrice varchar(11) not null,
	flowerDescribe text not null
);
用来记录反馈信息
create table message (
	messageId int primary key auto_increment,
	userId int references user(userId),
	messageContent text not null,
	messageTiem datetime
);
用来记录订单
create table flowerOrder (
	orderId int primary key auto_increment,
	userId int references user(userId),
	addr varchar(255) not null,
	status int default 0,
	orderDate datetime default now()
);
用来记录订单中的单个订单item条目
create table flowerOrderItem (
	ItemId int primary key auto_increment,
	flowerId int references flower(flowerId),
	unitPrice varchar(11) default '0',
	flowerCount int default 0,
	flowerOrderId int  references flowerOrder(orderId)
);
用来记录访问过的用户
create table webCount (
	countId int primary key auto_increment,
	webIp varchar(30) unique,
	countNum int default 0
);
