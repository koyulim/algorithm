import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> arr = new ArrayList<>();   
        boolean chek = true;
        
        for (int i = 0; i < numbers.length; i++) {    
            arr.add(Integer.toString(numbers[i]));
            if (numbers[i] != 0) chek = false;
        }
        
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        
        for (int i = 0; i < arr.size(); i++) {
            answer += arr.get(i);
        }
        
        if (chek) answer = "0";
        
        return answer;
    }
}