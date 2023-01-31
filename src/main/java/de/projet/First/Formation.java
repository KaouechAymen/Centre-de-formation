package de.projet.First;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.ToString;


@Entity
@Data
@ToString(exclude = "formateurs")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String type;
	private int nb_session;
	private int volume_horaire;
	
	@ManyToMany
	private List<Formateur> formateurs=new ArrayList<>();
	
	

	

}
