package 收銀機系統.責任鏈模式;

public abstract class ChargingHandler {
    protected ChargingHandler nextHandler;

    public void setNextHandler(ChargingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract double handle(double originalPrice, int points, int vipLevel);
}
