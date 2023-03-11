package staticProxy;

public class TestProxy {
    public static void main(String[] args) {
        TargetProxy targetProxy = new TargetProxy(new TargetInterfaceImpl());

        targetProxy.sayHello("张无忌");
        targetProxy.sayBye("张无忌");
    }
}
