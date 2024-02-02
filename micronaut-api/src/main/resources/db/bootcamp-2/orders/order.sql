-- liquibase formatted sql

-- changeset naviz:creating:orders
create table orders
(
    id   varchar(256) null,
    quantity numeric null,
    constraint orders_pk
        primary key (id)
)
    collate = utf8mb4_unicode_ci;

