alter table MARKET_PURCHASE add constraint FK_MARKET_PURCHASE_ON_GOODS foreign key (GOODS_ID) references MARKET_GOODS(ID);
alter table MARKET_PURCHASE add constraint FK_MARKET_PURCHASE_ON_SHIPMENT foreign key (SHIPMENT_ID) references MARKET_SHIPMENT(ID);
create index IDX_MARKET_PURCHASE_ON_GOODS on MARKET_PURCHASE (GOODS_ID);
create index IDX_MARKET_PURCHASE_ON_SHIPMENT on MARKET_PURCHASE (SHIPMENT_ID);