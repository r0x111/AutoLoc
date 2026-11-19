package tn.esprit.project1.dto;

import tn.esprit.project1.models.Maintenance;

import java.time.LocalDate;

/** Données d'une maintenance exposées par l'API (sans les relations JPA). */
public record MaintenanceDTO(
        Long idMaintenance,
        LocalDate dateDebut,
        LocalDate dateFin,
        String description,
        Long idVehicule
) {

    // Entity → DTO
    public static MaintenanceDTO fromEntity(Maintenance maintenance) {
        if (maintenance == null) return null;
        return new MaintenanceDTO(
                maintenance.getIdMaintenance(),
                maintenance.getDateDebut(),
                maintenance.getDateFin(),
                maintenance.getDescription(),
                maintenance.getVehicule() != null
                        ? maintenance.getVehicule().getIdVehicule()
                        : null
        );
    }

    // DTO → new Entity (pour POST)
    public Maintenance toEntity() {
        return applyTo(new Maintenance());
    }

    // DTO → existing Entity (pour PUT / modify)
    public Maintenance applyTo(Maintenance maintenance) {
        if (idMaintenance != null) {
            maintenance.setIdMaintenance(idMaintenance);
        }
        maintenance.setDateDebut(dateDebut);
        maintenance.setDateFin(dateFin);
        maintenance.setDescription(description);
        // Le véhicule est affecté via un endpoint dédié (affecterVehicule)
        return maintenance;
    }
}