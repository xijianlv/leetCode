package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No29 {
    public static void main(String[] args) {
        divide(10, 3);
    }

    public static int divide(int dividend, int divisor) {
        int ans = 0;
        if (divisor == 0) {
            return ans;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend > Integer.MIN_VALUE ? -dividend : Integer.MAX_VALUE;
        }

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        ans = div(absDividend, absDivisor);

        return sign > 0 ? ans : -ans;
    }

    public static int div(long a, long b) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            long temp = a >> i;
            if (temp >= b) {
                ans = ans | (1 << i);
                a = a - (b << i);
            }
        }
        return ans;
    }
}
