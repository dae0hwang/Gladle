package objectoriented.designpattern.observer;

class CatObserver implements Observer {

    @Override
    public void update() {
        System.out.println("야옹 울림");
    }
}
