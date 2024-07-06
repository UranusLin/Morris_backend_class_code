package 收銀機系統.裝飾者模式;

import 收銀機系統.策略模式.ChargingStrategy;

public class BaseChargingStrategy implements ChargingStrategy {
    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        return originalPrice;
    }
}
