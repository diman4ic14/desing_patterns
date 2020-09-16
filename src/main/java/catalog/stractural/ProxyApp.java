package catalog.stractural;

import java.lang.reflect.Field;

public class ProxyApp {

    public static void main(String[] args) {
        Net net = new ProxyNet("rutracker.org");
        net.openSite();
    }
}

interface Net {
    void openSite();
}

class RuNet implements Net {
    private String url;
    private String location = "Russia";

    public RuNet(String url) {
        this.url = url;
    }

    @Override
    public void openSite() {
        if (location.equals("Russia")) {
            System.out.println("Page isn't found");
        } else {
            System.out.println(url + " loaded");
        }
    }
}

class ProxyNet implements Net {
    private String url;
    private RuNet ruNet;

    public ProxyNet(String url) {
        this.url = url;
    }

    @Override
    public void openSite() {
        if (ruNet == null) {
            ruNet = new RuNet(url);
            try {
                Field location = ruNet.getClass().getDeclaredField("location");
                location.setAccessible(true);
                location.set(ruNet, "Finland");
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        ruNet.openSite();
    }
}
