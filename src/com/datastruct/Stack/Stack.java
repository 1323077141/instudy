package com.datastruct.Stack;

public interface Stack<E> {

    public boolean empty();

    public int size();

    //压栈
    public void push(E item);

    //弹栈
    public E pop();

    //查看栈顶元素,不弹栈
    public  E peek();
}
