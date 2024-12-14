import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int value = i;
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                value += Character.getNumericValue(str.charAt(j));
            }

            if (value == n) {
                result = Math.min(result, i);
                break;
            }
        }
        
        if (result == Integer.MAX_VALUE) {
            bw.write("0" + "\n");
        } else {
            bw.write(result + "\n");
        }

        bw.flush();
    }
}
