package objectoriented.designpattern.strategy;

public class PunchAttack implements AttackStrategy {

    @Override
    public void attack() {
        System.out.println("punch attack");
    }
}
