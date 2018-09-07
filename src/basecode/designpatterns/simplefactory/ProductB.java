package basecode.designpatterns.simplefactory;

public class ProductB implements Product {

    @Override
    public void doSomething() {
        System.out.print("这是产品B");
    }
}
