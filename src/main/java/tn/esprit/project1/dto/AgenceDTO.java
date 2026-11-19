package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.Agence;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgenceDTO {

    private Long idAgence;
    private String nom;
    private String ville;
    private String adresse;
    // Ajoutez uniquement les champs à exposer

    // Mapper Entity → DTO
    public static AgenceDTO fromEntity(Agence agence) {
        if (agence == null) return null;
        return AgenceDTO.builder()
                .idAgence(agence.getIdAgence())
                .nom(agence.getNom())
                .ville(agence.getVille())
                .adresse(agence.getAdresse())
                .build();
    }

    // Mapper DTO → Entity
    public Agence toEntity() {
        Agence agence = new Agence();
        agence.setIdAgence(this.idAgence);
        agence.setNom(this.nom);
        agence.setVille(this.ville);
        agence.setAdresse(this.adresse);
        return agence;
    }
}