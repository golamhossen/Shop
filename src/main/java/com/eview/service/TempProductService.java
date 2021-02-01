
package com.eview.service;

import com.eview.dao.impl.ITempProductDAO;
import com.eview.model.TempProduct;
import com.eview.service.impl.ITempProductService;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "tempProductService")
public class TempProductService implements ITempProductService{
    @Autowired
    ITempProductDAO tempProductDAO;

    @Override
    public TempProduct save(HttpServletRequest request) {
   
      Map<String, String[]> map = request.getParameterMap();
        String[] id =  map.get("id[]");
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
//        LocalDate ld = LocalDate.now();
//        String orderDate = ld.toString();
        

        System.out.println("........................" + id);
        TempProduct t = new TempProduct();

        for (int i = 0; i < id.length; i++) {
            System.out.println("........................" + id);
            t.setPid(Integer.parseInt(pid[i]));
            t.setPhoto(photo[i]);
            t.setpName(pName[i]);
            t.setpCode(pCode[i]);
            t.setpPrice(Double.parseDouble(pPrice[i]));
            t.setQty(Integer.parseInt(qty[i]));
            t.setDiscount(Integer.parseInt(discount[i]));
            t.setTotal(Double.parseDouble(total[i]));
            t.setCid(cid);
             tempProductDAO.save(t);
        }
        return t;
    }

    @Override
    public TempProduct update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TempProduct delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TempProduct> getAll() {
   return tempProductDAO.getAll();
    }

    @Override
    public TempProduct getById(int id) {
  return tempProductDAO.getById(id);
    }

    @Override
    public String deleteByCid(int cid) {   
    return tempProductDAO.deleteByCid(cid);
    }

    @Override
    public List<TempProduct> getByCid(int cid) {
   return tempProductDAO.getByCid(cid);
    }

   
    }
    
    

