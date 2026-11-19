package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.MaintenanceDTO;
import tn.esprit.project1.services.IMaintenanceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    // http://localhost:8081/projet/maintenance/retrieve-all-maintenances
    @GetMapping("/retrieve-all-maintenances")
    public List<MaintenanceDTO> getMaintenances() {
        return maintenanceService.getAllMaintenance().stream()
                .map(MaintenanceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/maintenance/retrieve-maintenance/1
    @GetMapping("/retrieve-maintenance/{maintenance-id}")
    public MaintenanceDTO retrieveMaintenance(@PathVariable("maintenance-id") Long idMaintenance) {
        return MaintenanceDTO.fromEntity(maintenanceService.getMaintenanceById(idMaintenance));
    }

    // http://localhost:8081/projet/maintenance/add-maintenance
    @PostMapping("/add-maintenance")
    public MaintenanceDTO addMaintenance(@RequestBody MaintenanceDTO dto) {
        return MaintenanceDTO.fromEntity(maintenanceService.saveMaintenance(dto.toEntity()));
    }

    // http://localhost:8081/projet/maintenance/modify-maintenance
    @PutMapping("/modify-maintenance")
    public MaintenanceDTO modifyMaintenance(@RequestBody MaintenanceDTO dto) {
        return MaintenanceDTO.fromEntity(maintenanceService.saveMaintenance(dto.toEntity()));
    }

    // http://localhost:8081/projet/maintenance/remove-maintenance/1
    @DeleteMapping("/remove-maintenance/{maintenance-id}")
    public void removeMaintenance(@PathVariable("maintenance-id") Long idMaintenance) {
        maintenanceService.deleteMaintenance(idMaintenance);
    }

    // http://localhost:8081/projet/maintenance/affecterVehicule/1/2
    @PutMapping("/affecterVehicule/{idMaintenance}/{idVehicule}")
    public void affecterVehicule(
            @PathVariable Long idMaintenance,
            @PathVariable Long idVehicule) {
        maintenanceService.affecterMaintenanceVehicule(idMaintenance, idVehicule);
    }

    // http://localhost:8081/projet/maintenance/vehicule/2/maintenance/1
    @DeleteMapping("/vehicule/{vehicule-id}/maintenance/{maintenance-id}")
    public void retirerMaintenance(
            @PathVariable("vehicule-id") Long idVehicule,
            @PathVariable("maintenance-id") Long idMaintenance) {

        // ⚠️ idVehicule n'était pas utilisé dans la logique d'origine.
        // Version simple (détache toute maintenance) :
        maintenanceService.retirerVehiculeDeMaintenance(idMaintenance);

        // Version stricte (vérifie que c'est bien le bon véhicule) :

    }
}