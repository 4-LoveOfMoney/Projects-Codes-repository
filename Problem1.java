import java.io.*;
import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "";

        try {
            System.out.print("Enter the input file name: ");
            fileName = scanner.nextLine();

            // Debugging help: print the absolute path being accessed
            File file = new File(fileName);
            System.out.println("Looking for file in: " + file.getAbsolutePath());

            // Try opening the file
            readFile(fileName);

        } catch (FileNotFoundException e) {
            System.out.println("❌ Could not find the file at: " + fileName);
            System.out.println("Trying a fallback test file path...");

            // Fallback full path (replace this with your actual path to test)
            String fallbackPath = "C:\\Users\\YourUsername\\Desktop\\game_input.txt";
            try {
                System.out.println("Trying fallback path: " + fallbackPath);
                readFile(fallbackPath);
            } catch (FileNotFoundException ex) {
                System.out.println("❌ Still can't find the file. Check if it exists at that path.");
                ex.printStackTrace();
            }
        }
    }

    public static void readFile(String fileName) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        System.out.println("✅ File found! Reading contents...\n");

        try {
            while ((line = reader.readLine()) != null) {
                System.out.println("Read line: " + line);
                // You can later add your actual parsing logic here
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }
}
