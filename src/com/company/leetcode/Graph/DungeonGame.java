package com.company.leetcode.Graph;

public class DungeonGame {
    public static void main(String[] args) {

        int data[][]={{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int d[][]={{0}};
        int t[][]={{0,-3}};
        System.out.println(calculateMinimumHP(t));
        System.out.println(calculateMinimumHP(d));
        System.out.println(calculateMinimumHP(data));
    }

    private static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;

        int row=dungeon.length;
        int col=dungeon[0].length;
        int[][] result=new int[row][col];
        row--;col--;
        result[row][col]= 1-dungeon[row][col]>0 ? 1-dungeon[row][col] : 1;

        for(int i=row-1;i>=0;i--){
            result[i][col]=result[i+1][col]-dungeon[i][col]>0 ? result[i+1][col]-dungeon[i][col] : 1;
        }
        for(int i=col-1;i>=0;i--){
            result[row][i]=result[row][i+1]-dungeon[row][i]>0 ? result[row][i+1]-dungeon[row][i] : 1;
        }


        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                result[i][j]= Math.max(Math.min(result[i+1][j],result[i][j+1])-dungeon[i][j],1);
            }
        }

        return result[0][0];
    }

    public static int calculateMinimumHP2(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 0;
        return minimpath(dungeon,0,0);
    }

    private static int minimpath(int[][] dungeon, int row, int col) {
        if(row >= dungeon.length || col >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }

        int health=Math.min(minimpath(dungeon,row+1,col),minimpath(dungeon,row,col+1));

        if(health==Integer.MAX_VALUE){
            if(1-(dungeon[row][col])>0){
                return 1-(dungeon[row][col]);
            }else{
                return 1;
            }

        }

        int res=0;
        if(health-dungeon[row][col]>0){
            res=health-dungeon[row][col];
        }else{
            res=1;
        }
        return res;
    }
}
