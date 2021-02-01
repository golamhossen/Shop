package com.eview.service;

import com.eview.dao.impl.ICheckoutDAO;
import com.eview.dao.impl.ICountryDAO;
import com.eview.model.Checkout;
import com.eview.model.Country;
import com.eview.service.impl.ICheckoutService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "checkoutService")
public class CheckoutService implements ICheckoutService {

    @Autowired
    ICheckoutDAO checkoutDAO;

    @Autowired
    ICountryDAO countryDAO;

    @Override
    public Checkout save(HttpServletRequest request) {

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
        Checkout c = new Checkout();
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

        return checkoutDAO.save(c);
    }

    @Override
    public Checkout update(HttpServletRequest request) {
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
        Checkout c = new Checkout();
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

        return checkoutDAO.update(c);
    }

    @Override
    public Checkout delete(int id) {
        return checkoutDAO.delete(id);
    }

    @Override
    public List<Checkout> getAll() {
        return checkoutDAO.getAll();
    }

    @Override
    public Checkout getById(int id) {
        return checkoutDAO.getById(id);
    }

}
