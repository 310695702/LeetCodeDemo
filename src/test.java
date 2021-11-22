/**
 * @author: HanYuXing
 * @date: 2021-09-17 15:32
 **/
public class test {

    private static int jumptoN(int n) {
        if (n == 0) return 0;
        return jump(n);
    }

    private static int jump(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return jump(n - 1) + jump(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(jumptoN(1));
    }
}
