package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.Equipement;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {

}
