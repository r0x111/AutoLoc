package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.ModePaiement;
import tn.esprit.project1.models.Paiement;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaiementDTO {

    private Long idPaiement;
    private BigDecimal montant;
    private LocalDate datePaiement;
    private ModePaiement modePaiement;
    private Long idContrat;

    // Entity → DTO
    public static PaiementDTO fromEntity(Paiement paiement) {
        if (paiement == null) return null;
        return PaiementDTO.builder()
                .idPaiement(paiement.getIdPaiement())
                .montant(paiement.getMontant())
                .datePaiement(paiement.getDatePaiement())
                .modePaiement(paiement.getModePaiement())
                .idContrat(paiement.getContrat() != null
                        ? paiement.getContrat().getIdContrat()
                        : null)
                .build();
    }

    // DTO → Entity
    public Paiement toEntity() {
        Paiement paiement = new Paiement();
        paiement.setIdPaiement(this.idPaiement);
        paiement.setMontant(this.montant);
        paiement.setDatePaiement(this.datePaiement);
        paiement.setModePaiement(this.modePaiement);
        // Le contrat est affecté séparément via un endpoint dédié
        return paiement;
    }
}