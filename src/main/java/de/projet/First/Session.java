package de.projet.First;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id_session;
	
	LocalDate date_debut;
	LocalDate date_fin;

}
