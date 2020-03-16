package com.company.market.web.screens.producer;

import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Producer;

@UiController("market_Producer.browse")
@UiDescriptor("producer-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ProducerBrowse extends MasterDetailScreen<Producer> {
}