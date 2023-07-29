package objectoriented.designpattern.proxy;

public class Proxy implements TargetInterface {

    private final TargetInterface target;  //타깃 오브젝트를 프록시에서 가지고 있는다.

    public Proxy(TargetInterface target) {
        this.target = target;
    }

    @Override
    public void run() {
        System.out.println("DecoratorProxy 시작");  //부가적인 기능을 부여
        target.run();     //실제 타깃의 로직 실행
    }
}