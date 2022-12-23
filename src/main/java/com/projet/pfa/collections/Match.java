package com.projet.pfa.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "match")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {
    @Id
    private String id;
    private Date date;
    private Stadium stade;
}
