import java.util.Arrays;

//插入排序法
public class InsertSort {

    private InsertSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i=1;i<arr.length;i++){
            E temp = arr[i];
            int j;
            for (j = i;j-1>=0&&temp.compareTo(arr[j-1])<0;j--){
                arr[j] = arr[j-1];
            }
            arr[j]= temp;
        }
    }


}
