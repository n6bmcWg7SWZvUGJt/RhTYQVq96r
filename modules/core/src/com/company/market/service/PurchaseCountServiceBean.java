package com.company.market.service;

import com.company.market.entity.Purchase;
import com.company.market.entity.Shipment;
import com.company.market.entity.Shop;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(PurchaseCountService.NAME)
public class PurchaseCountServiceBean implements PurchaseCountService {

    @Inject
    private DataManager dataManager;
    @Inject
    private Messages messages;

    @Authenticated
    @Override
    public String purchaseCount(String shopName) {
        List<Shop> allShops = dataManager.load(Shop.class).view("shop-view").list();
        Shop shop = null;
        for(Shop s:allShops){
            if(s.getName().equals(shopName)){
                shop = s;
                break;
            }
        }
        if(shop!=null) {
            int count=0;
            List<Shipment> shipments = shop.getShipments();
            for(Shipment shipment:shipments){
                List<Purchase> purchases = shipment.getPurchase();
                for(Purchase purchase:purchases ){
                    count += purchase.getCount();
                }
            }
            return shopName + " " + count + "\n";
        }
        return "";
    }

}