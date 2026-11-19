package org.example;

public class StackUsingLinkedList {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;
    static int size = 0;

    static void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate + " -> top " + top.data + ", size " + size);
    }

    static void pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return;
        }

        String removed = top.data;
        top = top.next;
        size--;

        System.out.println("pop -> " + removed + ", size " + size);
    }

    static void peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
        } else {
            System.out.println("peek -> " + top.data);
        }
    }

    static boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        push("P1");
        push("P2");
        peek();
        pop();
        push("P3");
        pop();
        pop();
        pop();
        System.out.println("isEmpty -> " + isEmpty());
    }
}
