# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table car (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  kilometers                float,
  color                     varchar(255),
  constraint pk_car primary key (id))
;

create table person (
  id                        bigint not null,
  name                      varchar(255),
  description               varchar(255),
  age                       integer,
  birthday                  timestamp,
  constraint pk_person primary key (id))
;

create sequence car_seq;

create sequence person_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists car;

drop table if exists person;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists car_seq;

drop sequence if exists person_seq;

