import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nx = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]);
        int x = Integer.parseInt(nx[1]);

        String[] input = br.readLine().split(" ");
        for (int i = 0 ; i < n; i++) {
            if (Integer.parseInt(input[i]) < x) bw.write(Integer.parseInt(input[i]) + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}
