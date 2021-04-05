//选择排序
public class SelectSort {
    private SelectSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        for (int i=0;i<arr.length;i++){
            int min = i;
            for (int j=i;j<arr.length;j++){
                if (arr[j].compareTo(arr[min])<0){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int i, int min) {
        E temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

}
