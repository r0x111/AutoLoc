package tn.esprit.project1.services;

import tn.esprit.project1.models.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    Maintenance saveMaintenance(Maintenance maintenance);

    void deleteMaintenance(Long idMaintenance);

    Maintenance getMaintenanceById(Long idMaintenance);

    List<Maintenance> getAllMaintenance();
    void affecterMaintenanceVehicule(Long idMaintenance, Long idVehicule);
    void retirerVehiculeDeMaintenance(Long idMaintenance);
}
