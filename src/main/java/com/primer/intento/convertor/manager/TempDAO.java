package com.primer.intento.convertor.manager;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TempDAO {
    private double temp;
    private String tempUnit;
}
