package LC75;

import java.util.Random;

/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[0]
 *
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
class Solution {
    public void sortColors(int[] nums) {
        Random random = new Random();
        sort3ways(nums,0,nums.length-1,random);
    }

    private void sort3ways(int[] arr,int l,int r,Random random){
        if (l>=r)return;
        int p = random.nextInt(r-l+1)+l;
        swap(arr,l,p,arr[l]);
        int lt=-1,i=l,rt=r+1;
        while (i<rt){
            if (arr[i] == 0){
                lt++;
                swap(arr,lt,i,0);
                i++;
            }else if(arr[i] == 2){
                rt--;
                swap(arr,i,rt,2);
            }else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j ,int iparam) {
        arr[i] = arr[j];
        arr[j] = iparam;
    }
}