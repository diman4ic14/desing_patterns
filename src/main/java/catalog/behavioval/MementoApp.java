package catalog.behavioval;

public class MementoApp {

    public static void main(String[] args) {
        Game game = new Game();
        game.setProps("LVL 5", 300_000);

        System.out.println(game);

        File file = new File(game.save());

        game.setProps("LVL 2", 120_000);

        System.out.println(game);

        game.load(file.getSave());

        System.out.println(game);
    }

}

class Game {
    private String lvl;
    private int duration;

    public void setProps(String lvl, int duration) {
        this.lvl = lvl;
        this.duration = duration;
    }

    public Save save() {
        return new Save(lvl, duration);
    }

    public void load(Save save) {
        this.lvl = save.getLvl();
        this.duration = save.getDuration();
    }

    @Override
    public String toString() {
        return "Game{" +
                "lvl='" + lvl + '\'' +
                ", duration=" + duration +
                '}';
    }
}

class Save {
    private String lvl;
    private int duration;

    public Save(String lvl, int duration) {
        this.lvl = lvl;
        this.duration = duration;
    }

    public String getLvl() {
        return lvl;
    }

    public int getDuration() {
        return duration;
    }
}

class File {
    private Save save;

    public File(Save save) {
        this.save = save;
    }

    public Save getSave() {
        return save;
    }
}