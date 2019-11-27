create database if not exists land;

use land;

CREATE TABLE IF NOT EXISTS customers(
    id int not null auto_increment,
    description varchar(100) not null,
    email varchar(45) not null unique,
    pass varchar(18) not null,
    cpf varchar(11) not null,
    phone int,
    primary key(id))
    engine = InnoDB;



CREATE TABLE IF NOT EXISTS shoes(
    id int not null auto_increment,
    descripton varchar(100) not null,
    brand varchar(100) not null,
    size varchar(4) not null,
    price double not null,
    amount int not null,
    primary key(id))
    engine = InnoDB;

                
CREATE TABLE IF NOT EXISTS cart (
   id INT NOT NULL AUTO_INCREMENT,
   customer_id INT NOT NULL,
   total DOUBLE NOT NULL,
   done boolean not null,
   done_at Date not null,
   PRIMARY KEY (id),
   CONSTRAINT fk_customer_has_cart
   FOREIGN KEY (customer_id)
   REFERENCES land.customers (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION);
   
   
CREATE TABLE IF NOT EXISTS cart_shoes(
   cart_id INT NOT NULL,
   shoe_id INT NOT NULL,
   amount INT NOT NULL,
   partial_total DOUBLE NOT NULL,
   PRIMARY KEY (cart_id, shoe_id),
   CONSTRAINT fk_cart_has_cart_shoes
   FOREIGN KEY (cart_id)
   REFERENCES land.cart (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION,
   CONSTRAINT fk_cart_shoes_has_shoe
   FOREIGN KEY (shoe_id)
   REFERENCES land.shoes (id)
   ON DELETE NO ACTION
   ON UPDATE NO ACTION)
 ENGINE = InnoDB;
