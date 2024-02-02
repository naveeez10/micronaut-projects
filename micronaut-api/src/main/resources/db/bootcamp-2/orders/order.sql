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


-- changeset naviz:adding:product_id-as-fk
alter table orders
    add product_id varchar(256) not null,
    add constraint orders_products_id_fk
        foreign key (product_id) references products (id);

