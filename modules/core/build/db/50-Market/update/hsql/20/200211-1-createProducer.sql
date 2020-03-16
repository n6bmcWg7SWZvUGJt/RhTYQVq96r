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
);