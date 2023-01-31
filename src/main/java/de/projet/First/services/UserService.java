package de.projet.First.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.projet.First.Administrateur;
import de.projet.First.Candidat;
import de.projet.First.Formateur;
import de.projet.First.User;
import de.projet.First.DTO.UserDTO;
import de.projet.First.repositories.UserRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService {
	
	private UserRepository userRepos;
	private ModelMapper mapper;
	
	
	public UserDTO saveUserInDB(UserDTO dto) {
		 System.out.println(dto);
			 
		User user = null;
		switch (dto.getType()) {
		case "Administrateur":
			user = mapper.map(dto, Administrateur.class);
			break;
		case "Formateur":
			user = mapper.map(dto, Formateur.class);
			user.setMail(dto.getMail());
			System.out.println(user);
			break;
		case "Candidat":
			user = mapper.map(dto, Candidat.class);
			break;
		
		
		}
		user = userRepos.save(user);
		dto.setId(user.getId());
		return dto;
		
		
	}
	
	public List<UserDTO> getAllUser(){
		/*
		 * List<User> entities = userRepos.findAll();
		 *  List<UserDTO> dtos = newArrayList<>(); 
		 * for (User user : entities) { 
		 * UserDTO dto = mapper.map(user,UserDTO.class); 
		 * 
		 * //if(user instanceof Formateur) 
		 * //dto.setType("Formateur");
		 * 
		 * dto.setType(user.getClass().getSimpleName());// pour remplir le champ type
		 * car il n'existe pas dans la base
		 * dtos.add(dto);
		 * }
		 * return dtos;
		 */
		
		return userRepos.findAll().stream().map((User ent) -> {
			UserDTO dto = mapper.map(ent, UserDTO.class);
			dto.setType(ent.getClass().getSimpleName());
			return dto;
		}).collect(Collectors.toList());
		
		
	}
	
	
	  public UserDTO getUserById(int id){
		  Optional<User> user =userRepos.findById(id); 
		  user.orElseThrow(()->new NoSuchElementException("n'existe pas"));
		  System.out.println(user.get());
		  UserDTO dto = mapper.map(user.get(), UserDTO.class);
			 dto.setType(user.get().getClass().getSimpleName());
			 return dto;
	 
	 
	  }

	  public UserDTO UpdateUserById(int id, UserDTO newUser) {
		UserDTO dto= getUserById(id);
		System.out.println(dto);
		
		User user = null;
		switch (dto.getType()) {
		case "Administrateur":
			user = mapper.map(dto, Administrateur.class);
			break;
		case "Formateur":
			 user = mapper.map(dto, Formateur.class);
			break;
		case "Candidat":
			user = mapper.map(dto, Candidat.class);
			break;
		
		
		}
		 
		
		
		if(newUser.getNom()!=null)
			user.setNom(newUser.getNom());
		if(newUser.getPrenom()!=null)
			user.setPrenom(newUser.getPrenom());
		if(newUser.getMail()!=null)
			user.setMail(newUser.getMail());
		if(newUser.getTel()!=null)
			user.setTel(newUser.getTel());
		
		userRepos.save(user);
		UserDTO dtos = mapper.map(user, UserDTO.class);
		
			dtos.setType(newUser.getType());
		
		return dtos;
	}

	  
	  
	  
	  
	  
	 public UserDTO deleteUserById(int id) {
		
		 UserDTO user1 = getUserById(id);
		 
		 User user = null;
			switch (user1.getType()) {
			case "Administrateur":
				user = mapper.map(user1, Administrateur.class);
				break;
			case "Formateur":
				 user = mapper.map(user1, Formateur.class);
				break;
			case "Candidat":
				user = mapper.map(user1, Candidat.class);
				break;
			
			
			}
		 
		 userRepos.delete(user);
		
		 return user1;
	 }
	  
	  
	  
		  
	  

	
	 
	
	

	
	
	
	
	  
	  
	  
	  }
	 


