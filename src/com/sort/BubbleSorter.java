package com.sort;


public class BubbleSorter implements Sorter {
    @Override
    public void sort(int[] args) {
        if (args == null || args.length == 1){
            return ;
        }


        //best O(n)
        //worst Avg(O^2)
        //T(n)=T(n-1)+O(N)
        for (int i = 0,len = args.length; i < len; i++){
            boolean flag =false;
            for (int j = 0;j < args.length-1-i; j++){
                if (args[j] > args[j+1]){
                    int tmp = args[j];
                    args[j] = args[j+1];
                    args[j+1] = tmp;
                    flag = true;
                }
            }
            //排序完成时即完成排序
            if (!flag){
                return;
            }
        }

    }

    public static void main(String[] args){
    }

}
