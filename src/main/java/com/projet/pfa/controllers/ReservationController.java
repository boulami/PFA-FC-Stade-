package com.projet.pfa.controllers;

import com.projet.pfa.collections.Reservation;
import com.projet.pfa.collections.Stadium;
import com.projet.pfa.repositories.ReservationRepository;
import com.projet.pfa.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;


    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping("/add")
    public String save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping("/getReservation/{id}")
    public Reservation getReservationById(@PathVariable String id){
        return reservationService.getReservationById(id);
    }


    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping("/getAllReservations")
    public List<Reservation> getAllReservations(){
        return reservationService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping("/getReservationTimes/{id}")
    public List<Map<String, String>> getReservationTimes(@PathVariable String id){
        return reservationService.getReservationTimes(id);
    }


    @CrossOrigin(origins = "http://localhost:8082")
    @PutMapping("/update/{id}")
    public String update(@PathVariable String id,
                         @RequestBody Reservation reservation){
        return reservationService.update(id, reservation);
    }


    @CrossOrigin(origins = "http://localhost:8082")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        reservationService.delete(id);
        return "Deleted successfully";
    }
}
