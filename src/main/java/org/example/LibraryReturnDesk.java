package org.example;
import java.util.Scanner;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stack = new String[3], queue = new String[3];
        int top = -1, front = 0, rear = 0, size = 0;
        String[] commands = sc.nextLine().split(",");
        for (String command : commands) {
            String[] parts = command.trim().split("\\s+");
            String operation = parts[0];
            if (operation.equals("RETURN")) {
                String book = parts[1];
                if (top == 2) System.out.println(book + " rejected: pile is full");
                else { stack[++top] = book; System.out.println(book + " placed on pile"); }
            } else if (operation.equals("SHELVE")) {
                if (top == -1) System.out.println("pile is empty");
                else System.out.println("shelved " + stack[top--]);
            } else if (operation.equals("WAIT")) {
                String student = parts[1];
                if (size == 3) System.out.println(student + " rejected: line is full");
                else {
                    queue[rear] = student; rear = (rear + 1) % 3; size++;
                    System.out.println(student + " joined the line");
                }
            } else if (operation.equals("SERVE")) {
                if (size == 0) System.out.println("no one waiting");
                else {
                    System.out.println("served " + queue[front]);
                    front = (front + 1) % 3; size--;
                }
            }
        }
        sc.close();
    }
}
