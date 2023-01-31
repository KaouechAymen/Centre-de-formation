package de.projet.First.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.projet.First.Candidat;

public interface CandidatRepos extends JpaRepository<Candidat, Integer>{

}
