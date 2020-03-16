alter table MARKET_GOODS add constraint FK_MARKET_GOODS_ON_PRODUCT foreign key (PRODUCT_ID) references MARKET_PRODUCT(ID);
alter table MARKET_GOODS add constraint FK_MARKET_GOODS_ON_SHOP foreign key (SHOP_ID) references MARKET_SHOP(ID);
create index IDX_MARKET_GOODS_ON_PRODUCT on MARKET_GOODS (PRODUCT_ID);
create index IDX_MARKET_GOODS_ON_SHOP on MARKET_GOODS (SHOP_ID);
