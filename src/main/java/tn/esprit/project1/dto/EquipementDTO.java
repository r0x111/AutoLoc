package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.Equipement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipementDTO {

    private Long idEquipement;
    private String libelle;
    // Les véhicules (relation @ManyToMany) ne sont PAS exposés ici :
    // - La relation est @JsonIgnore côté entité
    // - Elle est gérée via les endpoints dédiés de Vehicule
    //   (ex : PUT /vehicule/affecterEquipement/{idVehicule}/{idEquipement})

    // Entity → DTO
    public static EquipementDTO fromEntity(Equipement equipement) {
        if (equipement == null) return null;
        return EquipementDTO.builder()
                .idEquipement(equipement.getIdEquipement())
                .libelle(equipement.getLibelle())
                .build();
    }

    // DTO → Entity
    public Equipement toEntity() {
        Equipement equipement = new Equipement();
        equipement.setIdEquipement(this.idEquipement);
        equipement.setLibelle(this.libelle);
        return equipement;
    }
}