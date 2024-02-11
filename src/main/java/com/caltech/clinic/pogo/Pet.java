package com.caltech.clinic.pogo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xxpets")
public class Pet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String species;
	
	@ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
	
	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Consultation> consultations = new ArrayList<>();
	
    public List<Consultation> getConsultations() {
        return consultations;
    }
	
}
