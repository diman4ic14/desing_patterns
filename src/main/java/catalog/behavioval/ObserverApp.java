package catalog.behavioval;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ObserverApp {

    public static void main(String[] args) {
        NewsGroup newsGroup = new NewsGroup();
        Observer subscriber = new Subscriber();
        Observer subscriber1 = new Subscriber();
        Observer subscriber2 = new Subscriber();

        newsGroup.addObserver(subscriber);
        newsGroup.addObserver(subscriber1);
        newsGroup.addObserver(subscriber2);

        newsGroup.addNews("Everything's good");

        Observer subscribe3 = new Subscriber();
        newsGroup.addObserver(subscribe3);

        newsGroup.addNews("COVID 19 taken all world");
    }
}

interface Observer {
    void update(String msg);
}

class Subscriber implements Observer {

    @Override
    public void update(String msg) {
        System.out.println(msg);
    }
}

class NewsGroup {

    private Set<Observer> observers = new HashSet<>();
    private List<String> newsList = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        observers.forEach(o -> o.update(newsList.get(newsList.size() - 1)));
    }

    public void addNews(String msg) {
        newsList.add(msg);
        notifyObservers();
    }
}
