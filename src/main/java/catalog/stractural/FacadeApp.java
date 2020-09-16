package catalog.stractural;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FacadeApp {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.downloadFile("https://sun9-33.userapi.com/c857728/v857728749/98098/2GVikf0lXus.jpg", "image");
    }
}


class Computer {

    public void downloadFile(String url, String fileName) {
        Power power = new Power();
        Internet internet = new Internet();

        power.on();
        internet.connect();
        Downloader downloader = new Downloader();
        downloader.downloadFile(url, fileName);
        power.off();
    }

}

class Downloader {
    public void downloadFile(String url, String fileName) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream())) {
            FileOutputStream fileOutputStream = new FileOutputStream(getNewFile(fileName, url));

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            System.out.println("Loading..");
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File downloaded");
    }

    public File getNewFile(String name, String url) {
        String format = url.substring(url.lastIndexOf('.') + 1);
        return new File("C:/Users/falin/Downloads/" + name + "." + format);
    }
}

class Power {
    public void on() {
        System.out.println("Power on");
    }

    public void off() {
        System.out.println("Power off");
    }
}

class Internet {
    public void connect() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Connection established");
    }
}
