-- DADOS SATAR
-- 1,admin,admin,{bcrypt}$2a$10$62G2DfTMpiQasT4WwbDXUuJly3pZYUVRn/qYbQA7PV5yTSkS6SGTe,"ROLE_ADMIN,ROLE_USER"
create table "user"
(
    id          serial not null
        constraint user_pk
            primary key,
    name        varchar,
    username    varchar,
    password    varchar,
    authorities varchar
);

alter table "user"
    owner to postgres;

create unique index user_id_uindex
    on "user" (id);

