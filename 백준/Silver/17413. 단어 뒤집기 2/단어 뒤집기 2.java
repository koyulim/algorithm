import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String result = "";
        Stack<Character> stack = new Stack<>();
        boolean change = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                while (!stack.empty()) {
                    result += stack.pop();
                }
                change = true;
                result += '<';
            } else if (str.charAt(i) == '>') {
                change = false;
                result += '>';
            } else if (change) {
                result += str.charAt(i);
            } else {
                if (str.charAt(i) == ' ') {
                    while (!stack.empty()) {
                        result += stack.pop();
                    }
                    result += ' ';
                } else {
                    stack.add(str.charAt(i));
                }
            }
        }

        while (!stack.empty()) {
            result += stack.pop();
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
