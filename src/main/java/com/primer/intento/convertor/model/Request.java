package com.primer.intento.convertor.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
    private String value;
    private String currentUnit;
    private String unitToChange;
}
