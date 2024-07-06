package 收銀機系統.裝飾者模式;

import 收銀機系統.策略模式.ChargingStrategy;

public class Cashier {
    private ChargingStrategy strategy;

    public void setStrategy(ChargingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFinalPrice(double originalPrice, int points, int vipLevel) {
        return strategy.calculatePrice(originalPrice, points, vipLevel);
    }

    public static void main(String[] args) {
        double originalPrice = 1000.0;
        int points = 100;
        int vipLevel = 2;

        // 使用裝飾者模式組合策略
        ChargingStrategy baseStrategy = new BaseChargingStrategy();
        ChargingStrategy vipStrategy = new VIPDiscountDecorator(baseStrategy);
        ChargingStrategy combinedStrategy = new PointsDiscountDecorator(vipStrategy, 1.0);

        Cashier cashier = new Cashier();
        cashier.setStrategy(combinedStrategy);
        System.out.println("Combined Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));
    }
}
