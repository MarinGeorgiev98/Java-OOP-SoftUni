package studentsystem;

import java.util.*;

public class StudentSystem {
    private Map<String, Student> store;

    public StudentSystem() {
        this.store = new HashMap<>();
    }

    public Map<String, Student> getStore() {
        return this.store;
    }

    public void executeCommand(String[] args) {
        String commandName = args[0];
        String studentName = args[1];
        if (commandName.equals("Create")) {
            executeCreateCommand(args, studentName);
        }
        else if (commandName.equals("Show")) {
            executeShowCommand(studentName);
        }
    }

    private void executeShowCommand(String studentName) {
        if (!this.store.containsKey(studentName)) {
            return;
        }
            Student student = this.store.get(studentName);
            String outputFormat = String.format("%s is %s years old.",
                    student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                outputFormat += " Excellent student.";
            }
            else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                outputFormat += " Average student.";
            }
            else {
                outputFormat += " Very nice person.";
            }
            System.out.println(outputFormat);
        }

    private void executeCreateCommand(String[] args, String studentName) {
        int age = Integer.parseInt(args[2]);
        double grade =Double.parseDouble(args[3]);
        Student student = new Student(studentName, age, grade);
        this.store.putIfAbsent(studentName, student);
    }
}