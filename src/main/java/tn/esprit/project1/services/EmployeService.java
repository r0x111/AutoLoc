package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Agence;
import tn.esprit.project1.models.Employe;
import tn.esprit.project1.repositories.AgenceRepository;
import tn.esprit.project1.repositories.EmployeRepository;


import java.util.List;

@Service
public class EmployeService implements IEmployeService {

    private final EmployeRepository employeRepository;
    private AgenceRepository agenceRepository;

    public EmployeService(EmployeRepository employeRepository, AgenceRepository agenceRepository) {
        this.employeRepository = employeRepository;
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public Employe getEmployeById(Long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }

    @Override
    public List<Employe> getAllEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public void affecterEmployAgence(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye)
                .orElseThrow(() -> new EntityNotFoundException("Employé introuvable : " + idEmploye));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        employe.setAgence(agence);
        employeRepository.save(employe);
    }
}

