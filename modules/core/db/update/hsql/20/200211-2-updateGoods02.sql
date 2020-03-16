-- update MARKET_GOODS set PRODUCT_ID = <default_value> where PRODUCT_ID is null ;
alter table MARKET_GOODS alter column PRODUCT_ID set not null ;
