import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int resultNumeric = A + B - C;

        String stringA = String.valueOf(A);
        String stringB = String.valueOf(B);
        String stringC = String.valueOf(C);

        String combinedString = stringA + stringB;
        int resultStringCalculation = Integer.parseInt(combinedString) - Integer.parseInt(stringC);

        System.out.println(resultNumeric);
        System.out.println(resultStringCalculation);
    }
}
