package com.xijianlv.leetcode.test;

public class Point {

    private Integer xg;
    private Integer yg;

    public Point(Integer xg, Integer yg) {
        this.xg = xg;
        this.yg = yg;
    }

    public Integer getXg() {
        return xg;
    }

    public void setXg(Integer xg) {
        this.xg = xg;
    }

    public Integer getYg() {
        return yg;
    }

    public void setYg(Integer yg) {
        this.yg = yg;
    }

    @Override
    public String toString() {
        return "Point{" +
                "xg=" + xg +
                ", yg=" + yg +
                '}';
    }
}
