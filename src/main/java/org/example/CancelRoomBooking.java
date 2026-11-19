package org.example;

public class CancelRoomBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addLast(Node head, String booking) {
        Node newNode = new Node(booking);

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

    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void printBookings(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;
        head = addLast(head, "104");
        head = addLast(head, "101");
        head = addLast(head, "107");
        head = addLast(head, "101");

        head = removeFirst(head, "101");
        printBookings(head);
    }
}
