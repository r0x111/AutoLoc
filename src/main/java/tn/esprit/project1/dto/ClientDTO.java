package tn.esprit.project1.dto;

import lombok.*;
import tn.esprit.project1.models.Client;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDTO {

    private Long idClient;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    // Entity → DTO
    public static ClientDTO fromEntity(Client client) {
        if (client == null) return null;
        return ClientDTO.builder()
                .idClient(client.getIdClient())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .numPermis(client.getNumPermis())
                .dateInscription(client.getDateInscription())
                .build();
    }

    // DTO → Entity
    public Client toEntity() {
        Client client = new Client();
        client.setIdClient(this.idClient);
        client.setNom(this.nom);
        client.setPrenom(this.prenom);
        client.setEmail(this.email);
        client.setTelephone(this.telephone);
        client.setNumPermis(this.numPermis);
        client.setDateInscription(this.dateInscription);
        return client;
    }
}