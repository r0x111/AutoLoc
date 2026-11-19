package tn.esprit.project1.services;

import org.springframework.stereotype.Service;
import tn.esprit.project1.models.Client;
import tn.esprit.project1.repositories.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }

    @Override
    public Client getClientById(Long idClient) {
        return clientRepository.findById(idClient).orElse(null);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }
}
