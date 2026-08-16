class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, Boolean> cache = new HashMap<>();
        cache.put(s.length(), true);
        return isWordBreak(s, 0, wordDict, cache);
    }

    private boolean isWordBreak(
        String s, int i, List<String> wordDict, HashMap<Integer, Boolean> cache) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        for (String word : wordDict) {
            if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                if (isWordBreak(s, i + word.length(), wordDict, cache)) {
                    // cache.put(i, true);
                    return true;
                };
            }
        }
        cache.put(i, false);
        return false;
    }
}
