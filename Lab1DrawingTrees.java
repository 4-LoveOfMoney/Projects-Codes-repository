
public class Lab1DrawingTrees {

	/* Project: Lab1
	 * Class:  MUTunes.java
	 * Author: Frank Ferrantelli
	 * Date: January 31, 2024
	 * This program prints out images of trees, it prints out two different trees each with their own
	 * segments as well as the base of the tree
	 */

	    public static void main(String[] args) {
	        // This is the display header for Tree One
	        System.out.println("Tree One:");
	        // The method to generate and print Tree One
	        generateChristmasTree1(4, 3);

	        // The display header for Tree Two
	        System.out.println("\nTree Two:");
	        // The method to generate and print Tree Two
	        generateChristmasTree2(4, 2);
	    }

	    // The method to generate and print Tree One
	    public static void generateChristmasTree1(int height, int segments) {
	        // Calculate the maximum line number in the tree
	        int maxLine = height + segments - 1;

	        // A for loop through each segment and draw it
	        for (int i = 1; i <= segments; i++) {
	            drawTreeSegment1(i, height, maxLine);
	        }

	        // Drawing the base of Tree One
	        drawTreeBase1(maxLine);
	    }

	    // The method to draw a single segment of Tree One
	    private static void drawTreeSegment1(int currentSegment, int height, int maxLine) {
	        // Another loop through each line in the current segment and draw it
	        for (int line = currentSegment; line <= currentSegment + height - 1; line++) {
	            // Draw leading spaces
	            for (int spaces = 1; spaces <= maxLine - line; spaces++) {
	                System.out.print(" ");
	            }
	            // Drawing asterisks for the current line
	            for (int stars = 1; stars <= 2 * line - 1; stars++) {
	                System.out.print("*");
	            }
	            // Move to the next line after printing the current line
	            System.out.println();
	        }
	    }

	    // The method to draw the base of Tree One
	    private static void drawTreeBase1(int maxLine) {
	        // Setting the base width for Tree One
	        int baseWidth = maxLine - 1;

	        // Drawing two lines of base
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < baseWidth; j++) {
	                System.out.print(" ");
	            }
	            System.out.println("*");
	        }

	        // Drawing an additional line of asterisks in the base
	        for (int k = 2; k < baseWidth - 1; k++) {
	            System.out.print(" ");
	        }
	        System.out.println("*******");
	    }

	    // The method to generate and print Tree Two
	    public static void generateChristmasTree2(int height, int segments) {
	        // Calculating the maximum line number in the tree
	        int maxLine = height + segments - 1;

	        // The loop through each segment and draw it
	        for (int i = 1; i <= segments; i++) {
	            drawTreeSegment2(i, height, maxLine);
	        }

	        // Drawing the base of Tree Two
	        drawTreeBase2(maxLine);
	    }

	    // The method to draw a single segment of Tree Two
	    private static void drawTreeSegment2(int currentSegment, int height, int maxLine) {
	        // A loop through each line in the current segment and draw it
	        for (int line = currentSegment; line <= currentSegment + height - 1; line++) {
	            // Drawing leading spaces
	            for (int spaces = 1; spaces <= maxLine - line; spaces++) {
	                System.out.print(" ");
	            }
	            // Drawing asterisks for the current line
	            for (int stars = 1; stars <= 2 * line - 1; stars++) {
	                System.out.print("*");
	            }
	            // Move to the next line after printing the current line
	            System.out.println();
	        }
	    }

	    // The method to draw the base of Tree Two
	    private static void drawTreeBase2(int maxLine) {
	        // Set the base width for Tree Two
	        int baseWidth = maxLine - 1;

	        // Drawing two lines of base
	        for (int i = 0; i < 2; i++) {
	            // Drawing leading spaces
	            for (int j = 0; j < baseWidth; j++) {
	                System.out.print(" ");
	            }
	            // Drawing an asterisk for the base
	            System.out.println("*");
	        }

	        // Drawing an additional line of asterisks in the base
	        for (int k = 2; k < baseWidth - 1; k++) {
	            System.out.print(" ");
	        }
	        System.out.println("*******");
	    }
	}
