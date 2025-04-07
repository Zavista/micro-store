CREATE TABLE `t_inventory`
(
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `sku_code` varchar(255) NULL,
    `quantity` int(11),
    PRIMARY KEY (`id`)
);