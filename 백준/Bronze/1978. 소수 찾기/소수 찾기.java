import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(input[i]);
            boolean check = true;
            if (n != 1 && n != 0) {
                for (int j = 2; j < n; j++) {
                    if ((n % j) == 0)check = false;
                }
                if (check)cnt++;
            }
            
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}