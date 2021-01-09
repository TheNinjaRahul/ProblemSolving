package com.company;

public class ClockProblem {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30));
        System.out.println(angleClock(3, 15));
    }

    private static double getClockEngle(int h, int min) {
        double perMin = 6;
        double perMinHourEngle = 0.5;
        double minStick = perMin * min;
        double hourStickMoved = min * perMinHourEngle;
        double finalHourPosition = (perMin * 5 * h) + hourStickMoved;

        return Math.max(minStick, finalHourPosition) - Math.min(minStick, finalHourPosition);
    }

    public static double angleClock(int hour, int min) {
        hour %= 12;
        double perMin = 6;
        double perMinHourEngle = 0.5;
        double minStick = perMin * min;
        double hourStickMoved = min * perMinHourEngle;
        double finalHourPosition = (perMin * 5 * hour) + hourStickMoved;

        double ans = Math.max(minStick, finalHourPosition) - Math.min(minStick, finalHourPosition);

        if (ans > 180) {
            return ans - 180;
        } else {
            return ans;
        }
    }
}
