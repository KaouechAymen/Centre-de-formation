package de.projet.First.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.projet.First.DTO.ReclamationReqDTO;
import de.projet.First.DTO.ReclamationResDTO;
import de.projet.First.services.ReclamationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReclamationCtr {
	private ReclamationService reclamationservice;
	
	@PostMapping("/api/reclamation")
	public ReclamationResDTO addReclamation(@RequestBody ReclamationReqDTO reclamationreqdto) {
		return reclamationservice.saveToDB(reclamationreqdto);
	}
	
	@GetMapping("/api/reclamation/{id}")
	public ReclamationResDTO getByID(@PathVariable("id") int id) {
		return reclamationservice.getById(id);
	}
	@GetMapping("/api/reclamation")
	public List<ReclamationResDTO> GetAll() {
		return reclamationservice.getAll();
	}
	@PutMapping("/api/reclamation/update/{id}")
	public ReclamationResDTO UpdateReclamation(@PathVariable("id") int id, @RequestBody ReclamationReqDTO newReclamation) {
		return reclamationservice.updateReclamation(id, newReclamation);
	}
	@DeleteMapping("/api/reclamation/delete/{id}")
	public ReclamationResDTO DeleteReclamation(@PathVariable("id") int id) {
		return reclamationservice.DeleteReclamation(id);
	}
	@ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		  return ResponseEntity.status(HttpStatus.NOT_FOUND)
				  .body("Error in search : "+e.getMessage());
	  }
	
	

}
