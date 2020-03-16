package com.company.market.jmx;

import com.company.market.entity.*;
import com.company.market.service.UtilsService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.*;

@Component("market_NetworkMethod")
public class NetworkMethod implements NetworkMethodMBean {

    @Inject
    private DataManager dataManager;
    @Inject
    private MetadataTools metadataTools;
    @Inject
    private UtilsService utilsService;

    @Authenticated
    @Override
    public String productList(int count) {
        List<Goods> allGoodses = dataManager.load(Goods.class).list();
        List<Goods> returnGoodses = new ArrayList<>();
        for (Goods goods : allGoodses) {
            Long quantity = goods.getQuantity();
            if (quantity == null || quantity < count) {
                returnGoodses.add(goods);
            }
        }
        return utilsService.collectionToString(returnGoodses);
    }

    @Authenticated
    @Override
    public String shopList(String inputGoodsName) {
        List<Shop> allShops = dataManager.load(Shop.class).view("shop-view").list();
        //Set<Shop> returnShops = new HashSet<>();
        List<Shop> returnShops = new ArrayList<>();
        for (Shop shop : allShops) {
            boolean contains = false;
            List<Goods> allShopGoodses = shop.getGoods();
            for (Goods goods : allShopGoodses) {
                String productName = goods.getProduct().getName();
                if (productName.equals(inputGoodsName)) {
                    contains = true;
                    Long quantity = goods.getQuantity();
                    if (quantity == null || quantity <= 0) {
                        returnShops.add(goods.getShop());
                        break;
                    }
                }
            }
            if(contains==false) {
                returnShops.add(shop);
            }
        }
        return utilsService.collectionToString(returnShops);
    }

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
        return "null";
    }

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
            returnString +=  purchaseCount(shop.getName());

        }

        return returnString;
    }
}

