package com.datastruct.Queue;

public class LinkedQueue<E> implements Queue<E> {
    private static class Node<E>{
        private E data;
        private Node<E> next;
        public Node(E data,Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        Node<E> prev = tail;
        tail = new Node<E>(e,null);
        if (size == 0){
            head = tail;
        }else{
            prev.next = tail;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0){
            throw new RuntimeException("空队列");
        }
        E result = head.data;
        head = head.next;
        size--;
        if (size == 0){
            tail = null;
        }
        return result;
    }

    @Override
    public E peek() {
        return head.data;
    }
}
