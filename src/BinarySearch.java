import java.util.Arrays;

/**
 * @version: V1.0
 * @author: HanYuXing
 * @date: 2021-08-19 10:44
 **/
public class BinarySearch {

    private BinarySearch() {
    }

    //查找比target大的最小索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {
        int l = 0, r = data.length, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else r = mid;
        }
        return l;
    }

    //查找与target相等的最大索引
    public static <E extends Comparable<E>> int ceil(E[] data, E target) {
        int upper = upper(data, target);
        if (upper - 1 >= 0 && data[upper - 1].compareTo(target) == 0)
            return upper - 1;
        return upper;
    }

    //查找与target相等的最小索引 在data[l,r]中寻找解
    public static <E extends Comparable<E>> int lowerceil(E[] data, E target) {
        int l = 0, r = data.length, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l;
    }

    //查找小于target的最大值
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1, mid;
        while (l < r) {
            mid = l + (r - l + 1)/2;
            if (data[mid].compareTo(target) < 0)
                l = mid;
            else
                r = mid - 1 ;
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 1, 3, 3, 5, 5};
        for (int i = 0; i <= 6; i++) {
            int ceil = BinarySearch.lower(arr, i);
            System.out.print(ceil + "  ");
        }
        int[] arr2 = new int[]{1, 1, 3, 3, 5, 5};
        Integer integer = Arrays.stream(arr2).max().getAsInt();
        System.out.println(integer);
    }
}
