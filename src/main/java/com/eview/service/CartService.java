package com.eview.service;

import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IProductionDAO;
import com.eview.model.Cart;
import com.eview.model.Production;
import com.eview.service.impl.ICartService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "cartService")
public class CartService implements ICartService {

    @Autowired
    ICartDAO cartDAO;

    @Autowired
    IProductionDAO productionDAO;

    @Override
    public Cart save(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("pid"));

        Production p = productionDAO.getById(id);
        double dis = ((p.getPrice() * p.getDiscount()) / 100);
        double total = (p.getPrice() - dis);

        Cart cart = cartDAO.getByProductCode(p.getCode());
        if (cart != null) {
            System.out.println("Product already added to Cart");
        } else {
            Cart t = new Cart();
            t.setPid(p.getId());
            t.setpName(p.getName());
            t.setpCode(p.getCode());
            t.setSp(p.getSp());
            t.setDes(p.getDes());
            t.setpPrice(p.getPrice());
            t.setPhoto(p.getPhoto());
            t.setDiscount(p.getDiscount());
            t.setTotal(total);
            t.setCid(1);

            return cartDAO.save(t);
        }
        return cart;
    }

    @Override
    public Cart update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Cart t = new Cart();
        t.setKid(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return cartDAO.update(t);
    }

    @Override
    public Cart delete(int id) {
        return cartDAO.delete(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartDAO.getAll();
    }

    @Override
    public Cart getById(int id) {
        return cartDAO.getById(id);
    }

    @Override
    public Cart getByProductCode(String pCode) {
        return cartDAO.getByProductCode(pCode);
    }

    @Override
    public String deleteByCid(int cid) {
        return cartDAO.deleteByCid(cid);
    }

    @Override
    public List<Cart> getByCid(int cid) {
        return cartDAO.getByCid(cid);
    }

}
