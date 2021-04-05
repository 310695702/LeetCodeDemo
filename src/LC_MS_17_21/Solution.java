package LC_MS_17_21;

/**
 * 面试题 17.21. 直方图的水量
 *
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Solution {

    //暴力解
    public int trap(int[] height) {
        if (height==null)return 0;
        int max = 0;
        //首先获取最大值确定层数
        for (int i:height){
            if (i>max)max = i;
        }
        if (max==0)return 0;
        int cen = 1,l,r,sum = 0;
        while(cen<=max){
            l = 0;
            r = height.length-1;
            while (height[l]<cen){
                l++;
            }
            while (height[r]<cen){
                r--;
            }
            if (l>=r){
                cen++;
                break;
            }
            for (l=l+1;l<r;l++){
                if (height[l]<cen)sum++;
            }
            cen++;
        }
        return sum;
    }


}
