package basecode.container.collection;


import java.util.Arrays;

public class SimpleArrayList<E> {

    private final static int DEFAULT_CAPACITY = 10;

    private final static Object[] DEFAULT_EMPTY = {};

    transient Object[] elements;

    private int size;

    private int modCount;

    public SimpleArrayList() {
        elements = DEFAULT_EMPTY;
    }

    public SimpleArrayList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else if (capacity == 0) {
            elements = DEFAULT_EMPTY;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    capacity);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //    增
    public void add(E e) {
        if (elements.length == 0) {
            elements = new Object[DEFAULT_CAPACITY];
        }
        if (size >= elements.length) {
            grow();
        }
        elements[size] = e;
        size++;

    }

    //    删
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index,
                    numMoved);
        elements[--size] = null;
    }

    //    查
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object[] o){
        return indexOf(o) >= 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }


    private void grow() {
        int newCapacity = size + size >> 1;
        elements = Arrays.copyOf(elements, newCapacity);
    }


}
