package 收銀機系統.策略模式;

// 新的VIP折扣模式
public class NewVIPDiscountStrategy implements ChargingStrategy {
    private double pointToCurrencyRate;

    public NewVIPDiscountStrategy(double pointToCurrencyRate) {
        this.pointToCurrencyRate = pointToCurrencyRate;
    }

    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        double discountedPrice = originalPrice;
        if (points >= 100) {
            discountedPrice -= points * pointToCurrencyRate;
            discountedPrice *= 0.9;
        } else {
            discountedPrice -= points * pointToCurrencyRate;
        }
        return discountedPrice;
    }
}
 