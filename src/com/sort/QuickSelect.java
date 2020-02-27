package com.sort;

/**
 * 快排
 */
public class QuickSelect {
    public static int quickSelect(int[] arr,int k){
        return 0;
    }

    private static int selectPivotRandom(int start,int end){
        return (int) (start+Math.floor(Math.random() * (start-end+1)));
    }

    public static int quickSelectHelper
            (int start,int end,int[] arr,int k){
        if (start == end){
            return arr[start];
        }

        int pvoitIndex = selectPivotRandom(start,end);
//        int index = QuickSorter.partition(arr,start,end,pvoitIndex);
        int index = QuickSorter.partition(arr,start,end);
        if (k == index){
            return arr[k];
        }else if (k < index){
            return QuickSorter.partition(arr,start,index+1);
        }else{
            return QuickSorter.partition(arr,index+1,end);

        }
    }
}
