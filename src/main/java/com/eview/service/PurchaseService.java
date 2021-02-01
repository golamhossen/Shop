package com.eview.service;

import com.eview.dao.impl.ICategoryDAO;
import com.eview.dao.impl.IProductionDAO;
import com.eview.dao.impl.IPurchaseDAO;
import com.eview.dao.impl.IStockDAO;
import com.eview.model.Production;
import com.eview.model.Purchase;
import com.eview.model.Stock;
import com.eview.service.impl.IPurchaseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "purchaseService")
public class PurchaseService implements IPurchaseService {

    @Autowired
    IPurchaseDAO purchaseDAO;
    @Autowired
    IProductionDAO productionDAO;
    @Autowired
    ICategoryDAO categoryDAO;
    @Autowired
    IStockDAO stockDAO;

    @Override
    public Purchase save(HttpServletRequest request) {
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

        Purchase p = new Purchase();
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

        purchaseDAO.save(p);

        Stock stock = stockDAO.getByProductCode(pCode);
        if (stock != null) {
            System.out.println("Not Null");
            Stock s = new Stock();
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
            stockDAO.update(s);
        } else {
            Stock s = new Stock();
            s.setPid(pid);
            s.setpCode(pCode);
            s.setpName(pName);
            s.setpPrice(costPerProduct);
            s.setQty((int) qty);
            s.setTotalPrice(grandTotal);
            s.setTotalSales(0D);
            s.setProfit(0D);
            stockDAO.save(s);
            System.out.println("Null");
        }
        return p;
    }

    @Override
    public Purchase update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Purchase delete(int id) {
        return purchaseDAO.delete(id);
    }

    @Override
    public List<Purchase> getAll() {
        return purchaseDAO.getAll();
    }

    @Override
    public Purchase getById(int id) {
        return purchaseDAO.getById(id);
    }

    @Override
    public double getTotalPurchasePrice() {
   List<Purchase> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getGrandTotal();
        }
        return total;
    }

    @Override
    public int getTotalQty() {
   List<Purchase> stList = getAll();
        int total = 0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getQty();
        }
        return total;
    }

    @Override
    public double getTotal() {
   List<Purchase> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getTotal();
        }
        return total;
    }

}
