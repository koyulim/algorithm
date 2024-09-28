import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new PriorityQueue<>();
        int size = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < size; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) {
                if (!queue.isEmpty()) {
                    bw.write(queue.poll() + "\n");
                } else {
                    bw.write("0" + "\n");
                }
                
            } else {
                queue.add(val);
            }
        }
        bw.flush();
    }
}
