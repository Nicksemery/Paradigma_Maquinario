CREATE TABLE ClienteMaquina(
    ID_clienteMaquina int primary key auto_increment,
    idCliente int,
    idMaquina int,
    DataInicio date,
    DataFim date,
    Situacao varchar(255),
    ValorTotal float,
    Ativo BOOLEAN default true,

    foreign key (idCliente) references clientes (ID_cliente),
    foreign key (idMaquina) references maquina (ID_maquina)
)