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
import com.caltech.clinic.pogo.Pet;
import com.caltech.clinic.service.OwnerService;
import com.caltech.clinic.service.PetService;

@Controller
public class PetController {
    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;
    
    Logger log=Logger.getAnonymousLogger();

    @GetMapping("/listPets")
    public ModelAndView listPets(HttpServletRequest request, HttpServletResponse response) {
        List<Pet> pets = petService.getAllPets();
        ModelAndView modelAndView = new ModelAndView();
        List<Owner> owners = ownerService.getAllOwners();
        modelAndView.addObject("ownersList", owners);
        modelAndView.addObject("pets", pets);
        modelAndView.setViewName("pets/listPets.jsp");
        return modelAndView;
    }
    
    @GetMapping("/addPet")
    public ModelAndView addPet(HttpServletRequest request, HttpServletResponse response) {
    	log.info("inside addPet");
    	ModelAndView modelAndView = new ModelAndView();
    	List<Owner> owners = ownerService.getAllOwners();
    	modelAndView.addObject("ownersList", owners);
    	modelAndView.setViewName("pets/addPet.jsp");
        return modelAndView;
    }    

    @PostMapping("/addOnePet")
    public ModelAndView showAddPetForm(@RequestParam("name") String name,
    		@RequestParam("species") String species,
    		@RequestParam("ownerid") int ownerid,
    		HttpServletRequest request, HttpServletResponse response) {

        Pet pet = new Pet();
        Owner owner = ownerService.getOwnerById(ownerid);
        pet.setName(name);
        pet.setOwner(owner);
        pet.setSpecies(species);
    	ModelAndView mv = new ModelAndView();
    	petService.addPet(pet);
    	mv.setViewName("/main.jsp");
		return mv;
    }



    @GetMapping("/showEditPet/{id}")
    public ModelAndView showEditPetForm(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        Pet pet = petService.getPetById(id);
        List<Owner> owners = ownerService.getAllOwners();
        ModelAndView modelAndView = new ModelAndView("pet/edit");
        modelAndView.addObject("pet", pet);
        modelAndView.addObject("owners", owners);
        return modelAndView;
    }

    @PostMapping("/editPet/{id}")
    public ModelAndView editPet(@PathVariable int id, @ModelAttribute("pet") Pet updatedPet, HttpServletRequest request, HttpServletResponse response) {
        petService.updatePet(id, updatedPet);
        return new ModelAndView("redirect:/pets/list");
    }

    @GetMapping("/deletePet/{id}")
    public ModelAndView deletePet(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        petService.deletePet(id);
        return new ModelAndView("redirect:/pets/list");
    }
}
