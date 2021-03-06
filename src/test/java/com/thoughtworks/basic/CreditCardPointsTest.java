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

    @Test
    public void should_return_20_when_given_normal_user_pos_amont_208(){
        //given
        Consume consume = new Consume("POS机消费",new BigDecimal(208),"normal","2020-07-02 18:40");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardIntegral = new CreditCardPoints(consumes);
        //when
        String  result=creditCardIntegral.calculationPoints();
        //then
        Assert.assertEquals("总积分：20\n" +
                "2020-07-02 18:40 POS机消费 208元，积分 +20",result);
    }

    @Test
    public void should_return_30_when_given_normal_user_pos_amont_8_108_208(){
        //given
        Consume consume1 = new Consume("POS机消费",new BigDecimal(8),"normal","2020-07-02 18:50");
        Consume consume2 = new Consume("POS机消费",new BigDecimal(108),"normal","2020-07-02 18:40");
        Consume consume3 = new Consume("POS机消费",new BigDecimal(208),"normal","2020-07-02 18:40");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume1);
        consumes.add(consume2);
        consumes.add(consume3);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：30\n" +
                "2020-07-02 18:50 POS机消费 8元，积分 +0\n"+
                "2020-07-02 18:40 POS机消费 108元，积分 +10\n"+
                "2020-07-02 18:40 POS机消费 208元，积分 +20",result);
    }


    @Test
    public void should_return_1_when_given_normal_user_Wechat_amont_25(){
        //given
        Consume consume = new Consume("微信支付消费",new BigDecimal(25),"normal","2020-07-02 08:20");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：1\n" +
                "2020-07-02 08:20 微信支付消费 25元，积分 +1",result);
    }
    @Test
    public void should_return_1_when_given_normal_user_Wechat_amont_25_10(){
        //given
        Consume consume1 = new Consume("微信支付消费",new BigDecimal(25),"normal","2020-07-02 08:20");
        Consume consume2 = new Consume("微信支付消费",new BigDecimal(10),"normal","2020-07-02 08:35");

        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume1);
        consumes.add(consume2);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals( "总积分：1\n" +
                "2020-07-02 08:20 微信支付消费 25元，积分 +1\n"+
                "2020-07-02 08:35 微信支付消费 10元，积分 +0",result);
    }
    @Test
    public void should_return_32_when_given_normal_user_pos_amont_25_18_108_10_22_208(){
        //given
        Consume consume1 = new Consume("微信支付消费",new BigDecimal(25),"normal","2020-07-01 12:20");
        Consume consume2 = new Consume("微信支付消费",new BigDecimal(18),"normal","2020-07-01 12:50");
        Consume consume3 = new Consume("POS机消费",new BigDecimal(108),"normal","2020-07-01 18:50");
        Consume consume4 = new Consume("微信支付消费",new BigDecimal(10),"normal","2020-07-02 08:20");
        Consume consume5 = new Consume("微信支付消费",new BigDecimal(22),"normal","2020-07-02 12:20");
        Consume consume6 = new Consume("POS机消费",new BigDecimal(208),"normal","2020-07-02 18:50");

        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume1);
        consumes.add(consume2);
        consumes.add(consume3);
        consumes.add(consume4);
        consumes.add(consume5);
        consumes.add(consume6);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：32\n" +
                "2020-07-01 12:20 微信支付消费 25元，积分 +1\n"+
                "2020-07-01 12:50 微信支付消费 18元，积分 +0\n"+
                "2020-07-01 18:50 POS机消费 108元，积分 +10\n"+
                "2020-07-02 08:20 微信支付消费 10元，积分 +0\n"+
                "2020-07-02 12:20 微信支付消费 22元，积分 +1\n"+
                "2020-07-02 18:50 POS机消费 208元，积分 +20" ,result);
    }

    @Test
    public void should_return_320_when_given_normal_user_pos_amont_2208(){
        //given
        Consume consume = new Consume("快捷支付消费",new BigDecimal(2208),"normal","2020-07-02 22:30");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals( "总积分：320\n" +
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320",result);
    }
    @Test
    public void should_return_340_when_given_normal_user_pos_amont_208_2208(){
        //given
        Consume consume1 = new Consume("快捷支付消费",new BigDecimal(2208),"normal","2020-07-02 22:30");
        Consume consume2 = new Consume("POS机消费",new BigDecimal(208),"normal","2020-07-02 18:50");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume1);
        consumes.add(consume2);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals( "总积分：340\n" +
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320\n"+
                "2020-07-02 18:50 POS机消费 208元，积分 +20" ,result);
    }

    @Test
    public void should_return_382_when_given_normal_user_pos_amont_2208_208_208_22_more(){
        //given
        Consume consume1 = new Consume("快捷支付消费",new BigDecimal(2208),"normal","2020-07-02 22:30");
        Consume consume2 = new Consume("快捷支付消费",new BigDecimal(208),"normal","2020-07-02 20:30");
        Consume consume3 = new Consume("POS机消费",new BigDecimal(208),"normal","2020-07-02 18:50");
        Consume consume4 = new Consume("微信支付消费",new BigDecimal(22),"normal","2020-07-02 12:20");
        Consume consume5 = new Consume("微信支付消费",new BigDecimal(10),"normal","2020-07-02 08:20");
        Consume consume6 = new Consume("POS机消费",new BigDecimal(108),"normal","2020-07-01 18:50");
        Consume consume7 = new Consume("微信支付消费",new BigDecimal(18),"normal","2020-07-01 12:50");
        Consume consume8 = new Consume("微信支付消费",new BigDecimal(25),"normal","2020-07-01 12:20");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume1);
        consumes.add(consume2);
        consumes.add(consume3);
        consumes.add(consume4);
        consumes.add(consume5);
        consumes.add(consume6);
        consumes.add(consume7);
        consumes.add(consume8);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：382\n" +
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320\n" +
                "2020-07-02 20:30 快捷支付消费 208元，积分 +30\n" +
                "2020-07-02 18:50 POS机消费 208元，积分 +20\n" +
                "2020-07-02 12:20 微信支付消费 22元，积分 +1\n" +
                "2020-07-02 08:20 微信支付消费 10元，积分 +0\n" +
                "2020-07-01 18:50 POS机消费 108元，积分 +10\n" +
                "2020-07-01 12:50 微信支付消费 18元，积分 +0\n" +
                "2020-07-01 12:20 微信支付消费 25元，积分 +1",result);
    }

    @Test
    public void should_return_740_when_given_normal_user_pos_amont_6400(){
        //given
        Consume consume = new Consume("信用卡分期购物消费",new BigDecimal(6400),"normal","2020-07-02 23:00");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：740\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元，积分 +740",result);
    }
    @Test
    public void should_return_1060_when_given_normal_user_pos_amont_6400_2208(){
        //given
        Consume consume1 = new Consume("信用卡分期购物消费",new BigDecimal(6400),"normal","2020-07-02 23:00");
        Consume consume2 = new Consume("快捷支付消费",new BigDecimal(2208),"normal","2020-07-02 22:30");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume1);
        consumes.add(consume2);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：1060\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元，积分 +740\n"+
                "2020-07-02 22:30 快捷支付消费 2208元，积分 +320",result);
    }

    @Test
    public void should_return_440_when_given_normal_goldCardUser_pos_amont_4400(){
        //given
        Consume consume = new Consume("信用卡分期购物消费",new BigDecimal(4400) ,"goldcardUser","2020-07-02 23:00");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：660\n" +
                "2020-07-02 23:00 信用卡分期购物消费 4400元，积分 +660",result);
    }

    @Test
    public void should_return_1060_when_given_normal_goldCardUser_pos_amont_6400(){
        //given
        Consume consume = new Consume("信用卡分期购物消费",new BigDecimal(6400),"goldcardUser","2020-07-02 23:00");
        List<Consume> consumes = new ArrayList<>();
        consumes.add(consume);
        CreditCardPoints creditCardPoints = new CreditCardPoints(consumes);
        //when
        String  result=creditCardPoints.calculationPoints();
        //then
        Assert.assertEquals("总积分：1060\n" +
                "2020-07-02 23:00 信用卡分期购物消费 6400元，积分 +1060",result);
    }
}



