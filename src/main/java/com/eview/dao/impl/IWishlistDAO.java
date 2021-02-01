
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Wishlist;
import java.util.List;


public interface IWishlistDAO extends ICommonDAO<Wishlist>{
     long getWishlistCount();

    public Wishlist getByProductCode(String pCode);

    public String deleteByCid(int cid);

    public List<Wishlist> getByCid(int cid);
}
