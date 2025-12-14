class Solution {
    public String reverseWords(String s) {
        String [] words = s.split("\\s+");
        
        StringBuilder reverse = new StringBuilder();

        for(int end = words.length - 1; end >= 0; end--) {
            reverse.append(words[end]);
            if (end != 0) {
            reverse.append(" ");
            }
        }
            return reverse.toString().trim();
    }
}