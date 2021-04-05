import java.util.Random;

public class ArrayGenerate {

    private ArrayGenerate(){}

    public static Integer[] RandomGenerate(int n,int max){
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(max);
        }
        return arr;
    }

    public static Integer[] LinearGenerate(int n){
        Integer[] arr = new Integer[n];
        for (int i=0;i<arr.length;i++){
            arr[i] = arr.length-i;
        }
        return arr;
    }
}
