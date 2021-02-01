package com.eview.service;

import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.IGoodsDAO;
import com.eview.model.Cart2;
import com.eview.model.Goods;
import com.eview.service.impl.ICart2Service;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "cart2Service")
public class Cart2Service implements ICart2Service {

    @Autowired
    ICart2DAO cart2DAO;

    @Autowired
    IGoodsDAO goodsDAO;

    @Override
    public Cart2 save(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("pid"));

        Goods g = goodsDAO.getById(id);
        double dis = ((g.getPrice() * g.getDiscount()) / 100);
        double total = (g.getPrice() - dis);

        Cart2 cart = cart2DAO.getByGoodsCode(g.getCode());
        if (cart != null) {
            System.out.println("Product already added to Cart2");
        } else {
            Cart2 t = new Cart2();
            t.setPid(g.getId());
            t.setpName(g.getName());
            t.setpCode(g.getCode());
            t.setSp(g.getSp());
            t.setDes(g.getDes());
            t.setpPrice(g.getPrice());
            t.setPhoto(g.getPhoto());
            t.setDiscount(g.getDiscount());
            t.setTotal(total);
            t.setCid(1);

            return cart2DAO.save(t);
        }
        return cart;
    }

    @Override
    public Cart2 update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Cart2 t = new Cart2();
        t.setGid(Integer.parseInt(map.get("gid")[0]));
//         t.setName(map.get("name")[0]);
        return cart2DAO.update(t);
    }

    @Override
    public Cart2 delete(int id) {
        return cart2DAO.delete(id);
    }

    @Override
    public List<Cart2> getAll() {
        return cart2DAO.getAll();
    }

    @Override
    public Cart2 getById(int id) {
        return cart2DAO.getById(id);
    }

    @Override
    public String deleteByCid(int cid) {
        return cart2DAO.deleteByCid(cid);
    }

    @Override
    public List<Cart2> getByCid(int cid) {
        return cart2DAO.getByCid(cid);
    }

}
