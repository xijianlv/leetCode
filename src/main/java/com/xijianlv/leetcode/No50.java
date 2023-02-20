package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No50 {

    public static void main(String[] args) {
        double x = 2;
        int n = -2147483648;
        myPow(x,n);
    }

    public static double myPow(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    public static double quickMul(double x, long n) {
        double temp = x;
        double ans = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= temp;
            }
            temp *= temp;
            n /= 2;
        }
        return ans;
    }
}
