package tn.esprit.project1.services;

import tn.esprit.project1.models.CategorieVehicule;
import tn.esprit.project1.models.StatutVehicule;
import tn.esprit.project1.models.Vehicule;

import java.util.List;

public interface IVehiculeService {

    Vehicule saveVehicule(Vehicule vehicule);

    void deleteVehicule(Long idVehicule);

    Vehicule getVehiculeById(Long idVehicule);

    List<Vehicule> getAllVehicule();
    void retirerVehiculeDeAgence(Long idAgence, Long idVehicule);
    void retirerEquipementDeVehicule(Long idVehicule, Long idEquipement);

    List<Vehicule> searchVehicules(String immatriculation, String marque, String modele,
                                   CategorieVehicule categorie, StatutVehicule statut);
    void affecterVehiculeAgence(Long idVehicule, Long idAgence);
    void affecterEquipementVehicule(Long idVehicule, Long idEquipement);


    List<Vehicule> getByMarqueOrModele(String marque, String modele);

    List<Vehicule> getByMarquesIn(List<String> marques);

    List<Vehicule> getByMarquesNotIn(List<String> marques);

    List<Vehicule> getByStatut(StatutVehicule statut);

    List<Vehicule> getByMarqueAndTarifGreaterThan(String marque, double tarif);

    List<Vehicule> getByMarqueTarifAsc(String marque);

    List<Vehicule> getByTarifDesc();

    List<Vehicule> getByTarifAsc();

    List<Vehicule> getByTarifBetween(double min, double max);

    List<Vehicule> getByTarifGreaterThanEqual(double tarif);

    List<Vehicule> getByTarifLessThan(double tarif);

    List<Vehicule> getByTarifGreaterThan(double tarif);

    long countByMarque(String marque);

    boolean existsByImmatriculation(String immatriculation);

    List<Vehicule> getByModele(String modele);

    List<Vehicule> getByMarqueEndingWith(String suffix);

    List<Vehicule> getByMarqueStartingWith(String prefix);

    List<Vehicule> getByMarqueContaining(String valeur);

    List<Vehicule> getByMarque(String marque);


    List<Vehicule> getByAgenceIdAgence(Long idAgence);

    List<Vehicule> getByAgenceVille(String ville);

    List<Vehicule> getByAgenceNomContaining(String nom);

    List<Vehicule> getByAgenceIdAgenceAndMarque(
            Long idAgence, String marque);

    List<Vehicule> getByAgenceIsNull();
    List<Vehicule> getByAgenceIsNotNull();

    Long countByAgenceIdAgence(long idAgence);

    Boolean existsByAgenceIdAgence(long idAgence);


    List<Vehicule> rechercherVehiculesParAgence(long idAgence);

    List<Vehicule> rechercherVehiculesParVille(String ville);

    List<Vehicule> rechercherVehiculesParNomAgence(String nom);

    List<Vehicule> rechercherParAgenceEtMarque(long idAgence, String marque);

    List<Vehicule> rechercherVehiculesSansAgence();

    List<Vehicule> rechercherVehiculesAvecAgence();

    Long compterVehiculesParAgence(long idAgence);

    Boolean verifierExistenceVehiculesParAgence(long idAgence);




}
