package com.company.market.web.screens.address;

import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Address;

@UiController("market_Address.edit")
@UiDescriptor("address-edit.xml")
@EditedEntityContainer("addressDc")
@LoadDataBeforeShow
public class AddressEdit extends StandardEditor<Address> {
}