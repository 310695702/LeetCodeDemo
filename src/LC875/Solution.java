package LC875;

import java.util.Arrays;

/**
 * @version: V1.0
 * @author: HanYuXing
 * @date: 2021-08-20 9:09
 **/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1,r = Arrays.stream(piles).max().getAsInt(),mid = 0;
        while (l<r){
            mid = l + (r - l)/2;
            if (getEatTime(piles,mid) <= h)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int getEatTime(int[] arr,int mid){
        int h = 0;
        for (int i:arr){
            h += i/mid + (i % mid > 0 ? 1 : 0);
        }
        return h;
    }
}
