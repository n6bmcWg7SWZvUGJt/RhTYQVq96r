package com.company.market.web.screens.purchase;

import com.company.market.entity.Goods;
import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.validation.DecimalMaxValidator;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.market.entity.Purchase;

import javax.inject.Inject;
import java.math.BigDecimal;

@DialogMode(forceDialog = true)
@UiController("market_Purchase.edit")
@UiDescriptor("purchase-edit.xml")
@EditedEntityContainer("purchaseDc")
@LoadDataBeforeShow
public class PurchaseEdit extends StandardEditor<Purchase> {
    @Inject
    private CollectionLoader<Goods> goodsesDl;
    @Inject
    private TextField<Integer> countField;
    @Inject
    private BeanLocator beanLocator;
    @Inject
    private Messages messages;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        goodsesDl.setParameter("shop", getEditedEntity()
                .getShipment()
                .getShop());
    }

    @Subscribe("goodsField")
    public void onPurchaseFieldValueChange(HasValue.ValueChangeEvent<Goods> event) {
        if(event.getValue() != null) {
            DecimalMaxValidator maxValidator = beanLocator.getPrototype(DecimalMaxValidator.NAME, new BigDecimal(event.getValue().getQuantity()));
            maxValidator.setInclusive(true);
            maxValidator.setMessage(messages.getMessage("com.company.market.web.screens.purchase", "limit"));
            countField.addValidator(maxValidator);
        }
    }

}