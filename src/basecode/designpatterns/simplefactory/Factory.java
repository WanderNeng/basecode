package basecode.designpatterns.simplefactory;


public class Factory {

    public static Product create(String str){
        if(str == "A"){
            return new ProductA();
        } else if(str == "B"){
            return new ProductB();
        }
        return null;
    }
}
