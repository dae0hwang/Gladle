package objectoriented.designpattern.strategy;

public class MissileAttack implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("missile attack");
    }
}
