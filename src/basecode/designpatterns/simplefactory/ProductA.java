package basecode.designpatterns.simplefactory;

public class ProductA implements Product {
    @Override
    public void doSomething() {
        System.out.print("这是产品A");
    }
}
