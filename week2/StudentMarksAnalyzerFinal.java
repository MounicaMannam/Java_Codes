import java.io.*;
import java.util.*;

public class StudentMarksAnalyzerFinal {

    static class Student {
        String name;
        int total;
        double average;

        Student(String name, int total, double average) {
            this.name = name;
            this.total = total;
            this.average = average;
        }
    }

    public static void main(String[] args) {
        String inputFile = "marks.csv";      // Input file
        String outputFile = "results.csv";   // Output file
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            boolean headerSkipped = false;

            while ((line = br.readLine()) != null) {
                if (!headerSkipped) { // skip header row
                    headerSkipped = true;
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) {
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                String name = data[0].trim();
                int total = 0;

                try {
                    for (int i = 1; i < data.length; i++) {
                        total += Integer.parseInt(data[i].trim());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number for " + name + ". Skipping entry.");
                    continue;
                }

                double average = total / (double)(data.length - 1);
                students.add(new Student(name, total, average));
            }

            // Sort by total descending (top scorer first)
            students.sort((a, b) -> b.total - a.total);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                bw.write("Name,Total,Average,Remarks\n");

                int highest = students.get(0).total;
                int lowest = students.get(students.size() - 1).total;

                for (Student s : students) {
                    String remark;
                    if (s.total == highest) {
                        remark = " Top Scorer";
                    } else if (s.total == lowest) {
                        remark = "Needs Improvement";
                    } else if (s.average >= 75) {
                        remark = "Good Performance";
                    } else {
                        remark = "Average";
                    }

                    bw.write(s.name + "," + s.total + "," + String.format("%.2f", s.average) + "," + remark + "\n");
                }

                System.out.println("Analysis complete! Results saved to: " + outputFile);
                System.out.println("Top Scorer: " + students.get(0).name + " (" + students.get(0).total + ")");
                System.out.println("Lowest Scorer: " + students.get(students.size() - 1).name + " (" + students.get(students.size() - 1).total + ")");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
