import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");


        bw.write((Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])) +"\n");
        bw.write((Integer.parseInt(arr[0]) - Integer.parseInt(arr[1])) +"\n");
        bw.write((Integer.parseInt(arr[0]) * Integer.parseInt(arr[1])) +"\n");
        bw.write((Integer.parseInt(arr[0]) / Integer.parseInt(arr[1])) +"\n");
        bw.write((Integer.parseInt(arr[0]) % Integer.parseInt(arr[1])) +"\n");

        bw.flush();
    }
}