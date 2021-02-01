
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Stock2;


public interface IStock2Service extends ICommonService<Stock2>{
    public double getTotalPurchasePrice();
    public double getTotalSalesPrice();
    public double getTotalProfit();
    public int getTotalQty();
}
