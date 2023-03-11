package staticProxy;

public class TargetProxy implements TargetInterface {

    // 持有目标方法的引用
    private TargetInterface targetInterface;

    public TargetProxy(TargetInterface targetInterface) {
        this.targetInterface = targetInterface;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("方法前—---——");

        // 中间调用目标接口的真正实现
        targetInterface.sayHello(name);

        System.out.println("方法后—---——");
    }

    @Override
    public void sayBye(String name) {
        System.out.println("方法前—---——");

        // 中间调用目标接口的真正实现
        targetInterface.sayBye(name);

        System.out.println("方法后—---——");

    }
}
