package tn.esprit.project1.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Maintenance;
import tn.esprit.project1.models.Vehicule;
import tn.esprit.project1.repositories.MaintenanceRepository;
import tn.esprit.project1.repositories.VehiculeRepository;

import java.util.List;

@Service
public class MaintenanceService implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final VehiculeRepository vehiculeRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository, VehiculeRepository vehiculeRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Maintenance saveMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void deleteMaintenance(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }

    @Override
    public Maintenance getMaintenanceById(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance).orElse(null);
    }

    @Override
    public List<Maintenance> getAllMaintenance() {
        return maintenanceRepository.findAll();
    }

    @Override
    public void affecterMaintenanceVehicule(Long idMaintenance, Long idVehicule) {
        Maintenance maintenance = maintenanceRepository.findById(idMaintenance)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable : " + idMaintenance));

        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));

        maintenance.setVehicule(vehicule);
        maintenanceRepository.save(maintenance);
    }

    @Override
    public void retirerVehiculeDeMaintenance(Long idMaintenance) {
        Maintenance maintenance = maintenanceRepository.findById(idMaintenance)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable : " + idMaintenance));
        maintenance.setVehicule(null);
        maintenanceRepository.save(maintenance);
    }
}
