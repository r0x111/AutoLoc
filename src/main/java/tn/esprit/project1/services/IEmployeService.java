package tn.esprit.project1.services;

import tn.esprit.project1.models.Employe;

import java.util.List;

public interface IEmployeService {

    Employe saveEmploye(Employe employe);

    void deleteEmploye(Long idEmploye);


    Employe getEmployeById(Long idEmploye);

    List<Employe> getAllEmploye();
    void affecterEmployAgence(Long idEmploye, Long idAgence);
}
