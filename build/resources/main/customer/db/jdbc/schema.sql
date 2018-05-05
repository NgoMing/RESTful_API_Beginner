drop table if exists customer;

create table customer (
  id identity,
  username varchar(25) not null,
  password varchar(25) not null,
  firstname varchar(100) not null,
  lastname varchar(100) not null
);
