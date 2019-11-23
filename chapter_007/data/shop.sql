--drop table type CASCADE;
--drop table product CASCADE;


CREATE TABLE type(
	id serial primary key,
	name varchar(2000)
	);

CREATE TABLE product(
	id serial primary key,
	name varchar(2000),
	type_id integer references type(id),
	expired_date timestamp,
	price integer,
	quantity integer
);

insert into type (name) values ('напитки');
insert into type (name) values ('молоко');
insert into type (name) values ('хлеб');
insert into type (name) values ('сыр');
insert into type (name) values ('кефир');
insert into type (name) values ('мороженое');

insert into product (name, type_id, expired_date, price, quantity) values ('Российский сыр','4','2020-04-28 00:20','800','4');
insert into product (name, type_id, expired_date, price, quantity) values ('мороженое Жемчужина','6','2019-11-28 04:00','40','20');
insert into product (name, type_id, expired_date, price, quantity) values ('Бородинский хлеб','3','2019-11-28 00:10','45','24');
insert into product (name, type_id, expired_date, price, quantity) values ('Сыр пешехонский','4','2019-12-01 02:00','845','2');
insert into product (name, type_id, expired_date, price, quantity) values ('Хлеб даниловский в  нарезке','3','2019-11-25 03:30','50','23');
insert into product (name, type_id, expired_date, price, quantity) values ('Молоко "Белый город"','2','2019-12-12 01:00','66','6');
insert into product (name, type_id, expired_date, price, quantity) values ('мороженое Золотой стандарт ','6','2020-06-30 02:00','380','35');
insert into product (name, type_id, expired_date, price, quantity) values ('Кефир деревенский','5','2019-12-28 02:00','76','8');
insert into product (name, type_id, expired_date, price, quantity) values ('Хлеб нарезной','3','2019-11-28 00:00','35','2');
insert into product (name, type_id, expired_date, price, quantity) values ('Молоко "Домик в деревне"','2','2019-11-28 02:00','60','12');
insert into product (name, type_id, expired_date, price, quantity) values ('"Чистая линия" стаканчик ','6','2021-02-03 01:00','70','2');
insert into product (name, type_id, expired_date, price, quantity) values ('Хлеб Коломенское нарезной','3','2019-11-29 03:00','35','20');
insert into product (name, type_id, expired_date, price, quantity) values ('Квас Очаково','1','2020-03-08 01:00','74','23');
insert into product (name, type_id, expired_date, price, quantity) values ('Молоко "Лианозовское"','2','2019-11-28 01:00','66','4');
insert into product (name, type_id, expired_date, price, quantity) values ('"Чистая линия" пачка мороженое ','6','2021-05-25 03:00','180','24');
insert into product (name, type_id, expired_date, price, quantity) values ('Сыр Ламбер','4','2019-11-28 04:00','778','2');
insert into product (name, type_id, expired_date, price, quantity) values ('Лакомка мороженое ','6','2021-07-30 03:00','56','2');
insert into product (name, type_id, expired_date, price, quantity) values ('Квас "Царские припасы"','1','2020-07-07 01:00','85','4');
insert into product (name, type_id, expired_date, price, quantity) values ('мороженое Коровка','6','2020-04-28 03:00','64','2');
insert into product (name, type_id, expired_date, price, quantity) values ('Фанта апельсин ','1','2020-04-07 01:00','185','5');



--1
--SELECT * FROM product WHERE type_id = 4;

--2
--SELECT * FROM product WHERE name like '%мороженое%';

--3
--SELECT * FROM product WHERE expired_date between '2019-12-01 00:01:01' and '2019-12-31 23:59:00';
--SELECT * FROM product WHERE expired_date between '2019-11-01 00:01:01' and '2019-11-30 23:59:00';

--4
--SELECT * FROM product WHERE price = (SELECT MAX(price) FROM product);

--5
--SELECT COUNT(p.id) FROM product AS p WHERE type_id=4;

--6
--SELECT * FROM product WHERE (type_id = 2 OR type_id=4) ;

--7
--SELECT * FROM product WHERE quantity>10 ;

--8
--SELECT p.name, t.name, p.quantity FROM product as p
--INNER JOIN type as t on t.id = type_id ;

--8а - то же самое, но с количеством товаров в выборке.
--SELECT p.name, t.name, p.quantity FROM product as p
--INNER JOIN type as t on t.id = type_id ;
