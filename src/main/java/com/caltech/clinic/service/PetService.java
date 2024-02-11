package com.caltech.clinic.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.clinic.pogo.Owner;
import com.caltech.clinic.pogo.Pet;
import com.caltech.clinic.repo.OwnerRepository;
import com.caltech.clinic.repo.PetRepository;



@Service
public class PetService {
	
	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
	private PetRepository petService;
	
	@Autowired
    private OwnerRepository ownerService;

	public Pet addPet(Pet pet) {
        return petService.save(pet);
    }
	
	
    public Pet updatePet(int petId, Pet updatedPet) {

    	Pet existingPet = petService.findById(petId)
                .orElseThrow(() -> new NoSuchElementException("Pet not found"));

       
        existingPet.setName(updatedPet.getName());
        
        // Update other fields as needed

        // If the owner is also being updated, you can set the new owner
        if (updatedPet.getOwner() != null) {
            Owner newOwner = updatedPet.getOwner();
            existingPet.setOwner(newOwner);
        }


        return petService.save(existingPet);
    }

    public void deletePet(int petId) {
        // Additional logic can be added for validation, existence check, etc.
        if (petService.existsById(petId)) {
        	petService.deleteById(petId);
        } else {
            throw new NoSuchElementException("Pet not found");
        }
    }

    public Pet updatePetOwner(int petId, int ownerId) {
        Pet existingPet = petService.findById(petId)
                .orElseThrow();

        Owner newOwner = ownerService.findById(ownerId)
                .orElseThrow(() -> new NoSuchElementException("Owner not found"));

        existingPet.setOwner(newOwner);

        return petService.save(existingPet);
    }
    
    public List<Pet> getAllPets() {
        return petService.findAll();
    }

    public Pet getPetById(int petId) {
        return petService.findById(petId)
                .orElseThrow(() -> new NoSuchElementException("Pet not found"));
    }
}
