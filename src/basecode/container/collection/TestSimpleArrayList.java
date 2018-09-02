package basecode.container.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class TestSimpleArrayList {
    
    public static void main(String[] args){
        SimpleArrayList<Integer> sal = new SimpleArrayList<Integer>();
        sal.add(5);
        sal.add(3);
        sal.add(4);
        sal.add(52);
        sal.add(51);
        sal.add(53);
        sal.add(56);
        sal.add(58);
        sal.add(2);
        sal.add(34);
        sal.add(46);
        sal.add(95);
        sal.add(83);
        sal.add(24);
        sal.add(9);
        sal.add(-3);
        sal.add(-9);
        sal.add(98);
        sal.add(21);
        System.out.println(sal.get(1));//arraylist的index也是从0开始的
        Iterator<Integer> it = sal.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        SimpleArrayList<Integer> sal1 = (SimpleArrayList<Integer>) sal.clone();
        Iterator<Integer> it1 = sal1.iterator();
        System.out.println("");
        while(it1.hasNext()){
            System.out.print(it1.next()+" ");
        }
        System.out.println(sal1.getSize());

    }
}
