package 收銀機系統.責任鏈模式;

public class BaseHandler extends ChargingHandler {
    @Override
    public double handle(double originalPrice, int points, int vipLevel) {
        if (nextHandler != null) {
            return nextHandler.handle(originalPrice, points, vipLevel);
        }
        return originalPrice;
    }
}
