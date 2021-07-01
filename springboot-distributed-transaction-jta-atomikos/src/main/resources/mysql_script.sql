
-- create databases
CREATE DATABASE IF NOT EXISTS `goods` DEFAULT CHARACTER SET utf8;
CREATE DATABASE IF NOT EXISTS `order` DEFAULT CHARACTER SET utf8;

-- create table tb_goods
CREATE TABLE `tb_goods`
(
    `id`        int          NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `goodsName` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
    `store`     int          NOT NULL DEFAULT '0' COMMENT '库存',
    `price`     int          NOT NULL DEFAULT '0' COMMENT '价格',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- create table tb_order
CREATE TABLE `tb_order`
(
    `id`         int NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `userId`     int NOT NULL DEFAULT '0' COMMENT '用户ID',
    `goodsId`    int NOT NULL DEFAULT '0' COMMENT '商品ID',
    `totalMoney` int NOT NULL DEFAULT '0' COMMENT '总价',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


INSERT INTO shop.tb_goods (id, goodsName, store, price) VALUES (1, '小米电视', 10, 1000);