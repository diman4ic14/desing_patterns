package catalog.creational;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrototypeApp {

    public static void main(String[] args) {
        Cat myCat = new Cat("Batman", "Sphinx", "White", LocalDate.of(2020, 2, 1));
        PrototypeRegister register = new PrototypeRegister();
        register.addItem(myCat);
        Prototype batman = register.getByName("Batman");
        System.out.println(myCat == batman);
        System.out.println(batman);
    }
}

class Cat implements Prototype {

    private final String name;
    private final String breed;
    private final String color;
    private final LocalDate dateOfBirth;

    public Cat(String name, String breed, String color, LocalDate dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.dateOfBirth = dateOfBirth;
    }

    public Cat(Cat cat) {
        this(cat.name, cat.breed, cat.color, cat.dateOfBirth);
    }


    @Override
    public String getByName() {
        return name;
    }

    @Override
    public Prototype clone() {
        return new Cat(this);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

interface Prototype {
    String getByName();

    Prototype clone();
}

class PrototypeRegister {

    private final List<Prototype> prototypes;

    public PrototypeRegister() {
        prototypes = new ArrayList<>();
    }

    public void addItem(Prototype prototype) {
        prototypes.add(prototype);
    }

    public Prototype getByName(String name) {
        Prototype prototype = prototypes.stream().filter(p -> p.getByName().equals(name)).findFirst().orElse(null);
        return prototype != null ? prototype.clone() : null;
    }
}
