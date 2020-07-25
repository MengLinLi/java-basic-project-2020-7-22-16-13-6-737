package com.thoughtworks.basic.reditcard;

import java.math.BigDecimal;
import java.util.List;

public class CreditCardPoints {
    private List<Consume> consumes;

    public CreditCardPoints(List<Consume> consumes) {
        this.consumes=consumes;
    }
    public String calculationPoints() {
        String Pointstotal = "总积分：";
        String resultContent = "";
        BigDecimal points = new BigDecimal(0);
        CalculatePoints calculatePoints=new CalculatePoints();
        for (Consume consume :consumes){
            calculatePoints.countPoints(consume);
            if ("goldcardUser".equals(consume.getCustomType())){
                consume.setInitialPoints(consume.getInitialPoints().add(consume.getInitialPoints().multiply(new BigDecimal(0.5))));
                consume.setInitialPoints(consume.getInitialPoints().setScale(0,BigDecimal.ROUND_DOWN));
            }
            points = points.add(consume.getInitialPoints());
            resultContent = resultContent+"\n"+consume.getConsumTime()+" "+consume.getConsumMode()+" "+consume.getConsumAmount()+"元，"+"积分 +"+consume.getInitialPoints();
        }
        Pointstotal = Pointstotal+ points +resultContent;
        return Pointstotal;
    }
}
