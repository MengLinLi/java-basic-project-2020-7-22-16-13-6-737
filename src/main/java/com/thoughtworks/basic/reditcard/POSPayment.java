package com.thoughtworks.basic.reditcard;

import java.math.BigDecimal;

public class POSPayment implements CalculatePoints {
    @Override
    public void countPoints(Consume consume) {
        if ("POS机消费".equals(consume.getConsumMode())) {
            BigDecimal count = consume.getConsumAmount().divideToIntegralValue(new BigDecimal(10));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
        }
    }
}
