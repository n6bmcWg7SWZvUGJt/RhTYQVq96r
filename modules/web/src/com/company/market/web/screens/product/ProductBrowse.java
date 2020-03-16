package com.company.market.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Product;

@UiController("market_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}