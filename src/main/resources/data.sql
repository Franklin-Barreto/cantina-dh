INSERT INTO cliente (nome)VALUES ('Franklin Barreto');
INSERT INTO telefone (ddd,numero,fk_cliente) VALUES ('11','975215595',1);
INSERT INTO categoria (descricao) VALUES ('Bebida'),('Lanche');
INSERT INTO produto (descricao,preco,fk_categoria) VALUES ('Coca-cola',5.00,1),('X-tudo',10.00,2);