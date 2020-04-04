package ru.job4j.storage;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(double weight) {
        strategy.moving(weight);
    }
}
