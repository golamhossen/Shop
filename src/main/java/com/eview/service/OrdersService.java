package com.eview.service;

import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IInvoice1DAO;
import com.eview.dao.impl.IInvoiceDAO;
import com.eview.dao.impl.IOrdersDAO;
import com.eview.model.Cart;
import com.eview.model.Invoice;
import com.eview.model.Orders;
import com.eview.service.impl.IOrdersService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ordersService")
public class OrdersService implements IOrdersService {

    @Autowired
    IOrdersDAO ordersDAO;

    @Autowired
    ICartDAO cartDAO;
    @Autowired
    IInvoiceDAO invoiceDAO;

    @Override
    public Orders save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String[] kid = map.get("kid[]");
        String[] pid = (String[]) map.get("pid[]");
        String[] photo = (String[]) map.get("photo[]");
        String[] pName = (String[]) map.get("pName[]");
        String[] pCode = (String[]) map.get("pCode[]");
        String[] pPrice = (String[]) map.get("pPrice[]");
        String[] qty = (String[]) map.get("qty[]");
        String[] discount = (String[]) map.get("discount[]");
        String[] total = (String[]) map.get("total[]");

        double subTotal = Double.parseDouble(request.getParameter("subTotal"));
        int vat = Integer.parseInt(request.getParameter("vat"));
        int dCharge = Integer.parseInt(request.getParameter("dCharge"));
        double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));
       
        
        Random random = new Random();
        int cid = random.nextInt(100000);
        int orderNo = random.nextInt(100000000);
        LocalDate ld = LocalDate.now();
        String orderDate = ld.toString();
        
        
        Invoice in = new Invoice();
        in.setSubTotal(subTotal);
        in.setVat(vat);
        in.setdCharge(dCharge);
        in.setGrandTotal(grandTotal);
        in.setCid(cid);
        in.setOrderNo(orderNo);
        in.setOrderDate(orderDate);
        invoiceDAO.save(in);
        System.out.println("........................" + kid);
        Orders t = new Orders();

        for (int i = 0; i < kid.length; i++) {
            System.out.println("........................" + kid);
            t.setPid(Integer.parseInt(pid[i]));
            t.setPhoto(photo[i]);
            t.setpName(pName[i]);
            t.setpCode(pCode[i]);
            t.setpPrice(Double.parseDouble(pPrice[i]));
            t.setQty(Integer.parseInt(qty[i]));
            t.setDiscount(Integer.parseInt(discount[i]));
            t.setTotal(Double.parseDouble(total[i]));
            t.setCid(cid);
            t.setOrderNo(orderNo);
            ordersDAO.save(t);
        }
        return t;
    }

    @Override
    public Orders update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Orders t = new Orders();
        t.setId(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return ordersDAO.update(t);
    }

    @Override
    public Orders delete(int id) {
        return ordersDAO.delete(id);
    }

    @Override
    public List<Orders> getAll() {
        return ordersDAO.getAll();
    }

    @Override
    public Orders getById(int id) {
        return ordersDAO.getById(id);
    }

    @Override
    public String deleteByCid(int cid) {
        return ordersDAO.deleteByCid(cid);
    }

    @Override
    public List<Orders> getByCid(int cid) {
        return ordersDAO.getByCid(cid);
    }

    @Override
    public List<Orders> getByOrderNo(int orderNo) {
        return ordersDAO.getByOrderNo(orderNo);
    }

    @Override
    public String deleteByOrderNo(int orderNo) {
        return ordersDAO.deleteByOrderNo(orderNo);
    }
}
