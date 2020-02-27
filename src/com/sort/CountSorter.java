package com.sort;

/**
 * 计数排序
 */
public class CountSorter implements Sorter {
    @Override
    public void sort(int[] args) {
        //不稳定
        int max = findMax(args);
        int[] count=new int[max+1];
        count(args,count);
        rebuildArray(args,count);

    }

    int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i : arr){
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    void count(int[] arr,int count[]){
        for (int i : arr){
            count[i]++;
        }
    }

    void totalCount(int[] count){
        int sum = 0;
        for (int i =0;i < count.length;i++){
            sum+= count[i];
            count[i] = sum;
        }
    }

    void rebuildArrayStable(int [] arr,int totalCount[]){
        int[] sortedArr=new int[arr.length];
        for (int i = arr.length-1;i >=0;i--){
            sortedArr[totalCount[arr[i]]-1]=arr[i];
            totalCount[arr[i]]--;
        }
        for (int i =0;i < arr.length;i++){
            arr[i]=sortedArr[i];
        }
    }

    void rebuildArray(int[] arr,int count[]){
        int index = 0;
        for (int j = 0;j < count.length;j++){
            for (int i =0;i < count[j];i++){
                arr[index++]=j;
            }
        }
    }
}
