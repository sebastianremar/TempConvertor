package com.primer.intento.convertor.manager;

import org.springframework.stereotype.Component;

@Component
public class TempHandler implements TempConversion {
    @Override
    public double CToF(double currentTemp) {
        return (currentTemp * 1.8) + 32;
    }

    @Override
    public double CToK(double currentTemp) {
        return currentTemp + 273.15;
    }

    @Override
    public double FToC(double currentTemp) {
        return (( 5 *(currentTemp - 32.0)) / 9.0);
    }

    @Override
    public double FToK(double currentTemp) {
        return (currentTemp - 32) * 5/9 + 273.15;
    }

    @Override
    public double KToC(double currentTemp) {
        return currentTemp - 273.15;
    }

    @Override
    public double KToF(double currentTemp) {
        return (currentTemp - 273.15) * 9/5 + 32;
    }

    @Override
    public double sameUnit(double currentTemp) {
        return currentTemp;
    }
}
