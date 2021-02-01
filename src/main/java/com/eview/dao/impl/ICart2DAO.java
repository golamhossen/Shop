package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Cart2;
import java.util.List;

public interface ICart2DAO extends ICommonDAO<Cart2> {

    long getCart2Count();

    public Cart2 getByGoodsCode(String pCode);

    public String deleteByCid(int cid);

    public List<Cart2> getByCid(int cid);

}
