import java.awt.Point;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Long[] list = new Long[size];
        for (int i = 0; i < size; i++) {
            String str = sc.next();
            String strs = "";
            for (int j = str.length() - 1; j >= 0; j--) {
                strs += str.charAt(j);
            }
            list[i] = Long.parseLong(strs);
        }

        Arrays.sort(list);

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
