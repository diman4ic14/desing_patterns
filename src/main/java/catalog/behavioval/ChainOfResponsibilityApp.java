package catalog.behavioval;

public class ChainOfResponsibilityApp {

    public static void main(String[] args) {
        NoteModule noteModule5000 = new NoteModule5000();
        NoteModule noteModule2000 = new NoteModule2000();
        NoteModule noteModule1000 = new NoteModule1000();
        NoteModule noteModule500 = new NoteModule500();
        NoteModule noteModule200 = new NoteModule200();
        NoteModule noteModule100 = new NoteModule100();

        noteModule5000.setNextNoteModule(noteModule2000);
        noteModule2000.setNextNoteModule(noteModule1000);
        noteModule1000.setNextNoteModule(noteModule500);
        noteModule500.setNextNoteModule(noteModule200);
        noteModule200.setNextNoteModule(noteModule100);

        noteModule5000.takeMoney(new Money(93800));
    }
}

enum Note {
    R100(100),
    R200(200),
    R500(500),
    R1000(1000),
    R2000(2000),
    R5000(5000);

    private int value;

    Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class Money {
    private int amount;

    public Money(int amount) {
        setAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount >= 100 && amount <= 200_000 && amount%Note.R100.getValue() == 0) {
            this.amount = amount;
        } else {
            throw new RuntimeException("The amount must be between 100 Rub and 200 000 Rub and a multiple of 100");
        }
    }
}

abstract class NoteModule {
    protected NoteModule next;

    protected void takeMoney(Money money) {
        int countNote = money.getAmount()/getValue();
        int remain = money.getAmount()%getValue();

        if (countNote > 0) {
            System.out.printf("Issued %d banknotes in the amount of %d%n", getValue(), countNote);
        }

        if (remain > 0 && next != null) {
            next.takeMoney(new Money(remain));
        }
    }

    public void setNextNoteModule(NoteModule next) {
        this.next = next;
    }

    protected abstract int getValue();
}

class NoteModule5000 extends NoteModule {

    @Override
    protected int getValue() {
        return Note.R5000.getValue();
    }
}

class NoteModule2000 extends NoteModule {

    @Override
    protected int getValue() {
        return Note.R2000.getValue();
    }
}

class NoteModule1000 extends NoteModule {

    @Override
    protected int getValue() {
        return Note.R1000.getValue();
    }
}

class NoteModule500 extends NoteModule {

    @Override
    protected int getValue() {
        return Note.R500.getValue();
    }
}

class NoteModule200 extends NoteModule {

    @Override
    protected int getValue() {
        return Note.R200.getValue();
    }
}

class NoteModule100 extends NoteModule {

    @Override
    protected int getValue() {
        return Note.R100.getValue();
    }
}
