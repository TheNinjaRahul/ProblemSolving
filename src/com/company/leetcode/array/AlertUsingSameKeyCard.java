package com.company.leetcode.array;

import java.util.*;

public class AlertUsingSameKeyCard {
    public static void main(String[] args) {
        AlertUsingSameKeyCard a = new AlertUsingSameKeyCard();
//        String[] key = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
//        String[] time = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};
//        System.out.println(a.alertNames(key, time));

//        String[] key2 = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
//        String time2[] = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
//        System.out.println(a.alertNames(key2, time2));

        String[] key3 = {"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"};
        String[] time3 = {"23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38", "00:19"};
        System.out.println(a.alertNames(key3, time3));
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, Set<String>> map = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            if (!map.containsKey(keyName[i])) map.put(keyName[i], new TreeSet<>());
            map.get(keyName[i]).add(keyTime[i]);
        }
        System.out.println(map);
        List<String> names = new LinkedList<>();
        for (String key : map.keySet()) {
            if (checkIfExist(key, map.get(key))) {
                names.add(key);
            }
        }
        Collections.sort(names);
        return names;
    }

    private boolean checkIfExist(String key, Set<String> strings) {
        List<String> list = new ArrayList<>(strings);
        for (int i = list.size() - 1; i >= 1; i--) {
            int count = 0;
            for (int j = i - 1; j > i - 3 && j >= 0; j--) {
                int time2 = Integer.parseInt(list.get(i).replaceAll(":", ""));
                int time1 = Integer.parseInt(list.get(j).replace(":", ""));
                // difference between hours
                int hourDiff = time2 / 100 - time1 / 100 - 1;
                if (hourDiff > 1) break;
                // difference between minutes
                int minDiff = time2 % 100 + (60 - time1 % 100);
                if (minDiff <= 60 || hourDiff == -1) {
                    count++;
                }
                if (count == 2) return true;
            }
        }
        return false;
    }
}
