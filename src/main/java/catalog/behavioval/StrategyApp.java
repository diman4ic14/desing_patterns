package catalog.behavioval;

import java.util.Arrays;
import java.util.List;

public class StrategyApp {

    public static void main(String[] args) {
        Client client = new Client();
        List<Strategy> strategies = Arrays.asList(new StrategyAdd(), new StrategySubtract(), new StrategyMultiply());

        strategies.forEach(s -> {
            client.setStrategy(s);
            System.out.println(client.calculate(10, 5));
        });
    }
}


interface Strategy {
    int calculate(int a, int b);
}

class StrategyAdd implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}

class StrategySubtract implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}

class StrategyMultiply implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a * b;
    }
}

class Client {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int a, int b) {
        return strategy.calculate(a, b);
    }
}