import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String key = sc.next();
            map.put(key, key.length());
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return (o1.length() == o2.length()) ? o1.compareTo(o2) : map.get(o1).compareTo(map.get(o2));
            }
        });

        for (String key : keySet)System.out.println(key);
    }
}
