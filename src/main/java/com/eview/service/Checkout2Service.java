package com.eview.service;

import com.eview.dao.impl.ICheckout2DAO;
import com.eview.dao.impl.ICountryDAO;
import com.eview.model.Checkout2;
import com.eview.model.Country;
import com.eview.service.impl.ICheckout2Service;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "checkout2Service")
public class Checkout2Service implements ICheckout2Service {

    @Autowired
    ICheckout2DAO checkout2DAO;

    @Autowired
    ICountryDAO countryDAO;

    @Override
    public Checkout2 save(HttpServletRequest request) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("cid"));
        String town = request.getParameter("town");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        Country co = countryDAO.getById(id);
        Checkout2 c = new Checkout2();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setMobile(mobile);
        c.setAddress(address);
        c.setCid(co.getId());
        c.setCname(co.getName());
        c.setTown(town);
        c.setState(state);
        c.setZip(zip);

        return checkout2DAO.save(c);
    }

    @Override
    public Checkout2 update(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        int id = Integer.parseInt(request.getParameter("cid"));
        String town = request.getParameter("town");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");

        Country co = countryDAO.getById(id);
        Checkout2 c = new Checkout2();
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setMobile(mobile);
        c.setAddress(address);
        c.setCid(co.getId());
        c.setCname(co.getName());
        c.setTown(town);
        c.setState(state);
        c.setZip(zip);

        return checkout2DAO.update(c);
    }

    @Override
    public Checkout2 delete(int id) {
        return checkout2DAO.delete(id);
    }

    @Override
    public List<Checkout2> getAll() {
        return checkout2DAO.getAll();
    }

    @Override
    public Checkout2 getById(int id) {
        return checkout2DAO.getById(id);
    }

}
