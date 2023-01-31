package de.projet.First.DTO;



import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class FormateurReqDTO {
	@NotNull
	@Size(min =3, max = 50)
	private String nom;
	@NotBlank(message = "doit avoir un nom")
	private String prenom;
	@Email
	private String mail;
	private String tel;
	@Past
	private LocalDate DOB;
}
