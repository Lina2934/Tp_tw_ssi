package ssii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssii.dao.ParticipationRepository;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.entity.Participation;
import ssii.entity.Personne;
import ssii.entity.Projet;

import java.util.List;

@Service
public class ProjetService {

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Transactional
    public void participerAuProjet(Integer matricule, Integer codeProjet, String role, Float pourcentage) {
        Personne personne = personneRepository.findById(matricule).orElseThrow();
        Projet projet = projetRepository.findById(codeProjet).orElseThrow();

        if (participationRepository.existsByPersonneAndProjet(personne, projet)) {
            throw new IllegalStateException("La personne participe déjà à ce projet.");
        }

        Float totalPourcentage = participationRepository.findByPersonne(personne).stream()
                .map(Participation::getPourcentage)
                .reduce(0.0f, Float::sum);
        if (totalPourcentage + pourcentage > 100.0f) {
            throw new IllegalStateException("La personne est déjà occupée à plus de 100%.");
        }

        if (participationRepository.countByPersonne(personne) >= 3) {
            throw new IllegalStateException("La personne participe déjà à trois projets.");
        }

        Participation participation = new Participation();
        participation.setPersonne(personne);
        participation.setProjet(projet);
        participation.setRole(role);
        participation.setPourcentage(pourcentage);

        participationRepository.save(participation);
    }
}