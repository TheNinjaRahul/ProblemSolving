package com.company.challenges;

public class ViralAdvertisement {
    public static void main(String[] args) {
        System.out.println(viralAdvertising(6));
//        System.out.println(5);

    }

    static int viralAdvertising(int n) {
        if(n==1){
            return 2;
        }
        int like=2;
        int c=like;
//        int number=like*3;
        for(int i=2;i<=n;i++){
            like=(like*3)/2;
            c+=like;
//            System.out.println(c);
        }
        return c;
    }

}
