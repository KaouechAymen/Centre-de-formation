  package de.projet.First;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(callSuper = true)
public class Formateur extends User {
	

	private LocalDate DOB=LocalDate.MIN;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "formateurs")
	private List<Formation> formations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "formateur")
	private List<Reclamation> reclamations;
	
	
	
	
	public String getNomcomplet() {
		return getNom()+ " " + getPrenom();
	}
	public int getAge() {
		return (int)ChronoUnit.YEARS.between(DOB, LocalDate.now());
		
	}
	/*
	 * @Override public String toString() { return "Formateur [DOB=" + DOB +
	 * ", formations=" + formations + ", reclamations=" + reclamations +
	 * ", toString()=" + super.toString() + "]"; }
	 */

}
