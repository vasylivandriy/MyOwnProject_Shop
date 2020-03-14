drop database if exists project_shop;
create database if not exists project_shop char set utf8;

create table if not exists project_shop.users(
id int not null primary key auto_increment,
firstName varchar(50) not null,
lastName varchar(50) not null,
email varchar(50) not null unique,
role varchar(50) not null 
);

create table if not exists project_shop.products(
id int not null primary key auto_increment,
name varchar(50) not null unique,
description varchar(50) not null,
price dec(5,2) not null
);

create table if not exists project_shop.baskets(
id int not null primary key auto_increment,
user_id int not null,
product_id int not null,
purchase_date date not null,
foreign key (user_id) references users(id),
foreign key (product_id) references products(id)
);
