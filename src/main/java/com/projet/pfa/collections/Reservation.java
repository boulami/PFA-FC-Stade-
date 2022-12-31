package com.projet.pfa.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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

    private String gestId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String guestName;

    private String guestEmail;
}
