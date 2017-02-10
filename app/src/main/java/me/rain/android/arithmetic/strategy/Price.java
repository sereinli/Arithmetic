package me.rain.android.arithmetic.strategy;

/**
 * 策略模式
 * Created by serein on 2017/2/10.
 */

public class Price {

    private Sale mSale;

    public Price(Sale sale) {
        mSale = sale;
    }

    public double finalPrice(double price, double arg1, double arg2) {
        return mSale.calcPrice(price, arg1, arg2);
    }
}
