import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            bw.write((a + b) + "\n");
        }




        bw.flush();
    }
}