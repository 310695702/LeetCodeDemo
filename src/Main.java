import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = ArrayGenerate.RandomGenerate(n,n);
        Integer[] arr2 = Arrays.copyOf(arr,arr.length);
        Integer[] arr3 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort",arr2);
        SortingHelper.sortTest("QuickSort",arr3,"sort2ways");
        System.out.println();
        arr = ArrayGenerate.LinearGenerate(n);
        arr2 = Arrays.copyOf(arr,arr.length);
        arr3 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort",arr2);
        SortingHelper.sortTest("QuickSort",arr3,"sort2ways");
        System.out.println();
        arr = ArrayGenerate.RandomGenerate(n,1);
        arr2 = Arrays.copyOf(arr,arr.length);
        arr3 = Arrays.copyOf(arr,arr.length);
        SortingHelper.sortTest("MergeSort",arr);
        SortingHelper.sortTest("QuickSort",arr2);
        SortingHelper.sortTest("QuickSort",arr3,"sort2ways");
    }
}
