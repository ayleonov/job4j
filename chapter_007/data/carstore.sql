
/*
CREATE TABLE carcase(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE engine(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE transmission(
	id serial primary key,
	name varchar(2000)
);

CREATE TABLE car(
	id serial primary key,
	name varchar(2000),
	carcase_id integer references carcase(id),
	engine_id integer references engine(id),
	transmission_id integer references transmission(id)
);

insert into carcase (name) values ('кузов1');
insert into carcase (name) values ('кузов2');
insert into carcase (name) values ('кузов3');
insert into carcase (name) values ('кузов4');
insert into carcase (name) values ('кузов5');
insert into carcase (name) values ('кузов6');
insert into carcase (name) values ('кузов7');
insert into carcase (name) values ('кузов8');

insert into engine (name) values ('двигатель1');
insert into engine (name) values ('двигатель2');
insert into engine (name) values ('двигатель3');
insert into engine (name) values ('двигатель4');
insert into engine (name) values ('двигатель5');
insert into engine (name) values ('двигатель6');
insert into engine (name) values ('двигатель7');
insert into engine (name) values ('двигатель8');

insert into transmission (name) values ('коробка1');
insert into transmission (name) values ('коробка2');
insert into transmission (name) values ('коробка3');
insert into transmission (name) values ('коробка4');
insert into transmission (name) values ('коробка5');
insert into transmission (name) values ('коробка6');
insert into transmission (name) values ('коробка7');
insert into transmission (name) values ('коробка8');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car1','2','1','1');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car2','2','2','2');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car3','3','2','5');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car4','3','5','5');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car5','2','7','8');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car6','1','7','8');
insert into car (name, carcase_id, engine_id, transmission_id) values ('car7','7','2','8');

*/
-- задание 1
/*
select c.name, cc.name, e.name, t.name from car as c
inner join carcase as cc on carcase_id = cc.id
inner join engine as e on engine_id = e.id
inner join transmission as t on transmission_id = t.id;
*/
-- задание 2
/*
select cc.name from carcase as cc
left outer join car as c on c.carcase_id = cc.id where c.id is null;

select e.name from engine as e
left outer join car as c on c.engine_id = e.id where c.id is null;

select t.name from transmission as t
left outer join car as c on c.transmission_id = t.id where c is null;
*/





