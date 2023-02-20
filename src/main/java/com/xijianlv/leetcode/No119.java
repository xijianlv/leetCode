package com.xijianlv.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xijianlv
 */
public class No119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0) {

            return ans;
        }
        ans.add(1);
        if (rowIndex == 1) {
            return ans;
        }

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < ans.size() - 1; j++) {
                temp.add(ans.get(j) + ans.get(j + 1));
            }
            temp.add(1);
            ans = temp;
        }

        return ans;

    }
}
