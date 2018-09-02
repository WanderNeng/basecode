package basecode.container.collection;


import java.util.*;

public class SimpleArrayList<E> implements Cloneable{

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
        modCount++;

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
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index,
                    numMoved);
        elements[--size] = null;
        modCount++;
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

    public Object get(int index){
        rangeCheck(index);

        return elements[index];

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

    private void rangeCheck(int index) {
        if (index >= size && index <0)
            throw new IndexOutOfBoundsException("超出集合范围！");
    }



    private void grow() {
        int newCapacity = size + (size >> 1);
        elements = Arrays.copyOf(elements, newCapacity);
    }


    public Iterator<E> iterator(){return new Itr(); }

//    迭代器
    private class Itr implements Iterator<E> {
        int cursor;
        int lastRet = -1;
        int expectedModCount = modCount;
        @Override
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elements = SimpleArrayList.this.elements;
            if (i >= elements.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elements[lastRet = i];
        }

        @Override
        public boolean hasNext(){
            return cursor < size;
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }


    }
    @Override
    public Object clone(){
        try {
            SimpleArrayList<?> v = (SimpleArrayList<?>) super.clone();
            v.elements = Arrays.copyOf(elements, size);
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }




}
