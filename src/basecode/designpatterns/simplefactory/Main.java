package basecode.designpatterns.simplefactory;

public class Main{

    public static void main(String[] args){
        Product pro = Factory.create("A");
        pro.doSomething();
    }
}
