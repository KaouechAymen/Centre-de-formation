package de.projet.First.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.projet.First.Formateur;
import de.projet.First.Reclamation;
import de.projet.First.DTO.ReclamationReqDTO;
import de.projet.First.DTO.ReclamationResDTO;
import de.projet.First.DTO.UserDTO;
import de.projet.First.repositories.ReclamationRepos;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReclamationService {
	private ReclamationRepos reclamationrepos;
	private UserService US;
	
	private ModelMapper mapper;

	public ReclamationResDTO saveToDB(ReclamationReqDTO reclamationreqdto) {
		UserDTO formateur=US.getUserById(reclamationreqdto.getId_formateur());
		Formateur formateur1=mapper.map(formateur, Formateur.class);
		Reclamation reclamation=mapper.map(reclamationreqdto, Reclamation.class);
		reclamation.setFormateur(formateur1);
		reclamationrepos.save(reclamation);
		ReclamationResDTO reclamation1 = mapper.map(reclamation, ReclamationResDTO.class);
		return reclamation1;
		
		
	}
	
	public ReclamationResDTO getById(int id ) {
		
		Optional<Reclamation> reclamation = reclamationrepos.findById(id);
		reclamation.orElseThrow(()-> new NoSuchElementException("n'existe pas"));
		System.out.println(reclamation.get());
		ReclamationResDTO dtos = mapper.map(reclamation.get(), ReclamationResDTO.class);
		return dtos;
	}
	
	
	
	
	
	
	
	
	public ReclamationResDTO updateReclamation(int id , ReclamationReqDTO newReclamation) {
		ReclamationResDTO reclamation=getById(id );
		System.out.println("1"+ reclamation.toString());
		Reclamation reclamation1=mapper.map(reclamation, Reclamation.class);
		if(newReclamation.getDescription()!=null)
			reclamation1.setDescription(newReclamation.getDescription());
		if(newReclamation.getDate()!=null)
			reclamation1.setDate(newReclamation.getDate());
		
		System.out.println("2"+ reclamation1.toString());
		reclamation1=reclamationrepos.save(reclamation1);
		
		ReclamationResDTO dtos=mapper.map(reclamation1, ReclamationResDTO.class);
		
			
		return dtos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ReclamationResDTO DeleteReclamation(int id) {
		
		ReclamationResDTO reclamation= getById(id);
		Reclamation Reclamation=mapper.map(reclamation, Reclamation.class);
		reclamationrepos.delete(Reclamation);
		ReclamationResDTO dtos=mapper.map(Reclamation, ReclamationResDTO.class);
		return dtos;
	}
	
	
	
	
	public List<ReclamationResDTO> getAll() {
		return reclamationrepos.findAll().stream().map((Reclamation ent)->{
			ReclamationResDTO dtos=mapper.map(ent, ReclamationResDTO.class);
			return dtos;
		}).collect(Collectors.toList());
		
		
	}

}
