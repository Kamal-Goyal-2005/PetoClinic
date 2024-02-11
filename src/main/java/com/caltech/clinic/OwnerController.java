package com.caltech.clinic;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.caltech.clinic.pogo.Owner;
import com.caltech.clinic.service.OwnerService;

@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    
	Logger log=Logger.getAnonymousLogger();

    @GetMapping("/listOwners")
    public ModelAndView listOwners(HttpServletRequest request
    		,HttpServletResponse response) {
        
        ModelAndView modelAndView = new ModelAndView();
        List<Owner> owners = ownerService.getAllOwners();
        log.info("getting all owners in owner controller");
        modelAndView.addObject("ownersList", owners);
        modelAndView.setViewName("owners/listOwner.jsp");
        return modelAndView;
    }

    @GetMapping("/getOwner")
    public ModelAndView showAddOwnerForm() {
        ModelAndView modelAndView = new ModelAndView("owner/add");
        modelAndView.addObject("owner", new Owner());
        return modelAndView;
    }

    @PostMapping("/addOwner")
    public ModelAndView addOwner(@RequestParam("name") String name,
    		@RequestParam("contact_no") String contact,HttpServletRequest request
    		,HttpServletResponse response) {
    	log.info("Within add Owner");
    	ModelAndView mv = new ModelAndView();
    	Owner owner = new Owner();
    	owner.setName(name);
    	owner.setContact_no(contact);
    	ownerService.addOwner(owner);
    	log.info("redirecting to main page");
    	mv.setViewName("/main.jsp");
		return mv;
    }

    @GetMapping("/showEditOwner/{id}")
    public ModelAndView showEditOwnerForm(@PathVariable int id) {
        Owner owner = ownerService.getOwnerById(id);
        ModelAndView modelAndView = new ModelAndView("owner/edit");
        modelAndView.addObject("owner", owner);
        return modelAndView;
    }

    @PostMapping("/editOwner/{id}")
    public ModelAndView editOwner(@PathVariable int id, @ModelAttribute("owner") Owner updatedOwner) {
        ownerService.updateOwner(id, updatedOwner);
        return new ModelAndView("redirect:/owners/list");
    }

    @GetMapping("/deleteOwner/{id}")
    public ModelAndView deleteOwner(@PathVariable int id) {
    	ModelAndView mv = new ModelAndView();
    	ownerService.deleteOwner(id);
        mv.setViewName("listOwner.jsp");
		return mv;
        

    }
}
