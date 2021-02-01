
package com.eview.service.impl;

import com.eview.common.ICommonService;
import com.eview.model.Wishlist2;
import java.util.List;


public interface IWishlist2Service extends ICommonService<Wishlist2>{
    
      public Wishlist2 getByProductCode(String pCode);

    public String deleteByCid(int cid);

    public List<Wishlist2> getByCid(int cid);
}
