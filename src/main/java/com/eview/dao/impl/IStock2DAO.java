package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Stock2;
import com.eview.model.Stock2;

public interface IStock2DAO extends ICommonDAO<Stock2> {

    public Stock2 getByGoodsCode(String pCode);
}
