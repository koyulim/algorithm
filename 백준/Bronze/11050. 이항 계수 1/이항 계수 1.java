import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int n = 1;
        int k = 1;
        int nk = 1;
        
        for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
            n *= i;
            if (i <= Integer.parseInt(input[1]))k *= i;
            if (i <= (Integer.parseInt(input[0]) - Integer.parseInt(input[1])))nk *= i;
        }

        bw.write(n / (nk * k) + "\n");
        bw.flush();
    }
}