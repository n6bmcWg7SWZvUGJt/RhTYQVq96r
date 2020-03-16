-- begin MARKET_COMMERCIAL_NETWORK
create table MARKET_COMMERCIAL_NETWORK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    FULL_NAME varchar(255),
    --
    primary key (ID)
)^
-- end MARKET_COMMERCIAL_NETWORK
-- begin MARKET_ADDRESS
create table MARKET_ADDRESS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TOWN varchar(255),
    STREET varchar(255),
    HOUSE varchar(255),
    --
    primary key (ID)
)^
-- end MARKET_ADDRESS
-- begin MARKET_GOODS
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
)^
-- end MARKET_GOODS
-- begin MARKET_PRICE_HISTORY
create table MARKET_PRICE_HISTORY (
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
    SHOP_ID varchar(36),
    PRICE_CHANGE_DATE date,
    GOODS_ID varchar(36),
    --
    primary key (ID)
)^
-- end MARKET_PRICE_HISTORY
-- begin MARKET_PRODUCER
create table MARKET_PRODUCER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    ADDRESS_ID varchar(36),
    FUL_NAME varchar(255),
    COMMERCIAL_NETWORK_ID varchar(36),
    --
    primary key (ID)
)^
-- end MARKET_PRODUCER
-- begin MARKET_PRODUCT
create table MARKET_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRODUCER_ID varchar(36) not null,
    PRODUCER_PRICE decimal(19, 2) not null,
    SHIPMENT_ID varchar(36),
    --
    primary key (ID)
)^
-- end MARKET_PRODUCT
-- begin MARKET_SHIPMENT
create table MARKET_SHIPMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SHOP_ID varchar(36),
    DATE_ timestamp,
    --
    primary key (ID)
)^
-- end MARKET_SHIPMENT
-- begin MARKET_SHOP
create table MARKET_SHOP (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NO_ varchar(255) not null,
    SHOP_TYPE varchar(50),
    ADDRESS_ID varchar(36),
    NAME varchar(255) not null,
    COMMERCIAL_NETWORK_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end MARKET_SHOP
-- begin MARKET_PURCHASE
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
)^
-- end MARKET_PURCHASE
