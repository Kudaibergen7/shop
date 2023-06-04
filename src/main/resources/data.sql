INSERT INTO tb_user (id, address, email, first_name, last_name, login, password, payment_details, phone_number, role)
VALUES
    (1, 'Address 1', 'user1@example.com', 'John', 'Doe', 'user1', 'password1', '4323 0794 4066 9816', '123456789', 'ADMIN'),
    (2, 'Address 2', 'user2@example.com', 'Jane', 'Smith', 'user2', 'password2', '4323 0794 4066 9816', '987654321', 'CLIENT'),
    (3, 'Address 3', 'user3@example.com', 'David', 'Johnson', 'user3', 'password3', '4323 0794 4066 9816', '555555555', 'CLIENT'),
    (4, 'Address 4', 'user4@example.com', 'Emily', 'Brown', 'user4', 'password4', '4323 0794 4066 9816', '111111111', 'CLIENT'),
    (5, 'Address 5', 'user5@example.com', 'Michael', 'Wilson', 'user5', 'password5', '4323 0794 4066 9816', '999999999', 'CLIENT');

INSERT INTO tb_category (id, active, description, image, name)
VALUES
    (1, true, 'Category 1 description', 'image1.jpg', 'Category 1'),
    (2, true, 'Category 2 description', 'image2.jpg', 'Category 2'),
    (3, true, 'Category 3 description', 'image3.jpg', 'Category 3'),
    (4, true, 'Category 4 description', 'image4.jpg', 'Category 4'),
    (5, true, 'Category 5 description', 'image5.jpg', 'Category 5');

INSERT INTO tb_product (id, date_created, description, discount, discounted_price, image, name, price, product_status, category)
VALUES
    (1, CURRENT_TIMESTAMP, 'Product 1 description', 10.00, 90.00, 'product1.jpg', 'Product 1', 100.00, 'AVERAGE', 1),
    (2, CURRENT_TIMESTAMP, 'Product 2 description', 0, 0, 'product2.jpg', 'Product 2', 50.00, 'AVERAGE', 2),
    (3, CURRENT_TIMESTAMP, 'Product 3 description', 20.00, 80.00, 'product3.jpg', 'Product 3', 100.00, 'AVERAGE', 3),
    (4, CURRENT_TIMESTAMP, 'Product 4 description', 0, 0, 'product4.jpg', 'Product 4', 75.00, 'AVERAGE', 1),
    (5, CURRENT_TIMESTAMP, 'Product 5 description', 15.00, 85.00, 'product5.jpg', 'Product 5', 100.00, 'AVERAGE', 2),
    (6, CURRENT_TIMESTAMP, 'Product 6 description', 0, 0, 'product6.jpg', 'Product 6', 60.00, 'HEAT', 3),
    (7, CURRENT_TIMESTAMP, 'Product 7 description', 0, 0, 'product7.jpg', 'Product 7', 80.00, 'HEAT', 1),
    (8, CURRENT_TIMESTAMP, 'Product 8 description', 10.00, 90.00, 'product8.jpg', 'Product 8', 100.00, 'HEAT', 2),
    (9, CURRENT_TIMESTAMP, 'Product 9 description', 0, 0, 'product9.jpg', 'Product 9', 70.00, 'HEAT', 3),
    (10, CURRENT_TIMESTAMP, 'Product 10 description', 25.00, 75.00, 'product10.jpg', 'Product 10', 100.00, 'HEAT', 1);
