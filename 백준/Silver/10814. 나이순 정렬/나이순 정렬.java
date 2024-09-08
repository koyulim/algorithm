import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            ArrayList<String> list = new ArrayList<String>();
            if (map.containsKey(age)) {
                list = map.get(age);
                list.add(name);
            } else {
                list.add(name);
            }
            map.put(age,list);
        }

        for (int key : map.keySet()) {
            ArrayList<String> list = new ArrayList<String>();
            list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                bw.write(key + " " + list.get(i) + "\n");
            }
        }
        bw.flush();
    }
}