package LC3;

import java.util.HashMap;

/**
 * @author: HanYuXing
 * @date: 2021-09-24 16:29
 **/
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<String ,Integer> map = new HashMap<>(s.length());
        int j=0;
        for (int i=1;i<s.length();i++){
            int index = s.substring(j, i).indexOf(s.substring(i, i + 1));
            if (index != -1) {
                continue;
            }
            map.put(s.substring(j,i),s.substring(j,i).length());
            j ++;
            i = j;
        }
        int max = 0;
        map.forEach((k,v)->{
            System.out.println(v);
        });
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcada");
    }
}
