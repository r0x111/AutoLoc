package tn.esprit.project1.services;

import tn.esprit.project1.models.Agence;

import java.util.List;

public interface IAgenceService {

    Agence saveAgence(Agence agence);

    void deleteAgence(Long idAgence);

    Agence getAgenceById(Long idAgence);

    List<Agence> getAllAgence();
    void retirerEmployeDeAgence(Long idAgence, Long idEmploye);
}
