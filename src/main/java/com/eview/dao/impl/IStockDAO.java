
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Stock;


public interface IStockDAO extends ICommonDAO<Stock>{
    public Stock getByProductCode(String pCode);
    
    
}
