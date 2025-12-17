class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1) ;
        }

        Set <Integer> set1 = new HashSet<>();
        for(int value : map.values()) {
            set1.add(value);
        }
        return map.size() == set1.size();
    }
}