package catalog.stractural;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

    public static void main(String[] args) {
        Phone iPhone10 = new Phone("iPhone 10");
        Notebook macbook = new Notebook("MacBook Pro 13");
        Vipe vipe = new Vipe();

        Phone samsungGalaxyS10 = new Phone("Samsung Galaxy S10");
        Notebook xiaomi = new Notebook("Xiaomi NotePro 15");

        Composite composite1 = new Composite();

        composite1.addComponent(iPhone10);
        composite1.addComponent(macbook);
        composite1.addComponent(vipe);

        Composite composite2 = new Composite();
        composite2.addComponent(samsungGalaxyS10);
        composite2.addComponent(xiaomi);

        Composite composite = new Composite();
        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.getDescription();
    }
}

interface Item {
    void getDescription();
}

class Phone implements Item {
    private String name;

    public Phone(String name) {
        this.name = name;
    }

    @Override
    public void getDescription() {
        System.out.println("It's a phone " + name);
    }
}

class Notebook implements Item {

    private String name;

    public Notebook(String name) {
        this.name = name;
    }

    @Override
    public void getDescription() {
        System.out.println("It's a notebook " + name);
    }
}

class Vipe implements Item {

    @Override
    public void getDescription() {
        System.out.println("It's a vipe");
    }
}

class Composite implements Item {

    private List<Item> components = new ArrayList<>();

    public void addComponent(Item component) {
        components.add(component);
    }

    public void removeComponent(Item component) {
        components.remove(component);
    }

    @Override
    public void getDescription() {
        components.forEach(Item::getDescription);
    }
}