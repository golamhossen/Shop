
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.TempProduct;
import java.util.List;


public interface ITempProductDAO extends ICommonDAO<TempProduct>{
    public String deleteByCid(int cid);
     public List<TempProduct> getByCid(int cid);
}
