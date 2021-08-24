package LC1011;

import java.util.Arrays;

/**
 * @version: V1.0
 * @author: HanYuXing
 * @date: 2021-08-20 9:21
 **/
class Solution {
    public static int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt(),r = Arrays.stream(weights).sum(),mid =0;
        while (l<r){
            mid = l + (r - l)/2;
            if (getDays(weights,mid) <= days)
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }


    private static int getDays(int[] weights, int mid) {
        int cur=0,days = 0;
        for (int weight:weights){
            if (cur + weight <= mid){
                cur += weight;
            }else {
                days ++;
                cur = weight;
            }
        }
        days ++;
        return days;
    }

}
