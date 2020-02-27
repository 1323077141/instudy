package com.sort;

/**
 * 归并
 */
public class MergeSorter implements Sorter {
    @Override
    public void sort(int[] args) {
        //时间复杂度O(nlgn)-最坏(T(n)=2T(n/2)+O(n))
        //空间复杂度O(n)->怎么实现原地merge
        //稳定(左子数组优先),适合并行化
        if (args == null || args.length <= 1){
            return;
        }
        int[] tmp = new int[args.length];
        sortHelp(args,0,args.length-1,tmp);
    }

    public void sortHelp(int[] args,int start,int end,
                         int[] tmp){
        if (start >= end){
            return;
        }
        int mid = (start + end)/2;
        sortHelp(args,start,mid,tmp);
        sortHelp(args,mid+1,end,tmp);
        merge(args,start,mid,mid+1,end,tmp);
    }
    void merge(int[] arr,int s1,int e1,int s2,
               int e2,int[] tmp){
        int i = s1,j=s2,k=0;
        while (i <= e1 && j <= e2){
            if (arr[i] <= arr[j]){
                tmp[k++]=arr[i++];
            }else{
                tmp[k++]=arr[j++];
            }
        }
        while (i <= e1){
            tmp[k++] = arr[i++];
        }
        while (j <= e2){
            tmp[k++] = arr[j++];
        }
        for (int l=0;l < k;l++){
            arr[s1+l]=tmp[l];
        }

    }

}
