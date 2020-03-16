package com.company.market.web.screens.goods;

import com.company.market.entity.PriceHistory;
import com.company.market.entity.Product;
import com.company.market.entity.Shop;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Goods;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UiController("market_Goods.edit")
@UiDescriptor("goods-edit.xml")
@EditedEntityContainer("goodsDc")
@LoadDataBeforeShow
public class GoodsEdit extends StandardEditor<Goods> {

    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionLoader<Goods> goodsesDl;

    private Shop shop;

    @Inject
    private Metadata metadata;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        goodsesDl.setParameter("shop", getEditedEntity().getShop());
        shop = getEditedEntity().getShop();
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        getScreenData().getDataContext().evictAll();
        List<PriceHistory> priceHistories = getEditedEntity().getPriceHistory();
        if (priceHistories == null) {
            priceHistories = new ArrayList<>();
        }
        int last = priceHistories.size() - 1;
        if ((last == -1) || !(priceHistories.get(last).getPrice() .equals (getEditedEntity().getPrice()))) {
            PriceHistory priceHistory = metadata.create(PriceHistory.class);
            priceHistory.setShop(shop);
            priceHistory.setPriceChangeDate(new Date());
            priceHistory.setGoods(getEditedEntity());
            priceHistory.setPrice(getEditedEntity().getPrice());
            priceHistories.add(priceHistory);
            getEditedEntity().setPriceHistory(priceHistories);
        }
        getEditedEntity().setShop(shop);
        getEditedEntity().setPriceHistory(priceHistories);

        dataManager.commit(getEditedEntity());

    }

    @Subscribe("chbtn")
    public void onChbtnClick(Button.ClickEvent event) {
        for (PriceHistory ph : getEditedEntity().getPriceHistory()) {
            dataManager.remove(ph);
        }
        getEditedEntity().setPriceHistory(new ArrayList<>());
    }

    @Subscribe("lookupPickerField")
    public void onLookupPickerFieldValueChange(HasValue.ValueChangeEvent<Product> event) {
        if ((event.getValue().equals(event.getPrevValue())) == false) {

            List<Goods> allGoodses = dataManager.load(Goods.class).view("goods-view").list();
            List<Goods> thisShopGoodses = new ArrayList<>();
            for (Goods goods : allGoodses) {
                if (goods.getShop().getName().equals(shop.getName())) {
                    thisShopGoodses.add(goods);
                }
            }
            List<Product> products = new ArrayList<>();
            for (Goods goods : thisShopGoodses) {
                products.add(goods.getProduct());
            }

            Goods pr;
            if (products.contains(event.getValue())) {
                pr = thisShopGoodses.get(products.indexOf(event.getValue()));
            } else {
                pr =  metadata.create(Goods.class);
                pr.setProduct(event.getValue());
            }

            setEntityToEdit(pr);
            getEditedEntityContainer().setItem(pr);
        }
    }
}





