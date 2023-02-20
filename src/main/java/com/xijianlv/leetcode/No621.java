package com.xijianlv.leetcode;

import java.util.Arrays;

/**
 * @author xijianlv
 */
public class No621 {

    /**
     * 需要空闲时
     * (最多的单个任务数量-1)*(间隔+1)+任务数量和最大任务数量相等的任务数
     * <p>
     * 不需要空闲时
     * 数组长度
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i] - 'A']++;
        }
        //任务数量和最大任务数量相等的任务数
        int maxcount = 1;
        Arrays.sort(buckets);

        for (int i = 24; i >= 0; i--) {
            if (buckets[i] == buckets[25]) {
                maxcount++;
            }
        }
        int res = (buckets[25] - 1) * (n + 1) + maxcount;
        return Math.max(res, tasks.length);
    }
}
