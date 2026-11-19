package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.PaiementDTO;
import tn.esprit.project1.services.IPaiementService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementRestController {

    private final IPaiementService paiementService;

    // http://localhost:8081/projet/paiement/retrieve-all-paiements
    @GetMapping("/retrieve-all-paiements")
    public List<PaiementDTO> getPaiements() {
        return paiementService.getAllPaiement().stream()
                .map(PaiementDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/paiement/retrieve-paiement/1
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public PaiementDTO retrievePaiement(@PathVariable("paiement-id") Long idPaiement) {
        return PaiementDTO.fromEntity(paiementService.getPaiementById(idPaiement));
    }

    // http://localhost:8081/projet/paiement/add-paiement
    @PostMapping("/add-paiement")
    public PaiementDTO addPaiement(@RequestBody PaiementDTO dto) {
        return PaiementDTO.fromEntity(paiementService.savePaiement(dto.toEntity()));
    }

    // http://localhost:8081/projet/paiement/modify-paiement
    @PutMapping("/modify-paiement")
    public PaiementDTO modifyPaiement(@RequestBody PaiementDTO dto) {
        return PaiementDTO.fromEntity(paiementService.savePaiement(dto.toEntity()));
    }

    // http://localhost:8081/projet/paiement/remove-paiement/1
    @DeleteMapping("/remove-paiement/{paiement-id}")
    public void removePaiement(@PathVariable("paiement-id") Long idPaiement) {
        paiementService.deletePaiement(idPaiement);
    }

    // OPTIONNEL — affecter un paiement à un contrat
    // PUT /paiement/affecterContrat/1/2
    @PutMapping("/affecterContrat/{idPaiement}/{idContrat}")
    public void affecterContrat(
            @PathVariable Long idPaiement,
            @PathVariable Long idContrat) {
        paiementService.affecterPaiementContrat(idPaiement, idContrat);
    }
}