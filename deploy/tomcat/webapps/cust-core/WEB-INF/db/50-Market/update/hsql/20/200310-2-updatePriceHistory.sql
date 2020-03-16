alter table MARKET_PRICE_HISTORY alter column PRICE_CHANGE_DATE rename to PRICE_CHANGE_DATE__U24598 ^
alter table MARKET_PRICE_HISTORY add column PRICE_CHANGE_DATE timestamp ;
