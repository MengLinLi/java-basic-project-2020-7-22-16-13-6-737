package com.thoughtworks.basic.reditcard;

import java.math.BigDecimal;

public class ExpressPayment implements  CalculatePoints{
    @Override
    public void countPoints(Consume consume) {
        if ("快捷支付消费".equals(consume.getConsumMode())) {
            BigDecimal count = consume.getConsumAmount().divideToIntegralValue(new BigDecimal(10));
            consume.addBigDecimal(count.multiply(new BigDecimal(1)));
            BigDecimal extralCount = consume.getConsumAmount().divideToIntegralValue(new BigDecimal(100));
            if (extralCount.compareTo(new BigDecimal(20))==1) extralCount=new BigDecimal(20);
            consume.addBigDecimal(extralCount.multiply(new BigDecimal(5)));
        }
    }
}
