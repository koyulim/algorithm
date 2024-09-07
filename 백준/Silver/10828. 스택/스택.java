import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            if (command.equals("push")) {
                int value = Integer.parseInt(input[1]);
                stack.add(value);
            } else if (command.equals("pop")) {
                if (!stack.empty()) bw.write(String.valueOf(stack.pop()) + "\n");
                else bw.write("-1\n");
            } else if (command.equals("size")) {
                bw.write(String.valueOf(stack.size()) + "\n");
            } else if (command.equals("empty")) {
                if (!stack.empty()) bw.write("0\n");
                else bw.write("1\n");
            } else if (command.equals("top")) {
                if (!stack.empty()) bw.write(String.valueOf(stack.peek()) + "\n");
                else bw.write("-1\n");
            }
        }
        bw.flush();
    }
}