package com.thoughtworks.basic;

import com.thoughtworks.basic.reditcard.Consume;
import com.thoughtworks.basic.reditcard.CreditCardPoints;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCardPointsTest {
    @Test
    public void should_return_0_when_given_normal_user_pos_consum_8(){
        //given
        Consume consume = new Consume("POS机消费",new BigDecimal(8),"normal","2020-07-02 18:50");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：0\n" +
                "2020-07-02 18:50 POS机消费 8元，积分 +0",result);

    }
    @Test
    public void should_return_10_when_given_normal_user_pos_amont_108(){
        //given
        Consume consume = new Consume("POS机消费",new BigDecimal(108),"normal","2020-07-02 18:40");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardIntegral = new CreditCardPoints(consumes);
        //when
        String  result=creditCardIntegral.calculationPoints();
        //then
        Assert.assertEquals("总积分：10\n" +
                "2020-07-02 18:40 POS机消费 108元，积分 +10",result);
    }



}



