package basecode.container.collection;

public class TestSimpleArrayList {
    
    public static void main(String[] args){
        SimpleArrayList<Integer> sal = new SimpleArrayList<Integer>();
        sal.add(5);
        sal.add(3);
        sal.add(5);
        sal.add(52);
        sal.add(51);
        sal.add(52);
        sal.add(56);
        sal.add(58);
        sal.add(2);
        sal.add(34);
        sal.add(56);
        sal.add(95);
        sal.add(83);
        sal.add(24);
        sal.add(9);
        sal.add(-3);
        sal.add(-9);
        sal.add(98);
        sal.add(21);
        System.out.println(sal.getSize());
    }
}
