package de.projet.First;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Motif {
	@Id
	private int id;
	private String Designation;

}
