package com.primer.intento.convertor.model;

import lombok.Data;

@Data
public class Request {
    private String value;
    private String currentUnit;
    private String unitToChange;
}
