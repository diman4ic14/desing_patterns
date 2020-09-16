package catalog.behavioval;

public class TemplateMethodApp {

    public static void main(String[] args) {
        Teapot metalTeapot = new MetalTeapot();
        Teapot electricTeapot = new ElectricTeapot();

        metalTeapot.boil();

        System.out.println();

        electricTeapot.boil();
    }
}

abstract class Teapot {
    public void boil() {
        System.out.println("Fill water into the teapot");
        on();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The water is boiled");
        off();
    }

    protected abstract void off();

    protected abstract void on();
}

class MetalTeapot extends Teapot {

    @Override
    protected void off() {
        System.out.println("Gas is off");
    }

    @Override
    protected void on() {
        System.out.println("Gas is on");
    }
}

class ElectricTeapot extends Teapot {

    @Override
    protected void off() {
    }

    @Override
    protected void on() {
        System.out.println("Power supply is on");
    }
}