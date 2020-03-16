package com.company.market.web.screens.shop;

import com.company.market.config.CssConfig;
import com.company.market.entity.Address;
import com.company.market.entity.Goods;
import com.company.market.entity.Shipment;
import com.company.market.service.PurchaseCountService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Shop;

import javax.inject.Inject;
import javax.inject.Named;

@UiController("market_Shop.edit")
@UiDescriptor("shop-edit.xml")
@EditedEntityContainer("shopDc")
@LoadDataBeforeShow
public class ShopEdit extends StandardEditor<Shop> {

    @Inject
    private Field shopServicefield;
    @Inject
    private PurchaseCountService purchaseCountService;
    @Inject
    private CssConfig cssConfig;
    @Inject
    private GroupTable<Goods> shopGoodsTable;
    @Inject
    private TabSheet shopTabSheet;
    @Named("shopTabSheet.goodsTab")
    private VBoxLayout goodsTab;
    @Named("shopTabSheet.shipmentTab")
    private VBoxLayout shipmentTab;
    @Inject
    private Messages messages;
    @Inject
    private Metadata metadata;

    private void refreshAll(){
        try {
            getScreenData().loadAll();

            if (getEditedEntity() != null) {
                shopTabSheet.getTab("shipmentTab").setCaption(shipmentTab.getCaption() + " (" + getEditedEntity().getShipments().size() + ")");
                shopTabSheet.getTab("goodsTab").setCaption(goodsTab.getCaption() + " (" + getEditedEntity().getGoods().size() + ")");
                shopTabSheet.setCaption(getEditedEntity().getName());
            }

            int x = cssConfig.getFrom();
            shopGoodsTable.setStyleProvider(((entity, property) -> {
                if (entity != null && entity.getQuantity() != null) {
                    if (entity.getQuantity() < x) {
                        return "redColorStyle";
                    }
                }
                return null;
            }));

            boolean deficite = false;
            for (Goods g : shopGoodsTable.getItems().getItems()) {
                if (g.getQuantity() < x) deficite = true;
            }

            if (deficite) {
                shopTabSheet.getTab("goodsTab").setStyleName("redColorStyle");
            } else {
                shopTabSheet.getTab("goodsTab").setStyleName(null);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        refreshAll();
    }
    @Subscribe
    public void onInitEntity(InitEntityEvent<Shop> event) {
        event.getEntity().setAddress(metadata.create(Address.class));
    }

    //buttons
    @Subscribe("shopServiceButton")
    public void onShopServiceButtonClick(Button.ClickEvent event) {
        String fv = purchaseCountService.purchaseCount(getEditedEntity().getName());
        if(fv.equals("")) fv = messages.getMessage("com.abc.sales.web.shop","purchaseCountService.purchaseCount.noPurchases");
        shopServicefield.setValue(fv);
    }
    @Subscribe("goodsRefreshButton")
    public void onRefreshButtonClick(Button.ClickEvent event) {
        refreshAll();
    }
    @Subscribe("shipmentRefreshButton")
    public void onShipmentRefreshButtonClick(Button.ClickEvent event) {
        refreshAll();
    }

    //refresh
    @Subscribe(id = "shopGoodsesDc", target = Target.DATA_CONTAINER)
    public void onShopGoodsesDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Goods> event) {
        refreshAll();
    }
    @Subscribe(id = "shopGoodsesDc", target = Target.DATA_CONTAINER)
    public void onShopGoodsesDcItemChange(InstanceContainer.ItemChangeEvent<Goods> event) {
        refreshAll();
    }
    @Subscribe(id = "shopShipmentsesDc", target = Target.DATA_CONTAINER)
    public void onShopShipmentsesDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Shipment> event) {
        refreshAll();
    }
    @Subscribe(id = "shopShipmentsesDc", target = Target.DATA_CONTAINER)
    public void onShopShipmentsesDcItemChange(InstanceContainer.ItemChangeEvent<Shipment> event) {
        refreshAll();
    }
    @Subscribe("shopTabSheet")
    public void onShopTabSheetSelectedTabChange(TabSheet.SelectedTabChangeEvent event) {
        refreshAll();
    }

}