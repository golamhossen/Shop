
package com.eview.service;

import com.eview.dao.impl.IProductionDAO;
import com.eview.dao.impl.IWishlistDAO;
import com.eview.model.Production;
import com.eview.model.Wishlist;
import com.eview.service.impl.IWishlistService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "wishlistService")
public class WishlistService implements IWishlistService{

   @Autowired
    IWishlistDAO wishlistDAO;

    @Autowired
    IProductionDAO productionDAO;

    @Override
    public Wishlist save(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("pid"));

        Production p = productionDAO.getById(id);
        double dis = ((p.getPrice() * p.getDiscount()) / 100);
        double total = (p.getPrice() - dis);

        Wishlist wish = wishlistDAO.getByProductCode(p.getCode());
        if (wish != null) {
            System.out.println("Product already added to Wishlist");
        } else {
            Wishlist t = new Wishlist();
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

            return wishlistDAO.save(t);
        }
        return wish;
    }

    @Override
    public Wishlist update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Wishlist t = new Wishlist();
        t.setWid(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return wishlistDAO.update(t);
    }

    @Override
    public Wishlist delete(int id) {
        return wishlistDAO.delete(id);
    }

    @Override
    public List<Wishlist> getAll() {
        return wishlistDAO.getAll();
    }

    @Override
    public Wishlist getById(int id) {
        return wishlistDAO.getById(id);
    }

    @Override
    public Wishlist getByProductCode(String pCode) {
        return wishlistDAO.getByProductCode(pCode);
    }

    @Override
    public String deleteByCid(int cid) {
        return wishlistDAO.deleteByCid(cid);
    }

    @Override
    public List<Wishlist> getByCid(int cid) {
        return wishlistDAO.getByCid(cid);
    }

}
