package com.xijianlv.leetcode;

/**
 * <a href="https://leetcode.cn/problems/sqrtx/">x 的平方根 </a>
 * <a href="https://leetcode.cn/problems/jJ0w9p/">剑指 Offer II 072. 求平方根</a>
 *
 * @author xijianlv
 */
public class No69 {
    public static int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int ans = (int) (Math.exp(0.5 * Math.log(x)));
        return (long) (ans + 1) * (ans + 1) > x ? ans : ans + 1;
    }

    public static int mySqrt1(int x) {
        //二分法
        int ans = -1;
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = (high - low) >> 1 + low;
            if ((long) mid * mid <= x) {
                low = mid + 1;
                ans = mid;
            }
            if ((long) mid * mid > x) {
                high = mid - 1;
            }
        }
        return ans;
    }
}
