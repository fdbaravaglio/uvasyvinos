package com.uvasyvinos.ar.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Element {
    @JsonProperty("DESIGN")
    private String designation;

    @JsonProperty("RUTINA")
    private String routine;

    @JsonProperty("TIPANA")
    private String type;

}
