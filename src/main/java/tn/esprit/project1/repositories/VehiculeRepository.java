package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.StatutVehicule;
import tn.esprit.project1.models.Vehicule;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {



    List<Vehicule> findByMarque(String marque);

    List<Vehicule> findByMarqueContaining(String valeur);

    List<Vehicule> findByMarqueStartingWith(String prefix);

    List<Vehicule> findByMarqueEndingWith(String suffix);

    List<Vehicule> findByModele(String modele);

    boolean existsByImmatriculation(String immatriculation);

    long countByMarque(String marque);

    List<Vehicule> findByTarifJournalierGreaterThan(
           double tarif);

    List<Vehicule> findByTarifJournalierLessThan(
            double tarif);

    List<Vehicule> findByTarifJournalierGreaterThanEqual(
            double tarif);

    List<Vehicule> findByTarifJournalierBetween(
            double min, double max);

    List<Vehicule> findByOrderByTarifJournalierAsc();

    List<Vehicule> findByOrderByTarifJournalierDesc();

    List<Vehicule> findByMarqueOrderByTarifJournalierAsc(
            String marque);

    List<Vehicule> findByMarqueAndTarifJournalierGreaterThan(
            String marque, double tarif);

    List<Vehicule> findByMarqueOrModele(
            String marque, String modele);

    List<Vehicule> findByMarqueIn(List<String> marques);

    List<Vehicule> findByMarqueNotIn(List<String> marques);

    List<Vehicule> findByStatut(StatutVehicule statut);


    List<Vehicule> findByAgenceIdAgence(long idAgence);
    List<Vehicule> findByAgenceVille(String ville);

    List<Vehicule> findByAgenceNomContaining(String nom);
    List<Vehicule> findByAgenceIdAgenceAndMarque(long idAgence, String marque);
    List<Vehicule> findByAgenceIsNull();
    List<Vehicule> findByAgenceIsNotNull();
    Long countByAgenceIdAgence(long idAgence);
    Boolean existsByAgenceIdAgence(long idAgence);



    // 1. Recherche par ID agence (nominatif)
    @Query("SELECT v FROM Vehicule v WHERE v.agence.idAgence = :idAgence")
    List<Vehicule> rechercherVehiculesParAgence(
            @Param("idAgence") long idAgence);

    // 2. Recherche par ville (nominatif)
    @Query("SELECT v FROM Vehicule v WHERE v.agence.ville = :ville")
    List<Vehicule> rechercherVehiculesParVille(
            @Param("ville") String ville);

    // 3. Recherche par nom d'agence (nominatif)
    @Query("SELECT v FROM Vehicule v WHERE v.agence.nom LIKE CONCAT('%', :nom, '%')")
    List<Vehicule> rechercherVehiculesParNomAgence(
            @Param("nom") String nom);

    // 4. Recherche par agence et marque (positionnel)
    @Query("SELECT v FROM Vehicule v WHERE v.agence.idAgence = ?1 AND v.marque = ?2")
    List<Vehicule> rechercherParAgenceEtMarque(
            long idAgence, String marque);

    // 5. Véhicules sans agence
    @Query("SELECT v FROM Vehicule v WHERE v.agence IS NULL")
    List<Vehicule> rechercherVehiculesSansAgence();

    // 6. Véhicules avec agence
    @Query("SELECT v FROM Vehicule v WHERE v.agence IS NOT NULL")
    List<Vehicule> rechercherVehiculesAvecAgence();

    // 7. Compter les véhicules par agence (positionnel)
    @Query("SELECT COUNT(v) FROM Vehicule v WHERE v.agence.idAgence = ?1")
    Long compterVehiculesParAgence(long idAgence);

    // 8. Vérifier l'existence des véhicules par agence (positionnel)
    @Query("SELECT CASE WHEN COUNT(v) > 0 THEN TRUE ELSE FALSE END FROM Vehicule v WHERE v.agence.idAgence = ?1")
    Boolean verifierExistenceVehiculesParAgence(long idAgence);




}
