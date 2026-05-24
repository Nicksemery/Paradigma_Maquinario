CREATE TABLE clientes(
    ID_cliente int primary key AUTO_INCREMENT,
    Nome varchar(50),
    CPF varchar(25),
    Email varchar(100),
    Telefone int,
    Ativo BOOLEAN default true
)