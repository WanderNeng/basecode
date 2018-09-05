package basecode.designpatterns.producerandcustomer;

public class Customer{

    int count;

    public Customer(int count){
        this.count = count;
    }

    public void customer(){
        setCount(count-1);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
