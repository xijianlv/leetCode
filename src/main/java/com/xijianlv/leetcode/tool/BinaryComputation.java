package com.xijianlv.leetcode.tool;

/**
 * @author xijianlv
 * 二进制计算
 */
public class BinaryComputation {
    //https://blog.csdn.net/weixin_46838716/article/details/125381154
    //https://blog.csdn.net/BlackCarDriver/article/details/105247856?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-105247856-blog-122266040.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-105247856-blog-122266040.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=1
    /**
     * 二进制加法
     * ans = a ^ b; 即ans为 a + b 不考虑进位的结果，也就是无进位加法的结果
     * b = (a & b) << 1; 即 将b赋值为 a + b 的进位。
     * <p>
     * 然后继续进行 a + b 直到 b(进位) 为0，则a就为 a + b 的结果
     *
     * @param a 加数
     * @param b 加数
     * @return 结果
     */
    public static int binaryAdd(int a, int b) {
        int ans = 0;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans;
    }

    /**
     * 求一个数的负数
     *
     * @param num 待转变的数值
     * @return num的负数
     */
    public static int binaryNegate(int num) {
        return binaryAdd(~num, 1);
    }

    /**
     * 二进制减法
     *
     * @param a 被减数
     * @param b 减数
     * @return 结果
     */
    public static int binaryMinus(int a, int b) {
        return binaryAdd(a, binaryNegate(b));
    }

    /**
     * 二进制两个数相乘
     *
     * @param a 乘数
     * @param b 乘数
     * @return 结果
     */
    public static int binaryMulti(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                ans = binaryAdd(ans, a);
            }
            /*
             * >>> 使用零扩展：无论正负，都在高位插入0
             * >> 使用符号扩展：若符号为正，则在高位插入0；若符号为负，则在高位插入1
             * << 低位补0
             */
            b = b >>> 1;
            a = a << 1;
        }
        return ans;
    }

    /**
     * 二进制除法
     *
     * @param a 被除数
     * @param b 除数
     * @return 商
     */
    public static int binaryDiv(int a, int b) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int temp = a >> i;
            if (temp >= b) {
                ans = ans | (1 << i);
                a = binaryMinus(a, b << i);
            }
        }
        return ans;
    }

}
