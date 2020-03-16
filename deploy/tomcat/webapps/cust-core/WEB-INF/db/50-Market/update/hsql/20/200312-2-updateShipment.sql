-- update MARKET_SHIPMENT set SHOP_ID = <default_value> where SHOP_ID is null ;
alter table MARKET_SHIPMENT alter column SHOP_ID set not null ;
