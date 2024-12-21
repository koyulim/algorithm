import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int n = a * b * c;
        String str = String.valueOf(n);
        int[] cnt = new int[10];
        for (char digit : str.toCharArray()) {
            cnt[digit - '0']++;
        }
        for (int count : cnt) {
            bw.write(count + "\n");;
        }
        
        bw.close();
    }
}
