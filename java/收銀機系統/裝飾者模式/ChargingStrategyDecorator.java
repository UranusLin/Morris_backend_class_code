package 收銀機系統.裝飾者模式;

import 收銀機系統.策略模式.ChargingStrategy;

public abstract class ChargingStrategyDecorator implements ChargingStrategy {
    protected ChargingStrategy decoratedStrategy;

    public ChargingStrategyDecorator(ChargingStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }
}
