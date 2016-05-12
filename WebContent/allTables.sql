user:
create table user (
	userId int primary key auto_increment,
	email varchar(255) not null,
	userPassword varchar(255) not null,
	userRole int default 0
);

/*
userId
userNackName
userPassword
userTel
userRole

private Integer flowerId = 0;
	private String flowerName = "鲜花";
	private String flowerCategary = "";
	private String flowerPicture = "";
	private String flowerDescribe = "";
	private String flowePrice = "";
	*/
create table flower (
	flowerId int primary key auto_increment,
	flowerName varchar(255) unique,
	flowerCategary varchar(255) not null,
	flowerPicture varchar(255) not null,
	flowePrice varchar(11) not null,
	flowerDescribe text not null
);

create table message (
	messageId int primary key auto_increment,
	userId int references user(userId),
	messageContent text not null,
	messageTiem datetime
);
/*
| publicMsgId      | int(11)      | NO   | PRI | NULL              | auto_increment |
| publicMsgTheme   | varchar(255) | NO   |     | NULL              |                |
| publicMsgContent | text         | NO   |     | NULL              |                |
| publicMsgTime    | datetime     | YES  |     | CURRENT_TIMESTAMP |
*/
/*
flowerOrder
orderId
userId
addr
orderDate
status
*/
create table flowerOrder (

	orderId int primary key auto_increment,
	userId int references user(userId),
	addr varchar(255) not null,
	status int default 0,
	orderDate datetime default now()
);
/*
flowerId
unitPrice
flowerCount
flowerOrderId
*/
create table flowerOrderItem (
	ItemId int primary key auto_increment,
	flowerId int references flower(flowerId),
	unitPrice varchar(11) default '0',
	flowerCount int default 0,
	flowerOrderId references flowerOrder(orderId)
);



