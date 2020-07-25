package com.thoughtworks.basic.reditcard;

import java.math.BigDecimal;

public class CreditCardInstallment implements CalculatePoints {
    @Override
    public void countPoints(Consume consume) {
        if ("信用卡分期购物消费".equals(consume.getConsumMode())) {
            BigDecimal count = consume.getConsumAmount().divideToIntegralValue(new BigDecimal(10));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
            if (consume.getConsumAmount().compareTo(new BigDecimal(5000))==1)
                consume.addBigDecimal(new BigDecimal(100));
        }
    }
}
