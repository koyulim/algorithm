import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        if (a > b)bw.write(">" + "\n");
        else if (a < b)bw.write("<" + "\n");
        else bw.write("==" + "\n");

        bw.flush();
    }
}