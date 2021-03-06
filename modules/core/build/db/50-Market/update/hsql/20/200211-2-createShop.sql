alter table MARKET_SHOP add constraint FK_MARKET_SHOP_ON_ADDRESS foreign key (ADDRESS_ID) references MARKET_ADDRESS(ID);
alter table MARKET_SHOP add constraint FK_MARKET_SHOP_ON_COMMERCIAL_NETWORK foreign key (COMMERCIAL_NETWORK_ID) references MARKET_COMMERCIAL_NETWORK(ID);
create unique index IDX_MARKET_SHOP_UNIQ_NO_ on MARKET_SHOP (NO_) ;
create index IDX_MARKET_SHOP_ON_ADDRESS on MARKET_SHOP (ADDRESS_ID);
create index IDX_MARKET_SHOP_ON_COMMERCIAL_NETWORK on MARKET_SHOP (COMMERCIAL_NETWORK_ID);
