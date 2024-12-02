import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = 10;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < size; i++) {
            int val = Integer.parseInt(br.readLine());
            set.add(val % 42);
        }
        
        bw.write(set.size() + "\n");
        bw.flush();
    }
}
