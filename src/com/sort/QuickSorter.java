package com.sort;

public class QuickSorter implements Sorter {

    public final static int THRESHOLD = 10;

    //最好/平均:T(n)=2T(n/2)+O(n)   O(nlgn)
    //最坏:T(n)=T(n-1)+O(n)   O(n)
    @Override
    public void sort(int[] args) {
        if (args == null || args.length <= 1){
            return;
        }
        sortHelper(args,0,args.length-1);
    }

    //获取三位数中的中位数
    private int medianOf3Nums(int[] arr,int lo,int center,int hi){
        if (arr[lo] < arr[center]){
            if (arr[center] < arr[hi]){
                return center;
            }else{
                return (arr[lo] < arr[hi] ? hi : lo);
            }
        }else{
            if (arr[hi] < arr[center]){
                return center;
            }else{
                return (arr[hi] > arr[lo] ? hi:lo);
            }
        }
    }

    /**
     * 三分查找
     * @param arr
     * @param start
     * @param end
     */
    private void sortHelper1(int[] arr,int start,int end){

        if (end - start +1 <= THRESHOLD){
            //插入排序

            return;
        }
        int pivot = arr[start];
        int lt=start,i = start+1,gt=end;
        while (i <= gt){
            if (arr[i] < pivot){
                swap(arr,i,lt);
                lt++;
                i++;
            }else if (arr[i] > pivot){
                swap(arr,i,gt);
                gt--;
            }else{
                i++;
            }
        }
        sortHelper1(arr,start,lt-1);
        sortHelper1(arr,gt+1,end);

    }

    private void sortHelper(int[] arr,int start,int end){

        if (end - start +1 <= THRESHOLD){
            //插入排序

            return;
        }

        if(start>=end){
            return;
        }
        int center = medianOf3Nums(arr,start,(end-start)/2,end);
        swap(arr,start,center); //将中间元素(不大不小的)换到刚开始
        int index = partition(arr,start,end);
        sortHelper(arr,start,index-1);
        sortHelper(arr,index+1,end);
    }

    /**
     * [start,i-1]:小于等于pviot
     * [i,j]:未处理
     * [j+1,end]：大于pviot
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partition2(int[] arr, int start, int end) {
      int pivot = arr[start];
      int i = start +1,j=end;
      while (i < j){
            while(arr[i] <= pivot && i < j){
                i++;
            }
            while (arr[j] > pivot && i < j){
                j--;
            }
            if (i < j){
                swap(arr,i,j);
                i++;
                j--;
            }
      }

      swap(arr,start,i-1);
      return i-1;

    }


    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        for (int j = start + 1;j <= end;j++){
            if (arr[j] <= pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,start,i-1);
        return i-1;
    }



    static void swap(int [] arr,int i,int j){
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;
    }
}
