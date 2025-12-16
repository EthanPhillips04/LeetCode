class Solution {
    public int maxVowels(String s, int k) {
        
        char array[] = s.toCharArray();
        int n = array.length;

        int count = 0;
        for(int i = 0; i < k; i++) {
            count += vowelCheck(array[i]);
        }

        int max = count;
        for (int i = k; i < n; i++) {
            if (max == k) return k;
            count += vowelCheck(array[i]) - vowelCheck(array[i-k]);
            if(count > max) {
                max = count;
            }
        }
            return max;
    }
        public int vowelCheck (char c) {
            String vowels = "aeiou";
            if(vowels.indexOf(c) != -1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
