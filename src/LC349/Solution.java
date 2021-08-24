package LC349;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @version: V1.0
 * @author: HanYuXing
 * @date: 2021-08-24 14:07
 **/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i:nums1)
            set.add(i);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i:nums2){
            if (set.contains(i)){
                arrayList.add(i);
                set.remove(i);
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i=0;i<res.length;i++){
            res[i] = arrayList.get(i);
        }
        return res;
    }
}
