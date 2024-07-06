package 收銀機系統.策略模式;

// 點數折抵策略
public class PointsDiscountStrategy implements ChargingStrategy {
    private double pointToCurrencyRate;

    public PointsDiscountStrategy(double pointToCurrencyRate) {
        this.pointToCurrencyRate = pointToCurrencyRate;
    }

    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        double discount = points * pointToCurrencyRate;
        return originalPrice - discount;
    }
}