package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.CategorieVehicule;
import tn.esprit.project1.models.StatutVehicule;
import tn.esprit.project1.models.Vehicule;
import tn.esprit.project1.models.Equipement;  // ✅ pour Equipement::getIdEquipement

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehiculeDTO {

    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    private StatutVehicule statut;

    // Relations exposées par ID
    private Long idAgence;
    private List<Long> idEquipements;

    // Entity → DTO
    public static VehiculeDTO fromEntity(Vehicule vehicule) {
        if (vehicule == null) return null;

        return VehiculeDTO.builder()
                .idVehicule(vehicule.getIdVehicule())
                .immatriculation(vehicule.getImmatriculation())
                .marque(vehicule.getMarque())
                .modele(vehicule.getModele())
                .categorie(vehicule.getCategorie())
                .tarifJournalier(vehicule.getTarifJournalier())
                .statut(vehicule.getStatut())
                .idAgence(vehicule.getAgence() != null
                        ? vehicule.getAgence().getIdAgence()
                        : null)
                .idEquipements(vehicule.getEquipements() != null
                        ? vehicule.getEquipements().stream()
                        .map(Equipement::getIdEquipement)
                        .toList()
                        : List.of())
                .build();
    }

    // DTO → Entity (relations affectées via endpoints dédiés)
    public Vehicule toEntity() {
        Vehicule vehicule = new Vehicule();
        vehicule.setIdVehicule(this.idVehicule);
        vehicule.setImmatriculation(this.immatriculation);
        vehicule.setMarque(this.marque);
        vehicule.setModele(this.modele);
        vehicule.setCategorie(this.categorie);
        vehicule.setTarifJournalier(this.tarifJournalier);
        vehicule.setStatut(this.statut);
        return vehicule;
    }
}