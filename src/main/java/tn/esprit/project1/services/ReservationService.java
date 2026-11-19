package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Client;
import tn.esprit.project1.models.Reservation;
import tn.esprit.project1.models.Vehicule;
import tn.esprit.project1.repositories.ClientRepository;
import tn.esprit.project1.repositories.ReservationRepository;
import tn.esprit.project1.repositories.VehiculeRepository;

import java.util.List;

@Service
public class ReservationService implements IReservationService {


    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final VehiculeRepository vehiculeRepository;

    public ReservationService(ReservationRepository reservationRepository, ClientRepository clientRepository, VehiculeRepository vehiculeRepository) {
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation getReservationById(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }



    @Override
    public void affecterReservationClient(Long idReservation, Long idClient) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Réservation introuvable : " + idReservation));
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable : " + idClient));

        reservation.setClient(client);
        reservationRepository.save(reservation);
    }

    @Override
    public void affecterReservationVehicule(Long idReservation, Long idVehicule) {
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Réservation introuvable : " + idReservation));
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));

        reservation.setVehicule(vehicule);
        reservationRepository.save(reservation);
    }
}
