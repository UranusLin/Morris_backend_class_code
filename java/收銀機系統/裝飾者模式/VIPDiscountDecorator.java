package 收銀機系統.裝飾者模式;

import 收銀機系統.策略模式.ChargingStrategy;

public class VIPDiscountDecorator extends ChargingStrategyDecorator {
    public VIPDiscountDecorator(ChargingStrategy decoratedStrategy) {
        super(decoratedStrategy);
    }

    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        double price = decoratedStrategy.calculatePrice(originalPrice, points, vipLevel);
        double discount = 1.0;
        switch (vipLevel) {
            case 1: discount = 0.95; break;
            case 2: discount = 0.9; break;
            case 3: discount = 0.85; break;
        }
        return price * discount;
    }
}
