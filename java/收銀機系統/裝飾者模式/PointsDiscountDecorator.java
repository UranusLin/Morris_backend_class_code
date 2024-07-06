package 收銀機系統.裝飾者模式;

import 收銀機系統.策略模式.ChargingStrategy;

public class PointsDiscountDecorator extends ChargingStrategyDecorator {
    private double pointToCurrencyRate;

    public PointsDiscountDecorator(ChargingStrategy decoratedStrategy, double pointToCurrencyRate) {
        super(decoratedStrategy);
        this.pointToCurrencyRate = pointToCurrencyRate;
    }

    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        double price = decoratedStrategy.calculatePrice(originalPrice, points, vipLevel);
        double discount = points * pointToCurrencyRate;
        return price - discount;
    }
}
