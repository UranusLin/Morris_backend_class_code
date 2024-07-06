package 收銀機系統.責任鏈模式;

public class PointsDiscountHandler extends ChargingHandler {
    private double pointToCurrencyRate;

    public PointsDiscountHandler(double pointToCurrencyRate) {
        this.pointToCurrencyRate = pointToCurrencyRate;
    }

    @Override
    public double handle(double originalPrice, int points, int vipLevel) {
        double discount = points * pointToCurrencyRate;
        double price = originalPrice - discount;
        if (nextHandler != null) {
            return nextHandler.handle(price, points, vipLevel);
        }
        return price;
    }
}
