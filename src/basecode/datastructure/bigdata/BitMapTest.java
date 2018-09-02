package basecode.datastructure.bigdata;

import java.util.BitSet;

public class BitMapTest {

    int[] arrays;

    public BitMapTest(int maxValue) {
        arrays = new int[maxValue / 32 + 1];
    }

    public static void main(String[] args) {

        //Java自带的bitSet
        BitSet bs = new BitSet();
        bs.set(1);
        bs.set(3);
        bs.set(5);
        for (int i = 0; i < bs.length(); i++) {
            System.out.print(bs.get(i) + " ");

        }

        BitMapTest bmt = new BitMapTest(32);
        bmt.set(2);
        bmt.set(3);
        System.out.println(bmt.get(2));
        System.out.println(bmt.get(4));


    }

    public void initial() {
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = 0;
        }
    }

    public void set(int pos) {
        arrays[pos >> 5] = arrays[pos >> 5] | (1 << (31 - pos % 32));

    }

    public boolean get(int pos) {
        return (arrays[pos >> 5] | (1 << (31 - pos % 32))) == arrays[pos>>5];
    }
}
