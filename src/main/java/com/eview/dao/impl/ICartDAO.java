/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.dao.impl;

import com.eview.common.ICommonDAO;
import com.eview.model.Cart;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ICartDAO extends ICommonDAO<Cart> {

    long getCartCount();

    public Cart getByProductCode(String pCode);

    public String deleteByCid(int cid);

    public List<Cart> getByCid(int cid);
}
