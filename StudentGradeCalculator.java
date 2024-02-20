
import java.util.Scanner;

public class StudentGradeCalculator {
    
    public static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Average Grade Calculator");
        System.out.println("------------------------");
        
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        
        double[] grades = new double[numGrades];
        
        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }
        
        double averageGrade = calculateAverage(grades);
        System.out.println("The average grade is: " + averageGrade);
        
    }
}
