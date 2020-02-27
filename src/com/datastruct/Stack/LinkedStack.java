package com.datastruct.Stack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack {

    private static class Node<E>{
        public E data;
        public Node<E> next;
        public Node(E val,Node<E> next){
            this.data = val;
            this.next = next;
        }
    }
    private Node<E> top;
    private int size;


    public LinkedStack(){
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(Object item) {
        top = new Node(item,top);
        size++;
    }

    @Override
    public Object pop() {
        if (size == 0){
            throw new EmptyStackException();
        }
        E result = top.data;
        top = top.next;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args){
        Stack<Integer> stack = new LinkedStack<Integer>();
        for (int i = 0;i < 100;i++){
            stack.push(i+1);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        int size = stack.size();
        for(int i = 0;i < size; i++){
            System.out.println("The element:" + stack.pop());
        }

    }
}
