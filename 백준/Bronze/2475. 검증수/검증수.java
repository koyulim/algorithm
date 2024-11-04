import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long result = 0;
        String[] input = br.readLine().split(" ");
        for (int i = 0 ; i < input.length; i++) {
            long val = Long.parseLong(input[i]);
            result += val * val;
        }
        bw.write((result % 10) + "\n");
        bw.flush();
    }
}
