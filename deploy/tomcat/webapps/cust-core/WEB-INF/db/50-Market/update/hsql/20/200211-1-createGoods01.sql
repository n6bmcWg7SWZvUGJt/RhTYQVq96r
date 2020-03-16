create table MARKET_GOODS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID varchar(36),
    PRICE decimal(19, 2),
    QUANTITY bigint,
    SHOP_ID varchar(36),
    --
    primary key (ID)
);