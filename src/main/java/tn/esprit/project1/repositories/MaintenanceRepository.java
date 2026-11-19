package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.Maintenance;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

}
