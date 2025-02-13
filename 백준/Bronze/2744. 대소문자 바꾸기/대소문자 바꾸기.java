import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int num = (int)str.charAt(i);
            if (num >= 65 && num <= 90) {
                num += 32;
            } else {
                num -= 32;
            }
            result += (char)num;
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
