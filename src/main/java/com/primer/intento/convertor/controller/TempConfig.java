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

        if (request.getCurrentUnit().equals(request.getUnitToChange())) {
            result = tempHandler.sameUnit(tempToChange);
        } else {
            switch (request.getCurrentUnit()) {
                case "Celsius":
                    switch (request.getUnitToChange()) {
                        case "Fahrenheit":
                            result = tempHandler.CToF(tempToChange);
                            break;
                        case "Kelvin":
                            result = tempHandler.CToK(tempToChange);
                            break;
                    }
                    break;
                case "Fahrenheit":
                    switch (request.getUnitToChange()) {
                        case "Celsius":
                            result = tempHandler.FToC(tempToChange);
                            break;
                        case "Kelvin":
                            result = tempHandler.FToK(tempToChange);
                            break;
                    }
                    break;
                case "Kelvin":
                    switch (request.getUnitToChange()) {
                        case "Celsius":
                            result = tempHandler.KToC(tempToChange);
                            break;
                        case "Fahrenheit":
                            result = tempHandler.KToF(tempToChange);
                            break;
                    }
                    break;
            }
        }
//        Rounding to decimals and casting to String
        temp = String.valueOf(decimalFormat.format(result));

        return Response.builder()
                .temp(temp)
                .tempUnit(request.getUnitToChange())
                .build();
    }
}
