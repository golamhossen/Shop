
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Stock;


public interface IStockService extends ICommonService<Stock>{
    public double getTotalPurchasePrice();
    public double getTotalSalesPrice();
    public double getTotalProfit();
    public int getTotalQty();
}
