create database Projeto;

use Projeto;

create table pessoa(
	id int not null auto_increment,
    nome varchar(100),
    cpf varchar(11),
    telefone int,
    funcao varchar(100),
    primary key(id))
    engine = InnoDB;


create table tenis(
id int not null auto_increment,
nome varchar(100),
tamanho int,
preco double,
primary key(id))
engine = InnoDB;


select * from pessoa;

insert into tenis values (1, "adidas", 39, 200.0);
insert into pessoa values (1, "Hamilton", 03427783832, 1199991234, "professor");
