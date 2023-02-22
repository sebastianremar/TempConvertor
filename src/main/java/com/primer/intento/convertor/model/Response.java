package com.primer.intento.convertor.model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Response {
    private String temp;
    private String tempUnit;
}
