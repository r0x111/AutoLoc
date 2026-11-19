package tn.esprit.project1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.project1.models.Client;
@Repository

public interface ClientRepository extends JpaRepository<Client, Long> {

}
