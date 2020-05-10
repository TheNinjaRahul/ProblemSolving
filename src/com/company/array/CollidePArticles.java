package com.company.array;

public class CollidePArticles {
    public static void main(String[] args) {
//        int[] data={1,3,7,4,6,4};
//        int[] result={1,3,7,4,6,4};
        int[] data={8,3,6,3,2,2,4,8,1,6};
        int[] result={8,3,6,3,2,2,4,8,1,6};
        int pos=7;
        int count=0;

        for(int i=0;i<pos;i++){
            for(int j=0;j<i;j++){
                result[j]=data[j]+result[j];
            }
        }
        for(int i=pos;i<100;i++){
            for(int j=0;j<i;j++){
                if(j<data.length)
                result[j]=data[j]+result[j];
            }
            for(int k=0;k<data.length-i;k++){
                if(result[k]==result[pos]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
