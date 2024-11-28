import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        List<String> arr = new ArrayList<>();

        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        int val = 1;
        boolean chack = true;
        for (int num : list) {
            while (val <= num) {
                stack.push(val);
                arr.add("+");
                val++;
            }

            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                arr.add("-");
            } else {
                chack = false;
                break;
            }
        }

        if (chack) {
            for (String result : arr) {
                bw.write(result + "\n");
            }
        } else {
            bw.write("NO" + "\n");
        }

        bw.flush();
    }
}
