package ssii.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String role;

    @NonNull
    private Float pourcentage;

    @ManyToOne
    @JoinColumn(name = "matricule")
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "code")
    private Projet projet;
}