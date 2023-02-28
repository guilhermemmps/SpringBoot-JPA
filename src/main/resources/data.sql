create table tb_cidade (
    id_cidade bigint not null primary key,
    nome varchar(50) not null,
    qtd_habitantes bigint
);

insert into tb_cidade
    (id_cidade, nome, qtd_habitantes)
values
    (1, 'São Paulo',12393832),
    (2, 'Rio de Janeiro',1000000),
    (3, 'Fortaleza',8000000),
    (4, 'Salvador',7000000),
    (5, 'Belo Horizonte',6000000),
    (6, 'Porto Alegre',7770000),
    (7, 'Porto Velho',4953432),
    (8, 'Palmas',8000000),
    (9, 'Recife',8000000),
    (10, 'Natal',8000000),
    (11, 'Brasilia',1000000)
;
