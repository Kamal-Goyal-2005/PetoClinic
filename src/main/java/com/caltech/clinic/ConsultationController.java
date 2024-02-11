package com.caltech.clinic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.caltech.clinic.pogo.Consultation;
import com.caltech.clinic.pogo.Pet;
import com.caltech.clinic.service.ConsultationService;
import com.caltech.clinic.service.PetService;

@Controller
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PetService petService;

    @GetMapping("/listConsultation")
    public ModelAndView listConsultations(HttpServletRequest request, HttpServletResponse response) {
        List<Consultation> consultations = consultationService.getAllConsultations();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("consultationsList", consultations);
        modelAndView.setViewName("consultation/listConsultation.jsp");
        return modelAndView;
        
      
     }

    @GetMapping("/addConsultation")
    public ModelAndView showAddConsultationForm(HttpServletRequest request, HttpServletResponse response) {
        List<Pet> pets = petService.getAllPets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("petsList", pets);
        modelAndView.setViewName("consultation/addConsultation.jsp");
        return modelAndView;
      
    }

    @PostMapping("/addOneConsultation")
    public ModelAndView addConsultation(@RequestParam("petId") int petId,
    		@RequestParam("diagnosis") String diagnosis,
    		@RequestParam("consultationDate") String consultationDateStr,
    		@RequestParam("fee") int fee,
    		HttpServletRequest request, HttpServletResponse response) {
    	
     	 Pet pet = petService.getPetById(petId);
     	 Consultation consultation = new Consultation();
     	consultation.setPet(pet);
     	consultation.setDiagnosis(diagnosis);
     	consultation.setFee(fee);
     	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     	LocalDate consultationDate = LocalDate.parse(consultationDateStr, formatter);
     	
     	consultation.setDate(consultationDate);

     	ModelAndView mv = new ModelAndView();
     	consultationService.addConsultation(consultation);
     	mv.setViewName("/main.jsp");
 		return mv;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditConsultationForm(@PathVariable int id) {
        Consultation consultation = consultationService.getConsultationById(id);
        List<Pet> pets = petService.getAllPets();
        ModelAndView modelAndView = new ModelAndView("consultation/edit");
        modelAndView.addObject("consultation", consultation);
        modelAndView.addObject("pets", pets);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editConsultation(@PathVariable int id, @ModelAttribute("consultation") Consultation updatedConsultation) {
        consultationService.updateConsultation(id, updatedConsultation);
        return new ModelAndView("redirect:/consultations/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteConsultation(@PathVariable int id) {
        consultationService.deleteConsultation(id);
        return new ModelAndView("redirect:/consultations/list");
    }
}
