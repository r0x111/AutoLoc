package tn.esprit.project1.services;

import tn.esprit.project1.models.Contrat;

import java.util.List;

public interface IContratService {

    Contrat saveContrat(Contrat contrat);

    void deleteContrat(Long idContrat);

    Contrat getContratById(Long idContrat);

    List<Contrat> getAllContrat();
    void affecterContratReservation(Long idContrat, Long idReservation);
    void retirerReservationDeContrat(Long idContrat);
}
