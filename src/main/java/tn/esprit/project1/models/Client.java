package tn.esprit.project1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;
    private String telephone;

    @Column(unique = true)
    private String numPermis;
    private LocalDate dateInscription;

    @JsonIgnore

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations = new ArrayList<>();
}