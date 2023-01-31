package de.projet.First.DTO;


import lombok.Data;

@Data

public class FormationReqDTO {
	
	private String type;
	private int nb_session;
	private int volume_horaire;
	private int id_formateur;

}
