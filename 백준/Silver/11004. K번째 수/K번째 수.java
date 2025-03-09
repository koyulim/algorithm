import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");

        int[] list = new int[Integer.parseInt(nm[0])];
        for (int i = 0; i < Integer.parseInt(nm[0]); i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(list);
        bw.write(list[Integer.parseInt(nm[1]) - 1] + "\n");
        bw.flush();
    }
}
