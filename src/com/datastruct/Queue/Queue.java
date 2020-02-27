package com.datastruct.Queue;

public interface Queue<E> {

    public int size();
    public boolean empty();
    public void enqueue(E e);
    public E dequeue();
    public E peek();
}
