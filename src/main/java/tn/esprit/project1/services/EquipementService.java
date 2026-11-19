package tn.esprit.project1.services;

import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Equipement;
import tn.esprit.project1.repositories.EquipementRepository;

import java.util.List;

@Service
public class EquipementService implements IEquipementService {
    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement saveEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void deleteEquipement(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }

    @Override
    public Equipement getEquipementById(Long idEquipement) {
        return equipementRepository.findById(idEquipement).orElse(null);
    }

    @Override
    public List<Equipement> getAllEquipement() {
        return equipementRepository.findAll();
    }
}
