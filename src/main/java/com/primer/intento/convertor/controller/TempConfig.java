package com.primer.intento.convertor.controller;

import com.primer.intento.convertor.manager.TempHandler;
import com.primer.intento.convertor.model.Request;
import com.primer.intento.convertor.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@RestController
public class TempConfig {
    @Autowired
    TempHandler tempHandler;
    private String temp;
    private String unit;

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.0");

    @PostMapping(value = "/tmp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response convertTemperature(@RequestBody Request request) {

        tempHandler = new TempHandler();

        double tempToChange = Double.parseDouble(request.getValue());
        double result = 0;

        if (request.getCurrentUnit().startsWith("C")) {
            if (request.getUnitToChange().startsWith("F")) {
                result = tempHandler.CToF(tempToChange);
            } else {
                result = tempHandler.CToK(tempToChange);
            }
        }

        if (request.getCurrentUnit().startsWith("F")) {
            if (request.getUnitToChange().startsWith("C")) {
                result = tempHandler.FToC(tempToChange);
            } else {
                result = tempHandler.FToK(tempToChange);
            }
        }

        if (request.getCurrentUnit().startsWith("K")) {
            if (request.getUnitToChange().startsWith("C")) {
                result = tempHandler.KToC(tempToChange);
            } else {
                result = tempHandler.KToF(tempToChange);
            }
        }

        if (request.getCurrentUnit().equals(request.getUnitToChange())) {
            result = tempHandler.sameUnit(tempToChange);
        }

//        Rounding to decimals and casting to String
        temp = String.valueOf(decimalFormat.format(result));

        return Response.builder()
                .temp(temp)
                .tempUnit(request.getUnitToChange())
                .build();
    }
}
