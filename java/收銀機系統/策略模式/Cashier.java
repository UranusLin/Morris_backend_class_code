package 收銀機系統.策略模式;

public class Cashier {
    private ChargingStrategy strategy;

    public void setStrategy(ChargingStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFinalPrice(double originalPrice, int points, int vipLevel) {
        return strategy.calculatePrice(originalPrice, points, vipLevel);
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier();

        double originalPrice = 1000.0;
        int points = 100;
        int vipLevel = 2;

        // 正常收費
        cashier.setStrategy(new NormalChargingStrategy());
        System.out.println("Normal Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        // VIP優惠收費
        cashier.setStrategy(new VIPChargingStrategy());
        System.out.println("VIP Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        // 點數折抵
        cashier.setStrategy(new PointsDiscountStrategy(1.0));
        System.out.println("Points Discount Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));

        // 新的VIP折扣模式
        cashier.setStrategy(new NewVIPDiscountStrategy(1.0));
        System.out.println("New VIP Discount Price: " + cashier.calculateFinalPrice(originalPrice, points, vipLevel));
    }
}