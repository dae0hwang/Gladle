package objectoriented.designpattern.templatemethod;

public class MeatRamenRecipe extends BasicRecipe{

    @Override
    public void addCharacter() {
        System.out.println("고기를 넣는다");
    }
}
