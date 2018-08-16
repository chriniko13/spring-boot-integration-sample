package com.chriniko.springbootintegrationsample.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Uppercaser {

    public boolean shouldUppercase() {

        double randomValue = ThreadLocalRandom.current().nextDouble(0.1, 1.0);

        BigDecimal randomValueBD = BigDecimal.valueOf(randomValue)
                .round(new MathContext(2, RoundingMode.FLOOR));

        return randomValueBD.compareTo(BigDecimal.valueOf(0.4D)) <= 0;
    }

}
