package com.eview.service;

import com.eview.dao.impl.ICartDAO;
import com.eview.dao.impl.IInvoiceDAO;
import com.eview.model.Invoice;
import com.eview.service.impl.IInvoiceService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "invoiceService")
public class InvoiceService implements IInvoiceService {

    @Autowired
    IInvoiceDAO invoiceDAO;

    @Autowired
    ICartDAO cartDAO;

    @Autowired
    IInvoiceDAO ordersDAO;

    @Override
    public Invoice save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
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

        return invoiceDAO.save(in);
    }

    @Override
    public Invoice update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Invoice t = new Invoice();
        t.setId(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return ordersDAO.update(t);
    }

    @Override
    public Invoice delete(int id) {
        return ordersDAO.delete(id);
    }

    @Override
    public List<Invoice> getAll() {
        return ordersDAO.getAll();
    }

    @Override
    public Invoice getById(int id) {
        return ordersDAO.getById(id);
    }

    @Override
    public Invoice getByOrderNo(int orderNo) {
        return invoiceDAO.getByOrderNo(orderNo);
    }

    @Override
    public String deleteByOrderNo(int orderNo) {
        return invoiceDAO.deleteByOrderNo(orderNo);
    }

    @Override
    public long getCount() {
        return invoiceDAO.getCount();
    }
}
