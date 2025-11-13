import java.util.Scanner;

public class EA_EEA {

    // ---------- EUCLIDEAN ALGORITHM ----------
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // ---------- EXTENDED EUCLIDEAN ALGORITHM ----------
    static class Result {
        int gcd, x, y;
        Result(int gcd, int x, int y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    public static Result extendedGCD(int a, int b) {
        if (b == 0)
            return new Result(a, 1, 0);

        Result next = extendedGCD(b, a % b);

        int gcd = next.gcd;
        int x = next.y;
        int y = next.x - (a / b) * next.y;

        return new Result(gcd, x, y);
    }

    // ---------- MODULAR INVERSE USING EEA ----------
    public static void modularInverse(int a, int N) {
        Result result = extendedGCD(a, N);
        if (result.gcd != 1) {
            System.out.println("No modular inverse exists since gcd(" + a + ", " + N + ") ≠ 1");
        } else {
            int inverse = (result.x % N + N) % N;
            System.out.println("The modular inverse of " + a + " mod " + N + " is: " + inverse);
        }
    }

    // ---------- MAIN PROGRAM ----------
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== Euclidean Algorithm (EA) and Extended Euclidean Algorithm (EEA) ===");

        System.out.print("Enter first integer a: ");
        int a = input.nextInt();

        System.out.print("Enter modulus N: ");
        int N = input.nextInt();

        // Euclidean Algorithm (GCD)
        int gcdValue = gcd(a, N);
        System.out.println("\n[EA] The GCD of " + a + " and " + N + " is: " + gcdValue);

        // Extended Euclidean Algorithm (Modular Inverse)
        System.out.println("\n[EEA] Computing modular inverse...");
        modularInverse(a, N);

        input.close();
    }
}
