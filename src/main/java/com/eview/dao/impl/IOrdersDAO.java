
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Orders;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IOrdersDAO extends ICommonDAO<Orders>{
     public String deleteByCid(int cid);
     public List<Orders> getByCid(int cid);
      public List<Orders> getByOrderNo(int orderNo);
    public String deleteByOrderNo(int orderNo);
}
