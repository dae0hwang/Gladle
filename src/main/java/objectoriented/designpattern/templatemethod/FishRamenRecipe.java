package objectoriented.designpattern.templatemethod;

public class FishRamenRecipe extends BasicRecipe{

    @Override
    public void addCharacter() {
        System.out.println("생선을 넣는다");
    }
}
