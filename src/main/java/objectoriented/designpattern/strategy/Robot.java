package objectoriented.designpattern.strategy;

public class Robot {

    private AttackStrategy attackStrategy;

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    //attack 종류를 변경하고 싶을 때 내부적 코드를 변경하는 것이 아니라,
    //외부에서 전략 변경을 통해 수정할 수 있다.
    public void attack() {
        attackStrategy.attack();
    }
}
