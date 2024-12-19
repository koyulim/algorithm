import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static int n, m;
    static ArrayList<int[]> house;
    static ArrayList<int[]> chicken;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(input[j]);
                if (val == 1) {
                    house.add(new int[]{i, j});
                } else if (val == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        combination(new ArrayList<>(), 0);
        bw.write(result + "\n");
        bw.close();
    }

    static void combination(ArrayList<int[]> select, int start) {
        
        int tatal = 0;
        if (select.size() == m) {
            for (int i = 0; i < house.size(); i++) {
                int[] hlist = house.get(i);
                int hx = hlist[0];
                int hy = hlist[1];
                int value = Integer.MAX_VALUE;

                for (int j = 0; j < select.size(); j++) {
                    int[] clist = select.get(j);
                    int cx = clist[0];
                    int cy = clist[1];
                    int lang = Math.abs(hx - cx) + Math.abs(hy - cy);
                    value = Math.min(value, lang); 
                }
                tatal += value;
            }

            result = Math.min(result, tatal);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            select.add(chicken.get(i));
            combination(select, i + 1);
            select.remove(select.size() - 1);
        }
    }
}
