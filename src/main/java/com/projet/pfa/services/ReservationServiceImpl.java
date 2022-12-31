package com.projet.pfa.services;

import com.projet.pfa.collections.Reservation;
import com.projet.pfa.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public String save(Reservation res) {
        return reservationRepository.save(res).getId();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public String update(String id, Reservation res) {
        Reservation reservationToUpdate = reservationRepository.findById(id).get();
        reservationToUpdate.setStadiumId(res.getStadiumId());
        reservationToUpdate.setGestId(res.getGestId());
        reservationToUpdate.setGuestName(res.getGuestName());
        reservationToUpdate.setGuestEmail(res.getGuestEmail());
        reservationToUpdate.setStartDate(res.getStartDate());
        reservationToUpdate.setEndDate(res.getEndDate());
        reservationToUpdate.setGuestEmail(res.getGuestEmail());

        return reservationRepository.save(reservationToUpdate).getGuestName();
    }

    @Override
    public void delete(String id) {
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
                        rsv.getGestId(),
                        rsv.getStartDate(),
                        rsv.getEndDate(),
                        rsv.getGuestName(),
                        rsv.getGuestEmail()
                )).collect(Collectors.toList());
        return reservations;
    }
}
