create table if not exists item (
   id serial primary key not null,
   name varchar(2000),
   descr varchar(2000),
   time timeStamp
);