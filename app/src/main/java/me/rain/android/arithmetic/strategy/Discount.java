package me.rain.android.arithmetic.strategy;

/**
 * Created by serein on 2017/2/10.
 */

public class Discount implements Sale {
    @Override
    public double calcPrice(double price, double arg1, double arg2) {
        double after = price * arg1;
        System.out.println(price + "打" + (arg1 * 10)+ "折后：" + after);
        return after;
    }
}
