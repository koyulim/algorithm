import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list);
        int answer = 0;
        int add = 0;

        for (int i = 0; i < size; i++) {
            add += list[i];
            answer += add;
        }

        System.out.println(answer);
    }
}