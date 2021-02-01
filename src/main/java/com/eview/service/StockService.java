package com.eview.service;

import com.eview.dao.impl.IProductionDAO;
import com.eview.dao.impl.IStockDAO;
import com.eview.model.Production;
import com.eview.model.Stock;
import com.eview.service.impl.IStockService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "stockService")
public class StockService implements IStockService {

    @Autowired
    IStockDAO stockDAO;

    @Autowired
    IProductionDAO productionDAO;

    @Override
    public Stock save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String[] kid = map.get("kid[]");
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

        Stock s = new Stock();
        for (int i = 0; i < kid.length; i++) {
            Stock stock = stockDAO.getByProductCode(pCode[i]);
            s.setId(stock.getId());
            s.setPid(stock.getPid());
            s.setpName(stock.getpName());
            s.setpCode(stock.getpCode());
            s.setpPrice(stock.getpPrice());
            int lastQty = stock.getQty();
            int updateQty = Integer.parseInt(qty[i]);
            int finalQty = (lastQty - updateQty);
            s.setQty(finalQty);
//            double lastTotal = stock.getTotalCost();
//            double updateTotal = lastTotal + grandTotal;
            s.setTotalPrice(stock.getTotalPrice());
            double salePrice = (Double.parseDouble(total[i]) / Integer.parseInt(qty[i]));

            s.setSalesPrice(salePrice);
            double lastSales = stock.getTotalSales();
            double updateSales = Double.parseDouble(total[i]);
            double totalSales = lastSales + updateSales;
            s.setTotalSales(totalSales);
            //Getting Profit
            double pPrice = stock.getpPrice();
            double sales = Double.parseDouble(total[i]);
            int quantity = Integer.parseInt(qty[i]);
            double purchase = (pPrice * quantity);
            double profits = sales - purchase;
            double lastProfit = stock.getProfit();
            double updateProfit = lastProfit + profits;
            s.setProfit(updateProfit);
//           Stock stock = stockDAO.getByProductCode(pCode[i]);
//           s.setId(stock.getId());
//           s.setPid(stock.getPid());
//           System.out.println(stock.getId());
//           s.setpName(stock.getpName());
//           s.setpCode(stock.getpCode());
//           s.setpPrice(stock.getpPrice());
//           int lastQty = stock.getQty();
//           int updateQty = Integer.parseInt(qty[i]);
//           int finalQty = (lastQty - updateQty);
//           s.setQty(finalQty);
//           
//           s.setTotalPrice(stock.getTotalPrice());
//           s.setSalesPrice(Double.parseDouble(salesPrice[i]));
//           double lastSales = stock.getTotalSales();
//           double updateSales = Double.parseDouble(total[i]);
//           double totalSales = lastSales + updateSales;
//           s.setTotalSales(totalSales);
//           
//           double pPrice = stock.getpPrice();
//           double sales = Double.parseDouble(total[i]);
//           int quantity = Integer.parseInt(qty[i]);
//           double purchase = (pPrice * quantity);
//           double profits = sales - purchase;
//           double lastProfit = stock.getProfit();
//           double updateProfit = lastProfit + profits;
//           
//           s.setProfit(updateProfit);
            stockDAO.update(s);
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
    public Stock update(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        String stockAction = request.getParameter("stockAction");
        double price = Double.parseDouble(request.getParameter("price"));
        double qty = Double.parseDouble(request.getParameter("qty"));
        double vat = Double.parseDouble(request.getParameter("vat"));
        double total = price * qty;
        double vatTotal = (total * vat) / 100;
        double totalPrice = total + vatTotal;
        Production pp = productionDAO.getById(pid);
        Stock p = new Stock();
        p.setPid(pp.getId());
        p.setpName(pp.getName());
        p.setpCode(pp.getCode());
        p.setpPrice(pp.getPrice());
        p.setTotalPrice(totalPrice);

        return stockDAO.update(p);
    }

    @Override
    public Stock delete(int id) {
        return stockDAO.delete(id);
    }

    @Override
    public List<Stock> getAll() {
        return stockDAO.getAll();
    }

    @Override
    public Stock getById(int id) {
        return stockDAO.getById(id);
    }

    @Override
    public double getTotalPurchasePrice() {
   List<Stock> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getTotalPrice();
        }
        return total;
    
    }
    

    @Override
    public double getTotalSalesPrice() {
   
     List<Stock> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getSalesPrice();
        }
        return total;
    
    }

    @Override
    public double getTotalProfit() {
        List<Stock> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getProfit();
        }
        return total;
    }

    @Override
    public int getTotalQty() {
     List<Stock> stList = getAll();
        int total = 0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getQty();
        }
        return total;
    }

}
