package map;

/**
 * @author: HanYuXing
 * @date: 2021-09-01 14:42
 **/
public class Array<E extends Comparable<E>> {

    private E[] data;
    private int size;

    public Array() {
        data = (E[]) new Object[10];
        size = 0;
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (size == data.length) {
            E[] newData = (E[]) new Object[size * 2];
            for (int i = 0 ; i < size ; i ++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[size + 1] = e;
    }

    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index out of size");
        }
        data[index] = e;
    }

    public void remove(){

    }

}
