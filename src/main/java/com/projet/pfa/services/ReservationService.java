package com.projet.pfa.services;

import com.projet.pfa.collections.Reservation;
import com.projet.pfa.collections.Stadium;

import java.util.List;

public interface ReservationService {
    String save(Reservation res);

    Reservation getReservationById(String id);

    String update(String id, Reservation res);

    void delete(String id);

    List<Reservation> getAll();
}
