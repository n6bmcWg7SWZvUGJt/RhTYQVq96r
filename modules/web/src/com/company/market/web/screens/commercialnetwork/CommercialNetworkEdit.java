package com.company.market.web.screens.commercialnetwork;

import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.CommercialNetwork;

@UiController("market_CommercialNetwork.edit")
@UiDescriptor("commercial-network-edit.xml")
@EditedEntityContainer("commercialNetworkDc")
@LoadDataBeforeShow
public class CommercialNetworkEdit extends StandardEditor<CommercialNetwork> {

}