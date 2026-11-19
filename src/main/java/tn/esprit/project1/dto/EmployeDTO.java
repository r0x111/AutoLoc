package tn.esprit.project1.dto;

import tn.esprit.project1.models.Employe;
import tn.esprit.project1.models.RoleEmploye;

/** Données d'un employé exposées par l'API (sans les relations JPA). */
public record EmployeDTO(
        Long idEmploye,
        String nom,
        String prenom,
        RoleEmploye role,
        Long idAgence
) {

    // Entity → DTO
    public static EmployeDTO fromEntity(Employe employe) {
        if (employe == null) return null;
        return new EmployeDTO(
                employe.getIdEmploye(),
                employe.getNom(),
                employe.getPrenom(),
                employe.getRole(),
                employe.getAgence() != null ? employe.getAgence().getIdAgence() : null
        );
    }

    // DTO → new Entity (pour POST)
    public Employe toEntity() {
        return applyTo(new Employe());
    }

    // DTO → existing Entity (pour PUT / modify)
    public Employe applyTo(Employe employe) {
        if (idEmploye != null) {
            employe.setIdEmploye(idEmploye);
        }
        employe.setNom(nom);
        employe.setPrenom(prenom);
        employe.setRole(role);
        // L'agence est affectée via un endpoint dédié (affecterAgence)
        return employe;
    }
}