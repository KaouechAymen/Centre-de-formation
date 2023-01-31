package de.projet.First.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.projet.First.DTO.FormationReqDTO;
import de.projet.First.DTO.FormationResDTO;
import de.projet.First.services.FormationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class FormationCrtl {
	private FormationService formationservice;
	
	
	@PostMapping("/api/Formation")
	public FormationResDTO saveFormation(@RequestBody FormationReqDTO formationReqDTO) {
		
		return formationservice.saveToDB(formationReqDTO);
	}
	
	 
	@GetMapping("/api/Formation")
	public List<FormationResDTO> GetALLFormation() {
		return formationservice.getAllFormation();
	}
	
	@GetMapping("/api/Formation/{id}")
	public FormationResDTO getFormationByID(@PathVariable("id") int id) {
		return formationservice.getbyId(id);
	}
	
	
	@PutMapping("/api/Formation/update/{id}")
	public FormationResDTO UpdateFormation(@PathVariable("id") int id,@RequestBody FormationReqDTO newformation) {
		
		
		return formationservice.updateFormation(id,newformation);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		  return ResponseEntity.status(HttpStatus.NOT_FOUND)
				  .body("Error in search : "+e.getMessage());

}
}
