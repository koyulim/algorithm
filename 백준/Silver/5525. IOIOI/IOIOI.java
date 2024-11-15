import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String str = "";

        for (int i = 0; i < n; i++) str += "IO";
        str += "I";

        int start = 0;
        int end = str.length();
        int cnt = 0;
        while (end <= m) {
            if (s.substring(start, end).equals(str)) cnt++;
            start++;
            end++;
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}
