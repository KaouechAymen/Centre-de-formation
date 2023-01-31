package de.projet.First.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.projet.First.DTO.FormateurReqDTO;
import de.projet.First.DTO.FormateurResDTO;
import de.projet.First.services.FormateurService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FormateurCtrl {
	/*
	 * private FormateurService formateurservice;
	 * 
	 * @PostMapping("/api/Formateur") public FormateurResDTO
	 * addFormateur(@Valid @RequestBody FormateurReqDTO formateurReqDTO) { return
	 * formateurservice.saveToDB(formateurReqDTO); }
	 */
}
