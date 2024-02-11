package com.caltech.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caltech.clinic.pogo.Owner;

public interface OwnerRepository extends JpaRepository<Owner,Integer>{

}
