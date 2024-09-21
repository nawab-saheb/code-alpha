//Student Grade Tracker

import java.util.*;
public class task_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }
        int total = 0;
        int highest = grades[0];
        int lowest = grades[0];

        for (int i = 0; i < grades.length; i++) {
            total += grades[i];

            if (grades[i] > highest) {
                highest = grades[i];
            }

            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        double average = (double) total / n;
        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }
}
