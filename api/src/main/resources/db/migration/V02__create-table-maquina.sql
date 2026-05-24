CREATE TABLE maquina(
    ID_maquina int primary key auto_increment,
    Nome varchar(255),
    Marca varchar(255),
    Tipo varchar(255),
    Valor_Diaria decimal(10,2),
    Ativo BOOLEAN default true

)