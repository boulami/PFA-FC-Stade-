package com.projet.pfa.collections;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "stadium")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stadium {
    @Id
    private String id;
    private String name;
    private String address;
}
