package 收銀機系統.策略模式;

// 正常平台幣收費策略
public class NormalChargingStrategy implements ChargingStrategy {
    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        return originalPrice;
    }
}
