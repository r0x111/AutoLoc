package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.ClientDTO;
import tn.esprit.project1.services.IClientService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    private final IClientService clientService;

    // http://localhost:8081/projet/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<ClientDTO> getClients() {
        return clientService.getAllClient().stream()
                .map(ClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/client/retrieve-client/1
    @GetMapping("/retrieve-client/{client-id}")
    public ClientDTO retrieveClient(@PathVariable("client-id") Long idClient) {
        return ClientDTO.fromEntity(clientService.getClientById(idClient));
    }

    // http://localhost:8081/projet/client/add-client
    @PostMapping("/add-client")
    public ClientDTO addClient(@RequestBody ClientDTO dto) {
        return ClientDTO.fromEntity(clientService.saveClient(dto.toEntity()));
    }

    // http://localhost:8081/projet/client/modify-client
    @PutMapping("/modify-client")
    public ClientDTO modifyClient(@RequestBody ClientDTO dto) {
        return ClientDTO.fromEntity(clientService.saveClient(dto.toEntity()));
    }

    // http://localhost:8081/projet/client/remove-client/1
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long idClient) {
        clientService.deleteClient(idClient);
    }
}