create table MARKET_PURCHASE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    GOODS_ID varchar(36),
    COUNT_ integer,
    SHIPMENT_ID varchar(36),
    --
    primary key (ID)
);