package 收銀機系統.工廠模式;

import 收銀機系統.策略模式.ChargingStrategy;
import 收銀機系統.策略模式.NewVIPDiscountStrategy;
import 收銀機系統.策略模式.NormalChargingStrategy;
import 收銀機系統.策略模式.PointsDiscountStrategy;
import 收銀機系統.策略模式.VIPChargingStrategy;

public class ChargingStrategyFactory {
    public static ChargingStrategy getStrategy(String type, double pointToCurrencyRate) {

        switch (type) {
            case "NORMAL":
                return new NormalChargingStrategy();
            case "VIP":
                return new VIPChargingStrategy();
            case "POINTS":
                return new PointsDiscountStrategy(pointToCurrencyRate);
            case "NEW_VIP":
                return new NewVIPDiscountStrategy(pointToCurrencyRate);
            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }

    }
}
