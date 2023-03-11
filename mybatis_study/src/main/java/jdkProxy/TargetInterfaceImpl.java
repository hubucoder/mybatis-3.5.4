package jdkProxy;

public class TargetInterfaceImpl implements TargetInterface{

    @Override
    public void sayHi() {
        System.out.println("Hi, dynamic proxy. sayHi.");
    }

    @Override
    public void work() {
        System.out.println("Hi, dynamic proxy.work");
    }
}
