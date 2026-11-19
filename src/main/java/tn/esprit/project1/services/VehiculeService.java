package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.*;
import tn.esprit.project1.repositories.AgenceRepository;
import tn.esprit.project1.repositories.VehiculeRepository;
import tn.esprit.project1.repositories.EquipementRepository;

import java.util.Collections;
import java.util.List;

@Service
public class VehiculeService implements IVehiculeService {



    private final VehiculeRepository vehiculeRepository;

    private final AgenceRepository agenceRepository;

    private final EquipementRepository equipementRepository;

    public VehiculeService(VehiculeRepository vehiculeRepository, AgenceRepository agenceRepository, EquipementRepository equipementRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.agenceRepository = agenceRepository;
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Vehicule saveVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long idVehicule) {
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public Vehicule getVehiculeById(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public List<Vehicule> getAllVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public List<Vehicule> searchVehicules(String immatriculation, String marque, String modele, CategorieVehicule categorie, StatutVehicule statut) {
        return Collections.emptyList();
    }



    public List<Vehicule> getByMarque(String marque) {
        return vehiculeRepository.findByMarque(marque);
    }

    public List<Vehicule> getByMarqueContaining(String valeur) {
        return vehiculeRepository.findByMarqueContaining(valeur);
    }

    public List<Vehicule> getByMarqueStartingWith(String prefix) {
        return vehiculeRepository.findByMarqueStartingWith(prefix);
    }

    public List<Vehicule> getByMarqueEndingWith(String suffix) {
        return vehiculeRepository.findByMarqueEndingWith(suffix);
    }

    public List<Vehicule> getByModele(String modele) {
        return vehiculeRepository.findByModele(modele);
    }

    public boolean existsByImmatriculation(String immatriculation) {
        return vehiculeRepository.existsByImmatriculation(immatriculation);
    }

    public long countByMarque(String marque) {
        return vehiculeRepository.countByMarque(marque);
    }

    public List<Vehicule> getByTarifGreaterThan(double tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThan(tarif);
    }

    public List<Vehicule> getByTarifLessThan(double tarif) {
        return vehiculeRepository.findByTarifJournalierLessThan(tarif);
    }

    public List<Vehicule> getByTarifGreaterThanEqual(double tarif) {
        return vehiculeRepository.findByTarifJournalierGreaterThanEqual(tarif);
    }

    public List<Vehicule> getByTarifBetween(double min, double max) {
        return vehiculeRepository.findByTarifJournalierBetween(min, max);
    }

    public List<Vehicule> getByTarifAsc() {
        return vehiculeRepository.findByOrderByTarifJournalierAsc();
    }

    public List<Vehicule> getByTarifDesc() {
        return vehiculeRepository.findByOrderByTarifJournalierDesc();
    }

    public List<Vehicule> getByMarqueTarifAsc(String marque) {
        return vehiculeRepository.findByMarqueOrderByTarifJournalierAsc(marque);
    }

    public List<Vehicule> getByMarqueAndTarifGreaterThan(
            String marque, double tarif) {
        return vehiculeRepository.findByMarqueAndTarifJournalierGreaterThan(
                marque, tarif);
    }

    public List<Vehicule> getByMarqueOrModele(String marque, String modele) {
        return vehiculeRepository.findByMarqueOrModele(marque, modele);
    }

    public List<Vehicule> getByMarquesIn(List<String> marques) {
        return vehiculeRepository.findByMarqueIn(marques);
    }

    public List<Vehicule> getByMarquesNotIn(List<String> marques) {
        return vehiculeRepository.findByMarqueNotIn(marques);
    }

    public List<Vehicule> getByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }

    @Override
    public List<Vehicule> getByAgenceIdAgence(Long idAgence) {
        return vehiculeRepository.findByAgenceIdAgence(idAgence);
    }

    @Override
    public List<Vehicule> getByAgenceVille(String ville) {
        return vehiculeRepository.findByAgenceVille(ville);
    }

    @Override
    public List<Vehicule> getByAgenceNomContaining(String nom) {
        return vehiculeRepository.findByAgenceNomContaining(nom);
    }

    @Override
    public List<Vehicule> getByAgenceIdAgenceAndMarque(
            Long idAgence, String marque) {
        return vehiculeRepository
                .findByAgenceIdAgenceAndMarque(idAgence, marque);
    }

    @Override
    public List<Vehicule> getByAgenceIsNull() {
        return vehiculeRepository.findByAgenceIsNull();
    }
    @Override
    public List<Vehicule> getByAgenceIsNotNull() {
        return vehiculeRepository.findByAgenceIsNotNull();
    }

    @Override
    public Long countByAgenceIdAgence(long idAgence) {
        return vehiculeRepository.countByAgenceIdAgence(idAgence);
    }

    @Override
    public Boolean existsByAgenceIdAgence(long idAgence) {
        return vehiculeRepository.existsByAgenceIdAgence(idAgence);
    }






    public void affecterVehiculeAgence(Long idVehicule, Long idAgence){
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));

        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        vehicule.setAgence(agence);
        vehiculeRepository.save(vehicule);

    }

    @Override
    public void affecterEquipementVehicule(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));

        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Équipement introuvable : " + idEquipement));

        vehicule.getEquipements().add(equipement);
        vehiculeRepository.save(vehicule);
    }






    @Override
    public List<Vehicule> rechercherVehiculesParAgence(long idAgence) {
        return vehiculeRepository.rechercherVehiculesParAgence(idAgence);
    }

    @Override
    public List<Vehicule> rechercherVehiculesParVille(String ville) {
        return vehiculeRepository.rechercherVehiculesParVille(ville);
    }

    @Override
    public List<Vehicule> rechercherVehiculesParNomAgence(String nom) {
        return vehiculeRepository.rechercherVehiculesParNomAgence(nom);
    }

    @Override
    public List<Vehicule> rechercherParAgenceEtMarque(long idAgence, String marque) {
        return vehiculeRepository.rechercherParAgenceEtMarque(idAgence, marque);
    }

    @Override
    public List<Vehicule> rechercherVehiculesSansAgence() {
        return vehiculeRepository.rechercherVehiculesSansAgence();
    }

    @Override
    public List<Vehicule> rechercherVehiculesAvecAgence() {
        return vehiculeRepository.rechercherVehiculesAvecAgence();
    }

    @Override
    public Long compterVehiculesParAgence(long idAgence) {
        return vehiculeRepository.compterVehiculesParAgence(idAgence);
    }

    @Override
    public Boolean verifierExistenceVehiculesParAgence(long idAgence) {
        return vehiculeRepository.verifierExistenceVehiculesParAgence(idAgence);
    }



    @Override
    public void retirerVehiculeDeAgence(Long idAgence, Long idVehicule) {
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable : " + idAgence));
        agence.getVehicules().removeIf(v -> v.getIdVehicule().equals(idVehicule));
        agenceRepository.save(agence);
    }

    @Override
    public void retirerEquipementDeVehicule(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        vehicule.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        vehiculeRepository.save(vehicule);
    }

}
