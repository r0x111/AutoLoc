package tn.esprit.project1.services;

import tn.esprit.project1.models.Client;

import java.util.List;

public interface IClientService {

    Client saveClient(Client client);

    void deleteClient(Long idClient);

    Client getClientById(Long idClient);

    List<Client> getAllClient();
}
