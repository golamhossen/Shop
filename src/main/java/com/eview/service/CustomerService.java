package com.eview.service;

import com.eview.dao.impl.ICityDAO;
import com.eview.dao.impl.ICountryDAO;
import com.eview.dao.impl.ICustomerDAO;
import com.eview.model.City;
import com.eview.model.Customer;
import com.eview.service.impl.ICustomerService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "customerService")
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerDAO customerDAO;

    @Autowired
    ICountryDAO countryDAO;

    @Autowired
    ICityDAO cityDAO;

    @Override
    public Customer save(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("cname");
        int cid = Integer.parseInt(request.getParameter("cityId"));
        String cname = request.getParameter("cityName");
        City city = cityDAO.getById(id);
        String nam = request.getParameter("name");

        String gender = request.getParameter("gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Customer t = new Customer();
        t.setCid(city.getId());
        t.setCname(city.getCname());
        t.setCityId(city.getCid());
        t.setCityName(city.getName());
        t.setName(nam);
        t.setGender(gender);
        t.setAge(age);
        t.setAddress(address);
        t.setEmail(email);
        t.setPassword(password);

        return customerDAO.save(t);
    }

    @Override
    public Customer update(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        Customer t = new Customer();
        t.setId(Integer.parseInt(map.get("id")[0]));
        t.setCname(map.get("name")[0]);
        return customerDAO.update(t);
    }

    @Override
    public Customer delete(int id) {
        return customerDAO.delete(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    public Customer getById(int id) {
        return customerDAO.getById(id);
    }

}
