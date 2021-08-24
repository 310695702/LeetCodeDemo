import java.util.Arrays;

//归并排序
public class MergeSort {
    private MergeSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        E[] temp = Arrays.copyOf(arr,arr.length);
        sort(arr,0,arr.length-1,0,temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r,int depth,E[] temp){
//        String depthString = generateDepthString(depth);
//        System.out.print(depthString);
//        System.out.print("sort: l="+l+" r="+r+" mid="+(l+(r-l)/2)+" ");
//        for (int i=l;i<=r;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
        if (l>=r){
//            System.out.print(depthString);
//            System.out.print("return ");
//            for (int i=l;i<=r;i++){
//                System.out.print(arr[i]+" ");
//            }
//            System.out.println();
            return;
        }
        int mid = l+(r-l)/2;
        sort(arr,l,mid,depth+1,temp);
//        System.out.print(depthString);
//        System.out.print("After sort l=" + l+" r="+mid+" mid="+(l+(mid-l)/2)+" ");
//        for (int i=l;i<=mid;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
        sort(arr,mid+1,r,depth+1,temp);
//        System.out.print(depthString);
//        System.out.print("After sort l=" + mid+1+" r="+r+" mid="+(mid+1+(r-mid-1)/2)+" ");
//        for (int i=mid+1;i<=r;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
        if (arr[mid].compareTo(arr[mid+1])>0)
        merge(arr,l,mid,r,temp);
    }

    private static String generateDepthString(int depth) {
        StringBuffer sbf = new StringBuffer();
        for (int i=0;i<depth;i++){
            sbf.append("--");
        }
        return sbf.toString();
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r,E[] temp) {
        System.arraycopy(arr,l,temp,l,r-l+1);
        int i = l,j=mid+1;
        for (int k=l;k<=r;k++){
            if (i>mid){
                arr[k] = temp[j];j++;
            }else if (j>r){
                arr[k] = temp[i];i++;
            }else if (temp[i].compareTo(temp[j])<0){
                arr[k] = temp[i];i++;
            }else {
                arr[k] = temp[j];j++;
            }
        }
//        System.out.print(depthString);
//        System.out.print("After merge l=" + l+" r="+r+" mid="+mid+" ");
//        for (int k=l;k<=r;k++){
//            System.out.print(arr[k]+" ");
//        }
//        System.out.println();
    }

}
