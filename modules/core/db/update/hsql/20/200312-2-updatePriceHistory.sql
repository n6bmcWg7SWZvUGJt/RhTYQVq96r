alter table MARKET_PRICE_HISTORY alter column PRODUCT_ID rename to PRODUCT_ID__U01459 ^
alter table MARKET_PRICE_HISTORY drop constraint FK_MARKET_PRICE_HISTORY_ON_PRODUCT ;
drop index IDX_MARKET_PRICE_HISTORY_ON_PRODUCT ;