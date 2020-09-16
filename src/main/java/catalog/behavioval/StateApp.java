package catalog.behavioval;

import java.util.Arrays;
import java.util.List;

public class StateApp {

    public static void main(String[] args) {
        List<Program> programs = Arrays.asList(new Frying(), new Boiling(), new Stew());
        Multicooker multicooker = new Multicooker();

        programs.forEach(p -> {
            multicooker.setProgram(p);
            multicooker.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

interface Program {
    void execute();
}

class Frying implements Program {
    @Override
    public void execute() {
        System.out.println("Program \"Frying\" on");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program \"Frying\" has finished");
    }
}

class Boiling implements Program {

    @Override
    public void execute() {
        System.out.println("Program \"Boiling\" on");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program \"Boiling\" has finished");
    }
}

class Stew implements Program {

    @Override
    public void execute() {
        System.out.println("Program \"Stew\" on");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program \"Stew\" has finished");
    }
}

class Multicooker {
    private Program program;

    public void setProgram(Program program) {
        this.program = program;
    }

    public void start() {
        program.execute();
    }
}