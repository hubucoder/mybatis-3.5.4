package jdkProxy;

public class Client2 {

    public static void main(String[] args) {

        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 使用动态代理
        TargetProxy proxyClass = new TargetProxy(new TargetInterfaceImpl());
        // Proxy0 对象
        TargetInterface targetClass = (TargetInterface) proxyClass.getProxy(TargetInterface.class);
        targetClass.sayHi();    // 等价于 Proxy0 super.h.invoke(this, m3, (Object[])null);
        targetClass.work();

    }
}
