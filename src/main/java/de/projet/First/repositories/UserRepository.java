package de.projet.First.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.projet.First.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
