import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < size; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (queue.isEmpty()) {
                    bw.write("0" + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            } else {
                queue.add(value);
            }
        }

        bw.flush();
    }
}
