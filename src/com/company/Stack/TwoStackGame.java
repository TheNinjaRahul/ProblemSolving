package com.company.Stack;

import java.util.Stack;




import java.io.*;
        import java.math.*;
        import java.text.*;
        import java.util.*;
        import java.util.regex.*;

public class TwoStackGame {

    /*
     * Complete the twoStacks function below.
     */



    static int twoStacks(int x, int[] h1, int[] h2) {

        int result=findMax(x,h1,h2);
        int result2=findMax1(x,h2,h1);
        int result1=findMax1(x,h1,h2);
        return Math.max(Math.max(result,result1),result2);

    }


    private static int findMax1(int x, int[] h1, int[] h2) {
        int sum=0;
        int i=0;
        int count=0;
        while(true){
            if(i==h1.length){
                return findMax(x-sum,h2,h1)+count;
            }
            sum+=h1[i];
            if(sum>x)
            {
                return count;
            }
            if(sum==x){
                return count+1;
            }
            count++;
            i++;
        }
    }


    private static int findMax(int x, int[] h1, int[] h2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

//        int sh1 = 0, sh2 = 0, sh3 = 0;
        for (int i = h1.length - 1; i >= 0; i--) {
            //          sh1 += h1[i];
            s1.push(h1[i]);
        }

        for (int i = h2.length - 1; i >= 0; i--) {
//            sh2 += h2[i];
            s2.push(h2[i]);
        }
        int sum=0;
        int count=0;
        while(true){
            if(s1.isEmpty() && s2.isEmpty()){
                return count;
            }
            if(sum>x){
                return count-1;
            }
            int peek1,peek2;
            if(s1.isEmpty()){
                peek1=Integer.MAX_VALUE;
            }else{
                peek1=s1.peek();
            }

            if(s2.isEmpty()){
                peek2=Integer.MAX_VALUE;
            }else{
                peek2=s2.peek();
            }

            count++;
            if(peek1<=peek2){
                sum+=peek1;
                s1.pop();
            }else{
                sum+=peek2;
                s2.pop();
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();
    }
}
