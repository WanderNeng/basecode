package basecode.datastructure.bigdata;

import java.util.BitSet;

public class BitMapTest {

    public static void main(String[] args){
        BitSet bs = new BitSet();
        bs.set(1);
        bs.set(3);
        bs.set(5);
        for(int i = 0; i < bs.length(); i++){
            System.out.println(bs.get(i));
            
        }

    }
}
