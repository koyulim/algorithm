import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            String[] list = br.readLine().split(" ");
            int n = Integer.parseInt(list[0]);
            String s = list[1];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                for (int z = 0; z < n; z++) {
                    bw.write(c);
                }
            }
            bw.write("\n");
        }

        bw.flush();
    }
}