/**
 * @author: HanYuXing
 * @date: 2021-11-16 9:20
 **/
public class ShellSort {

    private ShellSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        int h = arr.length / 2;
        while (h >= 1) {
            for (int start = 0; start < h; start++) {
                for (int i = start + h ; i < arr.length ; i += h){
                    E t = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0;j -= h){
                        arr[j] = arr[j - h];
                    }
                    arr[j] = t;
                }
            }
            h /= 2;
        }
    }


    public static <E extends Comparable<E>> void sort2(E[] arr) {
        int h = 1;
        while(h < arr.length) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int start = 0; start < h; start++) {
                for (int i = start + h ; i < arr.length ; i += h){
                    E t = arr[i];
                    int j;
                    for (j = i; j - h >= 0 && t.compareTo(arr[j - h]) < 0;j -= h){
                        arr[j] = arr[j - h];
                    }
                    arr[j] = t;
                }
            }
            h /= 3;
        }
    }
}
