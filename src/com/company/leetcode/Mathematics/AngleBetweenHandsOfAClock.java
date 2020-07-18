package com.company.leetcode.Mathematics;

public class AngleBetweenHandsOfAClock {
    public static void main(String[] args) {

    }

    public double angleClock(int hour, int minutes) {
        float h = (60 * hour) + minutes;
        h *= 0.5;
        float min = 6 * minutes;
        return Math.abs(h - min) <= 180 ? Math.abs(h - min) : 360 - Math.abs(h - min);
    }

}
