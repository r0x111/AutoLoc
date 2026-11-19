package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.EmployeDTO;
import tn.esprit.project1.services.IEmployeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeRestController {

    private final IEmployeService employeService;

    // http://localhost:8081/projet/employe/retrieve-all-employes
    @GetMapping("/retrieve-all-employes")
    public List<EmployeDTO> getEmployes() {
        return employeService.getAllEmploye().stream()
                .map(EmployeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/employe/retrieve-employe/1
    @GetMapping("/retrieve-employe/{employe-id}")
    public EmployeDTO retrieveEmploye(@PathVariable("employe-id") Long idEmploye) {
        return EmployeDTO.fromEntity(employeService.getEmployeById(idEmploye));
    }

    // http://localhost:8081/projet/employe/add-employe
    @PostMapping("/add-employe")
    public EmployeDTO addEmploye(@RequestBody EmployeDTO dto) {
        return EmployeDTO.fromEntity(employeService.saveEmploye(dto.toEntity()));
    }

    // http://localhost:8081/projet/employe/modify-employe
    @PutMapping("/modify-employe")
    public EmployeDTO modifyEmploye(@RequestBody EmployeDTO dto) {
        return EmployeDTO.fromEntity(employeService.saveEmploye(dto.toEntity()));
    }

    // http://localhost:8081/projet/employe/remove-employe/1
    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long idEmploye) {
        employeService.deleteEmploye(idEmploye);
    }

    // http://localhost:8081/projet/employe/affecterAgence/1/2
    @PutMapping("/affecterAgence/{idEmploye}/{idAgence}")
    public void affecterAgence(
            @PathVariable Long idEmploye,
            @PathVariable Long idAgence) {
        employeService.affecterEmployAgence(idEmploye, idAgence);
    }
}