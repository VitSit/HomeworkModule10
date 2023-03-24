package Ex2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileToJsonConverter {
    public static void main(String[] args) {
        String fileName = "file2.txt";
        String outputFileName = "user.json";
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("fileName"))) {
            String line;
            String[] headers = reader.readLine().split("\\s+");
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\s+");
                String name = values[0];
                int age = Integer.parseInt(values[1]);
                User user = new User(name, age);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        try (FileWriter writer = new FileWriter(outputFileName)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
