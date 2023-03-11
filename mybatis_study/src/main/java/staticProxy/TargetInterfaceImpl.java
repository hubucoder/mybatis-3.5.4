package staticProxy;

public class TargetInterfaceImpl implements TargetInterface {

  @Override
  public void sayHello(String name) {
    System.out.println("hello, " + name);
  }

  @Override
  public void sayBye(String name) {
    System.out.println("bye, " + name);
  }
}
