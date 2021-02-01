
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Orders2;
import java.util.List;


public interface IOrders2Service extends ICommonService<Orders2>{
    public String deleteByCid(int cid);
     public List<Orders2> getByCid(int cid);
}
