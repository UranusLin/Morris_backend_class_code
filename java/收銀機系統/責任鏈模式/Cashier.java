package 收銀機系統.責任鏈模式;

public class Cashier {
    private ChargingHandler handler;

    public void setHandler(ChargingHandler handler) {
        this.handler = handler;
    }

    public double calculateFinalPrice(double originalPrice, int points, int vipLevel) {
        return handler.handle(originalPrice, points, vipLevel);
    }

    public static void main(String[] args) {
        double originalPrice = 1000.0;
        int points = 100;
        int vipLevel = 2;

        // 使用職責鏈模式設置處理器鏈
        ChargingHandler baseHandler = new BaseHandler();
        ChargingHandler vipHandler = new VIPDiscountHandler();
        ChargingHandler pointsHandler = new PointsDiscountHandler(1.0);

        baseHandler.setNextHandler(pointsHandler);
        pointsHandler.setNextHandler(vipHandler);

        Cashier cashier = new Cashier();
        cashier.setHandler(baseHandler);
        System.out.println("Chained Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));
    }
}
