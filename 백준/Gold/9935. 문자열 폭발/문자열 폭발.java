import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String strs = br.readLine();
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strs.length(); i++) {
            stack.add(strs.charAt(i));

            if (stack.size() >= str.length()) {
                boolean chack = true;

                for (int j = 0; j < str.length(); j++) {
                    if (stack.get(stack.size() - str.length() + j) != str.charAt(j)) {
                        chack = false;
                        break;
                    }
                }

                if (chack) {
                    for (int j = 0; j < str.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write("FRULA" + "\n");
        } else {
            for (char c : stack) {
                bw.write(c + "");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
