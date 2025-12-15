class Solution {
    public boolean isSubsequence(String s, String t) {
       int sPosition = 0;
       int tPosition = 0;

       while (sPosition < s.length() && tPosition < t.length()) {
        if(s.charAt(sPosition) == t.charAt(tPosition)) {
            sPosition++;
        }
        tPosition++;
       }
       return sPosition == s.length();
    }
}