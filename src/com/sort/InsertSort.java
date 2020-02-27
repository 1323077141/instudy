package com.sort;

/**
 * 插入排序
 */
public class InsertSort implements Sorter {
    @Override
    public void sort(int[] args) {
        if (args == null || args.length == 1){
            return;
        }
        //best:O(n)
        //worst:O(n^2)
        //avg:O(n^2) (T(n)=T(n-1)+O(n))
        for (int i = 1,len = args.length;i < len; i++){
            //0-(i-1)是有序的
            int ele = args[i];
            int j = i-1;
            //二分查找:O(n)->O(lgn)
            while (j >=0 && ele < args[j]){
                args[j+1]=args[j];  //后移
                j--;
            }
            args[j+1]=ele;
        }


    }
}
