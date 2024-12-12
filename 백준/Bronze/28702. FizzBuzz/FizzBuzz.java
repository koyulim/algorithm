import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = 0;
        int value = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (!str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz")) {
                n = i;
                value = Integer.parseInt(str);
            }
        }

        if (n == 0) {
            value += 3;
        } else if (n == 1) {
            value += 2;
        } else if (n == 2) {
            value += 1;
        }

        if (value % 3 == 0 && value % 5 == 0) {
            bw.write("FizzBuzz" + "\n");
        } else if (value % 3 == 0) {
            bw.write("Fizz" + "\n");
        } else if (value % 5 == 0) {
            bw.write("Buzz" + "\n");
        } else {
            bw.write(value + "\n");
        }
        
        bw.flush();
    }
}
