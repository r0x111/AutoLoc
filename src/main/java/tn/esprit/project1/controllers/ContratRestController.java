package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.ContratDTO;
import tn.esprit.project1.services.IContratService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private final IContratService contratService;

    // http://localhost:8081/projet/contrat/retrieve-all-contrats
    @GetMapping("/retrieve-all-contrats")
    public List<ContratDTO> getContrats() {
        return contratService.getAllContrat().stream()
                .map(ContratDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/contrat/retrieve-contrat/1
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public ContratDTO retrieveContrat(@PathVariable("contrat-id") Long idContrat) {
        return ContratDTO.fromEntity(contratService.getContratById(idContrat));
    }

    // http://localhost:8081/projet/contrat/add-contrat
    @PostMapping("/add-contrat")
    public ContratDTO addContrat(@RequestBody ContratDTO dto) {
        return ContratDTO.fromEntity(contratService.saveContrat(dto.toEntity()));
    }

    // http://localhost:8081/projet/contrat/modify-contrat
    @PutMapping("/modify-contrat")
    public ContratDTO modifyContrat(@RequestBody ContratDTO dto) {
        return ContratDTO.fromEntity(contratService.saveContrat(dto.toEntity()));
    }

    // http://localhost:8081/projet/contrat/remove-contrat/1
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long idContrat) {
        contratService.deleteContrat(idContrat);
    }

    // http://localhost:8081/projet/contrat/affecterReservation/1/2
    @PutMapping("/affecterReservation/{idContrat}/{idReservation}")
    public void affecterReservation(
            @PathVariable Long idContrat,
            @PathVariable Long idReservation) {
        contratService.affecterContratReservation(idContrat, idReservation);
    }

    // http://localhost:8081/projet/contrat/reservation/2/contrat/1
    @DeleteMapping("/reservation/{reservation-id}/contrat/{contrat-id}")
    public void retirerContrat(
            @PathVariable("reservation-id") Long idReservation,
            @PathVariable("contrat-id") Long idContrat) {

        // ⚠️ idReservation n'est pas utilisé dans la logique actuelle
        // (setReservation(null) supprime toute réservation du contrat)
        contratService.retirerReservationDeContrat(idContrat);
    }
}