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
    quantidade int,
    primary key(id))
    engine = InnoDB;

                
CREATE TABLE IF NOT EXISTS Projeto.compra (
   id INT NOT NULL AUTO_INCREMENT,
   pessoa_id INT NOT NULL,
   data DATE NOT NULL,
   total DOUBLE NOT NULL,
   PRIMARY KEY (id));
   
CREATE TABLE IF NOT EXISTS Projeto.compra_itens (
   compra_id INT NOT NULL,
   tenis_id INT NOT NULL,
   quantidade INT NOT NULL,
   preco DOUBLE NOT NULL,
   PRIMARY KEY (compra_id, tenis_id),
   CONSTRAINT fk_compra_itens_compra1
   FOREIGN KEY (compra_id)
   REFERENCES Projeto.compra (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION,
   CONSTRAINT fk_compra_has_itens_tenis1
   FOREIGN KEY (tenis_id)
   REFERENCES Projeto.tenis (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION)
 ENGINE = InnoDB;
 

insert into tenis values (1, "adidas", 39, 200.0, 30);
insert into pessoa values (1, "Nazare", 03427783832, 1199991234, "cliente");
