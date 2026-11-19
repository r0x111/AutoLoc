package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Agence;
import tn.esprit.project1.repositories.AgenceRepository;

import java.util.List;

@Service
public class AgenceService implements IAgenceService {

    private final AgenceRepository agenceRepository;


    public AgenceService(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence saveAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void deleteAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    public Agence getAgenceById(Long idAgence) {
        return agenceRepository.findById(idAgence).orElse(null);
    }

    @Override
    public List<Agence> getAllAgence() {
        return agenceRepository.findAll();
    }
    @Override
    public void retirerEmployeDeAgence(Long idAgence, Long idEmploye) {
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));

        agence.getEmployes().removeIf(e -> e.getIdEmploye().equals(idEmploye));
        agenceRepository.save(agence);
    }
}
