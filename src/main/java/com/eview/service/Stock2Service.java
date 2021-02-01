package com.eview.service;

import com.eview.dao.impl.IGoodsDAO;
import com.eview.dao.impl.IStock2DAO;
import com.eview.model.Goods;
import com.eview.model.Stock2;
import com.eview.service.impl.IStock2Service;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "stock2Service")
public class Stock2Service implements IStock2Service {

    @Autowired
    IStock2DAO stock2DAO;

    @Autowired
    IGoodsDAO goodsDAO;

    @Override
    public Stock2 save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String[] gid = map.get("gid[]");
        String[] pid = (String[]) map.get("pid[]");
        String[] pName = (String[]) map.get("pName[]");
        String[] pCode = (String[]) map.get("pCode[]");
        String[] photo = (String[]) map.get("photo[]");
        String[] salesPrice = (String[]) map.get("salesPrice[]");
        String[] discount = (String[]) map.get("discount[]");
        String[] qty = (String[]) map.get("qty[]");
        String[] total = (String[]) map.get("total[]");
        String[] cid = (String[]) map.get("cid[]");
        int cId = Integer.parseInt(request.getParameter("cid"));
        String code = request.getParameter("pCode");

        Stock2 s = new Stock2();
        for (int i = 0; i < gid.length; i++) {
            Stock2 stock2 = stock2DAO.getByGoodsCode(pCode[i]);
            s.setId(stock2.getId());
            s.setPid(stock2.getPid());
            s.setpName(stock2.getpName());
            s.setpCode(stock2.getpCode());
            s.setpPrice(stock2.getpPrice());
            int lastQty = stock2.getQty();
            int updateQty = Integer.parseInt(qty[i]);
            int finalQty = (lastQty - updateQty);
            s.setQty(finalQty);
//            double lastTotal = stock.getTotalCost();
//            double updateTotal = lastTotal + grandTotal;
            s.setTotalPrice(stock2.getTotalPrice());
            double salePrice = (Double.parseDouble(total[i]) / Integer.parseInt(qty[i]));

            s.setSalesPrice(salePrice);
            double lastSales = stock2.getTotalSales();
            double updateSales = Double.parseDouble(total[i]);
            double totalSales = lastSales + updateSales;
            s.setTotalSales(totalSales);
            //Getting Profit
            double pPrice = stock2.getpPrice();
            double sales = Double.parseDouble(total[i]);
            int quantity = Integer.parseInt(qty[i]);
            double purchase = (pPrice * quantity);
            double profits = sales - purchase;
            double lastProfit = stock2.getProfit();
            double updateProfit = lastProfit + profits;
            s.setProfit(updateProfit);
//            Stock2 stock = stock2DAO.getByProductCode(pCode[i]);
//            s.setId(stock.getId());
//            s.setPid(stock.getPid());
//            s.setpName(stock.getpName());
//            s.setpCode(stock.getpCode());
//            s.setpPrice(stock.getpPrice());
//            int lastQty = stock.getQty();
//            int updateQty = Integer.parseInt(qty[i]);
//            int finalQty = (lastQty - updateQty);
//            s.setQty(finalQty);
//
//            s.setTotalPrice(stock.getTotalPrice());
//            s.setSalesPrice(Double.parseDouble(salesPrice[i]));
//            double lastSales = stock.getTotalSales();
//            double updateSales = Double.parseDouble(total[i]);
//            double totalSales = lastSales + updateSales;
//            s.setTotalSales(totalSales);
//
//            double pPrice = stock.getpPrice();
//            double sales = Double.parseDouble(total[i]);
//            int quantity = Integer.parseInt(qty[i]);
//            double purchase = (pPrice * quantity);
//            double profits = sales - purchase;
//            double lastProfit = stock.getProfit();
//            double updateProfit = lastProfit + profits;
//
//            s.setProfit(updateProfit);
            stock2DAO.update(s);
        }

//        int pid = Integer.parseInt(request.getParameter("pid"));
//        double price = Double.parseDouble(request.getParameter("price"));
//        double qty = Double.parseDouble(request.getParameter("qty"));
//        double vat = Double.parseDouble(request.getParameter("vat"));
//        double total = price * qty;
//        double vatTotal = (total * vat) / 100;
//        double totalPrice = total + vatTotal;
//        Production pp = productionDAO.getById(pid);
//        Stock p = new Stock();
//        p.setPid(pp.getId());
//        p.setpName(pp.getName());
//        p.setpCode(pp.getCode());
//        p.setpPrice(pp.getPrice());
//        p.setQty((int) qty);
//        p.setTotalPrice(totalPrice);
//        return stockDAO.save(p);
        return s;
    }

    @Override
    public Stock2 update(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        String stockAction = request.getParameter("stockAction");
        double price = Double.parseDouble(request.getParameter("price"));
        double qty = Double.parseDouble(request.getParameter("qty"));
        double vat = Double.parseDouble(request.getParameter("vat"));
        double total = price * qty;
        double vatTotal = (total * vat) / 100;
        double totalPrice = total + vatTotal;
        Goods pp = goodsDAO.getById(pid);
        Stock2 p = new Stock2();
        p.setPid(pp.getId());
        p.setpName(pp.getName());
        p.setpCode(pp.getCode());
        p.setpPrice(pp.getPrice());
        p.setTotalPrice(totalPrice);

        return stock2DAO.update(p);
    }

    @Override
    public Stock2 delete(int id) {
        return stock2DAO.delete(id);
    }

    @Override
    public List<Stock2> getAll() {
        return stock2DAO.getAll();
    }

    @Override
    public Stock2 getById(int id) {
        return stock2DAO.getById(id);
    }

    @Override
    public double getTotalPurchasePrice() {
        List<Stock2> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getTotalPrice();
        }
        return total;

    }

    @Override
    public double getTotalSalesPrice() {

        List<Stock2> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getSalesPrice();
        }
        return total;

    }

    @Override
    public double getTotalProfit() {
        List<Stock2> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getProfit();
        }
        return total;
    }

    @Override
    public int getTotalQty() {
        List<Stock2> stList = getAll();
        int total = 0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getQty();
        }
        return total;
    }

}
