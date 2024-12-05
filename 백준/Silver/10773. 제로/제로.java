import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) stack.pop();
            else stack.add(val);
        }

        int result = 0;
        for (int value : stack) result += value;

        bw.write(result + "\n");
        bw.flush();
    }
}
