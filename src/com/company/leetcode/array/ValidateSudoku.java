package com.company.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ValidateSudoku {
    public static void main(String[] args) {
            char [][] data={
                    {'5','3','1','.','7','.','.','.','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},

                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},

                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
            };

        System.out.println(isValidSudoku2(data));
    }

    public static boolean isValidSudoku2(char[][] board) {
        short[] rows = new short[9];
        short[] cols = new short[9];
        short[] squares = new short[9];

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') continue;

                short value = (short) (1 << board[row][col] - '1');

                if((value & rows[row]) > 0) return false;
                if((value & cols[col]) > 0) return false;
                if((value & squares[3*(row/3) + col/3]) > 0) return false;

                rows[row] |= value;
                cols[col] |= value;
                squares[3*(row/3) + (col/3)] |= value;
            }
        }
        return true;
    }
    public static boolean isValidSudoku(char[][] board) {

//        Set<Character>[] rowSet= HashSet<Character>()[3][9];
        MySet[]  box= new MySet[3];
        MySet[]  col= new MySet[9];


        for (int i = 0; i < board.length; i++) {
            if( i%3 == 0){
                box =new MySet[3];
            }
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {

                if(board[i][j]=='.'){
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    System.out.println("row issue:"+ i+ " " +rowSet);
                    return false;

                } else {
                    rowSet.add(board[i][j]);
                }

                if(box[j/3]==null){
                    box[j/3]=new MySet();
                }
                if(box[j/3].set.contains(board[i][j])){
                    System.out.println("Box issue:"+j/3+" "+i+"  and char: "+board[i][j]+"  "+box[j/3].set);
                    return false;
                }else{
                    box[j/3].set.add(board[i][j]);
                }

                if(col[j]==null){
                    col[j]=new MySet();
                }
                if(col[j].set.contains(board[i][j])){
                    System.out.println("Col issue: "+ i+"  " +col[j].set);
                    return false;
                }else {
                    col[j].set.add(board[i][j]);
                }

            }
        }

        return true;
    }


}


class MySet
{
    public Set<Character> set=new HashSet<>();
}