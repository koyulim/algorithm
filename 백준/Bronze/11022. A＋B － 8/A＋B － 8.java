import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            bw.write("Case #" + (i + 1) + ": " + Integer.parseInt(input[0]) + " + " + Integer.parseInt(input[1]) + " = " + (Integer.parseInt(input[0]) + Integer.parseInt(input[1])) + "\n");
        }
        bw.flush();
    }
}
