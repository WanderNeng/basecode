package basecode.designpatterns.producerandcustomer;

public class Producer implements Runnable {

    int count;

    public Producer(int count){
        this.count = count;
    }

    public void producer(){
        count++;
    }


    @Override
    public void run() {

    }
}
