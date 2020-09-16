package catalog.creational;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class FactoryMethodApp {

    public static void main(String[] args) {
        FactoryConverter factory = getFactory("xml");

        Car car = new Car(10001, "BMW X6", 3.2, "black", 2017);

        String string = factory.convert(car);

        System.out.println(string);
    }

    public static FactoryConverter getFactory(String type) {
        type = type.toLowerCase();
        if (type.equals("xml")) {
            return new XMLFactory();
        } else if (type.equals("json")) {
            return new JSONFactory();
        } else {
            throw new RuntimeException("Unsupported type of convertor");
        }
    }
}

interface Converter {
    String convert(Car source);
}

class JSONConverter implements Converter {
    public String convert(Car source) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            return "Ops, an error has occurred";
        }
    }
}

class XMLConverter implements Converter {
    public String convert(Car source) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Ops, an error has occurred";
        }
    }
}

abstract class FactoryConverter {

    protected abstract Converter createConverter();

    public String convert(Car source) {
        return createConverter().convert(source);
    }
}

class JSONFactory extends FactoryConverter {

    @Override
    public Converter createConverter() {
        return new JSONConverter();
    }
}

class XMLFactory extends FactoryConverter {

    @Override
    public Converter createConverter() {
        return new XMLConverter();
    }
}

class Car {
    private Integer id;
    private String name;
    private Double engine;
    private String color;
    private Integer yearOfProduction;

    public Car(Integer id, String name, Double engine, String color, Integer yearOfProduction) {
        this.id = id;
        this.name = name;
        this.engine = engine;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engine=" + engine +
                ", color='" + color + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
