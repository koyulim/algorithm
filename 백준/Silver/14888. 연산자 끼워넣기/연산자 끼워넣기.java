import java.util.*;

import javax.swing.plaf.metal.MetalTheme;

import java.io.*;
import java.awt.Point;

public class Main {

    private static int[] aList;
    private static int n, m;
    private static String[] temp;
    private static List<String> list;
    private static boolean[] visit;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int max, min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        m = n - 1;
        temp = new String[m];
        aList = new int[n];
        visit = new boolean[m];
        for (int i = 0; i < n; i++) {
            aList[i] = Integer.parseInt(input1[i]);
        }

        list = new ArrayList<>();
        String[] input2 = br.readLine().split(" ");
        if (Integer.parseInt(input2[0]) > 0) {
            for (int i = 0; i < Integer.parseInt(input2[0]); i++) {
                list.add("+");
            }
        }

        if (Integer.parseInt(input2[1]) > 0) {
            for (int i = 0; i < Integer.parseInt(input2[1]); i++) {
                list.add("-");
            }
        }

        if (Integer.parseInt(input2[2]) > 0) {
            for (int i = 0; i < Integer.parseInt(input2[2]); i++) {
                list.add("*");
            }
        }

        if (Integer.parseInt(input2[3]) > 0) {
            for (int i = 0; i < Integer.parseInt(input2[3]); i++) {
                list.add("/");
            }
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        backTracking(0);
        bw.write(max + "\n");
        bw.write(min + "\n");
        bw.flush();
    }

    private static void backTracking(int depth) throws Exception {
        if (depth == m) {
            int result = aList[0];
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].equals("+")) {
                    result += aList[i + 1];
                } else if (temp[i].equals("-")) {
                    result -= aList[i + 1];
                } else if (temp[i].equals("*")) {
                    result *= aList[i + 1];
                } else {
                    if (result < 0) {
                        result = -(-result / aList[i + 1]);
                    } else {
                        result /= aList[i + 1];
                    }                    
                }
            }

            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visit[i]) {
                continue;
            }

            visit[i] = true;
            temp[depth] = list.get(i);
            backTracking(depth + 1);
            visit[i] = false;
        }
    }
}