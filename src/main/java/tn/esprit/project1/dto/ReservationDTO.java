package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.Reservation;
import tn.esprit.project1.models.StatutReservation;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationDTO {

    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;

    // Relations exposées par ID uniquement
    private Long idClient;
    private Long idVehicule;
    private Long idContrat;

    // Entity → DTO
    public static ReservationDTO fromEntity(Reservation reservation) {
        if (reservation == null) return null;
        return ReservationDTO.builder()
                .idReservation(reservation.getIdReservation())
                .dateDebut(reservation.getDateDebut())
                .dateFin(reservation.getDateFin())
                .statut(reservation.getStatut())
                .idClient(reservation.getClient() != null
                        ? reservation.getClient().getIdClient()
                        : null)
                .idVehicule(reservation.getVehicule() != null
                        ? reservation.getVehicule().getIdVehicule()
                        : null)
                .idContrat(reservation.getContrat() != null
                        ? reservation.getContrat().getIdContrat()
                        : null)
                .build();
    }

    // DTO → Entity (les relations sont affectées via endpoints dédiés)
    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        reservation.setIdReservation(this.idReservation);
        reservation.setDateDebut(this.dateDebut);
        reservation.setDateFin(this.dateFin);
        reservation.setStatut(this.statut);
        // client / vehicule / contrat affectés séparément
        return reservation;
    }
}