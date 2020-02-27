package com.sort;


/**
 * 递归
 */
public class RecursiveAlgo {

    private class Node<E>{
        private E data;
        private Node next;  //指向下一个节点
        public Node(E data,Node next){
            this.data = data;
            this.next = next;
        }
        public Node(E data){
            this(data,null);
        }
    }

    public static int sum(int[] arr,int startIndex,int endIndex){
        if (startIndex == endIndex){
            return arr[startIndex];
        }
        return arr[startIndex] + sum(arr,startIndex+1,endIndex);
    }

    public static int countListNodes(Node head){
        if (head == null){
            return 0;
        }
        return 1+countListNodes(head);
    }

    //正向打印
    public static void printList(Node head){
        if (head == null){
            return;
        }
        System.out.println(head.data);
        printList(head.next);
    }

    //反向打印
    public static void printListReverse(Node head){
        if (head == null){
            return;
        }
        printList(head.next);
        System.out.println(head.data);
    }




}
