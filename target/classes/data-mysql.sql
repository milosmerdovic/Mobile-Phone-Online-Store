CREATE TABLE IF NOT EXISTS `products` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 1', 'images/product1.png', 150.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 2', 'images/product1.png', 250.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 3', 'images/product1.png', 350.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 4', 'images/product1.png', 450.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 5', 'images/product1.png', 550.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 6', 'images/product1.png', 650.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 7', 'images/product1.png', 750.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 8', 'images/product1.png', 850.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 9', 'images/product1.png', 950.00, 15);
INSERT IGNORE INTO products (name, path, price, quantity)
VALUES ('Mobile Phone 10', 'images/product1.png', 1050.00, 15);

