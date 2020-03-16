package com.company.market.service;

import com.company.market.entity.Goods;
import com.company.market.entity.Shop;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service(ProducerService.NAME)
public class ProducerServiceBean implements ProducerService {
    @Inject
    private DataManager dataManager;
    @Inject
    private UtilsService utilsService;
    @Inject
    private Messages messages;

    @Authenticated
    @Override
    public String productList(int count) {
        List<Goods> allGoodses = dataManager.load(Goods.class).view("goods-view").list();
        List<Goods> returnGoodses = new ArrayList<>();
        String returnString = "";
        for (Goods goods : allGoodses) {
            Long quantity = goods.getQuantity();
            if (quantity == null || quantity < count) {
               // returnGoodses.add(goods);
                returnString+= goods.getShop().getName() + ": " + goods.getProduct().getName() + " " + goods.getQuantity() +",\n";
            }
        }

        //return utilsService.collectionToString(returnGoodses);
        return returnString;
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
        String returnString = utilsService.collectionToString(returnShops);
        return returnString;
    }



}