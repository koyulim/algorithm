import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            String[] st = input.split(" ");
            String s = st[0];
            String t = st[1];
            int i = 0;
            int index = 0;
            while (i < t.length()) {
                if (index < s.length() && t.charAt(i) == s.charAt(index)) {
                    index++;
                }
                i++;
            }

            if (index == s.length()) bw.write("Yes" + "\n");
            else bw.write("No" + "\n");
        }

        bw.flush();
    }
}
