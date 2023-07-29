package objectoriented.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

class EventBox {

    List<Observer> list = new ArrayList<>();

    void addObserver(Observer observer) {
        list.add(observer);
    }

    void eventNotify() {
        for (var observer : list) {
            observer.update();
        }
    }
}