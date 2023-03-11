package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现 jdk 提供的 InvocationHandler 接口
 *
 * 实现改接口是未来实现 jdk 的动态代理
 *
 * 此类不是真正的代理类，真正的代理的类在 jvm 内存中，
 */
public class TargetProxy implements InvocationHandler {

    // 持有目标接口的引用，动态代理为了适配各种目标类型，把引用使用 Object
    private Object target;

    public TargetProxy(Object target) {
        this.target = target;
    }

    // 获取真正的代理类
    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class interfaces) {
        // jvm 内存中生成一个 class 类
        // 根据该 class 类反射创建一个代理对象
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),
                new Class<?>[] {interfaces},
                this);
    }


    /**
     *
     * @param proxy 代理对象
     * @param method 目标接口的方法的反射对象 Method
     * @param args 目标接口的方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("前置增强（通知）...");
        // 调用业务方法，所以要把 args 传递过去
        Object result = method.invoke(target, args);

        System.out.println("后置增强（通知）...");

        return result;
    }
}
