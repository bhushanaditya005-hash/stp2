package org.example;
import java.util.Scanner;

class ReportCardStudent {
    private String name;
    private int a, b, c;
    ReportCardStudent(String name) { this.name = name; }
    boolean setMarks(int a, int b, int c) {
        if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) return false;
        this.a = a; this.b = b; this.c = c;
        return true;
    }
    int getTotal() { return a + b + c; }
    double getAverage() { return getTotal() / 3.0; }
    char getGrade() {
        double avg = getAverage();
        if (avg >= 80) return 'A';
        else if (avg >= 70) return 'B';
        else if (avg >= 60) return 'C';
        else if (avg >= 40) return 'D';
        else return 'F';
    }
    String getName() { return name; }
}
public class ClassReportCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), count = 0;
        ReportCardStudent[] students = new ReportCardStudent[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            ReportCardStudent student = new ReportCardStudent(name);
            if (student.setMarks(sc.nextInt(), sc.nextInt(), sc.nextInt())) students[count++] = student;
            else System.out.println(name + " skipped: marks must be 0 to 100");
        }
        int passes = 0;
        for (int i = 0; i < count - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getTotal() < students[j + 1].getTotal()) {
                    ReportCardStudent temp = students[j];
                    students[j] = students[j + 1]; students[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        for (int i = 0; i < count; i++) {
            ReportCardStudent s = students[i];
            System.out.printf("%d. %s total=%d avg=%.2f grade=%c%n",
                i + 1, s.getName(), s.getTotal(), s.getAverage(), s.getGrade());
        }
        System.out.println("Sorted in " + passes + " passes");
        sc.close();
    }
}
