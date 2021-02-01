
package com.eview.controller;

import com.eview.controller.impl.IProfileController;
import com.eview.dao.impl.IProfileDAO;
import com.eview.model.Profile;
import com.eview.service.impl.IProfileService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "profile")
public class ProfileController implements IProfileController{
    
    @Autowired
    IProfileDAO profileDAO;
    
    @Autowired
    ServletContext servletContext;
    
    @Autowired
    IProfileService profileService;
    
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public ModelAndView save1(HttpServletRequest request, @RequestParam("profilePicture") MultipartFile file) throws IOException {
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String designation = request.getParameter("designation");
        String language = request.getParameter("language");
        String education = request.getParameter("education");
        String skills = request.getParameter("skills");
        String hourlyRate = request.getParameter("hourlyRate");
        String employmentHistory = request.getParameter("employmentHistory");
        String availability = request.getParameter("availability");
        String userType = request.getParameter("userType");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String country = request.getParameter("country");

        if (!file.isEmpty()) {
            String profilepicture = file.getOriginalFilename();
            saveFile(file, profilepicture, "/resources/profile/create");

            Profile pr = new Profile();
            pr.setFullName(fullName);
            pr.setAddress(address);
            pr.setAvailability(availability);
            pr.setCountry(country);
            pr.setDesignation(designation);
            pr.setEducation(education);
            pr.setEmploymentHistory(employmentHistory);
            pr.setLanguage(language);
            pr.setSkills(skills);
            pr.setFirstName(firstName);
            pr.setLastName(lastName);
            pr.setUserName(userName);
            pr.setUserType(userType);
            pr.setHourlyRate(hourlyRate);
            String profilePicture = file.getOriginalFilename();
            pr.setProfilePicture(profilePicture);
            profileDAO.save(pr);
        }
        return new ModelAndView("redirect:/profile/create");
    }

    private void saveFile(MultipartFile file, String fileName, String path) throws IOException {
        System.out.println("Start");
        byte[] bytes = file.getBytes();
        String filePath = servletContext.getRealPath(path);
        File directory = new File(filePath);
        File cFile = new File(
                "C:\\Users\\Mr. Ahsun Habib\\Desktop\\SpringProject\\src\\main\\webapp\\resources\\freelancer\\profile"
                + File.separator + fileName);

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(cFile));
        stream.write(bytes);
        stream.close();
        System.out.println(cFile);
    }

    @RequestMapping(value = "/updateView")
    public ModelAndView updateView() {
        return new ModelAndView("profile/update");
    }

    @Override
    @RequestMapping(value = "/create")
    public ModelAndView create() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        List<Category> cList = categoryService.getAll();
//        map.put("cList", cList);
        return new ModelAndView("profile/create"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request) {
        Profile m = profileService.save(request);
        Map<String, Object> map = new HashMap<>();
        map.put("m", m);
        return new ModelAndView("/profile/create", "map", map); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView edit(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView update(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelAndView delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Profile> pList = profileService.getAll();
        map.put("pList", pList);
        return new ModelAndView("profile/view", "map", map);
    }

}
