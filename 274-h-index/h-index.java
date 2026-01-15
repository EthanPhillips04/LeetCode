class Solution {
    public int hIndex(int[] citations) {
        int papers = citations.length;
        int[] citationBucket = new int[papers + 1];

        for (int citation : citations) {
            citationBucket[Math.min(citation, papers)]++;
        }

        int totalPapers = 0;
        for (int h = papers; h >= 0; h--) {
            totalPapers += citationBucket[h];
            if (totalPapers >= h) {
                return h;
            }
        }

        return 0;
    }
}