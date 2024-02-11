package com.caltech.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caltech.clinic.pogo.Pet;

public interface PetRepository extends JpaRepository<Pet,Integer>{

}
