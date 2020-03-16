package com.company.market.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Product;

@UiController("market_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {

}