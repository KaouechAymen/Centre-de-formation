package de.projet.First.DTO;

import de.projet.First.Formateur;
import lombok.Data;

@Data
public class ReclamationResDTO {
	
	private int id;
	private String description;
	private Formateur formateur;

}
