package com.company.market.web.screens.commercialnetwork;

import com.company.market.entity.Product;
import com.company.market.service.NPurchaseCountService;
import com.company.market.service.ProducerService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.CommercialNetwork;
import com.haulmont.cuba.gui.screen.LookupComponent;

import javax.inject.Inject;

@UiController("market_CommercialNetwork.browse")
@UiDescriptor("commercial-network-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CommercialNetworkBrowse extends StandardLookup<CommercialNetwork> {
    @Inject
    private NPurchaseCountService nPurchaseCountService;
    @Inject
    private TextArea<String> calPurOutputArea;
    @Inject
    private GroupTable<CommercialNetwork> table;
    @Inject
    private TextArea<String> defGdsOutputArea;
    @Inject
    private TextArea<String> absShOutputArea;
    @Inject
    private ProducerService producerService;
    @Inject
    private TextField<String> defGdsTextField;
    @Inject
    private LookupPickerField<Product> absShLookupPickerField;
    @Inject
    private Messages messages;

    @Subscribe("calPurButton")
    public void onCalPurButtonClick(Button.ClickEvent event) {
        String output = "";
        if (table.getSingleSelected() != null) {
            output = nPurchaseCountService.npurchaseCount(table.getSingleSelected().getName());
        } else {
            output = messages.getMessage("com.company.market.web.screens.commercialnetwork", "noShopSelect");
        }
        if (output.equals(""))
            output = messages.getMessage("com.company.market.web.screens.commercialnetwork", "noPurchases");
        calPurOutputArea.setValue(output);

    }

    @Subscribe("absentShopButton")
    public void onAbsentShopButtonClick(Button.ClickEvent event) {
        if (absShLookupPickerField.getValue() != null) {
            String output = producerService.shopList(absShLookupPickerField.getValue().getName());
            if (output.equals(""))
                output = messages.getMessage("com.company.market.web.screens.commercialnetwork", "allShopsHaveThis");
            absShOutputArea.setValue(output);
        } else {
            absShOutputArea.setValue(messages.getMessage("com.company.market.web.screens.commercialnetwork", "noGoodsSelect"));
        }
    }

    @Subscribe("defGdsButton")
    public void onDefGdsButtonClick(Button.ClickEvent event) {
        if (defGdsTextField.getValue() == null) defGdsTextField.setValue("0");
        int i = Integer.valueOf(defGdsTextField.getValue());
        String s = producerService.productList(i);
        defGdsOutputArea.setValue(s);
    }

}