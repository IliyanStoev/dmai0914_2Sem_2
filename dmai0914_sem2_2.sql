

use dmai0914_2sem_2

create table customer ( 

cid int identity(1,1) primary key(cid),
name varchar(30),
address varchar(30),
zipCode varchar(10),
city varchar(20),
phoneNo varchar(30),
email varchar(30));


create table supplier ( 

sid int identity(1,1) primary key(sid),
name varchar(30),
address varchar(30),
country varchar(30),
phoneNo varchar(30),
email varchar(30));


create table product ( 

pid int identity(1,1) primary key(pid),
name varchar(30),
purchasePrice decimal(10,2),
salesPrice decimal(10,2),
rentPrice decimal(10,2),
countryOfOrig varchar(30),
inStock int not null,
minStock int not null,
sid int, 
foreign key (sid) references supplier(sid));


create table salesOrder ( 

oid int identity(1,1) primary key(oid),
date varchar(40),
ordAmount decimal(10,2),
deliveryDate varchar(40),
deliveryStatus varchar(30),
discount int,
cid int,
foreign key (cid) references customer(cid),
invoiceNo int,
foreign key (invoiceNo) references invoice(invoiceNo)); 


create table clothing ( 
size varchar(20),
color varchar(20),
pid int,
foreign key (pid) references product(pid));


create table equipment ( 
eType varchar(30),
descr varchar(60),
pid int,
foreign key(pid) references product(pid));


create table gunReplica ( 
fabric varchar(20),
calibre decimal (10,2),
pid int,
foreign key(pid) references product(pid));


create table invoice ( 
invoiceNo int identity(1,1) primary key(invoiceNo),
paymentDate varchar(40),
inAmount decimal(10,2));


create table salesLine ( 
quantity int not null,
pid int,
foreign key(pid) references product(pid),
oid int,
foreign key(oid) references salesOrder(oid));

