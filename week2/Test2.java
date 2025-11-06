import java.io.*;
import java.util.*;

public class Test2 {

    static class Student {
        String name;
        List<Integer> marks;
        int total;
        double average;

        Student(String name, List<Integer> marks) {
            this.name = name;
            this.marks = marks;
            this.total = marks.stream().mapToInt(Integer::intValue).sum();
            this.average = total / (double) marks.size();
        }
    }

    public static void main(String[] args) {
        String inputFile = "Test2.csv";
        String outputFile = "TestOutput.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) { // Skip header
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) {
                    System.out.println("Invalid line (skipped): " + line);
                    continue;
                }

                String name = data[0].trim();
                List<Integer> marks = new ArrayList<>();
                boolean valid = true;

                for (int i = 1; i < data.length; i++) {
                    try {
                        int mark = Integer.parseInt(data[i].trim());
                        if (mark < 0 || mark > 100) {
                            System.out.println(" Invalid mark for " + name + ": " + mark);
                            valid = false;
                            break;
                        }
                        marks.add(mark);
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid number format for " + name + ": " + data[i]);
                        valid = false;
                        break;
                    }
                }

                if (valid) students.add(new Student(name, marks));
            }

            if (students.isEmpty()) {
                System.out.println(" No valid student data found.");
                return;
            }
            
            students.sort((a, b) -> b.total - a.total);

            double classTotal = 0;
            for (Student s : students) {
                classTotal += s.average;
            }
            double classAverage = classTotal / students.size();

            
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                bw.write("Name,Total,Average,Result,Remarks\n");

                for (Student s : students) {
                    String result = (s.average >= 40) ? "Pass" : "Fail";
                    String remark;
                    if (s.average >= 90) remark = "Outstanding";
                    else if (s.average >= 75) remark = " Excellent";
                    else if (s.average >= 60) remark = " Good";
                    else if (s.average >= 40) remark = " Average";
                    else remark = "Needs Improvement";

                    bw.write(String.format("%s,%d,%.2f,%s,%s%n", s.name, s.total, s.average, result, remark));
                }

                bw.write("\nClass Average," + String.format("%.2f", classAverage) + "\n");
                bw.write("Top Scorer," + students.get(0).name + "," + students.get(0).total + "\n");
                bw.write("Lowest Scorer," + students.get(students.size() - 1).name + "," + students.get(students.size() - 1).total + "\n");

                System.out.println("All calculations complete!");
                System.out.println("Top Scorer: " + students.get(0).name + " (" + students.get(0).total + ")");
                System.out.println(" Lowest Scorer: " + students.get(students.size() - 1).name + " (" + students.get(students.size() - 1).total + ")");
                System.out.println("Results saved to: " + outputFile);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}

