package catalog.behavioval;

import java.util.Arrays;
import java.util.List;

public class VisitorApp {

    public static void main(String[] args) {
        Element computer = new Computer();
        Element phone = new Phone();
        Element car = new Car();

        List<Visitor> visitors = Arrays.asList(new MajorMan(), new UsualMan());
        visitors.forEach(v -> {
            computer.accept(v);
            phone.accept(v);
            car.accept(v);
        });
    }
}

interface Element {
    void accept(Visitor visitor);
}

class Computer implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Phone implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Car implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitor {
    void visit(Computer computer);
    void visit(Phone phone);
    void visit(Car car);
}


class MajorMan implements Visitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("Buy MacBook Pro latest model");
    }

    @Override
    public void visit(Phone phone) {
        System.out.println("Buy iPhone latest model");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Buy Ferrari newest model");
    }
}


class UsualMan implements Visitor {

    @Override
    public void visit(Computer computer) {
        System.out.println("See a new MacBook and buy Xiaomi");
    }

    @Override
    public void visit(Phone phone) {
        System.out.println("See a new iPhone and buy iPhone 8");
    }

    @Override
    public void visit(Car car) {
        System.out.println("See a new Ferrari and buy Kia");
    }
}