package tn.esprit.project1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @JsonIgnore

    @OneToMany(mappedBy = "agence")
    private List<Employe> employes = new ArrayList<>();

    @JsonIgnore

    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules = new ArrayList<>();

    public void setTelephon(String telephon) {
    }
}
