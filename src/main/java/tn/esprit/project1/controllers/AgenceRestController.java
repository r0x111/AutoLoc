package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.AgenceDTO;
import tn.esprit.project1.services.IAgenceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceRestController {

    private final IAgenceService agenceService;

    // GET /agence/retrieve-all-agences
    @GetMapping("/retrieve-all-agences")
    public List<AgenceDTO> getAgences() {
        return agenceService.getAllAgence().stream()
                .map(AgenceDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // GET /agence/retrieve-agence/1
    @GetMapping("/retrieve-agence/{agence-id}")
    public AgenceDTO retrieveAgence(@PathVariable("agence-id") Long idAgence) {
        return AgenceDTO.fromEntity(agenceService.getAgenceById(idAgence));
    }

    // POST /agence/add-agence
    @PostMapping("/add-agence")
    public AgenceDTO addAgence(@RequestBody AgenceDTO dto) {
        return AgenceDTO.fromEntity(agenceService.saveAgence(dto.toEntity()));
    }

    // PUT /agence/modify-agence
    @PutMapping("/modify-agence")
    public AgenceDTO modifyAgence(@RequestBody AgenceDTO dto) {
        return AgenceDTO.fromEntity(agenceService.saveAgence(dto.toEntity()));
    }

    // DELETE /agence/remove-agence/1
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long idAgence) {
        agenceService.deleteAgence(idAgence);
    }


    @DeleteMapping("/agence/{agence-id}/employe/{employe-id}")
    public void retirerEmploye(
            @PathVariable("agence-id") Long idAgence,
            @PathVariable("employe-id") Long idEmploye) {
        agenceService.retirerEmployeDeAgence(idAgence, idEmploye);
    }
}