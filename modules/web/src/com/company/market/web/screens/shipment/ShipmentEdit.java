package com.company.market.web.screens.shipment;

import com.company.market.entity.*;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;
import com.haulmont.cuba.gui.screen.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PublishEntityChangedEvents
@UiController("market_Shipment.edit")
@UiDescriptor("shipment-edit.xml")
@EditedEntityContainer("shipmentDc")
@LoadDataBeforeShow
public class ShipmentEdit extends StandardEditor<Shipment> {

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        Shipment shipment = getEditedEntity();

        List<Purchase> inputPurchases = shipment.getPurchase();
        List<Purchase> collapsedPurchases = new ArrayList<>();
        List<Goods> goods = new ArrayList<>();

        for (Purchase purchase : inputPurchases) {
            if (goods.contains(purchase.getGoods()) == false) {
                collapsedPurchases.add(purchase);
                goods.add(purchase.getGoods());
            } else {
                int purchaseIndex = goods.indexOf(purchase.getGoods());
                Purchase p = collapsedPurchases.get(purchaseIndex);
                p.setCount(p.getCount() + purchase.getCount());
                goods.add(purchase.getGoods());
                purchase.setCount(0);
                purchase.setShipment(null);
            }
        }
        if (inputPurchases.size() != collapsedPurchases.size()) {
            shipment.setPurchase(collapsedPurchases);
        }
        shipment.setDate(new Date());


        //purchase subtraction
        List<Purchase> commitPurchases = shipment.getPurchase();
        for (Purchase purchase : commitPurchases) {
            Goods purchaseGoods = purchase.getGoods();
            long goodsCount = purchaseGoods.getQuantity();
            long purchaseCount = purchase.getCount();
            purchaseGoods.setQuantity(goodsCount - purchaseCount);
        }
    }
}