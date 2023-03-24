package Ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) {
        String fileName = "Ex1/file.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/Ex1/file.txt"))) {
            Pattern pattern1 = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");
            Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

            while ((line = reader.readLine()) != null) {
                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);

                if (matcher1.matches()) {
                    System.out.println(matcher1.group());
                } else if (matcher2.matches()) {
                    System.out.println(matcher2.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}