
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Purchase2;


public interface IPurchase2Service extends ICommonService<Purchase2>{
    
    public double getTotalPurchasePrice();

    public int getTotalQty();
    
    public double getTotal();
}
