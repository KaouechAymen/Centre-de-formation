package de.projet.First.DTO;

import java.util.List;

import de.projet.First.Formateur;
import lombok.Data;

@Data
public class FormationResDTO {
	
	private int id;
	private String type;
	private List<Formateur> formateurs;

}
