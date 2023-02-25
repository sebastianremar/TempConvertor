package com.primer.intento.convertor;

import com.primer.intento.convertor.controller.TempConfig;
import com.primer.intento.convertor.model.Request;
import com.primer.intento.convertor.model.Response;
import org.junit.Assert;
import org.junit.Test;


public class TempConfigTests {

    final static String tempC = "Celsius";
    final static String tempF = "Fahrenheit";
    final static String tempK = "Kelvin";

    @Test
    public void sameTemperatureCase() {
        String testTemp = "32";
        Request request = Request.builder()
                .currentUnit(tempC)
                .value(testTemp)
                .unitToChange(tempC)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "32.0");
        Assert.assertEquals(response.getTempUnit(), tempC);
    }

    @Test
    public void CtoK() {
        String testTemp = "40";
        Request request = Request.builder()
                .currentUnit(tempC)
                .value(testTemp)
                .unitToChange(tempK)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "313.1");
        Assert.assertEquals(response.getTempUnit(), tempK);
    }

    @Test
    public void CtoF() {
        String testTemp = "200";
        Request request = Request.builder()
                .currentUnit(tempC)
                .value(testTemp)
                .unitToChange(tempF)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "392.0");
        Assert.assertEquals(response.getTempUnit(), tempF);
    }

    @Test
    public void KtoC() {
        String testTemp = "300";
        Request request = Request.builder()
                .currentUnit(tempK)
                .value(testTemp)
                .unitToChange(tempC)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "26.9");
        Assert.assertEquals(response.getTempUnit(), tempC);
    }

    @Test
    public void KtoF() {
        String testTemp = "100";
        Request request = Request.builder()
                .currentUnit(tempK)
                .value(testTemp)
                .unitToChange(tempF)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "-279.7");
        Assert.assertEquals(response.getTempUnit(), tempF);
    }

    @Test
    public void FtoC(){
        String testTemp = "50";
        Request request = Request.builder()
                .currentUnit(tempF)
                .value(testTemp)
                .unitToChange(tempC)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "10.0");
        Assert.assertEquals(response.getTempUnit(), tempC);
    }

    @Test
    public void FtoK() {
        String testTemp = "180";
        Request request = Request.builder()
                .currentUnit(tempF)
                .value(testTemp)
                .unitToChange(tempK)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "355.4");
        Assert.assertEquals(response.getTempUnit(), tempK);
    }
}
