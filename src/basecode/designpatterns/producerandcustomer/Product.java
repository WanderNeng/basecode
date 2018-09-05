package basecode.designpatterns.producerandcustomer;

public class Product {

    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data: "+data;
    }

    public Product(int data){
        this.data = data;
    }
}
