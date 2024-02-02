-- liquibase formatted sql

-- changeset naviz:creating:product
create table table_1
(
    id   varchar(256) null,
    name varchar(256) null,
    constraint table_1_pk
        primary key (id)
)
    collate = utf8mb4_unicode_ci;

-- changeset naviz:deleting:table_1
drop table table_1;

--changeset naviz:creating:product_again
create table products
(
    id   varchar(256) null,
    name varchar(256) null,
    constraint table_1_pk
        primary key (id)
)
    collate = utf8mb4_unicode_ci;

--changeset naviz:modifying:product_for_timestamps
alter table products
    add created_at timestamp null,
    add updated_at timestamp null;



