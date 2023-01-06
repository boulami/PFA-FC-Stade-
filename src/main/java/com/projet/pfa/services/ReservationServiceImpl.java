package com.projet.pfa.services;

import com.projet.pfa.collections.Reservation;
import com.projet.pfa.collections.Stadium;
import com.projet.pfa.repositories.ReservationRepository;
import com.projet.pfa.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private StadiumService stadiumService;
    @Autowired
    private MongoTemplate mongoTemplate;

    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    @Override
    public String save(Reservation res) {
        reservationRepository.save(res);
        Reservation ress = reservationRepository.findById(res.getId()).get();
        Stadium stadium = stadiumService.getStadeById(ress.getStadiumId());
        System.out.println("sid: "+ ress.getStadiumId());
        //stadium.addReservation(ress);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(ress.getStadiumId()));

        Update update = new Update();
        update.push("reservations", ress);

        mongoTemplate.updateFirst(query, update, Stadium.class);
        System.out.println("res: "+stadium.getReservations());
        return "added successfully";
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Map<String, String>> getReservationTimes(String id) {
        Stadium stadium = stadiumService.getStadeById(id);
        Set<Reservation> reservations = stadium.getReservations();
        return reservations.stream().map(reservation -> {
            Map<String, String> map = new HashMap<>();
            map.put("time", reservation.getTime());
            map.put("day", reservation.getDay());
            return map;
        }).collect(Collectors.toList());
    }

    @Override
    public String update(String id, Reservation res) {
        Reservation reservationToUpdate = reservationRepository.findById(id).get();
        reservationToUpdate.setStadiumId(res.getStadiumId());
        reservationToUpdate.setGuestName(res.getGuestName());
        reservationToUpdate.setGuestEmail(res.getGuestEmail());
        reservationToUpdate.setDay(res.getDay());
        reservationToUpdate.setTime(res.getTime());
        reservationToUpdate.setGuestEmail(res.getGuestEmail());

        return reservationRepository.save(reservationToUpdate).getGuestName();
    }

    @Override
    public void delete(String id) {
        Reservation res = reservationRepository.findById(id).get();
        Stadium stadium = stadiumService.getStadeById(res.getStadiumId());
        stadium.removeReservation(res);
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> reservationEntities = reservationRepository.findAll();
        List<Reservation> reservations = reservationEntities
                .stream()
                .map(rsv -> new Reservation(
                        rsv.getId(),
                        rsv.getStadiumId(),
                        rsv.getDay(),
                        rsv.getTime(),
                        rsv.getGuestName(),
                        rsv.getGuestEmail()
                )).collect(Collectors.toList());
        return reservations;
    }


}
