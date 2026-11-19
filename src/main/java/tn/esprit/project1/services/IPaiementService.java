package tn.esprit.project1.services;

import tn.esprit.project1.models.Paiement;

import java.util.List;

public interface IPaiementService {

    Paiement savePaiement(Paiement paiement);

    void deletePaiement(Long idPaiement);

    Paiement getPaiementById(Long idPaiement);

    List<Paiement> getAllPaiement();
    void affecterPaiementContrat(Long idPaiement, Long idContrat);
}
