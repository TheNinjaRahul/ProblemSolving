package com.company.GFG.Matrix;

public class SearchInRColumnSortedMatrix {
    public static void main(String[] args) {
//        int [][]a={{3 ,30 ,38},{ 44, 52, 54},{ 57, 60, 69}};
        int [][]x={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        System.out.println(searchMatrix(x,10));
////        System.out.println(searchMatrix(a,62));
////        System.out.println(searchMatrix(a,62));
//       int d[][]={{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
//        System.out.println(searchMatrix(d,3));
//        int [][] b={{1}};
//        System.out.println(searchMatrix(b,2));
        int[][] d={{1},{2}};

        int[][]gfg={{18}, {21}, {27}, {38}, {55}, {67}};
        System.out.println(searchGFG(0,0,55,gfg));
    }

    static int search( int n,int m, int x, int a[][])
    {
        printMatrix(a);

        return 0;
    }

    public static boolean searchMatrix(int[][] a, int target) {

        if (null == a || a.length == 0 || a[0].length == 0) {
            return false;
        }
        int row=a.length;

        int col=a[0].length;

        int i=0;
        for(i=0;i<row;i++){
            if(a[i][col-1]==target){
                return true;
            }else if(a[i][col-1] > target ){
//                i--;
                break;
            }
        }
        if(i==row){
            i--;
        }
        for(int j=col-1;j>=0;j--){
            if(a[i][j]==target){
                return true;
            }
        }

        return false;
    }

    private static int searchCol(int[][] a, int r, int col, int target) {
        {
            int l=0,h=col-1;
            int mid=-1;
            while(l<=h){
                mid=l+(h-l)/2;
                if(a[r][mid]==target){
                    return mid;
                }else{
                    if(a[r][mid]<target)
                    {
                        h=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
            }
            return mid;
        }
    }

    private static int searchRow(int[][] a, int row, int col, int target) {
        int l=0,h=row-1;
        int mid=-1;
        while(l<=h){
            mid=l+(h-l)/2;
            if(a[mid][col-1]<target){
                return mid;
            }else{
                if(a[mid][col-1]<target)
                {
                    h=mid-1;
                }else{
                    l=mid+1;
                }
            }
        }
        return mid;
    }

    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    static int searchGFG( int n,int m, int target, int[][] a) {

        if (null == a || a.length == 0 || a[0].length == 0) {
            return 0;
        }
        int row=a.length;

        int col=a[0].length;

        int i=0;
        for(i=0;i<row;i++){
            if(a[i][col-1]==target){
                return 1;
            }else if(a[i][col-1] > target ){
//                i--;
                break;
            }
        }
        if(i==row){
            i--;
        }
        for(int j=col-1;j>=0;j--){
            if(a[i][j]==target){
                return 1;
            }
        }

        return 0;
    }
}
