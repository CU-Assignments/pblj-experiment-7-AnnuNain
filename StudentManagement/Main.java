import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentController.createTable();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Department: ");
                String dept = scanner.nextLine();
                System.out.print("Enter Marks: ");
                double marks = scanner.nextDouble();
                StudentController.addStudent(new Student(0, name, dept, marks));
            } else if (choice == 2) {
                break;
            }
        }
        scanner.close();
    }
}
