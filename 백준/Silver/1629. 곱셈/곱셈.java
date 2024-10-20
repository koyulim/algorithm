import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long c = Long.parseLong(input[2]);

        long val = pow(a, b, c);

        bw.write(val + "\n");
        bw.flush();
    }

    public static long pow(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long temp = pow(a, b / 2, c);

        long result = temp * temp % c;

        if ((b % 2) == 0)  {
            return result;
        }

        return result * a % c;
    }
}
