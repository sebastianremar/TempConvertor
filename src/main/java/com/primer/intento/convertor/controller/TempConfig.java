package com.primer.intento.convertor.controller;

import com.primer.intento.convertor.manager.TempHandler;
import com.primer.intento.convertor.model.Request;
import com.primer.intento.convertor.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TempConfig {
    @Autowired
    TempHandler tempHandler;
    private String temp;
    private String unit;

    @PostMapping(value = "/tmp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response convertTemperature(@RequestBody Request request) {

        tempHandler = new TempHandler();

        double tempToChange = Double.parseDouble(request.getValue());

        if (request.getCurrentUnit().startsWith("C")) {
            if (request.getUnitToChange().startsWith("F")) {
                temp = String.valueOf(tempHandler.CToF(tempToChange));
            } else {
                temp = String.valueOf(tempHandler.CToK(tempToChange));
            }
        }

        if (request.getCurrentUnit().startsWith("F")) {
            if (request.getUnitToChange().startsWith("C")) {
                temp = String.valueOf(tempHandler.FToC(tempToChange));
            } else {
                temp = String.valueOf(tempHandler.FToK(tempToChange));
            }
        }

        if (request.getCurrentUnit().startsWith("K")) {
            if (request.getUnitToChange().startsWith("C")) {
                temp = String.valueOf(tempHandler.KToC(tempToChange));
            } else {
                temp = String.valueOf(tempHandler.KToF(tempToChange));
            }
        }
        return Response.builder()
                .temp(temp)
                .tempUnit(request.getUnitToChange())
                .build();
    }
}
