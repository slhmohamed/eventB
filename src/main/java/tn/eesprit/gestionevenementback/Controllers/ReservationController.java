package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Facture;
import tn.eesprit.gestionevenementback.Entities.Reservation;
import tn.eesprit.gestionevenementback.Exception.ResourceNotFoundException;
import tn.eesprit.gestionevenementback.Services.IReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*", maxAge = 3600)

public class ReservationController {
    private final IReservationService iReservationService;


    @PostMapping("/user/{userId}/reservation/{eventId}")
    Reservation affecteReservatioToUser(@PathVariable (value="userId") Long userId,
                                        @PathVariable (value="eventId") Long eventId
                                        )
    {
         return iReservationService.affecteReservatioToUser(eventId,userId) ;
    }

    @GetMapping("/users/reservations")
    public ResponseEntity<List<Reservation>> getAllReservation()   {


        return new ResponseEntity<>(iReservationService.retrieveAllReservations(), HttpStatus.OK);
    }


}
