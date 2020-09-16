package catalog.stractural;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DecoratorApp {

    public static void main(String[] args) {
        Component message = new Message();
        NameDecorator nameDecorator = new NameDecorator(message);

        nameDecorator.setName("Dmitry Falin");

        Component timeDecorator = new TimeDecorator(nameDecorator);

        String hello = timeDecorator.execute("Hello, bro");
        System.out.println(hello);
    }
}

abstract class Decorator implements Component {

    protected Component wrapper;

    public Decorator(Component wrapper) {
        this.wrapper = wrapper;
    }
}

interface Component {
    String execute(String string);
}

class Message implements Component {

    @Override
    public String execute(String string) {
        return string;
    }
}

class NameDecorator extends Decorator {
    public NameDecorator(Component wrapper) {
        super(wrapper);
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute(String string) {
        return String.format("From %s:\n%s", name, wrapper.execute(string));
    }
}

class TimeDecorator extends Decorator {
    public TimeDecorator(Component wrapper) {
        super(wrapper);
    }

    @Override
    public String execute(String string) {
        return String.format("%s\n%s", wrapper.execute(string),
                getDateTime());
    }

    private String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).replace("T", " ").substring(0, 19);
    }
}
