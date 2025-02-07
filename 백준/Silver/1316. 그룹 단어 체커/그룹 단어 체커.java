import java.io.*;
import java.util.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Character> set = new HashSet<>();
            String str = br.readLine();
            boolean chack = true;
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) != str.charAt(j + 1)) {
                    if (!set.contains(str.charAt(j + 1))) {
                        set.add(str.charAt(j));
                    } else {
                        chack = false;
                    }
                }
            }

            if (chack) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
