package tn.esprit.project1.services;

import tn.esprit.project1.models.Equipement;

import java.util.List;

public interface IEquipementService {

    Equipement saveEquipement(Equipement equipement);

    void deleteEquipement(Long idEquipement);

    Equipement getEquipementById(Long idEquipement);

    List<Equipement> getAllEquipement();
}
