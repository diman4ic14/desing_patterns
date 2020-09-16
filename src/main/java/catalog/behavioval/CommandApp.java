package catalog.behavioval;

public class CommandApp {

    public static void main(String[] args) {
        Cooker cooker = new Cooker();

        Command borschCommand = new BorschCommand(cooker);
        Command olivierCommand = new OlivierCommand(cooker);
        Command ragoutCommand = new RagoutCommand(cooker);

        Waiter waiter = new Waiter(borschCommand, olivierCommand, ragoutCommand);

        waiter.doBorsch();
        waiter.doOlivier();
        waiter.doRagout();
    }
}

class Cooker {
    public void makeBorsch() {
        System.out.println("Borsch is ready");
    }

    public void makeOlivier() {
        System.out.println("Olivier is ready");
    }

    public void makeRagout() {
        System.out.println("Ragout is ready");
    }
}

interface Command {
    void execute();
}

class BorschCommand implements Command {
    private final Cooker cooker;

    public BorschCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void execute() {
        cooker.makeBorsch();
    }
}

class OlivierCommand implements Command {
    private final Cooker cooker;

    public OlivierCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void execute() {
        cooker.makeOlivier();
    }
}

class RagoutCommand implements Command {
    private final Cooker cooker;

    public RagoutCommand(Cooker cooker) {
        this.cooker = cooker;
    }

    @Override
    public void execute() {
        cooker.makeRagout();
    }
}

class Waiter {
    private final Command borsch;
    private final Command olivier;
    private final Command ragout;

    public Waiter(Command borsch, Command olivier, Command ragout) {
        this.borsch = borsch;
        this.olivier = olivier;
        this.ragout = ragout;
    }

    public void doBorsch() {
        borsch.execute();
    }

    public void doOlivier() {
        olivier.execute();
    }

    public void doRagout() {
        ragout.execute();
    }
}