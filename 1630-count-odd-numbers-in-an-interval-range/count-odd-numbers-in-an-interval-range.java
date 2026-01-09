class Solution {
    public int countOdds(int low, int high) {
        int diff = 0;
        diff = high - low;
        int odds = diff / 2;
        if (low % 2 == 1 || high % 2 == 1) odds++;

    return odds;
    }

}