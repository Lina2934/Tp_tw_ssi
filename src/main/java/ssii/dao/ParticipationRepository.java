package ssii.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ssii.entity.Participation;
import ssii.entity.Personne;
import ssii.entity.Projet;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
    boolean existsByPersonneAndProjet(Personne personne, Projet projet);
    int countByPersonne(Personne personne);
    List<Participation> findByPersonne(Personne personne); // Corrigé ici
}
