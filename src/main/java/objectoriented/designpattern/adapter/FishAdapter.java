package objectoriented.designpattern.adapter;

public class FishAdapter implements Animal {

    Fish fish;

    FishAdapter(Fish fish) {
        this.fish = fish;
    }

    @Override
    public void walk() {
        fish.swim();
    }
}
