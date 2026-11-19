package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.EquipementDTO;
import tn.esprit.project1.services.IEquipementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementRestController {

    private final IEquipementService equipementService;

    // http://localhost:8081/projet/equipement/retrieve-all-equipements
    @GetMapping("/retrieve-all-equipements")
    public List<EquipementDTO> getEquipements() {
        return equipementService.getAllEquipement().stream()
                .map(EquipementDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/equipement/retrieve-equipement/1
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public EquipementDTO retrieveEquipement(@PathVariable("equipement-id") Long idEquipement) {
        return EquipementDTO.fromEntity(equipementService.getEquipementById(idEquipement));
    }

    // http://localhost:8081/projet/equipement/add-equipement
    @PostMapping("/add-equipement")
    public EquipementDTO addEquipement(@RequestBody EquipementDTO dto) {
        return EquipementDTO.fromEntity(equipementService.saveEquipement(dto.toEntity()));
    }

    // http://localhost:8081/projet/equipement/modify-equipement
    @PutMapping("/modify-equipement")
    public EquipementDTO modifyEquipement(@RequestBody EquipementDTO dto) {
        return EquipementDTO.fromEntity(equipementService.saveEquipement(dto.toEntity()));
    }

    // http://localhost:8081/projet/equipement/remove-equipement/1
    @DeleteMapping("/remove-equipement/{equipement-id}")
    public void removeEquipement(@PathVariable("equipement-id") Long idEquipement) {
        equipementService.deleteEquipement(idEquipement);
    }
}