alter table MARKET_GOODS alter column SHIPMENT_ID rename to SHIPMENT_ID__U26333 ^
alter table MARKET_GOODS drop constraint FK_MARKET_GOODS_ON_SHIPMENT ;
drop index IDX_MARKET_GOODS_ON_SHIPMENT ;
