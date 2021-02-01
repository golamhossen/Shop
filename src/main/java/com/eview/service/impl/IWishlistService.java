
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Wishlist;
import java.util.List;


public interface IWishlistService extends ICommonService<Wishlist>{
    
    public Wishlist getByProductCode(String pCode);

    public String deleteByCid(int cid);

    public List<Wishlist> getByCid(int cid);
}
