package org.example;

public class FindBookID {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addLast(Node head, String id) {
        Node newNode = new Node(id);

        if (head == null) {
            return newNode;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        return head;
    }

    static String find(Node head, String id) {
        Node current = head;
        int position = 1;
        int firstPosition = -1;
        int count = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                if (firstPosition == -1) {
                    firstPosition = position;
                }
                count++;
            }

            current = current.next;
            position++;
        }

        if (count == 0) {
            return id + " not found";
        }

        return id + " first at position " + firstPosition + ", copies: " + count;
    }

    public static void main(String[] args) {
        Node head = null;
        head = addLast(head, "B12");
        head = addLast(head, "B07");
        head = addLast(head, "B30");
        head = addLast(head, "B07");
        head = addLast(head, "B45");
        head = addLast(head, "B07");

        System.out.println(find(head, "B07"));
        System.out.println(find(head, "B99"));
    }
}
