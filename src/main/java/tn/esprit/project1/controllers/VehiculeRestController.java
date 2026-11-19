package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.VehiculeDTO;
import tn.esprit.project1.models.CategorieVehicule;
import tn.esprit.project1.models.StatutVehicule;
import tn.esprit.project1.services.IVehiculeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    // ==================== CRUD ====================

    @GetMapping("/retrieve-all-vehicules")
    public List<VehiculeDTO> getVehicules() {
        return vehiculeService.getAllVehicule().stream()
                .map(VehiculeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public VehiculeDTO retrieveVehicule(@PathVariable("vehicule-id") Long idVehicule) {
        return VehiculeDTO.fromEntity(vehiculeService.getVehiculeById(idVehicule));
    }

    @PostMapping("/add-vehicule")
    public VehiculeDTO addVehicule(@RequestBody VehiculeDTO dto) {
        return VehiculeDTO.fromEntity(vehiculeService.saveVehicule(dto.toEntity()));
    }

    @PutMapping("/modify-vehicule")
    public VehiculeDTO modifyVehicule(@RequestBody VehiculeDTO dto) {
        return VehiculeDTO.fromEntity(vehiculeService.saveVehicule(dto.toEntity()));
    }

    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long idVehicule) {
        vehiculeService.deleteVehicule(idVehicule);
    }

    // ==================== RECHERCHE MULTI-CRITÈRES ====================

    @GetMapping("/search-vehicules")
    public List<VehiculeDTO> searchVehicules(
            @RequestParam(required = false) String immatriculation,
            @RequestParam(required = false) String marque,
            @RequestParam(required = false) String modele,
            @RequestParam(required = false) CategorieVehicule categorie,
            @RequestParam(required = false) StatutVehicule statut) {
        return vehiculeService.searchVehicules(immatriculation, marque, modele, categorie, statut)
                .stream()
                .map(VehiculeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // ==================== AFFECTATIONS / RETRAITS ====================

    @PutMapping("/affecterVehiculeAgence/{idVehicule}/{idAgence}")
    public void affecterVehiculeAgence(
            @PathVariable Long idVehicule,
            @PathVariable Long idAgence) {
        vehiculeService.affecterVehiculeAgence(idVehicule, idAgence);
    }

    @PutMapping("/affecterEquipement/{idVehicule}/{idEquipement}")
    public void affecterEquipement(
            @PathVariable Long idVehicule,
            @PathVariable Long idEquipement) {
        vehiculeService.affecterEquipementVehicule(idVehicule, idEquipement);
    }

    @DeleteMapping("/agence/{agence-id}/vehicule/{vehicule-id}")
    public void retirerVehicule(
            @PathVariable("agence-id") Long idAgence,
            @PathVariable("vehicule-id") Long idVehicule) {
        vehiculeService.retirerVehiculeDeAgence(idAgence, idVehicule);
    }

    @DeleteMapping("/vehicule/{vehicule-id}/equipement/{equipement-id}")
    public void retirerEquipement(
            @PathVariable("vehicule-id") Long idVehicule,
            @PathVariable("equipement-id") Long idEquipement) {
        vehiculeService.retirerEquipementDeVehicule(idVehicule, idEquipement);
    }

    // ==================== RECHERCHES SIMPLES ====================

    @GetMapping("/marque/{marque}")
    public List<VehiculeDTO> getByMarque(@PathVariable String marque) {
        return toDtoList(vehiculeService.getByMarque(marque));
    }

    @GetMapping("/marqueContaining/{valeur}")
    public List<VehiculeDTO> getByMarqueContaining(@PathVariable String valeur) {
        return toDtoList(vehiculeService.getByMarqueContaining(valeur));
    }

    @GetMapping("/marqueStartingWith/{prefix}")
    public List<VehiculeDTO> getByMarqueStartingWith(@PathVariable String prefix) {
        return toDtoList(vehiculeService.getByMarqueStartingWith(prefix));
    }

    @GetMapping("/marqueEndingWith/{suffix}")
    public List<VehiculeDTO> getByMarqueEndingWith(@PathVariable String suffix) {
        return toDtoList(vehiculeService.getByMarqueEndingWith(suffix));
    }

    @GetMapping("/modele/{modele}")
    public List<VehiculeDTO> getByModele(@PathVariable String modele) {
        return toDtoList(vehiculeService.getByModele(modele));
    }

    @GetMapping("/exists/{immatriculation}")
    public boolean existsByImmatriculation(@PathVariable String immatriculation) {
        return vehiculeService.existsByImmatriculation(immatriculation);
    }

    @GetMapping("/count/{marque}")
    public long countByMarque(@PathVariable String marque) {
        return vehiculeService.countByMarque(marque);
    }

    @GetMapping("/tarifGreaterThan/{tarif}")
    public List<VehiculeDTO> getByTarifGreaterThan(@PathVariable double tarif) {
        return toDtoList(vehiculeService.getByTarifGreaterThan(tarif));
    }

    @GetMapping("/tarifLessThan/{tarif}")
    public List<VehiculeDTO> getByTarifLessThan(@PathVariable double tarif) {
        return toDtoList(vehiculeService.getByTarifLessThan(tarif));
    }

    @GetMapping("/tarifGreaterThanEqual/{tarif}")
    public List<VehiculeDTO> getByTarifGreaterThanEqual(@PathVariable double tarif) {
        return toDtoList(vehiculeService.getByTarifGreaterThanEqual(tarif));
    }

    @GetMapping("/tarifBetween/{min}/{max}")
    public List<VehiculeDTO> getByTarifBetween(@PathVariable double min, @PathVariable double max) {
        return toDtoList(vehiculeService.getByTarifBetween(min, max));
    }

    @GetMapping("/tarifAsc")
    public List<VehiculeDTO> getByTarifAsc() {
        return toDtoList(vehiculeService.getByTarifAsc());
    }

    @GetMapping("/tarifDesc")
    public List<VehiculeDTO> getByTarifDesc() {
        return toDtoList(vehiculeService.getByTarifDesc());
    }

    @GetMapping("/marqueTarifAsc/{marque}")
    public List<VehiculeDTO> getByMarqueTarifAsc(@PathVariable String marque) {
        return toDtoList(vehiculeService.getByMarqueTarifAsc(marque));
    }

    @GetMapping("/marqueTarifGreaterThan/{marque}/{tarif}")
    public List<VehiculeDTO> getByMarqueAndTarifGreaterThan(
            @PathVariable String marque, @PathVariable double tarif) {
        return toDtoList(vehiculeService.getByMarqueAndTarifGreaterThan(marque, tarif));
    }

    @GetMapping("/marqueOrModele/{marque}/{modele}")
    public List<VehiculeDTO> getByMarqueOrModele(
            @PathVariable String marque, @PathVariable String modele) {
        return toDtoList(vehiculeService.getByMarqueOrModele(marque, modele));
    }

    @GetMapping("/marquesIn")
    public List<VehiculeDTO> getByMarquesIn(@RequestParam List<String> marques) {
        return toDtoList(vehiculeService.getByMarquesIn(marques));
    }

    @GetMapping("/marquesNotIn")
    public List<VehiculeDTO> getByMarquesNotIn(@RequestParam List<String> marques) {
        return toDtoList(vehiculeService.getByMarquesNotIn(marques));
    }

    @GetMapping("/statut/{statut}")
    public List<VehiculeDTO> getByStatut(@PathVariable StatutVehicule statut) {
        return toDtoList(vehiculeService.getByStatut(statut));
    }

    // ==================== RECHERCHES PAR AGENCE ====================

    @GetMapping("/agence/{idAgence}")
    public List<VehiculeDTO> getByAgence(@PathVariable Long idAgence) {
        return toDtoList(vehiculeService.getByAgenceIdAgence(idAgence));
    }

    @GetMapping("/agence/ville/{ville}")
    public List<VehiculeDTO> getByAgenceVille(@PathVariable String ville) {
        return toDtoList(vehiculeService.getByAgenceVille(ville));
    }

    @GetMapping("/agence/nom")
    public List<VehiculeDTO> getByAgenceNomContaining(@RequestParam String nom) {
        return toDtoList(vehiculeService.getByAgenceNomContaining(nom));
    }

    @GetMapping("/agence/{idAgence}/marque/{marque}")
    public List<VehiculeDTO> getByAgenceAndMarque(
            @PathVariable Long idAgence, @PathVariable String marque) {
        return toDtoList(vehiculeService.getByAgenceIdAgenceAndMarque(idAgence, marque));
    }

    @GetMapping("/sansAgence")
    public List<VehiculeDTO> getByAgenceIsNull() {
        return toDtoList(vehiculeService.getByAgenceIsNull());
    }

    @GetMapping("/avecAgence")
    public List<VehiculeDTO> getByAgenceIsNotNull() {
        return toDtoList(vehiculeService.getByAgenceIsNotNull());
    }

    @GetMapping("/countAgence/{idAgence}")
    public Long countByAgenceIdAgence(@PathVariable long idAgence) {
        return vehiculeService.countByAgenceIdAgence(idAgence);
    }

    @GetMapping("/existsAgence/{idAgence}")
    public Boolean existsByAgenceIdAgence(@PathVariable long idAgence) {
        return vehiculeService.existsByAgenceIdAgence(idAgence);
    }

    // ==================== HELPER ====================

    private List<VehiculeDTO> toDtoList(List<tn.esprit.project1.models.Vehicule> vehicules) {
        return vehicules.stream()
                .map(VehiculeDTO::fromEntity)
                .collect(Collectors.toList());
    }
}