package com.company.market.listeners;

import com.company.market.entity.Goods;
import com.company.market.entity.Purchase;
import com.company.market.entity.Shipment;
import com.company.market.service.UtilsService;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Component("market_ShipmentChangedListener")
public class ShipmentChangedListener {

    @Inject
    private TransactionalDataManager txDm;
    @Inject
    private Logger log;
    @Inject
    private UtilsService utilsService;
    @Inject
    private DataManager dataManager;

    @Transactional
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void beforeCommit(EntityChangedEvent<Shipment, UUID> event) {

    }

    @TransactionalEventListener(
            phase = TransactionPhase.AFTER_COMMIT
    )
    public void afterCommit(EntityChangedEvent<Shipment, UUID> event) {

    }
}