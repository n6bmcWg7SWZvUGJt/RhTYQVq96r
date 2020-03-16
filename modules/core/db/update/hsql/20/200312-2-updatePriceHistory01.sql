alter table MARKET_PRICE_HISTORY alter column PRICE_CHANGE_DATE rename to PRICE_CHANGE_DATE__U17673 ^
alter table MARKET_PRICE_HISTORY alter column PRODUCT_ID rename to PRODUCT_ID__U89361 ^
alter table MARKET_PRICE_HISTORY drop constraint FK_MARKET_PRICE_HISTORY_ON_PRODUCT ;
drop index IDX_MARKET_PRICE_HISTORY_ON_PRODUCT ;
alter table MARKET_PRICE_HISTORY add column PRICE decimal(19, 2) ;
alter table MARKET_PRICE_HISTORY add column PRICE_CHANGE_DATE timestamp ;
