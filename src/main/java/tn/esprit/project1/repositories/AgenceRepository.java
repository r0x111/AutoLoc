package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.Agence;
@Repository

public interface AgenceRepository extends JpaRepository<Agence, Long> {


}
