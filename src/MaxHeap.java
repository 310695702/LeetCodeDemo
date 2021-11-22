import java.util.ArrayList;

/**
 * @author: HanYuXing
 * @date: 2021-09-01 10:45
 **/
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回index节点父节点
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.add(data.size()-1,e);
        siftUp(data.size()-1);
    }

    private void siftUp(int k){

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){

        }
    }


}
