create table public.pessoa
(
    id              serial       not null
        constraint pessoa_pk
            primary key,
    nome            varchar(100) not null,
    cpf             varchar(11)  not null,
    data_nascimento date         not null,
    sexo            char         not null,
    email           varchar(100),
    maior_idade     date,
    data_criacao    timestamp,
    data_alteracao  timestamp
);

alter table public.pessoa
    owner to postgres;

create unique index pessoa_id_uindex
    on public.pessoa (id);

