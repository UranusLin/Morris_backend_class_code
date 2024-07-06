package 收銀機系統.策略模式;

// 定義收費策略介面
public interface ChargingStrategy {
    double calculatePrice(double originalPrice, int points, int vipLevel);
}