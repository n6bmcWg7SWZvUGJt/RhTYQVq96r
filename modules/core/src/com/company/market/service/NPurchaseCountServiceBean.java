package com.company.market.service;

import com.company.market.entity.Shop;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service(NPurchaseCountService.NAME)
public class NPurchaseCountServiceBean implements NPurchaseCountService {

    @Inject
    private DataManager dataManager;

    @Inject
    private PurchaseCountService purchaseCountService;
    @Inject
    private Messages messages;

    @Authenticated
    @Override
    public String npurchaseCount(String networkName) {
        List<Shop> allShops = dataManager.load(Shop.class).view("shop-view").list();
        List<Shop> nShops = new ArrayList<>();
        String returnString = "";
        for(Shop shop:allShops){
            if(shop.getCommercialNetwork().getName().equals(networkName)){
                nShops.add(shop);
            }
        }
        for(Shop shop:nShops){
            returnString +=  purchaseCountService.purchaseCount(shop.getName());

        }

        return returnString;
    }

}