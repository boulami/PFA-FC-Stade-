package com.projet.pfa.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "match")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class Match {
    @Id
    private String id;
    private String date;
    private Stadium stade;

    public Match(String date, Stadium stade) {
        this.date = date;
        this.stade = stade;
    }

    public Match() {
    }
}
