alter table MARKET_PRICE_HISTORY add constraint FK_MARKET_PRICE_HISTORY_ON_GOODS foreign key (GOODS_ID) references MARKET_GOODS(ID);
create index IDX_MARKET_PRICE_HISTORY_ON_GOODS on MARKET_PRICE_HISTORY (GOODS_ID);