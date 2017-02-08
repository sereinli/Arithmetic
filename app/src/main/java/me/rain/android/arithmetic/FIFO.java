package me.rain.android.arithmetic;

/**
 * FIFO队列
 * Created by serein on 2017/2/8.
 */

public class FIFO {

    private int[] stack;
    private int top;
    private int size;

    public FIFO(int maxSize) {
        size = maxSize;
        top = -1;
        stack = new int[maxSize];
    }

    private boolean isFull() {
        return top == size - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if(isFull()) {
            System.out.println("Stack is full!");
            return;
        }

        stack[++top] = value;
    }

    //弹出栈顶内容
    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return 0;
        }

        return stack[top--];
    }

    //返回栈顶内容，但不删除
    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return 0;
        }

        return stack[top];
    }

    //打印栈内容
    public void printStack() {
        for(int i = top; i >= 0; i--) {
            System.out.println("stack["+ i + "]:"+stack[i]);
        }
    }
}
