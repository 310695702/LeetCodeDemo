package LC912;

import java.util.Random;

/**
 * 912.排序数组
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        Random random = new Random();
        sort(nums,0,nums.length-1,random);
        return nums;
    }

    public static void sort(int[] arr, int l, int r, Random random){
        if(l>=r)return;
        int p = partition(arr,l,r,random);
        sort(arr,l,p-1,random);
        sort(arr,p+1,r,random);
    }

    private static int partition(int[] arr,int l,int r,Random random){
        int p = l+random.nextInt(r-l+1);
        swap(arr,l,p);
        int j = l;
        for(int i=l;i<=r;i++){
            if(arr[i]<arr[l]){
                j++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }

    private static void swap(int[] arr,int l,int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
