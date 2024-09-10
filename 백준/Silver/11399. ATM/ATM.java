import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] list = new int[size];
        
        for (int i = 0; i < str.length; i++) {
            list[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(list);
        int answer = 0;
        int add = 0;

        for (int i = 0; i < size; i++) {
            add += list[i];
            answer += add;
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}