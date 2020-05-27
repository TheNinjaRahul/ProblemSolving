package com.company.GFG.search;

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int data[]={5 ,6 ,7 ,8 ,9 ,10 ,1 ,2 ,3};
        System.out.println(search(data,10));

//        int data2[]={3 ,5,1,2};
//        System.out.println(search(data2,6));
//        int data3[]={3,1,2};
//        System.out.println(search(data3,1));
    }

    static int search(int b[], int i)
    {
        int pivot=searchIndexOFRotation(0,b.length-1,b);
        return Math.max(binarySearch(0,pivot,b,i),binarySearch(pivot+1,b.length-1,b,i));
    }

    public static int binarySearch(int start,int end,int []b,int i){
        int mid=0;
        while(start<=end){
            mid=start+((end-start)/2);
            if(b[mid]==i){
                return mid;
            }
            if(b[mid]>i){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static  int searchIndexOFRotation(int start,int end,int b[]){
//        int start=0,end=b.length-1,ans=-1,mid=0;
            if(start>end) return -1;
            int mid=0,ans=-1;
            mid=start+((end-start)/2);
            if(mid<=0 || (mid >= b.length-1 ))
            {
                return 0;
            }
//            if(mid >= b.length-1 ){
//                return b.length-1;
//            }
            if( mid != 0 && mid!=b.length-1 && b[mid-1]<b[mid] && b[mid]>b[mid+1]){
                return mid;
            }
            return Math.max(searchIndexOFRotation(start,mid-1,b),searchIndexOFRotation(mid+1,end,b));
    }

}
