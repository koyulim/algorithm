import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] upDp = new int[n];
        int[] downDp = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
            downDp[i] = 1;
            upDp[i] = 1;
        }
        
        //증가
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (list[i] > list[j]) {
                    upDp[i] = Math.max(upDp[i], upDp[j] + 1);
                }
            }
        }

        // 감소
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (list[i] > list[j]) {
                    downDp[i] = Math.max(downDp[i], downDp[j] + 1);
                }
            }
        }

        // total
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, upDp[i] + downDp[i] - 1);
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
