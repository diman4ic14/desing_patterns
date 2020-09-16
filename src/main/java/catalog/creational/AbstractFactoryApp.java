package catalog.creational;

public class AbstractFactoryApp {

    public static void main(String[] args) {
        OSFactory factory = getFactory("mac");

        Browser browser = factory.createBrowser();
        CommandPrompt commandPrompt = factory.createCommandPrompt();

        browser.open();
        commandPrompt.sent("./mvwn");
    }

    public static OSFactory getFactory(String os) {
        os = os.toLowerCase();
        if (os.equals("windows")) {
            return new WinFactory();
        } else if (os.equals("mac")) {
            return new MacOSFactory();
        } else {
            throw new RuntimeException("Unsupported system");
        }
    }
}

interface Browser {
    void open();
}

interface CommandPrompt {
    void sent(String command);
}

class MacOSBrowser implements Browser {
    public void open() {
        System.out.println("Safari has opened");
    }
}

class MacOSCommandPrompt implements CommandPrompt {
    public void sent(String command) {
        System.out.println("Mac Terminal is executing command: " + command);
    }
}

class WinBrowser implements Browser {
    public void open() {
        System.out.println("Microsoft Edge has opened");
    }
}

class WinCommandPrompt implements CommandPrompt {
    public void sent(String command) {
        System.out.println("Windows PowerShell is executing command: " + command);
    }
}

class MacOSFactory implements OSFactory {
    public Browser createBrowser() {
        return new MacOSBrowser();
    }

    public CommandPrompt createCommandPrompt() {
        return new MacOSCommandPrompt();
    }
}

interface OSFactory {
    Browser createBrowser();
    CommandPrompt createCommandPrompt();
}

class WinFactory implements OSFactory {
    public Browser createBrowser() {
        return new WinBrowser();
    }

    public CommandPrompt createCommandPrompt() {
        return new WinCommandPrompt();
    }
}