package com.company.leetcode.string;

public class AmazonFreshPromotion {
    public static void main(String[] args) {
        String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        System.out.println(AmazonFreshPromotion.winPrize(codeList2, shoppingCart2));
        System.out.println(AmazonFreshPromotion.winPrize(codeList1, shoppingCart1));

    }

    public static int winPrize(String[][] codeList, String[] shoppingCart) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < shoppingCart.length; k++) {
            if (codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
                j++;
                if (j == codeList[i].length) {
                    i++;
                    j = 0;
                }
                if (i == codeList.length) return 1;
            } else {
                j = codeList[i][0].equals("anything") ? 1 : 0;
            }
        }
        return 0;
    }

    private static int solve(String[][] codeList, String[] shoppingCart) {
        if (codeList == null || codeList.length == 0)
            return 1;
        if (shoppingCart == null || shoppingCart.length == 0)
            return 0;
        int i = 0, j = 0;
        /*
        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
         */
        for (int k = 0; k < shoppingCart.length; k++) {
            if (codeList[i][j].equals(shoppingCart[k]) || codeList[i][j].equals("anything")) {
                j++;
                if (j == codeList[i].length) {
                    i++;
                    j = 0;
                }
                if (i == codeList.length)
                    return 1;
            } else {
                j = codeList[i][0].equals("anything") ? 1 : 0;
            }
        }
        return 0;
    }
}
