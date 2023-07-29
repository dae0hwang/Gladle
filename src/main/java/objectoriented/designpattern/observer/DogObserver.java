package objectoriented.designpattern.observer;

class DogObserver implements Observer {

    @Override
    public void update() {
        System.out.println("멍멍 울림");
    }
}
