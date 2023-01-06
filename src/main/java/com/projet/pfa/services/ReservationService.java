package com.projet.pfa.services;

import com.projet.pfa.collections.Reservation;
import com.projet.pfa.collections.Stadium;

import java.util.List;
import java.util.Map;

public interface ReservationService {
    String save(Reservation res);

    Reservation getReservationById(String id);

    List<Map<String, String>> getReservationTimes(String id);

    String update(String id, Reservation res);

    void delete(String id);

    List<Reservation> getAll();
}
