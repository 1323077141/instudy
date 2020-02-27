#算法复杂度
在RAM模型中，算法的运行时间与算法需要执行的指令操作次数成正比，记为T(n)
BigO:存在常数c和函数f(n)，使得当n>=c时,T(n)<=f(n),表示为T(n)=O(f(n))
常数项可忽略,低次项可忽略
主定理：
令a>=1和b>1是常数,f(n)是一个函数,T(n)是定义在非负数整数上的递归式:
T(n)=aT(n/b)+f(n)
其中将n/b解释为n/b的向上取整或者向下取整,那么T(n)有如下渐近界:
1.若对某个常数c>0有f(n)=O(n^{\log_b(a-c) })，则T(n)=O(n^{\log_b a })
2.若f(n)=O(n^(logb(a))),则T(n)=O(n^(logba)*lg(n))
3.若对某个常数c>0,有f(n)=Omega(n^(lngb(a+b))),且对某个常数c<1和所有足够大的n有af(n/b) 小于 cf(n),则T(n) = O(f(n)).
例如.快排:T(n)=2T(n/2)+O(n),对比主定理T(n)=aT(n/b)+f(n),
则a=2,b=2,f(n)=O(n),符合第二条,则平均复杂度O(nlogn),最坏为O(n^2)

O(1)：常数阶;O(logn):对数阶;指数阶:O(2^n)
O(1)>O(logn)>O(n)>O(nlogn)>O(n^2)>O(2^n)>O(n!)

#数据结构
##数组与链表
            get/set     Add/Remove
ArrayList   O(1)            O(n)
LinkedList  O(n)            O(n)

##栈与队列
栈:后进先出(递归调用;基于数组的实现/基于链表的实现)
队列：先进先出:队尾进队列,队头出队列

#排序算法
##冒泡排序
通过两两比较交换位置，选出最大或最小放至数组尾部，[n-i-1,n-1]是有序的
`
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
`
##插入排序(当数据量小的时候,一般选择插入排序)
第i趟排序将数组第i+1个元素K(i+1)插入到一个已经按值有序的
子数组行(K1,K2,......,Ki)中的合适的位置,使得插入后的数组任然保持有序。[0,i-1]是有序的
`
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
`
##选择排序
每次从待排序的元素中选出最小(大)的一个元素，放在数组的起始位置，然后一直重复，直到排序完成
`
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
`

##递归
若一个算法直接或者间接的调用自己，则为递归算法
阶乘，数列，链表，树与分治法用到递归

##归并排序
建立在归并操作上的一种有效的排序算法，该算法是分治法
-先使每个子数组有序，再使子数组间有序
-将已有序的子数组合并，得到完全有序的数组
`
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
`

##快速排序
基于比较的排序算法的平均时间复杂度下限为O(nlgn)，最坏为O(n^2)
基本思想:
-从数组中取出一个数作为中轴数
-划分数组：将比这个数大的数放在右边，小的数放在左边
-再对左右区间重复上述，直到各区间只有一个数
数组划分:
索引i,j把数组分成三段:
①
[start,i-1] 都小等于pivot
[i,j] 都大于pivot
[j+1,end]未处理
②
[start,i-1]:小于等于pviot
[i,j]:未处理
[j+1,end]：大于pviot
`
`

快排的改进：
1.当划分到较小的数组时，通常可以使用插入排序代替快速排序
2.三平均分区法:
-并不是选择待排序数组的第一个数作为中轴，
而是选用待排数组最左边，最右边和中间的三个元素的中间值作为中轴
三分算法分区:
N-m(<pviot)|=pviot|M(>pviot)
[start,lt-1] 小于pviot
[lt,i-1]等于pviot
[i,gt]未处理
[gt,end]大于pviot

##线性时间排序
基于比较的排序算法时间复杂度下限为O(nlgn)
线性时间排序(计数排序,桶排序,基数排序)

###计数排序
当n个输入的每一个元素都为介于0-k的整数，此处k为整数,可以使用计数排序
即：计数排序记录在n个输入中，值为0,1,...,k分别有多少个，
之后根据几率号的个数来决定各元素摆放的位置
O(n):可以稳定(使用统计排序)，也可以不稳定

###桶排序

###基数排序


##算法比较

    空间复杂度   平均时间复杂度 最好时间复杂度 最坏时间复杂度 是否稳定
冒泡O(1)          O(n^2)          O(n)        O(n^2)      是
插入O(1)          O(n^2)          O(n)        O(n^2)      是
选择O(1)          O(n^2)          O(n^2)      O(n^2)      是
归并O(n)/O(1)     O(nlgn)         O(nlgn)                 是
快排              O(nlgn)         O(nlgn)     O(n)        否


#查找算法
##快速选择
是快速排序的分支算法,用于查找第K个元素：
[start,j-1]:当第K个元素在这个区间是(大于arr[j]或者小于arr[j]时)，在该区间查找
[j]:
[j+1,end]:当第K个元素在这个区间是(小于arr[j]或者大于arr[j]时)，在该区间查找

##二分搜索
给定一个排序数组，找出等于K的数
