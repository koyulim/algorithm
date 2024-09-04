import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String num = sc.next();
        int result = 0;
        
        for (int i = 0; i < size; i++) {
            result = result + (num.charAt(i) - '0');
        }
        System.out.println(result);
    }
}
