import java.io.*;
import java.util.*;

public class FrequencyAnalysis {
    public static void main(String[] args) {
        // Automatically get the Downloads folder path
        String home = System.getProperty("user.home");  // e.g., C:\Users\Frank
        String path = home + "/Downloads/ciphertext.txt"; // Works on Windows

        // Frequency map for ciphertext letters
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            freqMap.put(c, 0);
        }

        // Read the ciphertext file
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        freqMap.put(c, freqMap.get(c) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + path);
            e.printStackTrace();
            return;
        }

        // Sort letters by frequency (highest first)
        List<Map.Entry<Character, Integer>> freqList = new ArrayList<>(freqMap.entrySet());
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        // English letter frequency order (most frequent first)
        String englishFreq = "ETAOINSHRDLCUMWFGYPBVKJXQZ";

        // Print the mapping table
        System.out.println("Ciphertext Letter -> Suggested Plaintext Mapping:");
        for (int i = 0; i < freqList.size(); i++) {
            char cipher = freqList.get(i).getKey();
            char plain = englishFreq.charAt(i);
            System.out.println(cipher + " -> " + plain + " (" + freqList.get(i).getValue() + ")");
        }
    }
}
