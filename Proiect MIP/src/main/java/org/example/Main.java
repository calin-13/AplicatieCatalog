package org.example;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Test database connection
        Connection connection = DbUtils.getConnection();
        if (connection != null) {
            System.out.println("Connected to the database successfully!");
        } else {
            System.out.println("Failed to connect to the database.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        ClasaDAO clasaDAO = new ClasaDAO();
        ElevDAO elevDAO = new ElevDAO();
        MaterieDAO materieDAO = new MaterieDAO();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Class");
            System.out.println("2. View All Classes");
            System.out.println("3. Add Student");
            System.out.println("4. View Students in a Class");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    clasaDAO.addClass(new Clasa(0, className));
                    break;

                case 2:
                    List<Clasa> classes = clasaDAO.getAllClasses();
                    System.out.println("Classes:");
                    if (classes.isEmpty()) {
                        System.out.println("No classes found.");
                    } else {
                        for (Clasa clasa : classes) {
                            System.out.println(clasa.getId() + ". " + clasa.getNume());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student surname: ");
                    String studentSurname = scanner.nextLine();
                    System.out.print("Enter class ID: ");
                    int classId = scanner.nextInt();
                    scanner.nextLine();

                    elevDAO.addStudent(new ElevNeBursier(0, studentName, studentSurname, 0.0), classId);
                    break;

                case 4:
                    System.out.print("Enter class ID: ");
                    int classIdToView = scanner.nextInt();
                    scanner.nextLine();

                    List<Elev> students = elevDAO.getStudentsByClass(classIdToView);
                    System.out.println("Students in Class ID " + classIdToView + ":");
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Elev student : students) {
                            System.out.println(student.getNume() + " " + student.getPrenume());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}