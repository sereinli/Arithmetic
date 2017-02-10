package me.rain.android.arithmetic.strategy;

/**
 * Created by serein on 2017/2/10.
 */

public class FullCut implements Sale {
    @Override
    public double calcPrice(double price, double arg1, double arg2) {
        double after = price - ((int)(price / arg1) * arg2);
        System.out.println(price + "满" + arg1+ "减" + arg2 + "后：" + after);
        return after;
    }
}
