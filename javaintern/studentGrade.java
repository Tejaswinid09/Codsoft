import java.util.Scanner;

public class studentGrade {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float sum = 0;
        
        System.out.println("How many subjects?");
        int subjects = sc.nextInt();
        
        int[] marks = new int[subjects];
        for (int i = 0; i < subjects; i++) {
            System.out.println("Enter marks for subject " + (i + 1) + ":");
            marks[i] = sc.nextInt();
            sum += marks[i];
        }
        
        float percentage = sum / subjects;
        
        System.out.println("Total marks: " + sum + "\tAverage percentage: " + percentage + "%");
        System.out.print("Grade is: ");
        
        if (percentage > 90) {
            System.out.println("A1 grade");
        } else if (percentage > 80) {
            System.out.println("A2 grade");
        } else if (percentage > 70) {
            System.out.println("B1 grade");
        } else if (percentage > 60) {
            System.out.println("B2 grade");
        } else if (percentage > 50) {
            System.out.println("C1 grade");
        } else if (percentage > 40) {
            System.out.println("C2 grade");
        } else if (percentage >= 35) {
            System.out.println("D grade");
        } else if (percentage > 20) {
            System.out.println("E grade and you are fail");
        } else {
            System.out.println("E2 grade and you are fail");
        }
    }
}
