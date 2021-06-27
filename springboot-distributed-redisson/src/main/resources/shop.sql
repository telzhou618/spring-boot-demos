create database if not exists shop collate utf8_bin;

create table if not exists tb_goods
(
	id int auto_increment
		primary key,
	goods_name varchar(100) not null comment '商品名称',
	goods_count int default 0 not null comment '商品数量'
)
comment '商品表' charset=utf8;

create table if not exists tb_order
(
	id int auto_increment
		primary key,
	username varchar(50) not null,
	goods_name varchar(100) not null,
	buy_count int default 0 not null,
	total_money int default 0 not null,
	remark varchar(100) null
)
comment '订单表' charset=utf8;

