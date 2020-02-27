package com.datastruct.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

    private final static int DEFAULT_CAPACITY=10;
    private E[] data;
    private  int size;

    private int top;//栈顶索引

    public ArrayStack(int capacity){
        this.data= (E[]) new Object[capacity];
        this.size=0;
        this.top=-1;
    }

    public ArrayStack(){
        this(DEFAULT_CAPACITY);
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
    public void push(E item) {
        if (data.length == size){
            grow(data.length * 2);
        }
        data[++top]=item;
        size++;
    }

    private void grow(int i) {
        if (i <= DEFAULT_CAPACITY){
            return;
        }
        data = Arrays.copyOf(data,i);
    }

    @Override
    public E pop() {
        if(size == 0){
            throw new EmptyStackException();
        }
        if(size < data.length/2){
            grow(data.length/2);
        }
        size--;
        return data[top--];
    }

    @Override
    public E peek() {
        if(size == 0){
            throw new EmptyStackException();
        }
        return data[top];
    }

    public static void main(String[] args){
        Stack<Integer> stack = new ArrayStack<>();
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
