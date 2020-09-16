package catalog.stractural;

public class BridgeApp {

    public static void main(String[] args) {
        Car car = new Hatchback(new Audi());
        car.showDetails();
    }
}

abstract class Car {
    protected Producer producer;

    public Car(Producer producer) {
        this.producer = producer;
    }

    public void showDetails() {
        System.out.print(getType() + " ");
        producer.setProducer();
    }

    abstract String getType();
}

class Sedan extends Car {

    public Sedan(Producer producer) {
        super(producer);
    }

    @Override
    String getType() {
        return "Sedan";
    }
}

class Hatchback extends Car {

    public Hatchback(Producer producer) {
        super(producer);
    }

    @Override
    String getType() {
        return "Hatchback";
    }
}

interface Producer {
    void setProducer();
}

class BMW implements Producer {

    @Override
    public void setProducer() {
        System.out.println("BMW");
    }
}

class Audi implements Producer {

    @Override
    public void setProducer() {
        System.out.println("Audi");
    }
}