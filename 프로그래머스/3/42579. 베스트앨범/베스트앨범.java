import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> total = new HashMap<>();
        HashMap<String, ArrayList<int[]>> song = new HashMap<>();
        int[] result;
        
        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<int[]> temp = new ArrayList<>();
            int[] val = new int[2];
            val[0] = i;
            val[1] = plays[i];
            
            if(song.containsKey(genres[i])){
                song.get(genres[i]).add(val);
            } else {
                temp.add(val);
                song.put(genres[i], temp);
            }
        }
        
        for (String key : song.keySet()) {
            ArrayList<int[]> list = song.get(key);
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o2[1], o1[1]);
                }
            });
        }
        
        List<Integer> tempResult = new ArrayList<>();
        List<String> keys = new ArrayList<>(total.keySet());
		Collections.sort(keys, (v1, v2) -> (total.get(v2).compareTo(total.get(v1))));         
		
        for (String key : keys) {
			ArrayList<int[]> arr = song.get(key);
            int count = Math.min(arr.size(), 2);
            for (int i = 0; i < count; i++) {
                tempResult.add(arr.get(i)[0]);
            }
		}
        
        result = new int[tempResult.size()];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }
        
        return result;
    }
}