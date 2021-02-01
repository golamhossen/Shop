package com.eview.service;

import com.eview.dao.impl.IProductionDAO;
import com.eview.dao.impl.ISalesDAO;
import com.eview.model.Checkout;
import com.eview.model.Production;
import com.eview.model.Sales;
import com.eview.service.impl.ICheckoutService;
import com.eview.service.impl.ISalesService;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "salesService")
public class SalesService implements ISalesService {

    @Autowired
    ISalesDAO salesDAO;
    @Autowired
    IProductionDAO productionDAO;

    @Autowired
    ICheckoutService checkoutService;

    @Override
    public Sales save(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        String[] kid = map.get("kid[]");
        String[] pId = (String[]) map.get("pid[]");
        String[] pName = (String[]) map.get("pName[]");
        String[] pCode = (String[]) map.get("pCode[]");
        String[] photo = (String[]) map.get("photo[]");
        String[] pPrice = (String[]) map.get("pPrice[]");
        String[] discount = (String[]) map.get("discount[]");
        String[] qty = (String[]) map.get("qty[]");
        String[] total = (String[]) map.get("total[]");
        String[] cId = (String[]) map.get("cid[]");
        String[] orderNo = (String[]) map.get("orderNo[]");
        int cid = Integer.parseInt(request.getParameter("cid"));

        Checkout check = checkoutService.getById(cid);

        Sales t = new Sales();

        for (int i = 0; i < kid.length; i++) {
            t.setPid(Integer.parseInt(pId[i]));
            t.setpName(pName[i]);
            t.setpCode(pCode[i]);
            t.setPhoto(photo[i]);
            t.setpPrice(Double.parseDouble(pPrice[i]));
            t.setDiscount(Integer.parseInt(discount[i]));
            t.setQty(Integer.parseInt(qty[i]));
            t.setTotal(Double.parseDouble(total[i]));
            t.setCid(Integer.parseInt(cId[i]));
            t.setOrderNo(Integer.parseInt(orderNo[i]));
//            t.setCustomer(check.getFirstName());

            //Reporting purpose
            LocalDate currentdate = LocalDate.now();
            //getting current day
            int days = currentdate.getDayOfMonth();
            //getting current week
            Calendar calendar = Calendar.getInstance();
            int weeks = calendar.WEEK_OF_MONTH;
            //GEtting current months
            Month currentMonth = currentdate.getMonth();
            String months = currentMonth.toString();
            //getting current years
            int years = currentdate.getYear();
            System.out.println("days   " + days + "weeks   " + weeks + months + years);
            t.setDays(days);
            t.setWeeks(weeks);
            t.setMonths(months);
            t.setYears(years);
            salesDAO.save(t);
        }
        return t;
    }

    @Override
    public Sales update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sales delete(int id) {
        return salesDAO.delete(id);
    }

    @Override
    public List<Sales> getAll() {
        return salesDAO.getAll();
    }

    @Override
    public Sales getById(int id) {
        return salesDAO.getById(id);
    }

    @Override
    public List<Sales> getByOrderNo(int orderNo) {
        return salesDAO.getByOrderNo(orderNo);
    }

    @Override
    public String deleteByOrderNo(int orderNo) {
        return salesDAO.deleteByOrderNo(orderNo);
    }

    @Override
    public double getTotalPrice() {
   List<Sales> stList = getAll();
        double total = 0.0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getTotal();
        }
        return total;
    }

    @Override
    public int getTotalQty() {
   List<Sales> stList = getAll();
        int total = 0;
        for (int i = 0; i < stList.size(); i++) {
            total += stList.get(i).getQty();
        }
        return total;
    }

}
