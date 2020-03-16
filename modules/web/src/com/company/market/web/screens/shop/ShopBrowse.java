package com.company.market.web.screens.shop;

import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Shop;

@UiController("market_Shop.browse")
@UiDescriptor("shop-browse.xml")
@LookupComponent("shopsTable")
@LoadDataBeforeShow
public class ShopBrowse extends StandardLookup<Shop> {
}