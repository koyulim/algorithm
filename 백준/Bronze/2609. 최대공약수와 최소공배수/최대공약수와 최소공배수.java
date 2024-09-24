import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int n = a * b;

        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        bw.write(a + "\n");
        bw.write((n / a) + "\n");

        
        bw.flush();
    }
}