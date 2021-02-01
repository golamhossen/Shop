package com.eview.service;

import com.eview.dao.impl.ICart2DAO;
import com.eview.dao.impl.IOrders2DAO;
import com.eview.model.Orders2;
import com.eview.service.impl.IOrders2Service;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orders2Service")

public class Orders2Service implements IOrders2Service {

    @Autowired
    IOrders2DAO orders2DAO;

    @Autowired
    ICart2DAO cart2DAO;

    @Override
    public Orders2 save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String[] gid = map.get("gid[]");
        String[] pid = (String[]) map.get("pid[]");
        String[] photo = (String[]) map.get("photo[]");
        String[] pName = (String[]) map.get("pName[]");
        String[] pCode = (String[]) map.get("pCode[]");
        String[] pPrice = (String[]) map.get("pPrice[]");
        String[] qty = (String[]) map.get("qty[]");
        String[] discount = (String[]) map.get("discount[]");
        String[] total = (String[]) map.get("total[]");
        Random random = new Random();
        int cid = random.nextInt(100);

        System.out.println("........................" + gid);
        Orders2 t = new Orders2();

        for (int i = 0; i < gid.length; i++) {
            System.out.println("........................" + gid);
            t.setPid(Integer.parseInt(pid[i]));
            t.setPhoto(photo[i]);
            t.setpName(pName[i]);
            t.setpCode(pCode[i]);
            t.setpPrice(Double.parseDouble(pPrice[i]));
            t.setQty(Integer.parseInt(qty[i]));
            t.setDiscount(Integer.parseInt(discount[i]));
            t.setTotal(Double.parseDouble(total[i]));
            t.setCid(cid);
            orders2DAO.save(t);
            
        }
        return t;
    }

    @Override
    public Orders2 update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Orders2 t = new Orders2();
        t.setId(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return orders2DAO.update(t);
    }

    @Override
    public Orders2 delete(int id) {
        return orders2DAO.delete(id);
    }

    @Override
    public List<Orders2> getAll() {
        return orders2DAO.getAll();
    }

    @Override
    public Orders2 getById(int id) {
        return orders2DAO.getById(id);
    }

    @Override
    public String deleteByCid(int cid) {
        return orders2DAO.deleteByCid(cid);
    }

    @Override
    public List<Orders2> getByCid(int cid) {
        return orders2DAO.getByCid(cid);
    }

}
