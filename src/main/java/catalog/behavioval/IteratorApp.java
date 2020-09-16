package catalog.behavioval;

public class IteratorApp {

    public static void main(String[] args) {
        ConcreteCollection collection = new ConcreteCollection();
        Iterator iterator = collection.getIterator();

        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }
    }
}

interface Iterator {
    Object next();
    boolean hasNext();
}

interface Collection {
    Iterator getIterator();
}

class ConcreteCollection implements Collection {
    private String[] array = {"first", "second", "third", "fourth", "fifth"};

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator();
    }

    private class ConcreteIterator implements Iterator {
        private int index = 0;

        @Override
        public Object next() {
            return array[index++];
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }
    }
}
