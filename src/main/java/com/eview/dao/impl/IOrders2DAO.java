
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Orders2;
import java.util.List;


public interface IOrders2DAO extends ICommonDAO<Orders2>{
     public String deleteByCid(int cid);
     public List<Orders2> getByCid(int cid);
}
