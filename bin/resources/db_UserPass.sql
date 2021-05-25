CREATE DATABASE db_UserPass

create table Pessoa (
 id int identity (1,1) primary key,
 login varchar (20),
 senha varchar (150),
)

select * from Pessoa