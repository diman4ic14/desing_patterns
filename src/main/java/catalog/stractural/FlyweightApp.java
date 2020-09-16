package catalog.stractural;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyweightApp {

    public static void main(String[] args) {
        List<String> types = Arrays.asList("Birch", "Oak", "Pine", "Aspen", "Spruce");

        FlyweightFactory flyweightFactory = new FlyweightFactory();

        for (int i = 0; i < 20; i++) {
            Tree tree = flyweightFactory.getTree(types.get((int) (Math.random() * types.size())));
            tree.plant((int) (Math.random() * 100), (int) (Math.random() * 50));
        }
    }
}

interface Tree {
    void plant(int x, int y);
}

class ConcreteTree implements Tree {
    private String type;

    public ConcreteTree(String type) {
        this.type = type;
    }

    @Override
    public void plant(int x, int y) {
        System.out.printf("%s tree is planted in the place: x=%d, y=%d%n", type, x, y);
    }
}

class FlyweightFactory {
    private static final Map<String, Tree> treeMap = new HashMap<>();

    public Tree getTree(String type) {
        treeMap.putIfAbsent(type, new ConcreteTree(type));
        return treeMap.get(type);
    }
}
