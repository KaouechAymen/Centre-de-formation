package de.projet.First.DTO;

import java.time.LocalDate;

import de.projet.First.Formateur;
import lombok.Data;

@Data
public class ReclamationReqDTO {
	
	private LocalDate date;
	private String description;
	private int id_formateur;
	
	

}
