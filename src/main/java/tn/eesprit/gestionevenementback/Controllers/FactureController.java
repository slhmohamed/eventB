package tn.eesprit.gestionevenementback.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.eesprit.gestionevenementback.Entities.Facture;
import tn.eesprit.gestionevenementback.Entities.User;
import tn.eesprit.gestionevenementback.Exception.ResourceNotFoundException;
import tn.eesprit.gestionevenementback.Repository.FactureRepository;
import tn.eesprit.gestionevenementback.Repository.UserRepository;
import tn.eesprit.gestionevenementback.Services.IFactureService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/facture")
@CrossOrigin(origins = "*", maxAge = 3600)

public class FactureController {
    private final IFactureService iFactureService;

    @GetMapping("/users/{id}/factures")
    public ResponseEntity<List<Facture>> getAllFactureByUserid(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {


        return new ResponseEntity<>(iFactureService.listFactureByUser(id), HttpStatus.OK);
    }
    @PostMapping("/users/{id}/facture")
    public ResponseEntity<Facture> creatFacture(@PathVariable(value = "id") Long id,
                                                        @RequestBody Facture facture) throws ResourceNotFoundException {


        return new ResponseEntity<>(iFactureService.affecteFactureToUser(facture,id), HttpStatus.CREATED);
    }

}
