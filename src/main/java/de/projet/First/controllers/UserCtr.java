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
import org.springframework.web.bind.annotation.RestController;

import de.projet.First.DTO.UserDTO;
import de.projet.First.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserCtr {
	private UserService userService;
	
	@PostMapping("/api/user")
	public UserDTO saveDTO(@RequestBody UserDTO dto) {
		return userService.saveUserInDB(dto);
		
	}
	
	@GetMapping("/api/user")
	public List<UserDTO> getAllDTO() {
		return userService.getAllUser();
		}
	
	
	
	  @GetMapping("/api/user/{id}") 
	  public UserDTO getuserbyid(@PathVariable("id") int id){
		  return userService.getUserById(id);
		  }
	  
	  @PutMapping("/api/user/update/{id}")
	  public UserDTO Updateuserbyid(@PathVariable("id") int id, @RequestBody UserDTO newUser){
		  return userService.UpdateUserById(id , newUser);
		  }
	  
	  @DeleteMapping("/api/user/delete/{id}")
	  public UserDTO deleteuserbyid(@PathVariable("id") int id){
		  return userService.deleteUserById(id);
		  }
	  
	  
	  @ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		  return ResponseEntity.status(HttpStatus.NOT_FOUND)
				  .body("Error in search : "+e.getMessage());
	  }
	 



}
   
