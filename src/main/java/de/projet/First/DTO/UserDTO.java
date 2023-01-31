package de.projet.First.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String nom;
	private String prenom;
	private LocalDate DOB;
	private String mail;
	private String tel;
	private String type;
	
	

}
