package de.projet.First.services;

import java.util.List;
import java.util.NoSuchElementException;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.projet.First.Formateur;
import de.projet.First.Formation;
import de.projet.First.User;
import de.projet.First.DTO.FormationReqDTO;
import de.projet.First.DTO.FormationResDTO;
import de.projet.First.DTO.UserDTO;
import de.projet.First.repositories.FormateurRepos;
import de.projet.First.repositories.FormationRepos;
import de.projet.First.repositories.UserRepository;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class FormationService {
	private FormationRepos formationrepos;
	
	private UserService US;

	
	private ModelMapper mapper;
	
	public FormationResDTO saveToDB(FormationReqDTO formationReqDTO) {
		UserDTO formateur= US.getUserById(formationReqDTO.getId_formateur());
		Formateur formateurE=mapper.map(formateur, Formateur.class);
		System.out.println("1"+formateur);
		Formation formation = mapper.map(formationReqDTO, Formation.class);
		System.out.println("2"+formation);
		System.out.println("3"+formation.getFormateurs());
		formation.getFormateurs().add(formateurE);
		System.out.println("4"+formation.getFormateurs());
		System.out.println("4 / nom"+formation.getFormateurs().get(0).getNom());
		formationrepos.save(formation);
		FormationResDTO dtos=mapper.map(formation, FormationResDTO.class);
		return dtos;
		
	}

	public List<FormationResDTO> getAllFormation() {
		
			return formationrepos.findAll().stream().map((Formation ent)->{
				FormationResDTO dtos=mapper.map(ent, FormationResDTO.class);
				return dtos;
			}).collect(Collectors.toList());
					
		}

	public FormationResDTO getbyId(int id) {
		java.util.Optional<Formation>formation=formationrepos.findById(id);
		
		formation.orElseThrow(()->new NoSuchElementException("n'existe pas"));
		System.out.println(formation.get());
		FormationResDTO dtos = mapper.map(formation.get(), FormationResDTO.class);
		return dtos;
		
	}

	/*
	 * public FormationResDTO updateFormation(int id, FormationReqDTO newformation)
	 * { FormationResDTO formation= getbyId(id); System.out.println("1"+
	 * formation.toString()); Formation form= mapper.map(formation,
	 * Formation.class);
	 * 
	 * System.out.println("2"+ form.toString()); if(newformation.getType()!=null)
	 * form.setType(newformation.getType());
	 * if(newformation.getNb_session()!=form.getNb_session())
	 * form.setNb_session(newformation.getNb_session());
	 * if(newformation.getVolume_horaire()!=form.getNb_session())
	 * form.setVolume_horaire(newformation.getVolume_horaire());
	 * form=formationrepos.save(form); FormationResDTO dtos=mapper.map(form,
	 * FormationResDTO.class);
	 * 
	 * return dtos; }
	 */
	
	
	
	public FormationResDTO updateFormation(int id, FormationReqDTO newformation) {
		FormationResDTO formation= getbyId(id);
		System.out.println("1"+ formation.toString());
		Formation form= mapper.map(formation, Formation.class);

		System.out.println("2"+ form.toString());
		if(newformation.getType()!=null)
		form.setType(newformation.getType());
		if(newformation.getNb_session()!=form.getNb_session())
		form.setNb_session(newformation.getNb_session());
		if(newformation.getVolume_horaire()!=form.getNb_session())
		form.setVolume_horaire(newformation.getVolume_horaire());

		List<Formateur> formateurs= form.getFormateurs();

		for(int i=0; i<formateurs.size();i++) {
		if(formateurs.get(1).getId()!=newformation.getId_formateur()) {
		UserDTO formateur= US.getUserById(newformation.getId_formateur());
		Formateur formateurE=mapper.map(formateur, Formateur.class);
		form.getFormateurs().add(formateurE);
		}
		}




		form=formationrepos.save(form);
		FormationResDTO dtos=mapper.map(form, FormationResDTO.class);

		return dtos;
		}
	
	
	
	
	
	
	public FormationResDTO DeleteFormation(int id) {
		FormationResDTO formation=getbyId(id);
		System.out.println(formation);
		Formation form=mapper.map(formation, Formation.class);
		formationrepos.delete(form);
		
		return formation;
	}
	
	}

	
	


