package com.xijianlv.leetcode;

/**
 * @author xijianlv
 */
public class No812 {


    public double largestTriangleArea(int[][] points) {
        int count = points.length;
        double ans = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i; j < count; j++) {
                for (int k = j; k < count; k++) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    /**
     * area = 1/2(a*b*sin(C))
     * @param point
     * @param point1
     * @param point2
     * @return
     */
    public double area(int[] point, int[] point1, int[] point2) {
        return 0.5 * Math.abs(point[0] * point1[1] + point1[0] * point2[1] + point2[0] * point[1]
                - point[1] * point1[0] - point1[1] * point2[0] - point2[1] * point[0]);

    }


}
