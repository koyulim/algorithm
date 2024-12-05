import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            Stack<Character> stack = new Stack<>();
            boolean chack = true;

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(' || ch == '[') {
                    stack.add(ch);
                } else if (ch == ')') {
                    if (stack.empty() || stack.pop() != '(') {
                        chack = false;
                        break;
                    }

                } else if (ch == ']') {
                    if (stack.empty() || stack.pop() != '[') {
                        chack = false;
                        break;
                    }

                }
            }

            if (!stack.isEmpty()) chack = false;

            if (chack) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
    }
}
