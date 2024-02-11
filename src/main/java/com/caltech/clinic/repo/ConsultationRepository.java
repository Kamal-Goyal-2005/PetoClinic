package com.caltech.clinic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caltech.clinic.pogo.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation,Integer>{

}
