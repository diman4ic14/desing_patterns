package catalog.creational;

public class BuilderApp {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new PlasticBuilder();
        director.changeBuilder(builder);
        director.makeCupboard();
        System.out.println(builder.getResult());

        System.out.println();

        WoodBuilder builder2 = new WoodBuilder();
        director.changeBuilder(builder2);
        director.makeCupboard();
        System.out.println(builder2.getResult());
    }
}

interface Builder {
    void reset();
    void setMaterial();
    void setColor();
    void setHeight();
    void setWeight();
    void setDepth();
    void setDoorType();
    Cupboard getResult();
}

class PlasticBuilder implements Builder {
    private Cupboard cupboard;

    public PlasticBuilder() {
        reset();
    }

    public void reset() {
        cupboard= new Cupboard();
    }

    public void setMaterial() {
        cupboard.setMaterial("Plastic");
    }

    public void setColor() {
        cupboard.setColor("White");
    }

    public void setHeight() {
        cupboard.setHeight(160);
    }

    public void setWeight() {
        cupboard.setWeight(100);
    }

    public void setDepth() {
        cupboard.setDepth(50);
    }

    public void setDoorType() {
        cupboard.setDoorType(DoorType.TRADITIONAL);
    }

    public Cupboard getResult() {
        Cupboard product = this.cupboard;
        reset();
        return product;
    }
}

class WoodBuilder implements Builder {
    private Cupboard cupboard;

    public WoodBuilder() {
        reset();
    }

    public void reset() {
        cupboard = new Cupboard();
    }

    public void setMaterial() {
        cupboard.setMaterial("Wood");
    }

    public void setColor() {
        cupboard.setColor("Brown");
    }

    public void setHeight() {
        cupboard.setHeight(190);
    }

    public void setWeight() {
        cupboard.setWeight(120);
    }

    public void setDepth() {
        cupboard.setDepth(70);
    }

    public void setDoorType() {
        cupboard.setDoorType(DoorType.COUPE);
    }

    public Cupboard getResult() {
        Cupboard product = this.cupboard;
        reset();
        return product;
    }
}

class Cupboard {
    private String material;
    private String color;
    private int height;
    private int weight;
    private int depth;
    private DoorType doorType;

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDoorType(DoorType doorType) {
        this.doorType = doorType;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Cupboard{" +
                "material='" + material + '\'' +
                ", color='" + color + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", depth=" + depth +
                ", doorType=" + doorType +
                '}';
    }
}

enum DoorType {
    TRADITIONAL,
    COUPE
}

class Director {
    private Builder builder;

    public void changeBuilder(Builder builder) {
        this.builder = builder;
    }

    public void makeCupboard() {
        builder.reset();
        builder.setMaterial();
        builder.setColor();
        builder.setHeight();
        builder.setWeight();
        builder.setDepth();
        builder.setDoorType();
    }
}
