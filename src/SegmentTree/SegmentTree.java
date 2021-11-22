package SegmentTree;

/**
 * @author: HanYuXing
 * @date: 2021-11-17 10:01
 **/
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public int leftChild(int index){
        return index * 2 + 1;
    }

    public int rightChild(int index){
        return index * 2 + 2;
    }
}
