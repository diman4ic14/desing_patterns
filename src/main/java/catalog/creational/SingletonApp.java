package catalog.creational;

import java.util.Arrays;

public class SingletonApp {
    private static int counter = 0;

    private static volatile SingletonApp instance;

    private SingletonApp() {
        counter++;
    }

    public static SingletonApp getInstance() {
        if (instance == null) {
            synchronized(SingletonApp.class) {
                if (instance == null) {
                    instance = new SingletonApp();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        final int size = 100;
        Thread[] threads = new Thread[size];

        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(SingletonApp::getInstance);
            threads[i].start();
        }

        Arrays.stream(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(counter);
    }
}
