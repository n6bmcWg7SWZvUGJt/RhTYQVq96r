alter table MARKET_PRODUCT add constraint FK_MARKET_PRODUCT_ON_SHIPMENT foreign key (SHIPMENT_ID) references MARKET_SHIPMENT(ID);
create index IDX_MARKET_PRODUCT_ON_SHIPMENT on MARKET_PRODUCT (SHIPMENT_ID);