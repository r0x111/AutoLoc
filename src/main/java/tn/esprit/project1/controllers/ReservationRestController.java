package tn.esprit.project1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.project1.dto.ReservationDTO;
import tn.esprit.project1.services.IReservationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    private final IReservationService reservationService;

    // http://localhost:8081/projet/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<ReservationDTO> getReservations() {
        return reservationService.getAllReservation().stream()
                .map(ReservationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // http://localhost:8081/projet/reservation/retrieve-reservation/1
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public ReservationDTO retrieveReservation(@PathVariable("reservation-id") Long idReservation) {
        return ReservationDTO.fromEntity(reservationService.getReservationById(idReservation));
    }

    // http://localhost:8081/projet/reservation/add-reservation
    @PostMapping("/add-reservation")
    public ReservationDTO addReservation(@RequestBody ReservationDTO dto) {
        return ReservationDTO.fromEntity(reservationService.saveReservation(dto.toEntity()));
    }

    // http://localhost:8081/projet/reservation/modify-reservation
    @PutMapping("/modify-reservation")
    public ReservationDTO modifyReservation(@RequestBody ReservationDTO dto) {
        return ReservationDTO.fromEntity(reservationService.saveReservation(dto.toEntity()));
    }

    // http://localhost:8081/projet/reservation/remove-reservation/1
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    // OPTIONNEL — affecter un client à une réservation
    // PUT /reservation/affecterClient/1/2
    @PutMapping("/affecterClient/{idReservation}/{idClient}")
    public void affecterClient(
            @PathVariable Long idReservation,
            @PathVariable Long idClient) {
        reservationService.affecterReservationClient(idReservation, idClient);
    }

    // OPTIONNEL — affecter un véhicule à une réservation
    // PUT /reservation/affecterVehicule/1/3
    @PutMapping("/affecterVehicule/{idReservation}/{idVehicule}")
    public void affecterVehicule(
            @PathVariable Long idReservation,
            @PathVariable Long idVehicule) {
        reservationService.affecterReservationVehicule(idReservation, idVehicule);
    }
}