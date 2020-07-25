package com.thoughtworks.basic.reditcard;

import java.math.BigDecimal;

public class Wechat implements CalculatePoints {
    @Override
    public void countPoints(Consume consume) {
        if ("微信支付消费".equals(consume.getConsumMode())) {
            BigDecimal count = consume.getConsumAmount().divideToIntegralValue(new BigDecimal(20));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
        }
    }
}
