package com.primer.intento.convertor;

import com.primer.intento.convertor.controller.TempConfig;
import com.primer.intento.convertor.model.Request;
import com.primer.intento.convertor.model.Response;
import org.junit.Assert;
import org.junit.Test;


public class TempConfigTests {

    @Test
    public void sameTemperatureCase() {
        String testTemp = "32";
        String unit = "Celsius";
        Request request = Request.builder()
                .currentUnit(unit)
                .value(testTemp)
                .unitToChange(unit)
                .build();

        TempConfig tempConfig = new TempConfig();
        Response response = tempConfig.convertTemperature(request);

        Assert.assertEquals(response.getTemp(), "32.0");
        Assert.assertEquals(response.getTempUnit(), "Celsius");
    }
}
