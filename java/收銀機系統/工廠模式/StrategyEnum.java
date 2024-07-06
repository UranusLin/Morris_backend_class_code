package 收銀機系統.工廠模式;

import 收銀機系統.策略模式.ChargingStrategy;
import 收銀機系統.策略模式.NewVIPDiscountStrategy;
import 收銀機系統.策略模式.NormalChargingStrategy;
import 收銀機系統.策略模式.PointsDiscountStrategy;
import 收銀機系統.策略模式.VIPChargingStrategy;

public enum StrategyEnum {
    NORMAL("一般方案") {
        @Override
        public ChargingStrategy getStrategy(double pointToCurrencyRate) {
            return new NormalChargingStrategy();
        }
    },
    VIP("VIP方案") {
        @Override
        public ChargingStrategy getStrategy(double pointToCurrencyRate) {
            return new VIPChargingStrategy();
        }
    },
    POINTS("點數折抵方案") {
        @Override
        public ChargingStrategy getStrategy(double pointToCurrencyRate) {
            return new PointsDiscountStrategy(pointToCurrencyRate);
        }
    },
    NEW_VIP("活動方案") {
        @Override
        public ChargingStrategy getStrategy(double pointToCurrencyRate) {
            return new NewVIPDiscountStrategy(pointToCurrencyRate);
        }
    };

    private String showText;

    StrategyEnum (String showText) {
        this.showText = showText;
    }

    public String getShowText() {
        return this.showText;
    }

    public abstract ChargingStrategy getStrategy(double pointToCurrencyRate);
}
