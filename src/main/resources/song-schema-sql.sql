DROP TABLE IF EXISTS song;
create table song (id integer auto_increment,
 artist varchar(255), 
 name varchar(255),
  release_date integer,
   primary key (id))