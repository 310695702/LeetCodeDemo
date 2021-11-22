import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: HanYuXing
 * @date: 2021-11-17 15:32
 **/
public class DataParse {

    private static final String CONN = "-";
    private static final char YEAR = '年';
    private static final char MONTH = '月';
    private static final char DAY = '日';
    private static final int LENGTH = 10;
    private static final char ZERO = '0';
    private static final char NINE = '9';

    public static String parseTime(String time) {
        Queue<Character> queue = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();
        for (char c : time.toCharArray()) {
            if (c >= ZERO && c <= NINE) {
                queue.add(c);
            }
            if (c == YEAR || c == MONTH || c == DAY) {
                if (queue.size() == 1) {
                    queue.add(ZERO);
                    queue.add(queue.poll());
                }
                while (queue.size() > 0) {
                    sb.append(queue.poll().toString());
                }
                sb.append(CONN);
            }
        }
        String res = sb.toString().substring(0, sb.length() - 1);
        if (!res.contains(CONN) || res.length() != LENGTH) {
            throw new IllegalArgumentException("Date type is illegal.");
        }
        return res;
    }
}
