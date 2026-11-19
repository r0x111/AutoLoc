package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
