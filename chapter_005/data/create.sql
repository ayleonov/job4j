CREATE DATABASE work2;


CREATE TABLE items (
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE users (
	id serial primary key,
	login varchar(2000),
	password varchar(2000)
);
CREATE TABLE roles (
	id serial primary key,
	name varchar(2000)
);
CREATE TABLE role_rights (
	id serial primary key,
	name varchar(2000)
);
CREATE TABLE item_categories (
	id serial primary key,
	name varchar(2000)
);
CREATE TABLE item_comments (
	id serial primary key,
	text varchar(2000)
);
CREATE TABLE attachments (
	id serial primary key,
	name varchar(2000)
);
CREATE TABLE item_state (
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE rights (
	id serial primary key,
	name varchar(2000)
);

ALTER TABLE roles ADD COLUMN users_id integer references users(id);
ALTER TABLE role_rights ADD COLUMN roles_id integer references roles(id);
ALTER TABLE items ADD COLUMN users_id integer references users(id);
ALTER TABLE item_comments ADD COLUMN items_id integer references items(id);
ALTER TABLE attachments ADD COLUMN items_id integer references items(id);
ALTER TABLE roles ADD COLUMN role_rights_id integer references role_rights(id);
ALTER TABLE role_rights ADD COLUMN rights_id integer references rights(id);
ALTER TABLE items ADD COLUMN item_comments_id integer references item_comments(id);
ALTER TABLE items ADD COLUMN attachments_id integer references attachments(id);
ALTER TABLE items ADD COLUMN item_categories_id integer references item_categories(id);
ALTER TABLE items ADD COLUMN item_state_id integer references item_state(id);

insert into users (login, password) values ('iivanov','pass1');
insert into users (login, password) values ('aPetrov','111');
insert into users (login, password) values ('vSidorov','password');
insert into items (name,users_id) values ('заявка №1 ','2');
insert into items (name,users_id) values ('заявка №3 ','2');
insert into items (name,users_id) values ('заявка №4 ','1');

insert into item_categories (name) values ('обычная заявка');
insert into item_categories (name) values ('срочная заявка');

insert into item_state (name) values ('не оплачено');
insert into item_state (name) values ('оплачено');
insert into item_state (name) values ('заказ в сборке');
insert into item_state (name) values ('доставка');
insert into item_state (name) values ('доставлено');

insert into item_comments(text, items_id) values('комментарий122 вавааа',1);
insert into item_comments(text, items_id) values('коммен 544 dfdffd',1);
insert into item_comments(text, items_id) values('комментарий4 ккккккк',3);

insert into roles (name) values('Админ');
insert into roles (name) values('Главбух');
insert into roles (name) values('Бухгалтер');
insert into roles (name) values('Кладовщик');

insert into rights (name) values('чтение');
insert into rights (name) values('запись');
insert into rights (name) values('изменение');
insert into rights (name) values('полный доступ');

insert into role_rights (roles_id, rights_id) values('1','4');
insert into role_rights (roles_id, rights_id) values('2','1');
insert into role_rights (roles_id, rights_id) values('2','2');
insert into role_rights (roles_id, rights_id) values('3','1');
insert into role_rights (roles_id, rights_id) values('3','2');
