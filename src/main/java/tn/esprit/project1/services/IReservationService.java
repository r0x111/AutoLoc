package tn.esprit.project1.services;

import tn.esprit.project1.models.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation saveReservation(Reservation reservation);

    void deleteReservation(Long idReservation);

    Reservation getReservationById(Long idReservation);

    List<Reservation> getAllReservation();

    void affecterReservationClient(Long idReservation, Long idClient);
    void affecterReservationVehicule(Long idReservation, Long idVehicule);
}
