###book_library_example [![Build Status](https://travis-ci.org/mbohun/book_library_example.svg?branch=master)](https://travis-ci.org/mbohun/book_library_example)

Description: [Programming Exercise](https://github.com/mbohun/book_library_example/issues/1)

1. git clone https://github.com/mbohun/book_library_example.git
2. cd book_library_example
3. mvn jetty:run
4. go to [http://localhost:8080/library-books-demo/books](http://localhost:8080/library-books-demo/books) for the list of books
5. go to [http://localhost:8080/library-books-demo/customers](http://localhost:8080/library-books-demo/customers) for the list of customers (press the SEARCH button next to customer name to do an Ajax query to get the list of books customer has lent)

Use curl to test/trigger errors, and error handling, for example:
```
mbohun@linux:~> curl -H "Content-Type: application/json" -X POST -d '{"id":3}' http://localhost:8080/library-books-demo/getajax
{"msg":"","code":"200","payload":["Tom Sawyer","Moby Dick","Idiot"]}mbohun@linux:~> 
mbohun@linux:~>
mbohun@linux:~> curl -H "Content-Type: application/json" -X POST -d '{"id":-55}' http://localhost:8080/library-books-demo/getajax
{"msg":"Invalid search request!","code":"400","payload":null}mbohun@linux:~> 
mbohun@linux:~> 
mbohun@linux:~> curl -H "Content-Type: application/json" -X POST -d '{"id":34}' http://localhost:8080/library-books-demo/getajax
{"msg":"No results found.","code":"204","payload":null}mbohun@linux:~> 
mbohun@linux:~>
mbohun@linux:~> curl -H "Content-Type: application/json" -X POST -d '{"id":"kill"}' http://localhost:8080/library-books-demo/getajax
{"msg":"Invalid search request!","code":"400","payload":null}mbohun@linux:~> 
mbohun@linux:~> 
```

Use curl and [jq](https://stedolan.github.io/jq) to test the data, for example:
```
mbohun@linux:~> curl -s -H "Content-Type: application/json" -X POST -d '{"id":3}' http://localhost:8080/library-books-demo/getajax \
   | jq '.payload'
[
  "Tom Sawyer",
  "Moby Dick",
  "Idiot"
]

mbohun@linux:~> curl -s -H "Content-Type: application/json" -X POST -d '{"id":3}' http://localhost:8080/library-books-demo/getajax \
   | jq '.payload | contains(["Tom Sawyer", "Moby Dick", "Idiot"])'
true

mbohun@linux:~> curl -s -H "Content-Type: application/json" -X POST -d '{"id":3}' http://localhost:8080/library-books-demo/getajax \
   | jq '.payload | contains(["A Clockwork Orange"])'
false
```

NOTES:

SQL usedin this example ([SQLFiddle link](http://sqlfiddle.com/#!2/aefe3/2)):
```sql
CREATE TABLE customers
	(`id` int not null auto_increment primary key, `name` varchar(64), `phone` varchar(32), `email` nvarchar(320) )
;
	
INSERT INTO customers
	(`name`, `phone`, `email`)
VALUES
	('Ann', '0262650987', 'ann@somedomain.com'),
    ('Betty', '0421234555', 'betty@otherdomain.net'),
    ('Joe', '0262389700', 'joe.joe@anotherdomain.com.au')
;

CREATE TABLE books
	(`isbn` bigint not null unique primary key,
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
```
```sql
SELECT * FROM customers;
SELECT * FROM books;
SELECT isbn_id FROM lent_books where customer_id =3;

SELECT title from books b, lent_books p where p.customer_id = 2 and b.isbn = p.isbn_id;
```
