package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.Contrat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratDTO {

    private Long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    // Pour la relation @OneToOne vers Reservation
    private Long idReservation;

    // Entity → DTO
    public static ContratDTO fromEntity(Contrat contrat) {
        if (contrat == null) return null;
        return ContratDTO.builder()
                .idContrat(contrat.getIdContrat())
                .dateSignature(contrat.getDateSignature())
                .montantTotal(contrat.getMontantTotal())
                .valide(contrat.isValide())
                .idReservation(contrat.getReservation() != null
                        ? contrat.getReservation().getIdReservation()
                        : null)
                .build();
    }

    // DTO → Entity (sans réservation, gérée séparément)
    public Contrat toEntity() {
        Contrat contrat = new Contrat();
        contrat.setIdContrat(this.idContrat);
        contrat.setDateSignature(this.dateSignature);
        contrat.setMontantTotal(this.montantTotal);
        contrat.setValide(this.valide);
        // La réservation est affectée via un endpoint dédié (affecterReservation)
        return contrat;
    }
}