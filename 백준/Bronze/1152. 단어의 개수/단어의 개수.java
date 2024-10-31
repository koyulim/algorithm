import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < input.length; i++) if (input[i].length() > 0) cnt++;
        bw.write(cnt + "\n");
        bw.flush();
    }
}
