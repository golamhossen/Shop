
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Cart;
import java.util.List;


public interface ICartService extends ICommonService<Cart> {

    public Cart getByProductCode(String pCode);

    public String deleteByCid(int cid);

    public List<Cart> getByCid(int cid);
}
