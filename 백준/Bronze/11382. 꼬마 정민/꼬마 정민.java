import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        bw.write((Long.parseLong(input[0]) + Long.parseLong(input[1]) + Long.parseLong(input[2])) + "\n");
        bw.flush();
    }
}
