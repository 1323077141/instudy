package com.sort;

public class SelectSorter implements Sorter {
    @Override
    public void sort(int[] args) {

        if (args == null || args.length == 1){
            return;
        }
        //best:O(n)
        //worst:O(n^2)
        //avg:O(n^2)
        for (int i =0,len = args.length; i < len;i++){
            int minIdex = i;    //[0,i-1]是有序的
            for (int j = i+1;j < args.length;j++){
                if (args[minIdex] > args[j]){
                    minIdex = j;
                }
            }
            int tmp = args[i];
            args[i]=args[minIdex];
            args[minIdex] = tmp;
        }

    }
}
