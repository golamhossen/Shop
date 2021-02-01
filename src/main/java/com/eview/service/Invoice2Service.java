
package com.eview.service;

import com.eview.dao.impl.IInvoice2DAO;
import com.eview.dao.impl.IOrders2DAO;
import com.eview.model.Invoice2;
import com.eview.service.impl.IInvoice2Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "invoice2Service")
public class Invoice2Service implements IInvoice2Service{
    
    @Autowired
    IInvoice2DAO invoice2DAO;
    
    @Autowired
    IOrders2DAO orders2DAO;
    
    @Override
    public Invoice2 save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        double subTotal = Double.parseDouble(request.getParameter("subTotal"));
        int vat = Integer.parseInt(request.getParameter("vat"));
        int dCharge = Integer.parseInt(request.getParameter("dCharge"));
        double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));
        Random random = new Random();
        int orderNo = random.nextInt(100);
        LocalDate ld = LocalDate.now();
        String orderDate = ld.toString();
        Invoice2 in = new Invoice2();
        in.setSubTotal(subTotal);
        in.setVat(vat);
        in.setdCharge(dCharge);
        in.setGrandTotal(grandTotal);
        in.setOrderNo(orderNo);
        in.setOrderDate(orderDate);

        return invoice2DAO.save(in);
    }

    @Override
    public Invoice2 update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Invoice2 t = new Invoice2();
        t.setId(Integer.parseInt(map.get("id")[0]));
//         t.setName(map.get("name")[0]);
        return invoice2DAO.update(t);
    }

    @Override
    public Invoice2 delete(int id) {
        return invoice2DAO.delete(id);
    }

    @Override
    public List<Invoice2> getAll() {
        return invoice2DAO.getAll();
    }

    @Override
    public Invoice2 getById(int id) {
        return invoice2DAO.getById(id);
    }

   

}
