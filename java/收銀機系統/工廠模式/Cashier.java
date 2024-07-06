package 收銀機系統.工廠模式;

import 收銀機系統.策略模式.ChargingStrategy;

public class Cashier {
    private ChargingStrategy strategy;

    public void setStrategy(String type, double pointToCurrencyRate) {
        this.strategy = ChargingStrategyFactory.getStrategy(type, pointToCurrencyRate);
    }

    public void setStrategy(StrategyEnum strategyEnum, double pointToCurrencyRate) {
        this.strategy = strategyEnum.getStrategy(pointToCurrencyRate);
    }

    public double calculateFinalPrice(double originalPrice, int points, int vipLevel) {
        return strategy.calculatePrice(originalPrice, points, vipLevel);
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier();

        double originalPrice = 1000.0;
        int points = 100;
        int vipLevel = 2;
        double pointToCurrencyRate = 1.0;

        // 使用工廠模式設定策略
        cashier.setStrategy("NORMAL", pointToCurrencyRate);
        System.out.println("Normal Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        cashier.setStrategy("VIP", pointToCurrencyRate);
        System.out.println("VIP Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        cashier.setStrategy("POINTS", pointToCurrencyRate);
        System.out.println("Points Discount Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        cashier.setStrategy("NEW_VIP", pointToCurrencyRate);
        System.out.println("New VIP Discount Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));
   
        // 使用Enum
        cashier.setStrategy(StrategyEnum.NORMAL, pointToCurrencyRate);
        System.out.println(StrategyEnum.NORMAL.getShowText() + " Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        cashier.setStrategy(StrategyEnum.VIP, pointToCurrencyRate);
        System.out.println(StrategyEnum.VIP.getShowText() + " Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        cashier.setStrategy(StrategyEnum.POINTS, pointToCurrencyRate);
        System.out.println(StrategyEnum.POINTS.getShowText() + " Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        cashier.setStrategy(StrategyEnum.NEW_VIP, pointToCurrencyRate);
        System.out.println(StrategyEnum.NEW_VIP.getShowText() + " Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

    }
}
