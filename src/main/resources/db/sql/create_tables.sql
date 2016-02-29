
CREATE TABLE customers
(`id` int not null auto_increment primary key,
`name` varchar(64),
`phone` varchar(32),
`email` nvarchar(320))
;

INSERT INTO customers
(`name`, `phone`, `email`)
VALUES
('Ann', '0262650987', 'ann@somedomain.com'),
('Betty', '0421234555', 'betty@otherdomain.net'),
('Joe', '0262389700', 'joe.joe@anotherdomain.com.au')
;

CREATE TABLE books
(`isbn` bigint not null primary key,
`author` varchar(64),
`title` varchar(64))
;

INSERT INTO books
(`isbn`, `author`, `title`)
VALUES
(98125623489012, 'Mark Twain', 'Tom Sawyer'),
(78767552441425, 'Herman Melville', 'Moby Dick'),
(32352363666777, 'F.M.Dostojevskij', 'Idiot')
;

CREATE TABLE lent_books
( `customer_id` int not null,
`isbn_id` bigint not null,
constraint fk_customer_id foreign key (customer_id) references customers (id),
constraint fk_isbn_id foreign key (isbn_id) references books (isbn))
;

INSERT INTO lent_books
(`customer_id`, `isbn_id`)
VALUES
(1, 98125623489012),
(1, 32352363666777),
(2, 78767552441425),
(3, 98125623489012),
(3, 78767552441425),
(3, 32352363666777)
;
;
