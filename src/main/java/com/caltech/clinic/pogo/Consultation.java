package com.caltech.clinic.pogo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xxconsultation")
public class Consultation {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String diagnosis;
	private LocalDate date;
	private double fee;
	
	@ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
