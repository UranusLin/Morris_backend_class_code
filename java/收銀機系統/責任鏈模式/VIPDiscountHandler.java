package 收銀機系統.責任鏈模式;

public class VIPDiscountHandler extends ChargingHandler  {
    @Override
    public double handle(double originalPrice, int points, int vipLevel) {
        double discount = 1.0;
        switch (vipLevel) {
            case 1: discount = 0.95; break;
            case 2: discount = 0.9; break;
            case 3: discount = 0.85; break;
        }
        double price = originalPrice * discount;
        if (nextHandler != null) {
            return nextHandler.handle(price, points, vipLevel);
        }
        return price;
    }
}
