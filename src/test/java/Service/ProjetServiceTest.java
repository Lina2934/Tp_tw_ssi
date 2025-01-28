package Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.entity.Personne;
import ssii.entity.Projet;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ProjetServiceTest {

    @Autowired
    private ssii.service.ProjetService projetService;

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @BeforeEach
    public void setUp() {
        Personne personne = new Personne();
        personne.setNom("Dupont");
        personneRepository.save(personne);

        Projet projet = new Projet();
        projet.setNom("Projet A");
        projet.setDebut(LocalDate.now());
        projetRepository.save(projet);
    }

    @Test
    public void testParticipation() {
        projetService.participerAuProjet(1, 1, "Développeur", 50.0f);
        assertNotNull(projetService);
    }

    @Test
    public void testParticipationMultiple() {
        projetService.participerAuProjet(1, 1, "Développeur", 50.0f);
        assertThrows(IllegalStateException.class, () -> {
            projetService.participerAuProjet(1, 1, "Développeur", 50.0f);
        });
    }
}
