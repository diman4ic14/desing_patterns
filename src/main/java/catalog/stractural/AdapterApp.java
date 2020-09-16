package catalog.stractural;

public class AdapterApp {

    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(10);
        RoundPeg roundPeg = new RoundPeg(9);

        roundHole.fits(roundPeg);

        roundHole.fits(new SquarePegAdapter(new SquarePeg(15)));
        roundHole.fits(new SquarePegAdapter(new SquarePeg(14)));
    }
}

interface Round {
    double getRadius();
}

class RoundHole implements Round{
    private int radius;

    public RoundHole(int radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    public void fits(Round roundPeg) {
        if (radius > roundPeg.getRadius()) {
            System.out.println(roundPeg + " is approached");
        } else {
            System.out.println(roundPeg + " isn't approached");
        }
    }
}

class RoundPeg implements Round{
    private int radius;

    public RoundPeg(int radius) {
        this.radius = radius;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "RoundPeg{" +
                "radius=" + radius +
                '}';
    }
}

class SquarePeg {
    private int width;

    public SquarePeg(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "SquarePeg{" +
                "width=" + width +
                '}';
    }
}

class SquarePegAdapter implements Round {
    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(squarePeg.getWidth(), 2) + Math.pow(squarePeg.getWidth(), 2)) / 2;
    }

    @Override
    public String toString() {
        return "SquarePegAdapter{" +
                "squarePeg=" + squarePeg +
                '}';
    }
}
