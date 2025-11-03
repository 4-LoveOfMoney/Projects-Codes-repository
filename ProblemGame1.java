import java.io.*;
import java.util.*;

public class ProblemGame1 {

    static class Villain {
        String name;
        int strength;

        Villain(String name, int strength) {
            this.name = name;
            this.strength = strength;
        }

        public String toString() {
            return name + "(" + strength + ")";
        }
    }

    static String heroName;
    static int heroInitialStrength;
    static List<List<Villain>> levels = new ArrayList<>();
    static boolean foundWinningPath = false;
    static List<Villain> oneWinningPath = new ArrayList<>();
    static int targetVillainWays = 0;
    static List<Villain> targetVillainPath = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input file name: ");
        String filename = scanner.nextLine();

        readFile(filename);

        // 1. Total ways to win
        int totalWays = countWays(heroInitialStrength, 0, new ArrayList<>());
        System.out.println("1. Total ways to win the game: " + totalWays);

        // 2. One winning path
        findOneWinningPath(heroInitialStrength, 0, new ArrayList<>());
        System.out.println("2. One winning path: " + oneWinningPath);

        // 3 & 4. Ways to defeat a specific villain
        System.out.print("Enter a villain name to find paths to defeat: ");
        String villainName = scanner.nextLine();
        targetVillainWays = 0;
        targetVillainPath.clear();
        findTargetVillainPaths(heroInitialStrength, 0, new ArrayList<>(), villainName);
        System.out.println("3. Ways to defeat " + villainName + ": " + targetVillainWays);
        System.out.println("4. One path to defeat " + villainName + ": " + targetVillainPath);
    }

    // Robust file reader
    static void readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        // Hero line
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) {
                line = line.replace("(", "").replace(")", "");
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    br.close();
                    throw new IOException("Invalid hero line format. Expected: (Name, Strength)");
                }
                heroName = parts[0].trim();
                heroInitialStrength = Integer.parseInt(parts[1].trim());
                break;
            }
        }

        // Villain levels
        StringBuilder levelBuilder = new StringBuilder();
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            levelBuilder.append(" ").append(line);

            long open = levelBuilder.chars().filter(ch -> ch == '(').count();
            long close = levelBuilder.chars().filter(ch -> ch == ')').count();

            if (open == close && open > 0) {
                List<Villain> stage = new ArrayList<>();
                String[] parts = levelBuilder.toString().split("\\)");
                for (String part : parts) {
                    part = part.trim();
                    if (part.isEmpty()) continue;

                    part = part.replace("(", "").trim();
                    String[] villainParts = part.split(",");
                    if (villainParts.length != 2) continue;

                    String name = villainParts[0].trim();
                    int strength = Integer.parseInt(villainParts[1].trim());
                    stage.add(new Villain(name, strength));
                }

                if (!stage.isEmpty()) levels.add(stage);
                levelBuilder.setLength(0); // reset for next level
            }
        }

        br.close();
    }

    // Count all winning ways
    static int countWays(int currentStrength, int level, List<Villain> path) {
        if (level == levels.size()) return 1;

        int ways = 0;
        for (Villain v : levels.get(level)) {
            if (v.strength <= currentStrength) { // <= instead of <
                List<Villain> newPath = new ArrayList<>(path);
                newPath.add(v);
                ways += countWays(currentStrength + v.strength, level + 1, newPath);
            }
        }
        return ways;
    }

    // Find one winning path
    static void findOneWinningPath(int currentStrength, int level, List<Villain> path) {
        if (level == levels.size()) {
            oneWinningPath = new ArrayList<>(path);
            foundWinningPath = true;
            return;
        }

        for (Villain v : levels.get(level)) {
            if (v.strength <= currentStrength) {
                path.add(v);
                findOneWinningPath(currentStrength + v.strength, level + 1, path);
                if (foundWinningPath) return;
                path.remove(path.size() - 1);
            }
        }
    }

    // Count paths to defeat a specific villain
    static void findTargetVillainPaths(int currentStrength, int level, List<Villain> path, String target) {
        if (level == levels.size()) return;

        for (Villain v : levels.get(level)) {
            if (v.strength <= currentStrength) {
                path.add(v);
                if (v.name.equalsIgnoreCase(target)) {
                    targetVillainWays++;
                    if (targetVillainPath.isEmpty()) {
                        targetVillainPath = new ArrayList<>(path);
                    }
                }
                findTargetVillainPaths(currentStrength + v.strength, level + 1, path, target);
                path.remove(path.size() - 1);
            }
        }
    }
}
