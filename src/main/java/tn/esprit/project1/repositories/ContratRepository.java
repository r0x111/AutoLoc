package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

}
