package objectoriented.designpattern.proxy;

public class TargetImpl implements TargetInterface {

    @Override
    public void run() {
        System.out.println("TargetImpl.run() 실행");
    }
}