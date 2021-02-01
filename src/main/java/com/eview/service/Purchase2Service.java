package com.eview.service;

import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IGoodsDAO;
import com.eview.dao.impl.IPurchase2DAO;
import com.eview.dao.impl.IStock2DAO;
import com.eview.model.Purchase2;
import com.eview.model.Stock2;
import com.eview.service.impl.IPurchase2Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "purchase2Service")
public class Purchase2Service implements IPurchase2Service {

    @Autowired
    IPurchase2DAO purchase2DAO;
    @Autowired
    IGoodsDAO goodsDAO;
    @Autowired
    ICategoryDAO categoryDAO;
    @Autowired
    IStock2DAO stock2DAO;

    @Override
    public Purchase2 save(HttpServletRequest request) {
        int pid = Integer.parseInt(request.getParameter("pid"));
        String pName = request.getParameter("pName");
        String pCode = request.getParameter("pCode");
        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = request.getParameter("cname");
        String pDes = request.getParameter("pDes");
        String photo = request.getParameter("photo");

        double price = Double.parseDouble(request.getParameter("price"));
        double qty = Double.parseDouble(request.getParameter("qty"));
        double total = price * qty;
        double vat = Double.parseDouble(request.getParameter("vat"));
        double vatTotal = (total * vat) / 100;
        double grandTotal = total + vatTotal;
        double costPerProduct = grandTotal / qty;
        System.out.println(costPerProduct);

        Purchase2 p = new Purchase2();
        p.setPid(pid);
        p.setpName(pName);
        p.setpCode(pCode);
        p.setCid(cid);
        p.setCname(cname);
        p.setpDes(pDes);
        p.setPhoto(photo);
        p.setPrice(price);
        p.setQty((int) qty);
        p.setTotal(total);
        p.setVat((int) vat);
        p.setGrandTotal(grandTotal);
        p.setCostPerProduct(costPerProduct);

        purchase2DAO.save(p);

        Stock2 stock = stock2DAO.getByGoodsCode(pCode);
        if (stock != null) {
            System.out.println("Not Null");
            Stock2 s = new Stock2();
            s.setId(stock.getId());
            s.setPid(stock.getPid());
            s.setpName(stock.getpName());
            s.setpCode(stock.getpCode());
            s.setpPrice(costPerProduct);
            int lastQty = stock.getQty();
            int updateQty = (int) (lastQty + qty);
            s.setQty(updateQty);
            double lastTotal = stock.getTotalPrice();
            double updateTotal = lastTotal + grandTotal;
            s.setTotalPrice(updateTotal);
            s.setSalesPrice(stock.getSalesPrice());
            s.setTotalSales(stock.getTotalSales());
            s.setProfit(stock.getProfit());
            stock2DAO.update(s);
        } else {
            Stock2 s = new Stock2();
            s.setPid(pid);
            s.setpCode(pCode);
            s.setpName(pName);
            s.setpPrice(costPerProduct);
            s.setQty((int) qty);
            s.setTotalPrice(grandTotal);
            s.setTotalSales(0D);
            s.setProfit(0D);
            stock2DAO.save(s);
            System.out.println("Null");
        }
        return p;
    }

    @Override
    public Purchase2 update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase2 delete(int id) {
        return purchase2DAO.delete(id);
    }

    @Override
    public List<Purchase2> getAll() {
        return purchase2DAO.getAll();
    }

    @Override
    public Purchase2 getById(int id) {
        return purchase2DAO.getById(id);
    }

    @Override
    public double getTotalPurchasePrice() {
        List<Purchase2> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getGrandTotal();
        }
        return total;
    }

    @Override
    public int getTotalQty() {
        List<Purchase2> stList = getAll();
        int total = 0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getQty();
        }
        return total;
    }

    @Override
    public double getTotal() {
        List<Purchase2> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getTotal();
        }
        return total;
    }

}
