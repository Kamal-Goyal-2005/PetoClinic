package com.caltech.clinic.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caltech.clinic.pogo.Owner;
import com.caltech.clinic.pogo.Pet;
import com.caltech.clinic.repo.OwnerRepository;
import com.caltech.clinic.repo.PetRepository;

@Service
public class OwnerService {

	
	Logger log=Logger.getAnonymousLogger();
	
	@Autowired
    private OwnerRepository ownerService;
	
	@Autowired
	private PetRepository petService;
	
	   public Owner addOwner(Owner owner) {
	        // Additional logic can be added before saving, e.g., validation
	        return ownerService.save(owner);
	    }

	    public Owner updateOwner(int ownerId, Owner updatedOwner) {
	        // Additional logic can be added for validation, existence check, etc.
	        Owner existingOwner = ownerService.findById(ownerId)
	                .orElseThrow(() -> new NoSuchElementException("Owner not found"));

	        existingOwner.setName(updatedOwner.getName());
	        existingOwner.setContact_no(updatedOwner.getContact_no());

	        // Update other fields as needed

	        return ownerService.save(existingOwner);
	    }

	    public void deleteOwner(int ownerId) {
	        // Additional logic can be added for validation, existence check, etc.
	        if (ownerService.existsById(ownerId)) {
	        	ownerService.deleteById(ownerId);
	        } else {
	            throw new NoSuchElementException("Owner not found");
	        }
	    }

	    public List<Pet> getPetsByOwner(int ownerId) {
	        Owner owner = ownerService.findById(ownerId)
	                .orElseThrow(() -> new NoSuchElementException("Owner not found"));

	        return owner.getPets();
	    }
	    
	    public List<Owner> getAllOwners() {
	    	log.info("getting all owners in owner service");
	    	return ownerService.findAll();
	    }

	    // Other methods for add, update, and delete owners

	    public Owner getOwnerById(int ownerId) {
	        return ownerService.findById(ownerId)
	                .orElseThrow(() -> new NoSuchElementException("Owner not found"));
	    }
}
