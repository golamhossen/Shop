package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Purchase;

public interface IPurchaseService extends ICommonService<Purchase> {

    public double getTotalPurchasePrice();

    public int getTotalQty();
    
    public double getTotal();
}
