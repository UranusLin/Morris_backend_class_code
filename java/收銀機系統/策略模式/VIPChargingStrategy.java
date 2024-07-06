package 收銀機系統.策略模式;

// VIP優惠收費策略
public class VIPChargingStrategy implements ChargingStrategy {
    @Override
    public double calculatePrice(double originalPrice, int points, int vipLevel) {
        double discount = 1.0;
        switch (vipLevel) {
            case 1: discount = 0.95; break;
            case 2: discount = 0.9; break;
            case 3: discount = 0.85; break;
            case 4: discount = 0.8; break;
        }
        return originalPrice * discount;
    }
}
