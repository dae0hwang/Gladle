package objectoriented.designpattern.templatemethod;

public abstract class BasicRecipe {

    public void boilWater() {
        System.out.println("물을 500ml 넣고 끓인다");
    }

    public void addRamen() {
        System.out.println("기본 내용물을 넣는다.");
    }

    public abstract void addCharacter();
}
