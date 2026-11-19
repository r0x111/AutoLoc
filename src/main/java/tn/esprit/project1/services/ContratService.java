package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Contrat;
import tn.esprit.project1.models.Reservation;
import tn.esprit.project1.repositories.ContratRepository;
import tn.esprit.project1.repositories.ReservationRepository;

import java.util.List;

@Service
public class ContratService implements IContratService {

    private final ContratRepository contratRepository;
    private final ReservationRepository reservationRepository;

    public ContratService(ContratRepository contratRepository, ReservationRepository reservationRepository) {
        this.contratRepository = contratRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Contrat saveContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat getContratById(Long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }
    @Override
    public void affecterContratReservation(Long idContrat, Long idReservation) {
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));

        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new EntityNotFoundException("Réservation introuvable : " + idReservation));

        contrat.setReservation(reservation);
        contratRepository.save(contrat);
    }


    @Override
    public void retirerReservationDeContrat(Long idContrat) {
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));
        contrat.setReservation(null);
        contratRepository.save(contrat);
    }
}
