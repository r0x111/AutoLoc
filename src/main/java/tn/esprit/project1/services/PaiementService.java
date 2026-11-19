package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Contrat;
import tn.esprit.project1.models.Paiement;
import tn.esprit.project1.repositories.ContratRepository;
import tn.esprit.project1.repositories.PaiementRepository;

import java.util.List;

@Service
public class PaiementService implements IPaiementService {


    private final PaiementRepository paiementRepository;
    private final ContratRepository contratRepository;

    public PaiementService(PaiementRepository paiementRepository, ContratRepository contratRepository) {
        this.paiementRepository = paiementRepository;
        this.contratRepository = contratRepository;
    }

    @Override
    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public Paiement getPaiementById(Long idPaiement) {
        return paiementRepository.findById(idPaiement).orElse(null);
    }

    @Override
    public List<Paiement> getAllPaiement() {
        return paiementRepository.findAll();
    }


    @Override
    public void affecterPaiementContrat(Long idPaiement, Long idContrat) {
        Paiement paiement = paiementRepository.findById(idPaiement)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable : " + idPaiement));

        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable : " + idContrat));

        paiement.setContrat(contrat);
        paiementRepository.save(paiement);
    }
}
