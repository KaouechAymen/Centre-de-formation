package de.projet.First.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.projet.First.Reclamation;


public interface ReclamationRepos extends JpaRepository<Reclamation, Integer> {

}
