import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            if (command.equals("push")) {
                int value = Integer.parseInt(input[1]);
                last = value;
                queue.add(value);
            } else if (command.equals("pop")) {
                if (!queue.isEmpty()) bw.write(String.valueOf(queue.poll()) + "\n");
                else bw.write("-1\n");
            } else if (command.equals("size")) {
                bw.write(String.valueOf(queue.size()) + "\n");
            } else if (command.equals("empty")) {
                if (!queue.isEmpty()) bw.write("0\n");
                else bw.write("1\n");
            } else if (command.equals("front")) {
                if (!queue.isEmpty()) bw.write(String.valueOf(queue.peek()) + "\n");
                else bw.write("-1\n");
            } else if (command.equals("back")) {
                if (!queue.isEmpty()) bw.write(String.valueOf(last) + "\n");
                else bw.write("-1\n");
            }
        }
        bw.flush();
    }
}
