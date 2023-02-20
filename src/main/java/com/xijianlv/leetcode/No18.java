package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 转long，防止四个1000000000 在比较的时候溢出
 * @author xijianlv
 */
public class No18 {

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = 0;
        fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums.length < 4) {
            return ans;
        }
        long xxx = target;
        Arrays.sort(nums);
        for (int j = 0; j < len; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            long numj = nums[j];
            long _target = xxx - numj;
            for (int i = j + 1; i < len; i++) {
                if (i > j + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                int r = len - 1;

                while (l < r) {
                    long numi = nums[i];
                    long numl = nums[l];
                    long numr = nums[r];
                    long sum = numi + numl + numr;
                    if (sum == _target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[j]);
                        list.add(nums[i]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;

                    } else if (sum < _target) {
                        l++;
                    } else {
                        r--;
                    }
                }

            }
        }
        return ans;
    }
}
