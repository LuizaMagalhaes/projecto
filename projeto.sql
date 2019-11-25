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
 

insert into tenis values (1, "adidas", 39, 200.0, 20);
insert into tenis values (2, "olympicus", 42, 300.0, 30);
insert into tenis values (3, "rainha", 36, 100.0, 4);
insert into tenis values (4, "umbro", 41, 150.0, 9);
insert into tenis values (5, "kappa", 12, 100.0, 5);
insert into tenis values (6, "nike", 42, 500.0, 23);
insert into tenis values (7, "asics", 38, 170.0, 12);
insert into tenis values (8, "mizuno", 40, 180.0,15);
insert into tenis values (9, "Mizuno", 36, 100.0, 17);
insert into tenis values (10, "adidas", 34, 100.0, 13);

insert into pessoa values (1, "Hamilton", 03427783832, 1199991234, "vendedor");
insert into pessoa values (2, "Astrogildo", 04220504677, 119956732786, "vendedor");
insert into pessoa values (3, "Amanda", 01832781084, 18996563277, "vendedor");
insert into pessoa values (4, "Matheus", 02232778656, 11993456778, "vendedor");
insert into pessoa values (5, "Kayan", 05574686342, 11996568970, "vendedor");
insert into pessoa values (5, "Victor", 0347678908, 11996736870, "vendedor");
insert into pessoa values (6, "Bruno", 0456678910, 11994568769, "vendedor");
insert into pessoa values (7, "Agatha", 08925576761, 11998906574, "vendedor");
insert into pessoa values (8, "Bruna", 09837745456, 12998762727, "vendedor");
insert into pessoa values (9, "Rita", 03445523235, 1523456780, "vendedor");

