package com.projet.pfa.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@Document(collection = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reservation {
    @Id
    private String id;

    private String stadiumId;

    private String day;

    private String time;

    private String guestName;

    private String guestEmail;

    public Reservation(String stadiumId, String day, String time, String guestName, String guestEmail) {
        this.stadiumId = stadiumId;
        this.day = day;
        this.time = time;
        this.guestName = guestName;
        this.guestEmail = guestEmail;
    }
}
