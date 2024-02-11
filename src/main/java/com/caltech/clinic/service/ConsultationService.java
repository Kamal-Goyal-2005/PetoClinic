package com.caltech.clinic.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.clinic.pogo.Consultation;
import com.caltech.clinic.pogo.Pet;
import com.caltech.clinic.repo.ConsultationRepository;
import com.caltech.clinic.repo.PetRepository;

@Service
public class ConsultationService {

	@Autowired
    private ConsultationRepository consultationService;

    @Autowired
    private PetRepository petService;

    public Consultation addConsultation(Consultation consultation) {

        return consultationService.save(consultation);
    }

    public Consultation updateConsultation(int consultationId, Consultation updatedConsultation) {

        Consultation existingConsultation = consultationService.findById(consultationId)
                .orElseThrow(() -> new NoSuchElementException("Consultation not found"));

        existingConsultation.setDate(updatedConsultation.getDate());
        existingConsultation.setDiagnosis(updatedConsultation.getDiagnosis());
        existingConsultation.setFee(updatedConsultation.getFee());



        return consultationService.save(existingConsultation);
    }

    public void deleteConsultation(int consultationId) {
        if (consultationService.existsById(consultationId)) {
        	consultationService.deleteById(consultationId);
        } else {
            throw new NoSuchElementException("Consultation not found");
        }
    }

    public List<Consultation> getConsultationsByPet(int petId) {
        Pet pet = petService.findById(petId)
                .orElseThrow(() -> new NoSuchElementException("Pet not found"));

        return pet.getConsultations();
    }
    
    public List<Consultation> getAllConsultations() {
        return consultationService.findAll();
    }

    public Consultation getConsultationById(int consultationId) {
        return consultationService.findById(consultationId)
                .orElseThrow(() -> new NoSuchElementException("Consultation not found"));
    }
}
