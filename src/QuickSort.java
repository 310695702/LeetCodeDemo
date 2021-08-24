import java.util.Random;

public class QuickSort {

    private QuickSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        Random random = new Random();
        sort(arr,0,arr.length-1,random);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r,Random random){
        if (l>=r)return;
        int p = partition(arr,l,r,random);
        sort(arr,l,p-1,random);
        sort(arr,p+1,r,random);
    }


    private static <E extends Comparable<E>> int partition(E[] arr,int l,int r,Random random){
        //生成随机索引
        int p = l+random.nextInt(r-l+1);
        swap(arr,l,p);
        int j = l;
        for (int i=l;i<=r;i++){
            if (arr[i].compareTo(arr[l])<0){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr){
        Random random = new Random();
        sort2ways(arr,0,arr.length,random);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr,int l,int r,Random random){
        if (l>=r-1)return;
        int p = partition2ways(arr,l,r-1,random);
        sort2ways(arr,l,p,random);
        sort2ways(arr,p+1,r,random);
    }

    private static <E extends Comparable<E>> int partition2ways(E[] arr,int l,int r,Random random){
        //生成随机索引
        int p = l+random.nextInt(r-l+1);
        swap(arr,l,p);
        int i = l + 1 , j = r;
        while (true){
            while (i<=j&&arr[i].compareTo(arr[l])<0)
                i++;

            while (j>=i&&arr[j].compareTo(arr[l])>0)
                j--;

            if (i>=j)break;

            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);

        return j;
    }


    public static <E extends Comparable<E>> void sort3ways(E[] arr){
        Random random = new Random();
        sort3ways(arr,0,arr.length-1,random);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr,int l,int r,Random random){
        if (l>=r)return;
        int p = random.nextInt(r-l+1)+l;
        swap(arr,l,p);
        //arr[l+1,lt]<v arr[lt+1,i-1]==v arr[gt,r]>v
        int lt=l,i=l+1,rt=r+1;
        while (i<rt){
            if (arr[i].compareTo(arr[l])<0){
                lt++;
                swap(arr,i,lt);
                i++;
            }else if(arr[i].compareTo(arr[l])>0){
                rt--;
                swap(arr,i,rt);
            }else {
                i++;
            }
        }
        swap(arr,l,lt);
        sort3ways(arr,l,lt-1,random);
        sort3ways(arr,rt,r,random);
    }



    private static <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        Integer[] arr = ArrayGenerate.RandomGenerate(1000,1000);
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        sort3ways(arr);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }
}
