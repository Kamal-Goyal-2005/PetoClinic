package com.caltech.clinic.pogo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xxusers")
public class User {
    @Id
    private String name;
    private String phone;
    private String pwd;
}
