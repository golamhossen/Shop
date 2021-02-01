package com.eview.service;

import com.eview.dao.impl.IGoodsDAO;
import com.eview.dao.impl.IWishlist2DAO;
import com.eview.model.Goods;
import com.eview.model.Wishlist2;
import com.eview.service.impl.IWishlist2Service;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "wishlist2Service")
public class Wishlist2Service implements IWishlist2Service {

    @Autowired
    IWishlist2DAO wishlist2DAO;

    @Autowired
    IGoodsDAO goodsDAO;

    @Override
    public Wishlist2 save(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("pid"));

        Goods p = goodsDAO.getById(id);
        double dis = ((p.getPrice() * p.getDiscount()) / 100);
        double total = (p.getPrice() - dis);

        Wishlist2 wish = wishlist2DAO.getByProductCode(p.getCode());
        if (wish != null) {
            System.out.println("Product already added to Wishlist2");
        } else {
            Wishlist2 t = new Wishlist2();
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

            return wishlist2DAO.save(t);
        }
        return wish;
    }

    @Override
    public Wishlist2 update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Wishlist2 t = new Wishlist2();
        t.setWid(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return wishlist2DAO.update(t);
    }

    @Override
    public Wishlist2 delete(int id) {
        return wishlist2DAO.delete(id);
    }

    @Override
    public List<Wishlist2> getAll() {
        return wishlist2DAO.getAll();
    }

    @Override
    public Wishlist2 getById(int id) {
        return wishlist2DAO.getById(id);
    }

    @Override
    public Wishlist2 getByProductCode(String pCode) {
        return wishlist2DAO.getByProductCode(pCode);
    }

    @Override
    public String deleteByCid(int cid) {
        return wishlist2DAO.deleteByCid(cid);
    }

    @Override
    public List<Wishlist2> getByCid(int cid) {
        return wishlist2DAO.getByCid(cid);
    }

}
